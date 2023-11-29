import org.junit.jupiter.api.*;
import validations_speciales.Validation;

import static org.junit.jupiter.api.Assertions.*;

public class Tests_Validation {

    @BeforeAll
    public static void debutTests(){
        System.out.println("Début des tests");
    }

    @Test
    public void testCodeClientVide(){
        String stringTestCodeCLient = "";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeCLient));
    }

    @Test
    public void testCodeClientEtoile(){
        String stringTestCodeClient = "abc12345678*";
        assertEquals(true, Validation.ValiderCodeClient(stringTestCodeClient));
 }
    @Test
    public void testCodeClientDiese(){
        String stringTestCodeClient = "abc12345678#";
        assertEquals(true, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientRienApres(){
        String stringTestCodeClient = "abc12345678";
        assertEquals(true, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientLettresEtChiffresInverses(){
        String stringTestCodeClient = "12345678abc";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientCaractereAuDebut(){
        String stringTestCodeClient = "*abc12345678";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientBlancAuDebut(){
        String stringTestCodeClient = " abc12345678";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientMoinsDeTroisLettres(){
        String stringTestCodeClient = "ab12345678";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientPlusDeTroisLettres(){
        String stringTestCodeClient = "abcd12345678";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientMoinsDeHuitChiffres(){
        String stringTestCodeClient = "abc1234567";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientPlusDeHuitCiffres(){
        String stringTestCodeClient = "abc123456789";
        assertEquals(false, Validation.ValiderCodeClient(stringTestCodeClient));
    }
    @Test
    public void testCodeClientMajuscules(){
        String stringTestCodeClient = "ABC12345678";
        assertEquals(true, Validation.ValiderCodeClient(stringTestCodeClient));
    }

    @Test
    public void testNoSerieVide(){
        String stringTestNoSerie = "";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }

    @Test
    public void testNoSerieNimporteQuelCaractere(){
        String stringTestNoSerie = "abcde123456-&";
        assertEquals(true, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieLettreApresTiret(){
        String stringTestNoSerie = "abcde123456-a";
        assertEquals(true, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieMajuscules(){
        String stringTestNoSerie = "ABCDE123456-&";
        assertEquals(true, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieTroisLettres(){
        String stringTestNoSerie = "abc123456-&";
        assertEquals(true, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieHuitLettres(){
        String stringTestNoSerie = "abcdefgh123456-&";
        assertEquals(true, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieEspaceBlanc(){
        String stringTestNoSerie = "abcde123456- ";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }

    @Test
    public void testNoSeriePasDeTiret(){
        String stringTestNoSerie = "abcde123456*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSeriePlusDeSixChiffres(){
        String stringTestNoSerie = "abcde1234567-*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieMoinsDeSixChiffres(){
        String stringTestNoSerie = "abcde12345-*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieMoinsDeTroisLettres(){
        String stringTestNoSerie = "ab123456-*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSeriePlusDeHuitLettres(){
        String stringTestNoSerie = "abcdefghi123456-*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieLettresEtChiffresInverses(){
        String stringTestNoSerie = "123456abcd-*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieTiretAuDebut(){
        String stringTestNoSerie = "-abcd123456*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieCaractereAuDebut(){
        String stringTestNoSerie = "*abcd123456-";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testNoSerieBlancAuDebut(){
        String stringTestNoSerie = " abcd123456-*";
        assertEquals(false, Validation.ValiderNoSerie(stringTestNoSerie));
    }
    @Test
    public void testTelephoneVide(){
        String stringTestTelephone = "";
        assertEquals(false, Validation.ValiderTelephone(stringTestTelephone));
    }

    @Test
    public void testTelephoneSansEspace(){
        String stringTestTelephone = "1234567890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneAvecTirets(){
        String stringTestTelephone = "123-456-7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneDeuxiemeTiret(){
        String stringTestTelephone = "123 456-7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneAvecEspaces(){
        String stringTestTelephone = "123 456 7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneAvecParenthesesDebut(){
        String stringTestTelephone = "(123)456-7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneAvecParenthesesDebutEtEspace(){
        String stringTestTelephone = "(123) 456-7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneCrochetsDebut(){
        String stringTestTelephone = "[123]456-7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneCrochetsDebutEtEspace(){
        String stringTestTelephone = "[123] 456-7890";
        assertEquals(true, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneCrochetsAvecTiret(){
        String stringTestTelephone = "[123]-456-7890";
        assertEquals(false, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneParenthesesAvecTiret(){
        String stringTestTelephone = "(123)-456-7890";
        assertEquals(false, Validation.ValiderTelephone(stringTestTelephone));
    }
    @Test
    public void testTelephoneOnzeChifrres(){
        String stringTestTelephone = "12345678901";
        assertEquals(false, Validation.ValiderTelephone(stringTestTelephone));
    }

    @AfterAll
    public static void finTests(){
        System.out.println("Fin de tous les tests");
 }


}
