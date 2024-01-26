// 

import { reduceLife } from "./page-meteo";
import { reduceFuel } from "./page-meteo";

export default class LaserBeam {
  
    constructor(){
       
        this.node = document.createElement("div");
        this.parent = document.querySelector("body");
        this.node.classList.add("laserBeam");
        this.node.style.bottom = 200 + "px";
        this.x = window.innerWidth/2; 
        this.node.style.left = this.x + "px";
            
        this.parent.append(this.node);
        this.alive = true;

        
        setTimeout(() => {
            this.node.remove();
            this.alive = false; 
        }, 1500);

        reduceLife("lifeBar1", 0.6); 
        reduceFuel(2);
        
        
    }


    tick = () => {
       
        return this.alive;

    }
}