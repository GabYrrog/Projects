package projetheritagemaison;
import java.text.DecimalFormat;
public class Test {

    public static void main ( String[] args)
    {
        DecimalFormat df = new DecimalFormat("0.00$");

        Maison m = new Maison ( 5, 400, "12", "Roy", 180000);
        Maison m2 = new Maison ( 6, 230, "13", "Roy", 195000);
        Chalet c = new Chalet ( 4, 600, "33", "Desilets", 120000, true, true);
        Maison_Mobile mm = new Maison_Mobile ( 5, 80500, true, true, 1994);

        System.out.println ( m.valeur());

        c.ajouterPieces(2);

        System.out.println(df.format(c.valeur()));

        m.setSuperficie(500);

        System.out.println(m.meilleureAffaire(m2));

    }


}
