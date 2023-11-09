package ca.codexcvm.succursale;

public class TarificationSuccursale {
    public double calculerPrixVendant(double PrixSuccursale){ // le prix succursale est
// le prix du livre auquel la compagnie a ajoute son 10%
        Succursale succursale = new Succursale();
        return PrixSuccursale + PrixSuccursale * succursale.getMargeProfit();
        // on retourne le prix vendant, donc avec le 25% ajoute par la succursale
    }




}
