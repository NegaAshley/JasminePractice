describe("#changeBackgroundColor", function () {
    it("should change the background color on the body", function () {
        const body = document.querySelector('body');
        body.style.backgroundColor = 'rgb(0, 0, 0)';
        changeBackgroundColor('rgb(1, 0, 0)');
        expect(body.style.backgroundColor).toBe('rgb(1, 0, 0)');
    });
});

describe("#returnRandomColorValue", function () {
    it("should return a value greater than or equal to 0", function () {
        let returnValue = returnRandomColorValue();
        expect(returnValue).toBeGreaterThanOrEqual(0);
    });
    it("should return a value less than 256", function () {
        let returnValue = returnRandomColorValue();
        expect(returnValue).toBeLessThan(256);
    });
});

describe("#returnRandomRGBColor", function () {
    it("should return an object", function () {
        let randomColor = returnRandomRGBColor();
        expect(randomColor).toBeTruthy();
    });
});


