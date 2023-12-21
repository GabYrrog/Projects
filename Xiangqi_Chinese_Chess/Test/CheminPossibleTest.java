import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class CheminPossibleTest {


    @Test
    public void TestBombardeAvecObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));

    }
    @Test
    public void TestBombardeSansObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));

    }
    @Test
    public void TestBombardeAvecCaptureDonc1Obstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(1, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));
        test.getIntersection(3, 2).setPiece(new Pion("pionDansLeChemin2", "rouge"));
        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestBombardeAvecTentativeCaptureMaisDeuxObstacles(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(1, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));
        test.getIntersection(3, 2).setPiece(new Pion("pionDansLeChemin2", "rouge"));
        test.getIntersection(4, 2).setPiece(new Pion("pionDansLeChemin2", "rouge"));
        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestBombardeSansMouvement(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(1, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(7, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));

    }
    @Test
    public void TestBombardeMemeCouleurArriveeSansObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(1, 2).setPiece(new Pion("pionDansLeChemin", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestBombardeMemeCouleurArriveeAvecObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Bombarde("bombarde", "noir"));
        test.getIntersection(1, 2).setPiece(new Pion("pionDansLeChemin", "noir"));
        test.getIntersection(5, 2).setPiece(new Pion("pionDansLeChemin2", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(1, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCavalierAvecObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 3);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCavalierSansObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 3);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCavalierAvecCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(5, 3).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 3);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCavalierMemeCouleurArrivee(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Cavalier("cavalier", "noir"));
        test.getIntersection(5, 3).setPiece(new Pion("pionDansLeChemin", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 3);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCharAvecObstacle(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(2, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCharAvecCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));
        test.getIntersection(2, 2).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(2, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCharMemeCouleurArrivee(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));
        test.getIntersection(2, 2).setPiece(new Pion("pionDansLeChemin", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(2, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestCharAvecCaptureHorizontale(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Char("char", "noir"));
        test.getIntersection(7, 8).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(7, 8);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestElephantDeplacementSansCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("elephant", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 4);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestElephantAvecCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("elephant", "noir"));
        test.getIntersection(5, 4).setPiece(new Pion("pionDansLeChemin", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 4);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestElephantMemeCouleurArrivee(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Elephant("elephant", "noir"));
        test.getIntersection(5, 4).setPiece(new Pion("pionDansLeChemin", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(5, 4);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestMandarinDeplacementSansCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Mandarin("mandarin", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 3);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    // Les autres tests du mandarin sont les memes a ce stade-ci que lelephant
    @Test
    public void TestPionDeplacementSansCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Pion("pion", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestPionAvecCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Pion("pion", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionACapturer", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestPionMemeCouleurArrivee(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Pion("pion", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionACapturer", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestRoiMemeCouleurArrivee(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Roi("roi", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionACapturer", "noir"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 2);

        assertEquals(false, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestRoiAvecCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Roi("roi", "noir"));
        test.getIntersection(6, 2).setPiece(new Pion("pionACapturer", "rouge"));

        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
    @Test
    public void TestRoiDeplacementSansCapture(){
        Echiquier test = new Echiquier();
        test.getIntersection(7, 2).setPiece(new Roi("roi", "noir"));


        Position depart = new Position(7, 2);
        Position arrivee = new Position(6, 2);

        assertEquals(true, test.cheminPossible(depart, arrivee));
    }
}
