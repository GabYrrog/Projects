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

// 