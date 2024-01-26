// 

import { reduceFuel, reduceLife } from "./page-meteo";
export default class SnowFlake {
    constructor(){
        this.node = document.createElement("div");
        this.parent = document.querySelector("body");
        this.node.classList.add("snow");
        this.node.style.bottom = -100 + "px";
        this.positionY = -100;
        this.randomX = (25) + Math.random() * 50; 
        this.node.style.left = this.randomX + "vw";
        this.speedY = 25;
        this.rotateSpeed = 5;
        this.angle = 0;
        this.parent.append(this.node);
        reduceFuel(50);
    }


    tick = () => {

        this.positionY += this.speedY;
        this.node.style.bottom = this.positionY + "px";
        this.angle += this.rotateSpeed;
        this.node.style.rotate = this.angle + "deg";

        let threshold = 200;
        if (window.innerHeight - this.positionY <= threshold) {
            reduceLife("lifeBar1", 0.5); 
        }

        let alive = this.positionY < window.innerHeight; 

        if (!alive) { 
            this.node.remove(); 
        }

        return alive;



    }
}