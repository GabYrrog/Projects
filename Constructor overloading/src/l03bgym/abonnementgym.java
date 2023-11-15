package l03bgym;

public class abonnementgym {
   // private int dureAbonnementBase = 30;
    //private double prixAbonnementBase = 41.25;

  //  private int nbJoursAccesAbonnementCarte;
//
   // private double prixParJourAbonnementCarte = 8.25;

    //private int nbJoursAbonnementVIP;

    //private double prixParJourAbonnementVIP;

private double prix;
private int duree;
private String nomMembre;

    public double getPrix() {
        return prix;
    }

    public abonnementgym(double prix){
        this.prix = prix;

    }
    public abonnementgym(int duree,double prix){
        this.duree = duree;
        this.prix = prix * duree;

    }

    public abonnementgym(int duree,double prix, String nomMembre){
        this.duree = duree;
        this.prix = prix * duree;
        this.nomMembre = nomMembre;

    }

}
