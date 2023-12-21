import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DebuterTest {

    Echiquier test = new Echiquier();
    @Test
    public void testDebuterRoiRouge(){
        test.debuter();
        assertEquals("roiRouge",test.getIntersection(9,4).getPiece().getNom());
    }
    @Test
    public void testDebuterRoiNoir(){
        test.debuter();
        assertEquals("roiNoir",test.getIntersection(0,4).getPiece().getNom());
    }
    @Test
    public void testDebuterMandarinRougeGauche(){
        test.debuter();
        assertEquals("mandarinRougeGauche",test.getIntersection(9,3).getPiece().getNom());
    }
    @Test
    public void testDebuterElephantRougeDroite(){
        test.debuter();
        assertEquals("elephantRougeDroite",test.getIntersection(9,6).getPiece().getNom());
    }
    @Test
    public void testDebuterPionRouge3(){
        test.debuter();
        assertEquals("pionRouge3",test.getIntersection(6,4).getPiece().getNom());
    }
    @Test
    public void testDebuterBombardeRougeDroite(){
        test.debuter();
        assertEquals("bombardeRougeDroite",test.getIntersection(7,7).getPiece().getNom());
    }
    @Test
    public void testDebuterBombardeNoirGauche(){
        test.debuter();
        assertEquals("bombardeNoirGauche",test.getIntersection(2,1).getPiece().getNom());
    }
    @Test
    public void testDebuterMandarinNoirDroite(){
        test.debuter();
        assertEquals("mandarinNoirDroite",test.getIntersection(0,5).getPiece().getNom());
    }
    @Test
    public void testDebuterPionNoir1(){
        test.debuter();
        assertEquals("pionNoir1",test.getIntersection(3,0).getPiece().getNom());
    }
    @Test
    public void testDebuterCavalierNoirDroit(){
        test.debuter();
        assertEquals("cavalierNoirDroite",test.getIntersection(0,7).getPiece().getNom());
    }
    @Test
    public void testDebuterCharNoirGauche(){
        test.debuter();
        assertEquals("charNoirGauche",test.getIntersection(0,0).getPiece().getNom());
    }
    @Test
    public void testDebuterElephantNoirDroite(){
        test.debuter();
        assertEquals("elephantNoirDroite",test.getIntersection(0,6).getPiece().getNom());
    }






}
