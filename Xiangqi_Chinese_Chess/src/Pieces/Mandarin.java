package Pieces;

public class Mandarin extends Piece {

    private Position positionDepart;
    private Position positionArrivee;

    private static final int NORME = 2;

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

    public Mandarin(String nom, String couleur){
        super(nom,couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){
        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            return true;
        }
        int positionLigne = arrivee.getLigne();
        int positionColonne = arrivee.getColonne();
        if (this.getCouleur() == "rouge"){
            if(positionLigne < 7){
                return false;
            }
            if (positionColonne < 3 || positionColonne > 5){
                return false;
            }
        }
        if (this.getCouleur() == "noir"){
            if(positionLigne>  2){
                return false;
            }
            if (positionColonne < 3 || positionColonne > 5){
                return false;
            }
        }
        if (norme(depart,arrivee) != NORME){
            return false;
        }
        return true;
    }





}
