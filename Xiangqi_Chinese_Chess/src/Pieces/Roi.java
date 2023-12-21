package Pieces;

public class Roi extends Piece {
private Position positionDepart;
private Position positionArrivee;
private static final int NORME = 1;

    public Roi(String nom, String couleur){
        super(nom,couleur);
    }

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

    @Override
    public boolean estValide (Position depart, Position arrivee){
        int positionLigne = arrivee.getLigne();
        int positionColonne = arrivee.getColonne();
        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            return true;
        }
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
    /*@Override
    public boolean estValide (Position depart, Position arrivee){
        boolean reponse = true;
        Position mauvaisePosition1 = new Position(0,2);
        Position mauvaisePosition2 = new Position(1,2);
        Position mauvaisePosition3 = new Position(2,2);
        Position mauvaisePosition4 = new Position(3,3);
        Position mauvaisePosition5 = new Position(3,4);
        Position mauvaisePosition6 = new Position(3,5);
        Position mauvaisePosition7 = new Position(2,6);
        Position mauvaisePosition8 = new Position(1,6);
        Position mauvaisePosition9 = new Position(0,6);
        if (norme(depart,arrivee) != NORME){
            reponse = false;
        }
        else if (this.positionArrivee.equals(mauvaisePosition1) || this.positionArrivee.equals(mauvaisePosition2) || this.positionArrivee.equals(mauvaisePosition3) || this.positionArrivee.equals(mauvaisePosition4) || this.positionArrivee.equals(mauvaisePosition5) || this.positionArrivee.equals(mauvaisePosition6) || this.positionArrivee.equals(mauvaisePosition7) || this.positionArrivee.equals(mauvaisePosition8) || this.positionArrivee.equals(mauvaisePosition9) ){
            reponse = false;
        }
        return reponse;
    }*/

}
