// IDEES : 
// idee : tirs croises horizontaux a un timer random, hauteur random, couleur random
// lorsque la vie est en bas de 30%, ils bougent plus vite et glow pulse rouge vite
// parfois il y a une comete qui passe et qui enleve 10% de la vie de chaque joueur

// IDEE en fonction de la meteo : brouillard = green fog -1 vie par seconde, plue = renverser les lasers et en mettre plus plus vite
// ensoleille = buff de soleil qui pop random et redonne de la vie a un vaisseau random
// A FAIRE : 
// Adapter la comete pour etre un sprite objet dans la spriteList et mettre un etat alive .. 
let spriteList = [];
let comet;
let messageBox;
let cometTimeOut;
let greenState;

window.addEventListener("load", () => { // 
   
    spriteList.push(new GoodSpacecraft("Good"));
    spriteList.push(new EvilSpacecraft("Evil"));


    tick(); 
   
})

const tick = () => { 
   
    for (let i = 0; i < spriteList.length; i++){
        let alive = spriteList[i].tick();
        
        if (!alive) {
			spriteList.splice(i, 1);
			i--;
		}
    }
    setTimeout(tick,1000);
}

function randomColor() {
    let colors = ['red', 'green', 'blue', 'yellow', 'purple'];
    return colors[Math.floor(Math.random() * colors.length)];
}

function createLaser() {
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


// fonction normales juste quand on a besoin de this
const showAndShakeComet = () => {
   
    if (Math.random() > 0.5){
        comet = document.querySelector('#comet');
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


const reduceLife = (lifeBarId, reduction) => {
    if (lifeBarId == "lifeBar1"){
        flashSpacecraft("spacecraft-evil");
    }
    else {
        flashSpacecraft("spacecraft");
    }
   let lifeBar = document.getElementById(lifeBarId);
    
   let style = window.getComputedStyle(lifeBar);
   let currentLife = parseInt(style.height, 10);
   console.log(currentLife);
    currentLife = Math.max(currentLife - reduction, 0); // Pour ne pas que la life soit negative
    lifeBar.style.height = currentLife + 'px';
    
}

const flashSpacecraft = (spacecraftId) => {
    const spacecraft = document.getElementById(spacecraftId);

    spacecraft.style.animation = 'flash 0.5s linear 3';

    setTimeout(() => {
        spacecraft.style.animation = 'none';
    }, 1500); 
}

const endgame = (name) => {
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

    document.body.append(messageBox);
    moveEndgameMsg();
    document.onclick = () => {
        window.location.reload();
    }



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
        messageBox.style.backgroundColor = "green";
    }
    else {
        messageBox.style.color = "green";
        messageBox.style.backgroundColor = "red";
    }

    messageBox.style.top = newY + "px";

    setTimeout(moveEndgameMsg, 66);
}



