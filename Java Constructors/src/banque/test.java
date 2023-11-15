package banque;

public class test {
    public static void main(String[] args){


    compteBancaire FlavienLarrivee = new compteBancaire("Flavien Larrivee",100);

    compteBancaire DeniseLachance = new compteBancaire("Denise Lachance",36.78);

    System.out.println(FlavienLarrivee.getNomProprio());

    DeniseLachance.retirer(20);

    System.out.println(FlavienLarrivee.getNumeroCompte());

    compteBancaire MartialMaurice = new compteBancaire("Martial Maurice", 40);

    System.out.println(MartialMaurice.getNumeroCompte());

    System.out.println(DeniseLachance.getSoldeCompte());







    }



}
