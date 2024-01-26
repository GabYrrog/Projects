class EvilSpacecraft extends Spacers {
    constructor(name){
        super();
        this.name = name;
        this.node = document.createElement("div");
        this.node.classList.add("spacecraft");
        this.node.id = "spacecraft-evil";
        this.parent = document.querySelector(".spacecraft-container-evil");
        this.parent.append(this.node);
        this.attack1 = document.querySelector("#attack-1")
        this.attack2 = document.querySelector("#attack-2")
        this.attack3 = document.querySelector("#attack-3")
        
       
        this.lifeBar = document.querySelector("#lifeBar1");


        


        // this.attack1.onclick = () => {
            

        // }
        // this.attack2.onclick = () => {
            

        // }
        // this.attack3.onclick = () => {
            

        // }
    }
    tick(){
        let alive = true;

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
