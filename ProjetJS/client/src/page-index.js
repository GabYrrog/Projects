let introMessageBox;

window.addEventListener("load", () => {
    document.querySelector("#password-form").onsubmit = (e) => {
        e.preventDefault();
        let success = true;

        if (document.querySelector("#password").value !== "web2") {
            success = false;
            document.querySelector("#error-message").style.display = "block";
        }
        if (success) {
            window.location.href = "/client/meteo.html";
        }
        return success;
    }
})

window.addEventListener("load", () => {
    
    let text = "Depuis l'an 2318, les terriens luttent pour leur survie face à l'envahisseur venu du système XCPU4. Les humains ont été poussés dans leurs derniers retranchements au sein de trois villes, ciblées par l'envahisseur. Saurez-vous repousser le danger et protéger ces villes et leurs habitants? Cliquez ici pour choisir la ville à protéger."
    introMessageBox = document.createElement("div");
    introMessageBox.innerText = text;
    introMessageBox.classList.add("intro");
    let parent = document.querySelector("body");
    parent.append(introMessageBox);
    moveIntroMessage();
    introMessageBox.onclick = () => {

        introMessageBox.style.display = "none";
        showCities();

    
    }



})

const moveIntroMessage = () => {
 
        let rect = introMessageBox.getBoundingClientRect();
        let newY = rect.y;
    
        if (rect.y < window.innerHeight/5) {
            newY += 5;
        }
    
    
        introMessageBox.style.top = newY + "px";
    
        setTimeout(moveIntroMessage, 33);
}

const showCities = () => {

let parent = document.querySelector("body");

let citiesContainer = document.createElement("div");
citiesContainer.classList.add("citiesContainer");

let montreal = document.createElement("div");
montreal.classList.add("citie");
montreal.classList.add("montreal");

let newYork = document.createElement("div");
newYork.classList.add("citie");
newYork.classList.add("newYork");

let paris = document.createElement("div");
paris.classList.add("citie");
paris.classList.add("paris");


citiesContainer.append(montreal, newYork, paris);

parent.append(citiesContainer);

let text = "Choisissez la ville à protéger: Montréal, New-York ou Paris...";
let textNode = document.createElement("div");
textNode.classList.add("cityChoice");
textNode.innerHTML = text;
parent.append(textNode);

paris.onclick = () => {
    let name = "Paris";
    selectCity(name, citiesContainer, textNode);
}

montreal.onclick = () => {
    let name = "Montreal";
    selectCity(name, citiesContainer,textNode);
}

newYork.onclick = () => {
    let name = "New-York";
    selectCity(name, citiesContainer, textNode);
}


}

const selectCity = (name, container,previousText) => {
   
    localStorage.setItem("City", name);
    container.style.display = "none";
    previousText.style.display = "none";
    let text = "Veuillez maintenant entrer votre identification";
    let textNode = document.createElement("div");
    textNode.append(text);
    textNode.classList.add("login");
    let parent = document.querySelector("body");
    parent.append(textNode);
}
