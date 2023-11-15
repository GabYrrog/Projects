package l03bgym;

public class testconstructeur {

    public static void main(String[] args){

        abonnementgym abonnementBase = new abonnementgym(41.25);
        abonnementgym abonnementCarte = new abonnementgym(15, 8.25);
        abonnementgym abonnementVIP = new abonnementgym(45, 5.0, "Gab");

        System.out.println(abonnementVIP.getPrix());
        System.out.println(abonnementCarte.getPrix());
        System.out.println(abonnementBase.getPrix());


    }


}
