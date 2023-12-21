import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Pieces.Char;
import Pieces.Position;

public class CharTestEstValide {
    Char charRouge = new Char("charRouge", "rouge");
    Char charNoir = new Char("charNoir", "noir");

    @Test
    public void charRougeLigneDroiteVerticale(){
        Position depart = new Position(9, 1);
        charRouge.setPositionDepart(depart);
        Position arrivee = new Position(0, 1);
        charRouge.setPositionArrivee(arrivee);
        assertEquals(true, charRouge.estValide(depart,arrivee));
    }
    @Test
    public void charRougeLigneDroiteHorizontale(){
        Position depart = new Position(6, 4);
        charRouge.setPositionDepart(depart);
        Position arrivee = new Position(6, 3);
        charRouge.setPositionArrivee(arrivee);
        assertEquals(true, charRouge.estValide(depart,arrivee));
    }

    @Test
    public void charRougeDiagonale(){
        Position depart = new Position(9, 1);
        charRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 3);
        charRouge.setPositionArrivee(arrivee);
        assertEquals(false, charRouge.estValide(depart,arrivee));
    }
    @Test
    public void charRougeCommeCavalier(){
        Position depart = new Position(3, 3);
        charRouge.setPositionDepart(depart);
        Position arrivee = new Position(4, 5);
        charRouge.setPositionArrivee(arrivee);
        assertEquals(false, charRouge.estValide(depart,arrivee));
    }
    @Test
    public void charNoirLigneDroiteVerticale(){
        Position depart = new Position(0, 1);
        charNoir.setPositionDepart(depart);
        Position arrivee = new Position(9, 1);
        charNoir.setPositionArrivee(arrivee);
        assertEquals(true, charNoir.estValide(depart,arrivee));
    }
    @Test
    public void charNoirLigneDroiteHorizontale(){
        Position depart = new Position(0, 1);
        charNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 8);
        charNoir.setPositionArrivee(arrivee);
        assertEquals(true, charNoir.estValide(depart,arrivee));
    }
    @Test
    public void charNoirDiagonale(){
        Position depart = new Position(0, 1);
        charNoir.setPositionDepart(depart);
        Position arrivee = new Position(3, 4);
        charNoir.setPositionArrivee(arrivee);
        assertEquals(false, charNoir.estValide(depart,arrivee));
    }
    @Test
    public void charNoirNonCommeCavalier(){
        Position depart = new Position(5, 2);
        charNoir.setPositionDepart(depart);
        Position arrivee = new Position(7, 1);
        charNoir.setPositionArrivee(arrivee);
        assertEquals(false, charNoir.estValide(depart,arrivee));
    }

}
