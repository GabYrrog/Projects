package test_chaine;

import codes_secrets.ChiffrementChaine;
import validations_speciales.Validation;

public class TestChaine {
    public static void main(String[] args){

    String chaineTestCodeClient = "abc12345678*";
    String chaineTestNoSerie = "abcde123456-&";
    String chaineTestTelephone = "123-456-7890";

    String fauxChaineTestCodeClient = "abc";
    String fauxChaineTestNoSerie = "abc";
    String fauxChaineTestTelephone = "123";

    ChiffrementChaine chiffrement = new ChiffrementChaine();
    ChiffrementChaine chiffrementDelta = new ChiffrementChaine(10);
    chiffrement.setChaineAChiffrer("ALLOLEMONDE");
    chiffrement.setDelta(10);
    String chaineEncryptee = chiffrement.ChiffrerChaine(chiffrement.getChaineAChiffrer());
    //String chaineDecryptee = ChiffrementChaine.DechiffrerChaine(10, chaineEncryptee);

    System.out.println(chaineEncryptee);
    //System.out.println(chaineDecryptee);

    System.out.println(Validation.ValiderCodeClient(chaineTestCodeClient));
    System.out.println(Validation.ValiderNoSerie(chaineTestNoSerie));
    System.out.println(Validation.ValiderTelephone(chaineTestTelephone));

    System.out.println(Validation.ValiderCodeClient(fauxChaineTestCodeClient));
    System.out.println(Validation.ValiderNoSerie(fauxChaineTestNoSerie));
    System.out.println(Validation.ValiderTelephone(fauxChaineTestTelephone));


    }


}
