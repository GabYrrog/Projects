package Pieces;

public class Char extends Piece {
    private Position positionDepart;
    private Position positionArrivee;
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

    public Char(String nom, String couleur){
        super(nom,couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){
        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            return true;
        }
        int positionLigneDepart = depart.getLigne();
        int positionColonneDepart = depart.getColonne();
        int positionLigneArrivee = arrivee.getLigne();
        int positionColonneArrivee = arrivee.getColonne();
        // Si le mouvement nest ni vertical ni horizontal, return false;
        boolean estHorizontal = positionLigneArrivee == positionLigneDepart && positionColonneArrivee != positionColonneDepart;
        boolean estVertical = positionColonneArrivee == positionColonneDepart && positionLigneArrivee != positionLigneDepart;

        return estHorizontal || estVertical;
    }



}
