package banque;

public class compteBancaire {

    private String nomProprio;
    private String numeroCompte;
    private double soldeCompte;

    private static int nbComptes = 0 ;


    public compteBancaire(String nomProprio, double soldeCompte){
        this.nomProprio = nomProprio;
        this.numeroCompte = nomProprio.charAt(0) + "-" + nbComptes;
        this.soldeCompte = soldeCompte;
        nbComptes++;

    }


    public String getNomProprio() {
        return nomProprio;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void retirer(double sommeARetirer){


        this.soldeCompte = soldeCompte - sommeARetirer;

    }


    public void deposer(String numeroCompte, double sommeADeposer){


        this.soldeCompte = soldeCompte + sommeADeposer;
    }




}
