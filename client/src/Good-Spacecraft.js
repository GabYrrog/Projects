import Spacers from "./Spacers";
import { endgame } from "./page-meteo";
import { reduceLifeNoFlash } from "./page-meteo";
import { reduceFuel } from "./page-meteo";
export default class GoodSpacecraft extends Spacers {
    constructor(name){
        super();
        this.name = name;
        this.node = document.createElement("div");
        this.node.classList.add("spacecraft");
        this.node.id = "spacecraft";
        this.parent = document.querySelector(".spacecraft-container");
        this.parent.append(this.node);
       
        this.lifeBar = document.querySelector("#lifeBar2");


    }


    tick(){
        reduceFuel(-2);
        let alive = true;
        if (parseInt(this.lifeBar.style.height, 10) > 20){
            reduceLifeNoFlash("lifeBar2", -1.5);
        }
        
        if (parseInt(this.lifeBar.style.height) === 0){
            this.node.remove();
            alive = false;
            endgame(this.name);
        } else {
            this.move(); 
        }

        return alive;
    }
 }
