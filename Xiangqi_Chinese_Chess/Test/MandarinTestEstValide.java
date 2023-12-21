import org.junit.jupiter.api.Test;
import Pieces.Mandarin;
import Pieces.Position;
import static org.junit.jupiter.api.Assertions.*;


public class MandarinTestEstValide {

    Mandarin mandarinRouge = new Mandarin("mandarinRouge", "rouge");

    Mandarin mandarinNoir = new Mandarin("mandarinNoir", "noir");

    @Test
    public void mandarinRougeDiagoDe1(){
        Position depart = new Position(9, 3);
        mandarinRouge.setPositionDepart(depart);
        Position arrivee = new Position(8, 4);
        mandarinRouge.setPositionArrivee(arrivee);
        assertEquals(true, mandarinRouge.estValide(depart, arrivee));
    }
    @Test
    public void mandarinRougeDiagoDe2(){
        Position depart = new Position(9, 3);
        mandarinRouge.setPositionDepart(depart);
        Position arrivee = new Position(7, 5);
        mandarinRouge.setPositionArrivee(arrivee);
        assertEquals(false, mandarinRouge.estValide(depart, arrivee));
    }
    @Test
    public void mandarinRougeReculeDiagoDe1(){
        Position depart = new Position(7, 5);
        mandarinRouge.setPositionDepart(depart);
        Position arrivee = new Position(8, 4);
        mandarinRouge.setPositionArrivee(arrivee);
        assertEquals(true, mandarinRouge.estValide(depart, arrivee));
    }
    @Test
    public void mandarinRougeVerticaleDe1(){
        Position depart = new Position(9, 3);
        mandarinRouge.setPositionDepart(depart);
        Position arrivee = new Position(8, 3);
        mandarinRouge.setPositionArrivee(arrivee);
        assertEquals(false, mandarinRouge.estValide(depart, arrivee));
    }
    @Test
    public void mandarinRougeHorizontalDe1(){
        Position depart = new Position(9, 3);
        mandarinRouge.setPositionDepart(depart);
        Position arrivee = new Position(9, 4);
        mandarinRouge.setPositionArrivee(arrivee);
        assertEquals(false, mandarinRouge.estValide(depart, arrivee));
    }
    @Test
    public void mandarinRougeHorsDuPalais(){
        Position depart = new Position(7, 3);
        mandarinRouge.setPositionDepart(depart);
        Position arrivee = new Position(6, 2);
        mandarinRouge.setPositionArrivee(arrivee);
        assertEquals(false, mandarinRouge.estValide(depart, arrivee));
    }
    @Test
    public void mandarinNoirDiagoDe1(){
        Position depart = new Position(0, 3);
        mandarinNoir.setPositionDepart(depart);
        Position arrivee = new Position(1, 4);
        mandarinNoir.setPositionArrivee(arrivee);
        assertEquals(true, mandarinNoir.estValide(depart, arrivee));
    }
    @Test
    public void mandarinNoirDiagoDe2(){
        Position depart = new Position(0, 3);
        mandarinNoir.setPositionDepart(depart);
        Position arrivee = new Position(2, 5);
        mandarinNoir.setPositionArrivee(arrivee);
        assertEquals(false, mandarinNoir.estValide(depart, arrivee));
    }
    @Test
    public void mandarinNoirReculeDiagoDe1(){
        Position depart = new Position(1, 4);
        mandarinNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 3);
        mandarinNoir.setPositionArrivee(arrivee);
        assertEquals(true, mandarinNoir.estValide(depart, arrivee));
    }
    @Test
    public void mandarinNoirVertical(){
        Position depart = new Position(0, 3);
        mandarinNoir.setPositionDepart(depart);
        Position arrivee = new Position(1, 3);
        mandarinNoir.setPositionArrivee(arrivee);
        assertEquals(false, mandarinNoir.estValide(depart, arrivee));
    }
    @Test
    public void mandarinNoirHorizontal(){
        Position depart = new Position(0, 3);
        mandarinNoir.setPositionDepart(depart);
        Position arrivee = new Position(0, 4);
        mandarinNoir.setPositionArrivee(arrivee);
        assertEquals(false, mandarinNoir.estValide(depart, arrivee));
    }
    @Test
    public void mandarinNoirHorsDuPalai(){
        Position depart = new Position(0, 3);
        mandarinNoir.setPositionDepart(depart);
        Position arrivee = new Position(1, 2);
        mandarinNoir.setPositionArrivee(arrivee);
        assertEquals(false, mandarinNoir.estValide(depart, arrivee));
    }




}
