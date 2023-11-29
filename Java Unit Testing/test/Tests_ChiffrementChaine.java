import codes_secrets.ChiffrementChaine;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class Tests_ChiffrementChaine {
    private ChiffrementChaine chiffrement;
    @BeforeAll
    public static void debutTests() {
        System.out.println("Début des tests");
    }
@BeforeEach
public void ObjetDeTest(){
   chiffrement = new ChiffrementChaine();
}
@Test
public void testChiffrerChaineVide(){
   String chaineTest = "";
   assertEquals("", chiffrement.ChiffrerChaine(chaineTest));
}

@Test
public void testChiffrerChaineUnArgument(){
String chaineTest = "Gabriel";
assertEquals("Qkl|sov", chiffrement.ChiffrerChaine(chaineTest));
}
@Test
public void testChiffrerChaineDeuxArgument(){
     String chaineTest = "Gabriel";
     assertEquals("Smn~uqx", chiffrement.ChiffrerChaine(chaineTest, 12));
}

@Test
public void testChiffrerCaracteresSpeciaux(){
   String chaineTest = "*&^";
   assertEquals("40h", chiffrement.ChiffrerChaine(chaineTest, 10));
}
@Test
public void testChiffrerChaineComplexe(){
     String chaineTest = "Gab176%$gab89-*";
     assertEquals("Qkl;A@/.qklBC74", chiffrement.ChiffrerChaine(chaineTest, 10));
}
@Test
public void testChiffrerToutMajuscule(){
    String chaineTest = "ALLOLEMONDE";
    assertEquals("KVVYVOWYXNO", chiffrement.ChiffrerChaine(chaineTest, 10));
    }

@Test
public void testChiffrerDeltaPlusQueCent(){
        String chaineTest = "Gabriel";
        assertEquals("", chiffrement.ChiffrerChaine(chaineTest, 101));
    }

@Test
public void testChiffrerDeltaMoinsQueMoinsDix(){
    String chaineTest = "Gabriel";
    assertEquals("", chiffrement.ChiffrerChaine(chaineTest, -11));

}

@Test
public void testDechiffrerDeltaAvantChaine(){
        String chaineADechiffrer = "Qkl|sov";
        assertEquals("Gabriel", ChiffrementChaine.DechiffrerChaine(10, chaineADechiffrer));

}
@Test
public void testDechiffrerChaineAvantDelta(){
     String chaineADechiffrer = "Qkl|sov";
     assertEquals("Gabriel", ChiffrementChaine.DechiffrerChaine(chaineADechiffrer, 10));

}

@Test
public void testDechiffrerChaineVide(){
    String chaineADechiffrer = "";
    assertEquals("", ChiffrementChaine.DechiffrerChaine(chaineADechiffrer, 10));

}
@Test
public void testDechiffrerDeltaSurCent(){
    String chaineADechiffrer = "Lfgwnjq";
    assertEquals("Gabriel", ChiffrementChaine.DechiffrerChaine(chaineADechiffrer, 100));

}

@Test
public void testDechiffrerDeltaSurMoinsDix(){
     String chaineADechiffrer = "=WXh_[b";
     assertEquals("Gabriel", ChiffrementChaine.DechiffrerChaine(chaineADechiffrer, -10));

    }

@Test
public void testDechiffrerDeltaPlusGrandQueCent(){
   String chaineADechiffrer = "Qkl|sov";
   assertEquals("", ChiffrementChaine.DechiffrerChaine(chaineADechiffrer, 101));

}
@Test
public void testDechiffrerDeltaPlusGrandQueCentEtDeltaAvantChaine(){
     String chaineADechiffrer = "Qkl|sov";
     assertEquals("", ChiffrementChaine.DechiffrerChaine(101, chaineADechiffrer));

}

@Test
public void testDechiffrerDeltaPlusPetitQueMoinsDix(){
        String chaineADechiffrer = "Qkl|sov";
        assertEquals("", ChiffrementChaine.DechiffrerChaine(chaineADechiffrer, -11));
}
@Test
public void testDechiffrerDeltaPlusPetitQueMoinsDixEtDeltaAvantChaine(){
    String chaineADechiffrer = "Qkl|sov";
    assertEquals("", ChiffrementChaine.DechiffrerChaine(-11,chaineADechiffrer));
}

    @AfterAll
    public static void finTests() {
        System.out.println("Fin de tous les tests");
    }

}
