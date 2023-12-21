
import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class ValidationBombardeTest {


    @Test
    public void BombardeCapture() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));
        test.getIntersection(5, 2).setPiece(new Pion("pionACapturer", "rouge"));
        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 2);

        assertEquals(true, test.validationBombarde(depart, arrivee));
    }
    @Test
    public void BombardeCaptureImpossible() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));

        test.getIntersection(5, 2).setPiece(new Pion("pionACapturer", "rouge"));
        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 2);

        assertEquals(false, test.validationBombarde(depart, arrivee));
    }

    @Test
    public void BombardeDeplacementSansCaptureLigneVerticale() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));

        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 2);

        assertEquals(true, test.validationBombarde(depart, arrivee));
    }


    @Test
    public void BombardeDeplacementCaptureLigneHorizontale() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(7, 3).setPiece(new Pion("pionDansLeChemin", "rouge"));
        test.getIntersection(7, 4).setPiece(new Pion("pionACapturer", "rouge"));
        Position depart = new Position(7,2);
        Position arrivee = new Position(7, 4);

        assertEquals(true, test.validationBombarde(depart, arrivee));
    }


    @Test
    public void BombardeDeplacementSansCaptureLigneHorizontale() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));

        Position depart = new Position(7,2);
        Position arrivee = new Position(7, 4);

        assertEquals(true, test.validationBombarde(depart, arrivee));
    }

    @Test
   public void BombardeCaptureInverseLesCouleurs() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "rouge"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "noir"));
        test.getIntersection(5, 2).setPiece(new Pion("pionACapturer", "noir"));
        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 2);

        assertEquals(true, test.validationBombarde(depart, arrivee));
    }
    @Test
    public void BombardeCaptureInverseLesCouleursLongDeplacement() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "rouge"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "noir"));
        test.getIntersection(0, 2).setPiece(new Pion("pionACapturer", "noir"));
        Position depart = new Position(7,2);
        Position arrivee = new Position(0, 2);

        assertEquals(true, test.validationBombarde(depart, arrivee));
    }

    @Test
    public void BombardeCaptureInverseLesCouleursLongDeplacementDeuxObstacles() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "rouge"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "noir"));
        test.getIntersection(5, 2).setPiece(new Pion("pionDansLeChemin2", "rouge"));
        test.getIntersection(0, 2).setPiece(new Pion("pionACapturer", "noir"));
        Position depart = new Position(7,2);
        Position arrivee = new Position(0, 2);

        assertEquals(false, test.validationBombarde(depart, arrivee));
    }


}
