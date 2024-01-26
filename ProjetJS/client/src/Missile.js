// 

import { reduceLife, spriteList } from "./page-meteo";
import Explosion from "./Explosion";
import { reduceFuel } from "./page-meteo";
export default class Missile {
    constructor(){
        this.node = document.createElement("div");
        this.parent = document.querySelector("body");
        this.node.classList.add("missile");
        this.node.style.bottom = -100 + "px";
        this.positionY = -100;
        this.x = window.innerWidth/2; 
        this.node.style.left = this.x + "px";
        this.speedY = 100;
        
        this.parent.append(this.node);
        reduceFuel(20);
    }


    tick = () => {

        this.positionY += this.speedY;
        this.node.style.bottom = this.positionY + "px";
        

        let threshold = 200;
        if (window.innerHeight - this.positionY <= threshold) {
            reduceLife("lifeBar1", 10);
            setTimeout(this.explode, 200);
            setTimeout(this.explode, 300);
            setTimeout(this.explode, 400);
            setTimeout(this.explode, 500);
            setTimeout(this.explode, 600);
        }

        let alive = this.positionY < window.innerHeight - 200; 

        if (!alive) { 
            this.node.remove(); 
            
        }

        return alive;

    }

    explode = () => {
        spriteList.push(new Explosion());

    }
}