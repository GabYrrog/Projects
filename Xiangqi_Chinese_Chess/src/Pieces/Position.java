package Pieces;

public class Position
{

    private int ligne ; // de 0 à 9 voir schéma
    private int colonne; // de 0 à 8


    public Position(int ligne, int colonne)
    {
        this.ligne = ligne;
        this.colonne= colonne;
    }

    public int getLigne ()
    {
        return ligne;
    }

    public int getColonne ()
    {
        return colonne;
    }

    public void setLigne (int ligne)
    {
        this.ligne = ligne;
    }

    public void setColonne ( int colonne )
    {
        this.colonne = colonne;
    }

    @Override // pour que le equals (utilise dans trouverPositionRoi de Echiquier)
    // compare vraiment le contenu des objets position au lieu des adresses memoire
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return this.getLigne() == position.getLigne() && this.getColonne() == position.getColonne();
    }

}
