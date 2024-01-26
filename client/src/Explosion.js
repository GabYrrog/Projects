// 


export default class Explosion {
    constructor(){
        this.node = document.createElement("div");
        this.parent = document.querySelector("body");
        this.node.classList.add("explosion");
        this.randomX = Math.random() * (55 - 45) + 45;
        this.randomY = Math.random() * (120 - 20) + 20;
        this.node.style.top = this.randomY + "px";
        this.node.style.left = this.randomX + "%";
        
        this.parent.append(this.node);

        this.alive = true;

       
        setTimeout(() => {
            this.node.remove();
            this.alive = false; 
        }, 1000);

    }


    tick = () => {
    
        return this.alive;

    }

    
}