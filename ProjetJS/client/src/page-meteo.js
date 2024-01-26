//let randomInteger = Math.floor(Math.random() * (max - min + 1)) + min;
// let randomFloat = Math.random() * (max - min) + min;
 
import { fetchData } from "./meteo-api";
import GoodSpacecraft from "./Good-Spacecraft";
import EvilSpacecraft from "./Evil-Spacecraft";
import ArchEvil from "./Arch-Evil";
import SnowFlake from "./SnowFlake";
import Missile from "./Missile";
import LaserBeam from "./LaserBeam";
import StartGameMessage from "./StartGameMessage";


export let gameState = true;
export let spriteList = [];
let intervals = [];
let comet;
let messageBox;
let cometTimeOut;
let greenState;
let life1;
let life2;
let weatherData;

window.addEventListener("load", async () => {
   
    let city = localStorage.getItem("City");
    
    console.log(city);
    if (city == "Montreal"){
        weatherData = await fetchData(45.5019, -73.5674);
        console.log(weatherData);
    }
    if (city == "Paris"){
        weatherData = await fetchData(48.8566, 2.3522);
        console.log(weatherData);
    }
    if (city == "New-York"){
        weatherData = await fetchData(40.7128,  -74.0060);
        console.log(weatherData);
    }

    if (weatherData){
        meteo();
        document.getElementById('submit-temperature').addEventListener('click', () => {
            let temperatureInput = document.getElementById('temperature-input');
            let temp = temperatureInput.value;
            weatherData.temperature = parseInt(temp, 10); 
            temperatureInput.value = "";
            console.log(weatherData);
            clearIntervalsAndEffects();
            meteo();
        })
        document.getElementById('rain-btn').addEventListener('click', () => {
            if (weatherData.rain == 0){
                weatherData.rain = 1;
                document.getElementById('rain-btn').innerHTML = "Toggle sunny";
                meteo();
            }
            else {
                weatherData.rain = 0;
                document.getElementById('rain-btn').innerHTML = "Toggle rain";
                meteo();
                clearIntervalsAndEffects();
            }
        })

        let SpecialAttack = document.querySelector("#attack3");
        SpecialAttack.onclick = () => {
            ShootSnowFlakes();
        }
    
    }

})

const clearIntervalsAndEffects = () => {
    intervals.forEach(clearInterval);
    intervals = [];
    clearEffects();
};

const clearEffects = () => {
    
    let shadow = document.getElementById("shadow");
    if (shadow) {
        shadow.remove();
    }

    let lifebar1 = document.querySelector("#lifeBar1");
    let lifebar2 = document.querySelector("#lifeBar2");
    if (lifebar1) {
        lifebar1.classList.remove("iceGlow");
    }
    if (lifebar2) {
        lifebar2.classList.remove("iceGlow");
    }

    let reversedLasers = document.querySelector(".laser");
    if (reversedLasers){
        reversedLasers.classList.remove("laser");
    }
   
};

const meteo = () => {

    if (weatherData?.isDay == 0){
        let shadow = document.createElement("div");
        shadow.id = "shadow";
        let parent = document.querySelector("body");
        parent.append(shadow);
    }

    if (weatherData?.rain > 0){
        reversedLaser();
        intervals.push(setInterval(reversedLaser, 33));
       
        intervals.push(setInterval(function() {
            reduceLifeNoFlash("lifeBar1", -5);
        }, 2000));
    
        intervals.push(setInterval(function() {
            reduceLifeNoFlash("lifeBar2", -5);
        }, 2000));
    }

  
    if (weatherData?.temperature <= 0){
        let lifebar1 = document.querySelector("#lifeBar1");
        lifebar1.classList.add("iceGlow");
        let lifebar2 = document.querySelector("#lifeBar2");
        lifebar2.classList.add("iceGlow");

        intervals.push(setInterval(function() {
            reduceLifeNoFlash("lifeBar1", 1);
        }, 500));
    
        intervals.push(setInterval(function() {
            reduceLifeNoFlash("lifeBar2", 1);
        }, 500)); 
    }

    if (weatherData?.temperature < -20){
        let attacksContainer = document.querySelector("#attackButtons");
        attacksContainer.style.display = "flex";
        let SpecialAttack = document.querySelector("#attack3");
        SpecialAttack.style.display = "block";
    }

}
window.addEventListener("load", () => { // 
   
    spriteList.push(new GoodSpacecraft("Good"));
    spriteList.push(new EvilSpacecraft("Evil"));

    life1 = document.querySelector("#lifeBar1-background");
    life2 = document.querySelector("#lifeBar2-background");

    life1.addEventListener("mouseover", () => {
        const numericLife = document.createElement("div");
        let style = window.getComputedStyle(document.querySelector("#lifeBar1"));
        numericLife.innerText = parseInt(style.height, 10);
        numericLife.classList.add("numeric-life1");
        let parent = document.querySelector(".lifebar-container");
        parent.append(numericLife);
    });

    life1.addEventListener("mouseout", () => {
        const numericLife = document.querySelector(".numeric-life1");
        if (numericLife) {
            numericLife.remove();
        }
    });

    life2.addEventListener("mouseover", () => {
        const numericLife = document.createElement("div");
        let style = window.getComputedStyle(document.querySelector("#lifeBar2"));
        numericLife.innerText = parseInt(style.height, 10);
        numericLife.classList.add("numeric-life2");
        let parent = document.querySelector(".lifebar-container");
        parent.append(numericLife);
    });

    life2.addEventListener("mouseout", () => {
        const numericLife = document.querySelector(".numeric-life2");
        if (numericLife) {
            numericLife.remove();
        }
    });

   

    tick(); 
   
})

window.addEventListener("load", () => {

     
    comet = document.querySelector('#comet')
    const summonArchEvil = () => {
        if (comet.style.opacity=="0"){
            if (Math.random() > 0.8){
                spriteList.push(new ArchEvil());
                console.log("arch spawned");
            }
        }
    }
    setInterval(summonArchEvil, 5000);


    
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Enter'){
            if (checkFuel()){
                spriteList.push(new Missile());
            }
            
        }
    }) 

    document.addEventListener('keydown', (e) => {
        if (e.code === 'Space'){
          if (checkFuel()){
            spriteList.push(new LaserBeam());
          }
            
        }
    }) 
        
    spriteList.push(new StartGameMessage());
    

})

const tick = () => { 
   
    for (let i = 0; i < spriteList.length; i++){
        let alive = spriteList[i].tick();
        
        if (!alive) {
			spriteList.splice(i, 1);
			i--;
		}
    }
    setTimeout(tick, 100);
   
}

const randomColor = () => {
    let colors = ['red', 'green', 'blue', 'yellow', 'purple'];
    return colors[Math.floor(Math.random() * colors.length)];
}

const createLaser = () => {
    let laser = document.createElement('div');
    laser.className = 'laser';
    laser.style.top = Math.random() * 100 + 'vh';
    laser.style.left = '0'; 
    laser.style.width = Math.random() * 60 + 10 + "px";
    laser.style.backgroundColor = randomColor();

    document.getElementById('laserContainer').appendChild(laser);

    let duration = Math.random() * 3 + 2; 
    laser.style.transition = 'left ' + duration + 's linear';

    setTimeout(function() {
        laser.style.left = '90vw'; 
        setTimeout(function() { laser.remove(); }, duration * 1000); // Remove apres le mouvement
    }, 100);
}

// Lasers a intervals random
setInterval(createLaser, Math.random() * 2000 + 1000); // Chaque 1 a 3 secondes 

const reversedLaser = () => {
    let laser = document.createElement('div');
    laser.classList.add("laser");
    laser.style.top = '0';
    laser.style.left = Math.random() * 100 + 'vw'; 
    laser.style.height = Math.random() * 60 + 10 + "px";
    laser.style.width = 5 + "px";
    laser.style.backgroundColor = randomColor();

    document.getElementById('laserContainer').appendChild(laser);

    let duration = Math.random() * 3 + 2; 
    laser.style.transition = 'top ' + duration + 's linear';

    setTimeout(function() {
        laser.style.top = '90vw'; 
        setTimeout(function() { laser.remove(); }, duration * 1000); // Remove apres le mouvement
    }, 100);
}


// fonction normales juste quand on a besoin de this
const showAndShakeComet = () => {
   
    if (Math.random() > 0.5){
        //comet = document.querySelector('#comet');
        comet.style.opacity = '1';
        comet.style.animation = 'shake 0.5s infinite'; 
        let randomLifeBar = Math.floor(Math.random() * 2) + 1;
        reduceLife("lifeBar" + randomLifeBar, 25);// la comet fait du dmg a un combattant random
        setTimeout(() => {
            comet.style.opacity = '0'; 
            comet.style.animation = 'none'; 
        }, 2000);
    }

}


cometTimeOut = setInterval(showAndShakeComet, 4000);


export const reduceLife = (lifeBarId, reduction) => {
    if (lifeBarId == "lifeBar1"){
        flashSpacecraft("spacecraft-evil");
    }
    else {
        flashSpacecraft("spacecraft");
    }
   let lifeBar = document.getElementById(lifeBarId);
    
   let style = window.getComputedStyle(lifeBar);
   let currentLife = parseInt(style.height, 10);
   
    currentLife = Math.max(currentLife - reduction, 0); // Pour ne pas que la life soit negative
    if (currentLife < 200){
        lifeBar.style.height = currentLife + 'px';
    }
    
    
}

 export const reduceLifeNoFlash = (lifeBarId, reduction) => {
   
   let lifeBar = document.getElementById(lifeBarId);
    
   let style = window.getComputedStyle(lifeBar);
   let currentLife = parseInt(style.height, 10);
   
    currentLife = Math.max(currentLife - reduction, 0); // Pour ne pas que la life soit negative
    if (currentLife < 200){
        lifeBar.style.height = currentLife + 'px';
    }

}

export const reduceFuel = (reduction) => {
   
    let fuel = document.getElementById("FuelBar");
     
    let style = window.getComputedStyle(fuel);
    let currentFuel = parseInt(style.height, 10);
    
     currentFuel = Math.max(currentFuel - reduction, 0);
     if (currentFuel < 200){
         fuel.style.height = currentFuel + 'px';
     }
 
 }

 export const checkFuel = () => {
    let enoughFuel = true;
    let fuel = document.getElementById("FuelBar");
    let style = window.getComputedStyle(fuel);
    let currentFuel = parseInt(style.height, 10);
    
    if (currentFuel < 8){
        enoughFuel = false;
    }


    return enoughFuel;
 }

export const flashSpacecraft = (spacecraftId) => {
    const spacecraft = document.getElementById(spacecraftId);

    spacecraft.style.animation = 'flash 0.5s linear 3';

    setTimeout(() => {
        spacecraft.style.animation = 'none';
    }, 1500); 
}

export const endgame = (name) => {
    if (gameState == true){
        let messageName;
        if (name == "Good"){
            messageName = "Evil";
        }
        else {
            messageName = "Good";
        }
        comet.style.opacity = 0;
        clearTimeout(cometTimeOut);
        let endgameMessage = messageName + " WINS! Click to start anew!";
        messageBox = document.createElement("div");
        messageBox.innerText = endgameMessage;
        messageBox.id = "msgBox";
        messageBox.style.backgroundColor = "rgba(0, 0, 0, 0.5)";
        document.body.append(messageBox);
        moveEndgameMsg();
        document.onclick = () => {
            window.location.reload();
        }
        gameState = false;

    }
    

} 

const triggerExplosion =() => {
    spriteList.push(new EndGameExplosion());

}

greenState = false;

const moveEndgameMsg = () => {
    
    let rect = messageBox.getBoundingClientRect();
    let newY = rect.y;

    if (rect.y < window.innerHeight/3) {
        newY += 3;
    }

    greenState = !greenState;

    if (greenState) {
        messageBox.style.color = "red";
        
    }
    else {
        messageBox.style.color = "green";
       
    }

    messageBox.style.top = newY + "px";

    setTimeout(moveEndgameMsg, 66);
}



const ShootSnowFlakes = () => {
    if (checkFuel()){
        let randomNumber = Math.floor(Math.random() * 3 + 2);
        for (let i=0; i <= randomNumber; i++){
            spriteList.push(new SnowFlake());
        }
    }
    

}


