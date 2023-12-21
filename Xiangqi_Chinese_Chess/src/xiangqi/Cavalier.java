package xiangqi;

public class Cavalier extends Piece{
    private Position positionDepart;
    private Position positionArrivee;
    private static final int NORME = 3;

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

    public Cavalier(String nom, String couleur){
        super(nom,couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){
        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            return true;
        }

        int diffLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int diffColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        return (diffLigne == 1 && diffColonne == 2) || (diffLigne == 2 && diffColonne == 1);
    }



}
