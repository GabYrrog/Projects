
import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class ValidationCavalierTest {

    @Test
    public void CavalierAvecObstacleVersLeHaut() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 3);

        assertEquals(false, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierAvecObstacleVersLaDroite() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(7, 3).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7,2);
        Position arrivee = new Position(6, 4);

        assertEquals(false, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierAvecObstacleVersLeBas() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(8, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7,2);
        Position arrivee = new Position(9, 1);

        assertEquals(false, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierAvecObstacleVersLaGauche() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(7, 1).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7,2);
        Position arrivee = new Position(6, 0);

        assertEquals(false, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierSansObstacleVersLeHaut() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));


        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 3);

        assertEquals(true, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierSansObstacleVersLaDroite() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));


        Position depart = new Position(7,2);
        Position arrivee = new Position(6, 4);

        assertEquals(true, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierSansObstacleVersLeBas() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));


        Position depart = new Position(7,2);
        Position arrivee = new Position(9, 1);

        assertEquals(true, test.validationCavalier(depart, arrivee));
    }
    @Test
    public void CavalierSansObstacleVersLaGauche() {
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));


        Position depart = new Position(7,2);
        Position arrivee = new Position(6, 0);

        assertEquals(true, test.validationCavalier(depart, arrivee));
    }
}
