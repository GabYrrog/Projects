// 

import { reduceLife } from "./page-meteo";

export default class EvilGun {
    constructor(){
        this.node = document.createElement("div");
        this.parent = document.querySelector("body");
        this.node.classList.add("EvilGun");
        this.node.style.top = 100 + "px";
        this.positionY = 100;
        this.x = window.innerWidth/2; 
        this.node.style.left = this.x + "px";
        this.speedY = 60;
        
        this.parent.append(this.node);

    }


    tick = () => {

        this.positionY += this.speedY;
        this.node.style.top = this.positionY + "px";
    
        let threshold = 200;
    
        if ( this.positionY >= (window.innerHeight - threshold)) {
            reduceLife("lifeBar2", 20);
            this.node.remove();
            return false; 
        }

        return true;
      

    }

}