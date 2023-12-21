
import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class ValidationDiagonaleTest {


    @Test
    public void DiagonaleEnHautADroiteAvecObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));
        test.getIntersection(6, 3).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 8);

        assertEquals(false, test.validationDiagonale(depart, arrivee));
    }

    @Test
    public void DiagonaleEnHautADroiteSansObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 8);

        assertEquals(true, test.validationDiagonale(depart, arrivee));
    }

    @Test
    public void DiagonaleEnHautAGaucheAvecObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));
        test.getIntersection(6, 1).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 0);

        assertEquals(false, test.validationDiagonale(depart, arrivee));
    }
    @Test
    public void DiagonaleEnHautAGaucheSansObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 0);

        assertEquals(true, test.validationDiagonale(depart, arrivee));
    }

    @Test
    public void DiagonaleEnBasADroiteAvecObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));
        test.getIntersection(8, 3).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(9, 4);

        assertEquals(false, test.validationDiagonale(depart, arrivee));
    }
    @Test
    public void DiagonaleEnBasADroiteSansObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(9, 4);

        assertEquals(true, test.validationDiagonale(depart, arrivee));
    }
    @Test
    public void DiagonaleEnBasAGaucheAvecObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));
        test.getIntersection(8, 1).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(9, 0);

        assertEquals(false, test.validationDiagonale(depart, arrivee));
    }
    @Test
    public void DiagonaleEnBasAGaucheSansObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("dumbo", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(9, 0);

        assertEquals(true, test.validationDiagonale(depart, arrivee));
    }

}