package validation;

public class ValidationFormulaire {

    private static boolean validerNom(String nom){
        boolean reponse = true;
        int spaceNumber = 0;
        for (int i = 0; i < nom.length(); i++){
           char currentChar = nom.charAt(i);
           if (currentChar == ' '){
                spaceNumber++;
           }

            if (!Character.isLetter(currentChar) && currentChar != '-' && currentChar != ' ') {
                reponse = false;
            }
            if (spaceNumber > 1){
                reponse = false;
            }
        }
        return reponse;
    }

    private static boolean validerNumero(String num){
        boolean reponse = true;
        char first = num.charAt(0);
        for (int i = 0; i < num.length(); i++) {
            char currentChar = num.charAt(i);
            if (!Character.isLetter(currentChar) && !Character.isDigit(currentChar)) {
                reponse = false;
            }
        }
        if (first == '1' || first == '2' || first == '3' || first == '4') {
            reponse = true;
        }
        else
        {
            reponse = false;
        }
        return reponse;
    }

    private static boolean validerSalaireHoraire(double salaire){
        boolean reponse = true;
        if (salaire < 15.25){
            reponse = false;
        }
        return reponse;
    }

    private static boolean validerNbreHeuresSemaine(double nbHeures){
        boolean reponse = true;
        if (nbHeures < 0 || nbHeures > 80){
            reponse = false;
        }
        return reponse;
    }

    private static boolean validerAnciennete(int nbAnnees){
        boolean reponse = true;
        if (nbAnnees < 0){
            reponse = false;
        }
        return reponse;
    }

    public static boolean validerEmploye(String nom, String numero, double salaire, double heuresSem, int anciennete){
        boolean reponse = true;
        boolean nomValide = validerNom(nom);
        boolean numeroValide = validerNumero(numero);
        boolean salaireValide = validerSalaireHoraire(salaire);
        boolean heuresSemValide = validerNbreHeuresSemaine(heuresSem);
        boolean ancienneteValide = validerAnciennete(anciennete);

        if (!nomValide || !numeroValide || !salaireValide || !heuresSemValide || !heuresSemValide || !ancienneteValide){
            reponse = false;
        }
        return reponse;
    }

}
