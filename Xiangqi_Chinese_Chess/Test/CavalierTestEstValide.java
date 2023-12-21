import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Pieces.Cavalier;
import Pieces.Position;

public class CavalierTestEstValide {

    Cavalier cavalierRouge = new Cavalier("cavalierRouge", "rouge");
    Cavalier cavalierNoir = new Cavalier("cavalierNoir", "noir");


    @Test
    public void cavalierRougeValide(){
        Position depart = new Position(7, 2);
        cavalierRouge.setPositionDepart(depart);
        Position arrivee = new Position(5, 3);
        cavalierRouge.setPositionArrivee(arrivee);
        assertEquals(true, cavalierRouge.estValide(depart, arrivee));
    }


    @Test
    public void cavalierRougeValide2(){
        Position depart = new Position(7, 2);
        cavalierRouge.setPositionDepart(depart);
        Position arrivee = new Position(5, 1);
        cavalierRouge.setPositionArrivee(arrivee);
        assertEquals(true, cavalierRouge.estValide(depart, arrivee));
    }
    @Test
    public void cavalierRougeValide3(){
        Position depart = new Position(7, 2);
        cavalierRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 3);
        cavalierRouge.setPositionArrivee(arrivee);
        assertEquals(true, cavalierRouge.estValide(depart, arrivee));
    }


    @Test
    public void cavalierRougeInvalide(){
        Position depart = new Position(7, 2);
        cavalierRouge.setPositionDepart(depart);
        Position arrivee = new Position(5,2);
        cavalierRouge.setPositionArrivee(arrivee);
        assertEquals(false, cavalierRouge.estValide(depart, arrivee));
    }
    @Test
    public void cavalierRougeInvalide2(){
        Position depart = new Position(7, 2);
        cavalierRouge.setPositionDepart(depart);
        Position arrivee = new Position(7,3);
        cavalierRouge.setPositionArrivee(arrivee);
        assertEquals(false, cavalierRouge.estValide(depart, arrivee));
    }

    @Test
    public void cavalierNoirValide(){
        Position depart = new Position(0, 1);
        cavalierNoir.setPositionDepart(depart);
        Position arrivee = new Position(2,2);
        cavalierNoir.setPositionArrivee(arrivee);
        assertEquals(true, cavalierNoir.estValide(depart, arrivee));
    }
    @Test
    public void cavalierNoirValide2(){
        Position depart = new Position(0, 1);
        cavalierNoir.setPositionDepart(depart);
        Position arrivee = new Position(1,3);
        cavalierNoir.setPositionArrivee(arrivee);
        assertEquals(true, cavalierNoir.estValide(depart, arrivee));
    }

    @Test
    public void cavalierNoirValide3(){
        Position depart = new Position(0, 1);
        cavalierNoir.setPositionDepart(depart);
        Position arrivee = new Position(2,0);
        cavalierNoir.setPositionArrivee(arrivee);
        assertEquals(true, cavalierNoir.estValide(depart, arrivee));
    }

    @Test
    public void cavalierNoirInvlaide(){
        Position depart = new Position(0, 1);
        cavalierNoir.setPositionDepart(depart);
        Position arrivee = new Position(0,3);
        cavalierNoir.setPositionArrivee(arrivee);
        assertEquals(false, cavalierNoir.estValide(depart, arrivee));
    }

    @Test
    public void cavalierNoirInvlaide2(){
        Position depart = new Position(0, 1);
        cavalierNoir.setPositionDepart(depart);
        Position arrivee = new Position(2,1);
        cavalierNoir.setPositionArrivee(arrivee);
        assertEquals(false, cavalierNoir.estValide(depart, arrivee));
    }



}