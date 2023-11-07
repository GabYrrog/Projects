const colorDisplay = document.querySelector(".ColorDisplay");
const button = document.querySelector(".TheButton");

button.addEventListener("click", ChangeColor);


function ChangeColor() {
        
    const randomColor = '#' + Math.floor(Math.random()*16777215).toString(16);
    colorDisplay.style.backgroundColor = randomColor;
    colorDisplay.querySelector('p:nth-child(2)').textContent = randomColor;
}
    

const  AutomateButton = document.querySelector(".Auto");

AutomateButton.addEventListener("click", ActivateAutomation);


let colorInterval = null; 
const AutomateState= document.querySelector(".Auto p");

function ActivateAutomation() {
   
    if (colorInterval) {
        clearInterval(colorInterval);
        AutomateState.textContent = 'Off';
        AutomateState.style.color = 'red';
    } else {
        colorInterval = setInterval(ChangeColor, 1400);
        AutomateState.textContent = 'On';
        AutomateState.style.color = 'green';
    }
}
