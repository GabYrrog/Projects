
import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class ValidationVerticaleTest {


    @Test
    public void VerticaleAvecObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));
        test.getIntersection(3, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(0, 2);

        assertEquals(false, test.validationVerticale(depart, arrivee));
    }

    @Test
    public void VerticaleSansObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(0, 2);

        assertEquals(true, test.validationVerticale(depart, arrivee));
    }

}