import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Pieces.Elephant;
import Pieces.Position;

public class ElephantTestEstValide {
    Elephant elephantRouge = new Elephant("elephantRouge", "rouge");
    Elephant elephantNoir = new Elephant("elephantNoir", "noir");

    @Test
    public void elephantRougeDiagoDe2DeSonCote(){
        Position depart = new Position(7, 2);
        elephantRouge.setPositionDepart(depart);
        Position arrivee = new Position(5, 4);
        elephantRouge.setPositionArrivee(arrivee);
        assertEquals(true, elephantRouge.estValide(depart, arrivee));
    }
    @Test
    public void elephantRougeDiagoDe2DeSonCoteReculon(){
        Position depart = new Position(5, 4);
        elephantRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 2);
        elephantRouge.setPositionArrivee(arrivee);
        assertEquals(true, elephantRouge.estValide(depart, arrivee));
    }
    @Test
    public void elephantRougeLigneDroiteVerticale(){
        Position depart = new Position(7, 2);
        elephantRouge.setPositionDepart(depart);
        Position arrivee = new Position(5, 2);
        elephantRouge.setPositionArrivee(arrivee);
        assertEquals(false, elephantRouge.estValide(depart, arrivee));
    }
    @Test
    public void elephantRougeLigneDroiteHorizontale(){
        Position depart = new Position(7, 2);
        elephantRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 6);
        elephantRouge.setPositionArrivee(arrivee);
        assertEquals(false, elephantRouge.estValide(depart, arrivee));
    }
    @Test
    public void elephantRougeLigneDroiteVerticaleReculon(){
        Position depart = new Position(7, 2);
        elephantRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 2);
        elephantRouge.setPositionArrivee(arrivee);
        assertEquals(false, elephantRouge.estValide(depart, arrivee));
    }
    @Test
    public void elephantRougeAutreCoteRiviere(){
        Position depart = new Position(5, 2);
        elephantRouge.setPositionDepart(depart);
        Position arrivee = new Position(3, 0);
        elephantRouge.setPositionArrivee(arrivee);
        assertEquals(false, elephantRouge.estValide(depart, arrivee));
    }
    @Test
    public void elephantNoirDiagoDe2DeSonCote(){
        Position depart = new Position(2, 2);
        elephantNoir.setPositionDepart(depart);
        Position arrivee = new Position(4, 4);
        elephantNoir.setPositionArrivee(arrivee);
        assertEquals(true, elephantNoir.estValide(depart, arrivee));
    }
    @Test
    public void elephantNoirDiagoDe2DeSonCoteReculon(){
        Position depart = new Position(4, 4);
        elephantNoir.setPositionDepart(depart);
        Position arrivee = new Position(2, 2);
        elephantNoir.setPositionArrivee(arrivee);
        assertEquals(true, elephantNoir.estValide(depart, arrivee));
    }
    @Test
    public void elephantNoirLigneDroiteVerticale(){
        Position depart = new Position(2, 2);
        elephantNoir.setPositionDepart(depart);
        Position arrivee = new Position(4, 2);
        elephantNoir.setPositionArrivee(arrivee);
        assertEquals(false, elephantNoir.estValide(depart, arrivee));
    }
    @Test
    public void elephantNoirLigneDroiteHorizontale(){
        Position depart = new Position(2, 2);
        elephantNoir.setPositionDepart(depart);
        Position arrivee = new Position(2, 6);
        elephantNoir.setPositionArrivee(arrivee);
        assertEquals(false, elephantNoir.estValide(depart, arrivee));
    }
    @Test
    public void elephantNoirLigneDroiteVerticaleReculon(){
        Position depart = new Position(2, 2);
        elephantNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 2);
        elephantNoir.setPositionArrivee(arrivee);
        assertEquals(false, elephantNoir.estValide(depart, arrivee));
    }
    @Test
    public void elephantNoirAutreCoteDeLaRiviere(){
        Position depart = new Position(4, 6);
        elephantNoir.setPositionDepart(depart);
        Position arrivee = new Position(6, 4);
        elephantNoir.setPositionArrivee(arrivee);
        assertEquals(false, elephantNoir.estValide(depart, arrivee));
    }
}
