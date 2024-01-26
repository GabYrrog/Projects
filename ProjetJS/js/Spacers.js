class Spacers {
    constructor(){
        
        this.node = document.querySelector(".spacecraft");
        //this.lifebar = document.querySelector(life-bar);

        
       
    
    }

tick(){
  // Chaque sous-classe aura sa propre implementation
}

move(){
    this.node.style.left = 10 + Math.random() * (200 - this.node.offsetWidth) + "px";

    
    }
  

 }
