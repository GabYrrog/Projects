package ca.codexcvm.compagnie;

public class TarificationCompagnie {
    public double calculerPrixSuccursale(double prixCoutant){ // ajouter le 10%
        Compagnie compagnie = new Compagnie();
        return prixCoutant * ( 1 + compagnie.getMargeProfit());
    }
}
