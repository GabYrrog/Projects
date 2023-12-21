package Tableau_de_Jeu; // different package que les pieces car cela est davantage structure par thematique

import Pieces.*;

public class Echiquier implements MethodesEchiquier { // classe publique car sera instanciee dans l'interface graphique, qui serait dans un autre package
    private final Intersection[][] jeu; // final car même si ce qu'il y a sur chaque intersection va changer,
    // la matrice d'intersections ne pourra pas être changée vers une nouvelle référence.
    // p. ex. on ne pourra pas refaire jeu = new Intersection[8][8];

   public Echiquier(){
        jeu = new Intersection[10][9];
        initialiserJeu();
    }
    private void initialiserJeu() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                jeu[i][j] = new Intersection(null);
            }
        }
    }

    // METHODES public car si je faisais l'interface graphique je créerais un autre package pour ça
    @Override
    public void debuter(){
            // Placement des pièces rouges
            this.getIntersection(9,0).setPiece(new Char("charRougeGauche", "rouge"));
            this.getIntersection(9,8).setPiece(new Char("charRougeDroite", "rouge"));
            this.getIntersection(9,1).setPiece(new Cavalier("cavalierRougeGauche", "rouge"));
            this.getIntersection(9,7).setPiece(new Cavalier("cavalierRougeDroite", "rouge"));
            this.getIntersection(9,2).setPiece(new Elephant("elephantRougeGauche", "rouge"));
            this.getIntersection(9,6).setPiece(new Elephant("elephantRougeDroite", "rouge"));
            this.getIntersection(9,3).setPiece(new Mandarin("mandarinRougeGauche", "rouge"));
            this.getIntersection(9,5).setPiece(new Mandarin("mandarinRougeDroite", "rouge"));
            this.getIntersection(9,4).setPiece(new Roi("roiRouge", "rouge"));
            this.getIntersection(7,1).setPiece(new Bombarde("bombardeRougeGauche", "rouge"));
            this.getIntersection(7,7).setPiece(new Bombarde("bombardeRougeDroite", "rouge"));
            this.getIntersection(6,0).setPiece(new Pion("pionRouge1", "rouge"));
            this.getIntersection(6,2).setPiece(new Pion("pionRouge2", "rouge"));
            this.getIntersection(6,4).setPiece(new Pion("pionRouge3", "rouge"));
            this.getIntersection(6,6).setPiece(new Pion("pionRouge4", "rouge"));
            this.getIntersection(6,8).setPiece(new Pion("pionRouge5", "rouge"));

            // Placement des pièces noires
            this.getIntersection(0,0).setPiece(new Char("charNoirGauche", "noir"));
            this.getIntersection(0,8).setPiece(new Char("charNoirDroite", "noir"));
            this.getIntersection(0,1).setPiece(new Cavalier("cavalierNoirGauche", "noir"));
            this.getIntersection(0,7).setPiece(new Cavalier("cavalierNoirDroite", "noir"));
            this.getIntersection(0,2).setPiece(new Elephant("elephantNoirGauche", "noir"));
            this.getIntersection(0,6).setPiece(new Elephant("elephantNoirDroite", "noir"));
            this.getIntersection(0,3).setPiece(new Mandarin("mandarinNoirGauche", "noir"));
            this.getIntersection(0,5).setPiece(new Mandarin("mandarinNoirDroite", "noir"));
            this.getIntersection(0,4).setPiece(new Roi("roiNoir", "noir"));
            this.getIntersection(2,1).setPiece(new Bombarde("bombardeNoirGauche", "noir"));
            this.getIntersection(2,7).setPiece(new Bombarde("bombardeNoirDroite", "noir"));
            this.getIntersection(3,0).setPiece(new Pion("pionNoir1", "noir"));
            this.getIntersection(3,2).setPiece(new Pion("pionNoir2", "noir"));
            this.getIntersection(3,4).setPiece(new Pion("pionNoir3", "noir"));
            this.getIntersection(3,6).setPiece(new Pion("pionNoir4", "noir"));
            this.getIntersection(3,8).setPiece(new Pion("pionNoir5", "noir"));


    }
    @Override
    public Intersection getIntersection( int ligne, int colonne ){
        return jeu[ligne][colonne];
    }
    @Override
    public boolean cheminPossible ( Position  depart , Position arrivee){
       boolean reponse = true;
       // Si pas de mouvement, true
        if (depart.getLigne() == arrivee.getLigne() && arrivee.getColonne() == arrivee.getColonne()){
            return true;
        }
        // Si meme couleur a larrivee, false
        if (jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece() != null && jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() == jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece().getCouleur()){
            return false;
        }
        // Si le mouvement est horizontal, mais que ce nest pas une bombarde, valider presence dobstacles entre depart et arriver
        if (!(jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Bombarde) && estHorizontal(depart, arrivee)) {
            reponse = validationHorizontale(depart, arrivee);
            // meme chose pour mouvements verticaux
        } else if (!(jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Bombarde) && estVertical(depart, arrivee)) {
            reponse = validationVerticale(depart, arrivee);
            // Et pour mouvements en diagonale
        } else if (estDiagonal(depart,arrivee)){
            reponse = validationDiagonale(depart,arrivee);
            // Si cest un cavalier
        } else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Cavalier){
            reponse = validationCavalier(depart,arrivee);
        } else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Bombarde){
            reponse = validationBombarde(depart, arrivee);
        }
    return reponse;
    }

    @Override
    public boolean roisNePouvantPasEtreFaceAFace ( Position depart,Position arrivee ){
        Piece pieceBougee = jeu[depart.getLigne()][depart.getColonne()].getPiece();

        // On bouge la piece pour tester

        jeu[depart.getLigne()][depart.getColonne()].setPiece(null);
        Piece pieceOriginaleALarrivee = jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece();
        jeu[arrivee.getLigne()][arrivee.getColonne()].setPiece(pieceBougee);

        // On fait le test a savoir si les rois sont face a face
        boolean reponse = roisFaceAFace();

        // On revient a letat original du jeu avant le test
        jeu[depart.getLigne()][depart.getColonne()].setPiece(pieceBougee);
        jeu[arrivee.getLigne()][arrivee.getColonne()].setPiece(pieceOriginaleALarrivee);

        // on retourne la reponse, true si les rois se voient, false sils ne se voient pas;
        return reponse;
    }

    // METHODES UTILITAIRES
    // Private car utilisees seulement dans cette classe (methode public cheminPossible)
    // et dans les tests JUnit. Je les ai mis public pour les tests et remis private par la suite
    // la methode pour les rois face a face est public et utilise elle aussi est methodes utilitaires private
    private boolean estHorizontal(Position depart, Position arrivee){
        return arrivee.getLigne() == depart.getLigne();
    }
    private boolean validationHorizontale(Position depart, Position arrivee){
        int debut = Math.min(depart.getColonne(), arrivee.getColonne()) + 1;
        int fin = Math.max(depart.getColonne(), arrivee.getColonne());
        for (int i = debut; i < fin; i++) {
            if (jeu[depart.getLigne()][i].getPiece() != null) {
                return false;
            }
        }
       return true;
    }
    private boolean estVertical(Position depart, Position arrivee){
       return arrivee.getColonne() == depart.getColonne();
    }

    private boolean validationVerticale(Position depart, Position arrivee){
        int debut = Math.min(depart.getLigne(), arrivee.getLigne()) + 1;
        int fin = Math.max(depart.getLigne(), arrivee.getLigne());
        for (int i = debut; i < fin; i++) {
            if (jeu[i][depart.getColonne()].getPiece() != null) {
                System.out.println("il y a une piece dans le chemin");
                return false;
            }
        }
        return true;
    }
    private boolean estDiagonal(Position depart, Position arrivee){
        return Math.abs(arrivee.getLigne() - depart.getLigne()) == Math.abs(arrivee.getColonne() - depart.getColonne()) && arrivee.getLigne() != depart.getLigne();
    }
    private boolean validationDiagonale(Position depart, Position arrivee){
        int etapes = Math.abs(arrivee.getLigne() - depart.getLigne());

        //vers le haut a droite
        if (arrivee.getLigne() < depart.getLigne() && arrivee.getColonne() > depart.getColonne()){
            for (int i = 1; i < etapes; i++){
                if (jeu[depart.getLigne() - i][depart.getColonne() + i].getPiece() != null){
                    return false;
                }
            }
        }
        //vers le haut a gauche
        if (arrivee.getLigne() < depart.getLigne() && arrivee.getColonne() < depart.getColonne()){
            for (int i = 1; i < etapes; i++){
                if (jeu[depart.getLigne() - i][depart.getColonne() - i].getPiece() != null){
                    return false;
                }
            }
        }
        //vers le bas a droite
        if (arrivee.getLigne() > depart.getLigne() && arrivee.getColonne() > depart.getColonne()){
            for (int i = 1; i < etapes; i++){
                if (jeu[depart.getLigne() + i][depart.getColonne() + i].getPiece() != null){
                    return false;
                }
            }
        }
        //vers le bas a gauche
        if (arrivee.getLigne() > depart.getLigne() && arrivee.getColonne() < depart.getColonne()){
            for (int i = 1; i < etapes; i++){
                if (jeu[depart.getLigne() + i][depart.getColonne() - i].getPiece() != null){
                    return false;
                }
            }
        }
        return true;
    }

   private boolean validationCavalier(Position depart, Position arrivee){
       // 8 positions darrivee possibles, mais quatre mouvements en ligne droite initiaux
        // mouvement vers le haut
       if (arrivee.getLigne() - depart.getLigne() == -2){
           if (jeu[depart.getLigne() - 1][depart.getColonne()].getPiece() != null){
               return false;
           }
       }
       // mouvement vers la droite
       if (arrivee.getColonne() - depart.getColonne() == 2){
           if (jeu[depart.getLigne()][depart.getColonne() + 1].getPiece() != null){
               return false;
           }
       }
       //mouvement vers le bas
        if(arrivee.getLigne() - depart.getLigne() == 2){
            if (jeu[depart.getLigne() + 1][depart.getColonne()].getPiece() != null){
                return false;
            }
        }
        // mouvement vers la gauche
        if (arrivee.getColonne() - depart.getColonne() == -2){
            if (jeu[depart.getLigne()][depart.getColonne() - 1].getPiece() != null){
                return false;
            }
        }
        return true;
    }

    private boolean validationBombarde(Position depart, Position arrivee){
        // est-ce que cest la version horizontale ou verticale du move
        // est-ce que cest une capture, larrivee est autre couleur, si oui,
        // verifier quil y a exactement 1 piece entre les deux
        // Sinon, cest un deplacement et il ne peut pas y avoir de piece entre
        if (estHorizontal(depart,arrivee)){
            int debut = Math.min(arrivee.getColonne(), depart.getColonne());
            int fin = Math.max(arrivee.getColonne(), depart.getColonne());
            //si cest une capture
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece() != null && jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece().getCouleur() != jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur()){
                int compteurDePiece = 0;
                for (int i = debut + 1; i < fin; i++){
                    if (jeu[depart.getLigne()][i].getPiece() != null){
                        compteurDePiece++;
                    }
                }
                if (compteurDePiece == 1){
                    return true;
                }
                else {
                    return false;
                }
            }
            // Si ce nest pas une capture
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece() == null){
                for (int i = debut + 1; i < fin; i++){
                    if (jeu[depart.getLigne()][i].getPiece() != null){
                        return false;
                    }
                }
            }
        }
        // Si cest la version verticale du move
        if (estVertical(depart, arrivee)){
            int debut = Math.min(arrivee.getLigne(), depart.getLigne());
            int fin = Math.max(arrivee.getLigne(), depart.getLigne());
            //si cest une capture
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece() != null && jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece().getCouleur() != jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur()){
                int compteurDePiece = 0;
                for (int i = debut + 1; i < fin; i++){
                    if (jeu[i][depart.getColonne()].getPiece() != null){
                        compteurDePiece++;
                    }
                }
                if (compteurDePiece == 1){
                    return true;
                }
                else {
                    return false;
                }
            }
            // Si ce nest pas une capture
           if (jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece() == null) {
                for (int i = debut + 1; i < fin; i++){
                    if (jeu[i][depart.getColonne()].getPiece() != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private boolean roisFaceAFace(){
        Position positionRoiRouge = trouverPositionRoi("rouge");
        Position positionRoiNoir = trouverPositionRoi("noir");

        if (positionRoiRouge != null && positionRoiNoir!= null && positionRoiRouge.getColonne() == positionRoiNoir.getColonne()){
            for (int i = Math.min(positionRoiRouge.getLigne(), positionRoiNoir.getLigne()) + 1; i < Math.max(positionRoiRouge.getLigne(), positionRoiNoir.getLigne()); i++){
                if (jeu[i][positionRoiRouge.getColonne()].getPiece() != null){
                    return false; // rois ne se voient pas, il y a un obstacle
                }
            }
            return true; // les rois sont face a face et se voient
        }
        return false; // les rois ne sont pas alignes donc ne se voient pas
    }

    private Position trouverPositionRoi(String couleur) {
        for (int i = 0; i < jeu.length; i++) {
            for (int j = 0; j < jeu[i].length; j++) {
                Piece piece = jeu[i][j].getPiece();
                if (piece != null && piece instanceof Roi && piece.getCouleur().equals(couleur) ) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

}
