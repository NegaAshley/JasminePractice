const changeColorButton = document.querySelector('#changeColorButton');

changeColorButton.addEventListener('click', function () { changeBackgroundColor(returnRandomRGBColor()) });

function returnRandomRGBColor() {
    let firstColor = returnRandomColorValue();
    let secondColor = returnRandomColorValue();
    let thirdColor = returnRandomColorValue();
    return `rgb(${firstColor}, ${secondColor}, ${thirdColor})`
}

function returnRandomColorValue() {
    return Math.floor(Math.random() * 256);
}

function changeBackgroundColor(newColor) {
    const body = document.querySelector('body');
    body.style.backgroundColor = newColor;
}