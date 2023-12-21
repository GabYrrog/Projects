
import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class ValidationHorizontaleTest {


    @Test
    public void HorizontalAvecObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));
        test.getIntersection(7, 5).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(7, 8);

        assertEquals(false, test.validationHorizontale(depart, arrivee));
    }

    @Test
    public void HorizontalSansObstacle() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(7, 8);

        assertEquals(true, test.validationHorizontale(depart, arrivee));
    }

}