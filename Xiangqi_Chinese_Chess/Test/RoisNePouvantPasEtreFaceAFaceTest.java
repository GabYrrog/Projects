import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import Pieces.*;

import static org.junit.jupiter.api.Assertions.*;


public class RoisNePouvantPasEtreFaceAFaceTest {

    Echiquier test = new Echiquier();


    @Test
    public void RoisSansObstacle() {
        test.getIntersection(0, 4).setPiece(new Roi("roiNoir", "noir"));
        test.getIntersection(9, 4).setPiece(new Roi("roiRouge", "rouge"));
        test.getIntersection(4, 4).setPiece(new Pion("pionTest", "noir"));
        Position departPion = new Position(4,4);
        Position arriveePion = new Position(4,3);
        assertEquals(true, test.roisNePouvantPasEtreFaceAFace(departPion,arriveePion));
    }
    @Test
    public void RoisAvecObstacle() {
        test.getIntersection(0, 4).setPiece(new Roi("roiNoir", "noir"));
        test.getIntersection(9, 4).setPiece(new Roi("roiRouge", "rouge"));
        test.getIntersection(4, 3).setPiece(new Pion("pionTest", "noir"));
        Position departPion = new Position(4,3);
        Position arriveePion = new Position(4,4);
        assertEquals(false, test.roisNePouvantPasEtreFaceAFace(departPion,arriveePion));
    }


}
