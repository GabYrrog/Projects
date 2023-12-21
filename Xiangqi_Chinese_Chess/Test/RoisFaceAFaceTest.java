import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import Pieces.*;

import static org.junit.jupiter.api.Assertions.*;


public class RoisFaceAFaceTest {

    Echiquier test = new Echiquier();


    @Test
    public void RoisFaceAFace() {
        test.getIntersection(0, 4).setPiece(new Roi("roiNoir", "noir"));
        test.getIntersection(9, 4).setPiece(new Roi("roiRouge", "rouge"));


        assertEquals(true, test.roisFaceAFace());
    }

    @Test
    public void RoisPasFaceAFace() {
        test.getIntersection(0, 4).setPiece(new Roi("roiNoir", "noir"));
        test.getIntersection(9, 3).setPiece(new Roi("roiRouge", "rouge"));


        assertEquals(false, test.roisFaceAFace());
    }

}
