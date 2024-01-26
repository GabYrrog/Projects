// 

import { reduceLife } from "./page-meteo";

export default class LightningOrb {
    constructor(){
        this.node = document.createElement("div");
        this.parent = document.querySelector("body");
        this.node.classList.add("orb");
        this.node.style.top = 100 + "px";
        this.positionY = 100;
        this.x = window.innerWidth/2 - 30; 
        this.node.style.left = this.x + "px";
        this.speedY = 10;
        this.rotateFactor = 30;
        this.angle = 0;
        this.parent.append(this.node);
        
    }


    tick = () => {
        this.angle += this.rotateFactor;
        this.positionY += this.speedY;
        this.node.style.top = this.positionY + "px";
        this.node.style.rotate = this.angle + "deg";
        

        let threshold = 200;
        if (window.innerHeight - this.positionY <= threshold) {
            reduceLife("lifeBar2", 15);
        }

        let alive = this.positionY < window.innerHeight - 200; 

        if (!alive) { 
            this.node.remove(); 
            
        }

        return alive;

    }

}