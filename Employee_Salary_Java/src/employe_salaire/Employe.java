package employe_salaire;

import validation.ValidationFormulaire;

public class Employe {
    // Pas static parce que chaque champ appartient non pas a la classe mais a un employé
    // Pas final parce qu'on va l'initialiser plus tard avev setEmploye
    private String nom;
    private String numero;
    private double salaireHoraire;
    private double nbreHeuresSemaine;
    private int anciennete;

    public String getNom() {
        return nom;
    }



    public void setEmploye(String nom, String numero, double salaire, double heuresSem, int anciennete){
       boolean condition = ValidationFormulaire.validerEmploye(nom, numero, salaire, heuresSem, anciennete);
       if (condition){
        this.nom = nom;
        this.numero = numero;
        this.salaireHoraire = salaire;
        this.nbreHeuresSemaine = heuresSem;
        this.anciennete = anciennete;
        }
       else {
           this.nom = "";
           this.numero = "";
           this.salaireHoraire = 0;
           this.nbreHeuresSemaine = 0;
           this.anciennete = 0;
       }
    }

private double  salaireBrut(){
    return salaireHoraire * nbreHeuresSemaine;
}


private double salaireNetAvantImpot(){
        double brut = this.salaireBrut();
        double assurance = 0.111;
        double pension = 0.0136;
        int syndicat = 20;

        return brut - (brut * assurance) - (brut * pension) - syndicat;
    }

private double impotFederal(){
    double salaireNet = this.salaireNetAvantImpot();
    double fed = 0.19;
    return fed * salaireNet;
}

private double impotProvincial(){
    double salaireNet = this.salaireNetAvantImpot();
    double prov = 0.20;
    return prov * salaireNet;
    }

public double salaireNetApresImpot(){
    double salaireNet = this.salaireNetAvantImpot();
    return salaireNet - this.impotFederal() - this.impotProvincial();
}
public int joursVacances() {
    char premierNum = numero.charAt(0);
    int jours = 0;
    switch (premierNum) {
        case '1':
            jours = 5 + (1 * anciennete);
            break;
        case '2':
            jours = 10 + (1 * anciennete);
            break;
        case '3':
            jours = 15 + (1 * anciennete);
            break;
        case '4':
            jours = 20 + (1 * anciennete);
            break;

    }
    return jours;
}


public void heuresSup(float nombre){
    nbreHeuresSemaine += nombre;
    }



}




