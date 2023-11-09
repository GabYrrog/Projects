package ca.codexcvm.livres;

import ca.codexcvm.compagnie.Compagnie;
import ca.codexcvm.compagnie.TarificationCompagnie;
import ca.codexcvm.succursale.Succursale;
import ca.codexcvm.succursale.TarificationSuccursale;

public class Livres {
    private String titre;
    private double prixCoutant;

    public String getTitre() {
        return titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPrixCoutant(double prixCoutant) {
        this.prixCoutant = prixCoutant;
    }

    public double prixSuccursale() { // le livre auquel on a ajoute 10%
        TarificationCompagnie tarificationCompagnie = new TarificationCompagnie();
        return tarificationCompagnie.calculerPrixSuccursale(this.prixCoutant); // prix livre
    }

    public double prixVendant() { // on calcule le prix vendant avec en parametre le prix
        // ... le prix du livre lorsque la succursale le recoit
        //Compagnie compagnie = new Compagnie();
        TarificationSuccursale tarificationSuccursale = new TarificationSuccursale();
        return tarificationSuccursale.calculerPrixVendant(prixSuccursale()); // on ajoute 25%
        // au prix du livre deja augmente de 10% et cela donne le prix final.
    }
}

