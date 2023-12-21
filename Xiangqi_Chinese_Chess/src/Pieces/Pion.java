package Pieces;

public class Pion extends Piece {

    private Position positionDepart;
    private Position positionArrivee;
    private static final int NORME = 1;

    public Position getPositionDepart() {
        return positionDepart;
    }

    public Position getPositionArrivee() {
        return positionArrivee;
    }

    public void setPositionDepart(Position positionDepart) {
        this.positionDepart = positionDepart;
    }

    public void setPositionArrivee(Position positionArrivee) {
        this.positionArrivee = positionArrivee;
    }

    public Pion(String nom, String couleur){
        super(nom,couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee) {
        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            return true;
        }
        boolean reponse = true;
        int differenceColonne = arrivee.getColonne() - depart.getColonne();
        int differenceLigne = arrivee.getLigne() - depart.getLigne();

        if (norme(depart, arrivee) != NORME) {
            return false;
        }
        int positionPionLigne = arrivee.getLigne();
        if (this.getCouleur() == "rouge") {
            if (differenceLigne == 1){
                return false;
            }
            if (depart.getLigne() > 4) {
                if (differenceColonne != 0) {
                    return false;
                }
            }
        }
        if (this.getCouleur() == "noir") {
            if (differenceLigne == -1){
                return false;
            }
            if (depart.getLigne() <= 4) {
                if (differenceColonne != 0) {
                    reponse = false;
                }
            }
        }
        return reponse;
    }






}
