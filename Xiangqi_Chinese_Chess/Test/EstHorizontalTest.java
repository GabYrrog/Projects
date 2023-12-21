import Tableau_de_Jeu.Echiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Pieces.*;

public class EstHorizontalTest {
    @Test
    public void DeplacementHorizontalADroite(){
        Echiquier test = new Echiquier();
        Position depart = new Position(7,2);
        Position arrivee = new Position(7, 8);

        assertEquals(true, test.estHorizontal(depart,arrivee) );

    }

    @Test
    public void DeplacementHorizontalAGauche(){
        Echiquier test = new Echiquier();
        Position depart = new Position(7,2);
        Position arrivee = new Position(7, 0);

        assertEquals(true, test.estHorizontal(depart,arrivee) );

    }

    @Test
    public void DeplacementVerticalEnHaut(){
        Echiquier test = new Echiquier();
        Position depart = new Position(7,2);
        Position arrivee = new Position(0, 2);

        assertEquals(false, test.estHorizontal(depart,arrivee) );

    }

    @Test
    public void DeplacementVerticalEnBas(){
        Echiquier test = new Echiquier();
        Position depart = new Position(7,2);
        Position arrivee = new Position(9, 2);

        assertEquals(false, test.estHorizontal(depart,arrivee) );

    }

    @Test
    public void DeplacementDiagonale(){
        Echiquier test = new Echiquier();
        Position depart = new Position(7,2);
        Position arrivee = new Position(5, 4);

        assertEquals(false, test.estHorizontal(depart,arrivee) );

    }



}
