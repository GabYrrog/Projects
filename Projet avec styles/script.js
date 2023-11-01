// Feature pour cacher le texte des articles et les afficher onclick
document.addEventListener("DOMContentLoaded", function() {
    let toggles = document.querySelectorAll(".toggle-button");//Les titres des articles
    
    toggles.forEach(function(toggle) {
        toggle.addEventListener("click", function() { // Lorsqu'on clique sur la section de titre tandis que le reste des caché
            let section = toggle.closest(".article_loi"); //Retrouve l'article au complet
            section.classList.toggle("expanded"); // Ajoute à l'article la classe .expanded et çca affiche l'ensemble de l'article
        });
    });
});


// Bouton pour retourner au top
const scrollTopBtn = document.getElementById('scrollTopBtn');

function checkScrollPosition() {
    if (window.scrollY > 1000) {
        scrollTopBtn.style.display = 'block';
    } else {
        scrollTopBtn.style.display = 'none';
    }
}

function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}

window.addEventListener('scroll', checkScrollPosition);
scrollTopBtn.addEventListener('click', scrollToTop);

// JS pour pouvoir resize le font
const decreaseBtn = document.getElementById('decreaseFont');
const resetBtn = document.getElementById('resetFont');
const increaseBtn = document.getElementById('increaseFont');
const body = document.body; // or another container element if needed

// Define default font size
const defaultFontSize = window.getComputedStyle(body).fontSize;

function adjustFontSize(scaleFactor) {
    const currentSize = parseFloat(window.getComputedStyle(body).fontSize);
    body.style.fontSize = `${currentSize * scaleFactor}px`;
}

// Event listeners
decreaseBtn.addEventListener('click', () => {
    adjustFontSize(0.9); // decrease by 10%
});

resetBtn.addEventListener('click', () => {
    body.style.fontSize = defaultFontSize;
});

increaseBtn.addEventListener('click', () => {
    adjustFontSize(1.1); // increase by 10%
});

// Fonction pour avoir l'heure
setInterval(clockFunc, 1000);

function clockFunc() {
  let d = new Date();
  document.querySelector(".clock").innerHTML=
  d.getHours() + ":" +
  d.getMinutes() + ":" +
  d.getSeconds();
}