import Spacers from "./Spacers";
import { endgame } from "./page-meteo";
import { reduceLifeNoFlash } from "./page-meteo";
import EvilGun from "./Evil-Gun";
import { spriteList } from "./page-meteo";
import LightningOrb from "./Lightning-Orb";
export default class EvilSpacecraft extends Spacers {
    constructor(name){
        super();
        this.name = name;
        this.node = document.createElement("div");
        this.node.classList.add("spacecraft");
        this.node.id = "spacecraft-evil";
        this.parent = document.querySelector(".spacecraft-container-evil");
        this.parent.append(this.node);  
       
        this.lifeBar = document.querySelector("#lifeBar1");

        
            setInterval(() => {
                if (Math.random() <= 0.3){
                    spriteList.push(new EvilGun());
                }
            },666);
            setInterval(() => {
                if (Math.random() <= 0.2){
                    spriteList.push(new LightningOrb());
                }
            },1000);
    }
    tick(){
        
        let alive = true;
        if (parseInt(this.lifeBar.style.height, 10) > 20){
            reduceLifeNoFlash("lifeBar1", -2);
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
