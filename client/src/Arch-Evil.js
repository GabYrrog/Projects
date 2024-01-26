import Spacers from "./Spacers";
import { gameState, reduceLife } from "./page-meteo";
export default class ArchEvil extends Spacers {
    constructor(name){
        if (gameState == true){
            super();
            this.name = name;
            this.alive = true;
            this.node = document.createElement("div");
            this.node.classList.add("spacecraft");
            this.node.id = "Arch-Evil";
            this.parent = document.querySelector("body");
            this.node.style.top = -150 + "px";
            this.node.style.right = -150 + "px";
            this.speedX = 6;
            this.speedY = 6;
            this.speedFactor = 1.5;
            this.YPosition = -150;
            this.XPosition = -150;
            this.rotationFactor = 5;
            this.randomArchEffectFlag = true;
            this.parent.append(this.node);
    
            setTimeout(() => {
                this.alive = !this.alive;
                let text = document.querySelector("#Arch-says");
                text.style.display = "none";
            }, 9000);
    
            
        }
       
        
    }


    startWiggle() {
        let rotation = 0;
        let direction = 1;
        const maxRotation = 10; 
        const wiggleSpeed = 100;

        this.wiggleInterval = setInterval(() => {
            rotation += 5 * direction;
            if (rotation > maxRotation || rotation < -maxRotation) {
                direction *= -1; 
            }
            this.node.style.transform = `rotate(${rotation}deg)`;
        }, wiggleSpeed);
    }

    
   
    randomArchEffect() {
        let text = document.querySelector("#Arch-says");
        text.style.display = "block";
        let randomValue = Math.random();
        if (randomValue < 0.5){
            reduceLife("lifeBar1",75);
            reduceLife("lifeBar2",75);
            text.innerHTML = "Damaged both spacecrafts";
        }
        if (randomValue >= 0.5 && randomValue < 0.9){
            let randomLifeBar = Math.floor(Math.random() * 2) + 1;
            reduceLife("lifeBar" + randomLifeBar, -50); 
            text.innerHTML ="Healed a random foe";
        }
        if (randomValue >= 0.9) {
            reduceLife("lifeBar2", 150);
            text.innerHTML ="Nearly killed Good";
        }

    }
    
    tick(){
       
        console.log(this.alive);
        if (!this.alive) {
            this.node.remove();
            console.log("arch removed");
            return false; 
        }
        
        if (this.alive == true){
            this.speedX += this.speedFactor;
            this.speedY += this.speedFactor;
            if (this.XPosition < (window.innerWidth/3)-100){
                this.XPosition += this.speedX;
            }
            if (this.YPosition < (window.innerHeight/3)+100){
                this.YPosition += this.speedY;
            }
            if (this.XPosition >= (window.innerWidth/3)-120){
                this.startWiggle();
                if (this.randomArchEffectFlag == true){
                    this.randomArchEffect();
                    this.randomArchEffectFlag = false;
                }
                
            }
            
            this.node.style.top = this.YPosition + "px";
            this.node.style.right = this.XPosition + "px";
        }

        return true;
    }
 }
