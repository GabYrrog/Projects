package projetheritagemaison;
import java.time.*;
public class Maison_Mobile extends Chalet{

    private int anneeFabrication;

    public Maison_Mobile(int nbrePieces, double prixVente, boolean electricite, boolean accesLac, int anneefabrication){
        super(nbrePieces, 0 , null, "", prixVente, electricite, accesLac);
        this.anneeFabrication = anneeFabrication;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

@Override
public double valeur ()
{
    LocalDate aujourdhui = LocalDate.now();
    LocalDate fab = LocalDate.of(anneeFabrication, 1, 1);
   int age = Period.between(aujourdhui, fab).getYears();
    double val = super.valeur();
    if ( age < 10)
        return val;
    else if ( age < 20 )
        return val*0.6;
    else
        return val*0.5;

}



}
