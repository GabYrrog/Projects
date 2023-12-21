import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import Pieces.*;

import static org.junit.jupiter.api.Assertions.*;


public class TrouverPositionRoisTest {

    Echiquier test = new Echiquier();


    @Test
    public void PositionRois() {
        test.getIntersection(0, 4).setPiece(new Roi("roiNoir", "noir"));
        System.out.println(test.getIntersection(0,4).getPiece().getCouleur());
        System.out.println(test.getIntersection(0,4).getPiece() instanceof Roi);
        System.out.println(test.trouverPositionRoi("noir"));
        Position positionRoi = new Position(0, 4);
        Position actualPosition = test.trouverPositionRoi("noir");
        assertNotNull(actualPosition);
        assertEquals(positionRoi.getLigne(), actualPosition.getLigne());
        assertEquals(positionRoi.getColonne(), actualPosition.getColonne());
        assertEquals(new Position(0,4), test.trouverPositionRoi("noir"));
    }

//    @Test
//    public void PositionRois2() {
//        test.getIntersection(0, 4).setPiece(new Roi("roiNoir", "noir"));
//        Position expectedPosition = new Position(0, 4);
//        Position actualPosition = test.trouverPositionRoi("noir");
//
//        assertNotNull(actualPosition);
//        assertEquals(expectedPosition.getLigne(), actualPosition.getLigne());
//        assertEquals(expectedPosition.getColonne(), actualPosition.getColonne());
//    }

}