package edu.northwestern.alumni.affiliations.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.stepfunctions.model.AWSStepFunctionsException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.northwestern.alumni.affiliations.entity.TaskResult;
import edu.northwestern.alumni.affiliations.entity.Affiliation;
import edu.northwestern.alumni.affiliations.repository.AffiliationRepository;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author Brent Billows
 *
 */
@Service
public class TrusteeAffiliationService {
	private ObjectMapper mapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(DSTService.class);

	@Transactional
	public TaskResult handleRequest(Map<String, Object> event) {
		TaskResult result = new TaskResult();
		AffiliationRepository afr = new AffiliationRepository();
		try {

			// System.getenv() will give you access to all the Environment variables.  You could also access these with @Value annotation on members
			logger.info("ENVIRONMENT VARIABLES: " + mapper.writeValueAsString(System.getenv()));
			
			// The event is the payload from the Task definition in the step function blueprint.
			//This can be useful if you need to pass state from one task to another
			logger.info("EVENT: " + mapper.writeValueAsString(event));
			logger.info("EVENT TYPE: " + event.getClass().toString());

			afr.trusteeAffiliations();
			
			result.setResponseCode(201);
			result.setResponseMessage("OK");
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error(getClass().getName() + " caused the following Exception: " + e.getMessage(), e);
			throw new AWSStepFunctionsException(getClass().getName() + ".handleRequest() failed with the following error: " + e.getMessage());
		}

		return result;
	}

	public static void main(String[] args){
		SpringApplication.run(TrusteeAffiliationService.class, args);
	}

}

