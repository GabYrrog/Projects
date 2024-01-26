
export default class StartGameMessage  {
    constructor(){
       
        this.city = localStorage.getItem("City");
        this.node = document.createElement("div");
        this.node.classList.add("StartMessage");
        this.parent = document.querySelector("body");
        this.node.innerHTML = "Defend " + this.city + "!"
        this.node.style.top = window.innerHeight/2 - 200 + "px";
        this.node.style.left = window.innerWidth/2 - 300 + "px";
        this.node.style.width = 50 + "px";
        this.node.style.height = 100 + "px";
        this.node.style.fontSize = 30 + "px";
        this.font = 30;
        this.fontGrow = 5;
        this.width = 100;
        this.height = 25;
        this.growWidth = 20;
        this.growHeight = 50;
       
        this.parent.append(this.node);
    }

    
    tick(){
        this.width += this.growWidth;
        this.height += this.growHeight;
        this.font += this.fontGrow;

        // this.node.style.top = (window.innerHeight - this.height) / 2 + "px";
        // this.node.style.left = (window.innerWidth - this.width) / 2 + "px";

        this.node.style.width = this.width + "px";
        this.node.style.height = this.height + "px";
        this.node.style.fontSize = this.font + "px";

        let alive = this.width < 600;

        if (!alive){
            this.node.remove();
        }

        return alive;
    }
 }
