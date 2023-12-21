import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Pieces.Roi;
import Pieces.Position;

public class RoiTestEstValide {

    Roi roiRouge = new Roi("roiRouge", "rouge");
    Roi roiNoir = new Roi("roiNoir", "noir");



    @Test

    public void roiRougeAvanceDe1(){
        Position depart = new Position(9, 4);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(8, 4);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(true, roiRouge.estValide(depart,arrivee));
    }
    @Test
    public void roiRougeAvanceDe2(){
        Position depart = new Position(9, 4);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 4);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(false, roiRouge.estValide(depart,arrivee));
    }
    @Test
    public void roiRougeCoteDe1(){
        Position depart = new Position(9, 4);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 5);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(true, roiRouge.estValide(depart,arrivee));
    }
    @Test
    public void roiRougeCoteDe2(){
        Position depart = new Position(9, 4);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 6);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(false, roiRouge.estValide(depart,arrivee));
    }
    @Test
    public void roiRougeReculeDe1(){
        Position depart = new Position(8, 4);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 6);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(false, roiRouge.estValide(depart,arrivee));
    }
    @Test
    public void roiRougeDiagonale(){
        Position depart = new Position(9, 4);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(8, 5);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(false, roiRouge.estValide(depart,arrivee));
    }
    @Test
    public void roiRougeHorsDuPalai(){
        Position depart = new Position(9, 3);
        roiRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 2);
        roiRouge.setPositionArrivee(arrivee);
        assertEquals(false, roiRouge.estValide(depart,arrivee));
    }

    @Test
    public void roiNoirAvanceDe1(){
        Position depart = new Position(0, 4);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(1, 4);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(true, roiNoir.estValide(depart,arrivee));
    }

    @Test
    public void roiNoirAvanceDe2(){
        Position depart = new Position(0, 4);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(2, 4);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(false, roiNoir.estValide(depart,arrivee));
    }
    @Test
    public void roiNoirCoteDe1(){
        Position depart = new Position(0, 4);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 5);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(true, roiNoir.estValide(depart,arrivee));
    }
    @Test
    public void roiNoirCoteDe2(){
        Position depart = new Position(0, 4);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 2);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(false, roiNoir.estValide(depart,arrivee));
    }
    @Test
    public void roiNoirReculeDe1(){
        Position depart = new Position(1, 4);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 2);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(false, roiNoir.estValide(depart,arrivee));
    }
    @Test
    public void roiNoirDiagonale(){
        Position depart = new Position(0, 4);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(1, 3);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(false, roiNoir.estValide(depart,arrivee));
    }
    @Test
    public void roiNoirHorsDuPalais(){
        Position depart = new Position(3, 2);
        roiNoir.setPositionDepart(depart);
        Position arrivee = new Position(3, 3);
        roiNoir.setPositionArrivee(arrivee);
        assertEquals(false, roiNoir.estValide(depart,arrivee));
    }




}
