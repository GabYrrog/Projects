package Pieces;

public class Elephant extends Piece {

    private Position positionDepart;
    private Position positionArrivee;
    private static final int NORME = 8;

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

    public Elephant(String nom, String couleur){
        super(nom,couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){
        int positionElephantLigne = arrivee.getLigne();
        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = arrivee.getColonne() - depart.getColonne();
        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            return true;
        }
        if (norme(depart,arrivee) != NORME){
            return false;
        }

        if (this.getCouleur() == "rouge"){
            if(positionElephantLigne < 5){
                return false;
            }
        }
        if (this.getCouleur() == "noir"){
            if(positionElephantLigne > 4){
                return false;
            }
        }
       if (Math.abs(diffLigne) != 2 && Math.abs(diffColonne) != 2){
           return false;
       }
        return true;
    }

}
