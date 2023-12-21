import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Pieces.Pion;
import Pieces.Position;


public class PionTestEstValide {

    Pion pionRouge = new Pion("testRouge", "rouge");
    Pion pionNoir = new Pion("testNoir", "noir");



    @Test
    public void testRougeAvantRiviereAvanceDe1() {
        Position depart = new Position(6, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(5, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(true, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeSurPlace() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(3, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(true, pionRouge.estValide(depart, arrivee));
    }

    @Test

    public void testRougeApresRiviereAvanceDe1() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(2, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(true, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeAvantRiviereAvanceDe2() {
        Position depart = new Position(6, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(4, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeApresRiviereAvanceDe2() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(1, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeAvantRiviereReculeDe1() {
        Position depart = new Position(6, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeApresRiviereReculeDe1() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(4, 2);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeAvantRiviereCoteDroit() {
        Position depart = new Position(6, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(6, 3);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeAvantRiviereCoteGauche() {
        Position depart = new Position(6, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(6, 1);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeApresRiviereCoteGauche() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(3, 1);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(true, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeApresRiviereCoteDroit() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(3, 3);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(true, pionRouge.estValide(depart, arrivee));
    }

    @Test
    public void testRougeDiagonale() {
        Position depart = new Position(3, 2);
        pionRouge.setPositionDepart(depart);
        Position arrivee = new Position(4, 1);
        pionRouge.setPositionArrivee(arrivee);
        assertEquals(false, pionRouge.estValide(depart, arrivee));
    }

}







