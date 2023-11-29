package projetheritagemaison;

public class Chalet extends Maison{

private boolean electricite;
private boolean accesLac;


Chalet(int nbrePieces, double superficieTerrain, String noAdresse, String nomRue,  double prixVente, boolean electricite, boolean accesLac){
    super(nbrePieces, superficieTerrain, noAdresse, nomRue, prixVente);
    this.accesLac = accesLac;
    this.electricite = electricite;
}
    public boolean isElectricite() {
        return electricite;
    }

    public void setElectricite(boolean electricite) {
        this.electricite = electricite;
    }

    public boolean isAccesLac() {
        return accesLac;
    }

    public double valeur ()
    {
        double val =  super.valeur()/75 * 100;
        if (this.electricite)
        {
            val += val*0.10;
        }
        if (this.accesLac)
        {
            val += 5000;
        }
        return val;
    }


}
