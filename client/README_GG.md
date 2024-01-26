# CVM Météo

Par Gabriel Gorry

## Animations
- Les barres de vie se reduisent lors dattaques
- La barre de Fuel reduit lorquon fait des attaques
- Chaque 5 sec, il y a environ 20% de chances de spawn un arch-evil qui soit healera un joueur random, soit les dommagera les deux, soit dommagera beaucoup le user. Cette animation part du haut a droite en diagonale et lorsquelle atteint une certaine hauteur, sarrete et il y a une animation de rotation avec un dialogue qui apparait
- Des lasers horizontaux traversent en permanence lecran. Lorsquil pleut, leur sens est inverse et leur frequence est augmentee
- Chaque 4 secondes, il y a 50% de chances quune comete apparaisse au centre de lecran et endommage les deux vaisseaux, faisant naisser les barres de vie.
- Le joueur a trois attaques (dont une secrete), representant chacune une animation. Les missiles explosent, generant des explosions, ce qui est une animation declenchee par une autre.
- Lattaque LaserBeam est plus impressionnante lorsquon garde la touche space appuyee
- Possibilite de declencher la pluie, avec une animation de lasers verticaux avec vitesse et longueur aleatoire.


## Conditions Meteo
- Possibilite dajuster le temperature grace a un input
- Sil fait nuit, il y a un div qui occupe tout lecran et qui ajoute du noir avec opacite de 0.5
- Sil pleut, il y a des lasers verticaux en grande frequence qui heal chaque 2 sec
- Sil fait en bas de zero, les lifebars auront un glow bleu et la life reduira de 1 chaque demie seconde
- Sil fait en bas de -20 exclusivement, une attack speciale est accessible