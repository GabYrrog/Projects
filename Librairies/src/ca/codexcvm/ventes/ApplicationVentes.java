package ca.codexcvm.ventes;
import ca.codexcvm.compagnie.Compagnie;
import ca.codexcvm.compagnie.TarificationCompagnie;
import ca.codexcvm.livres.Livres;
import ca.codexcvm.succursale.Succursale;

public class ApplicationVentes {
    public static void main(String[] args) {
        Succursale succursale = new Succursale();
        succursale.setnoSuccursale(123456);
        succursale.setnomSuccursale("Montreal");

        Compagnie compagnie = new Compagnie();
        TarificationCompagnie tarificationCompagnie = new TarificationCompagnie();
        Livres livres = new Livres();
        livres.setTitre("AI");
        livres.setPrixCoutant(20);


        System.out.println(compagnie.getNomCompagnie());
        System.out.println(succursale.getNoSuccursale());
        System.out.println(livres.getTitre());
        System.out.println(succursale.getNomSuccursale());
        System.out.println(livres.prixVendant());

    }
}
