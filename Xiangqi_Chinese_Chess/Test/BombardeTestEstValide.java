import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Pieces.Bombarde;
import Pieces.Position;

public class BombardeTestEstValide {
    Bombarde bombardeRouge = new Bombarde("bombardeRouge", "rouge");
    Bombarde bombardeNoir = new Bombarde("bombardeNoir", "noir");

    @Test
    public void bombardeRougeLigneDroiteVerticale(){
        Position depart = new Position(9, 1);
        bombardeRouge.setPositionDepart(depart);
        Position arrivee = new Position(0, 1);
        bombardeRouge.setPositionArrivee(arrivee);
        assertEquals(true, bombardeRouge.estValide(depart,arrivee));
    }
    @Test
    public void bombardeRougeLigneDroiteHorizontale(){
        Position depart = new Position(6, 4);
        bombardeRouge.setPositionDepart(depart);
        Position arrivee = new Position(6, 3);
        bombardeRouge.setPositionArrivee(arrivee);
        assertEquals(true, bombardeRouge.estValide(depart,arrivee));
    }

    @Test
    public void bombardeRougeDiagonale(){
        Position depart = new Position(9, 1);
        bombardeRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 3);
        bombardeRouge.setPositionArrivee(arrivee);
        assertEquals(false, bombardeRouge.estValide(depart,arrivee));
    }
    @Test
    public void bombardeRougeCommeCavalier(){
        Position depart = new Position(3, 3);
        bombardeRouge.setPositionDepart(depart);
        Position arrivee = new Position(4, 5);
        bombardeRouge.setPositionArrivee(arrivee);
        assertEquals(false, bombardeRouge.estValide(depart,arrivee));
    }
    @Test
    public void bombardeNoirLigneDroiteVerticale(){
        Position depart = new Position(0, 1);
        bombardeNoir.setPositionDepart(depart);
        Position arrivee = new Position(9, 1);
        bombardeNoir.setPositionArrivee(arrivee);
        assertEquals(true, bombardeNoir.estValide(depart,arrivee));
    }
    @Test
    public void bombardeNoirLigneDroiteHorizontale(){
        Position depart = new Position(0, 1);
        bombardeNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 8);
        bombardeNoir.setPositionArrivee(arrivee);
        assertEquals(true, bombardeNoir.estValide(depart,arrivee));
    }
    @Test
    public void bombardeNoirDiagonale(){
        Position depart = new Position(0, 1);
        bombardeNoir.setPositionDepart(depart);
        Position arrivee = new Position(3, 4);
        bombardeNoir.setPositionArrivee(arrivee);
        assertEquals(false, bombardeNoir.estValide(depart,arrivee));
    }
    @Test
    public void bombardeNoirNonCommeCavalier(){
        Position depart = new Position(5, 2);
        bombardeNoir.setPositionDepart(depart);
        Position arrivee = new Position(7, 1);
        bombardeNoir.setPositionArrivee(arrivee);
        assertEquals(false, bombardeNoir.estValide(depart,arrivee));
    }

}

