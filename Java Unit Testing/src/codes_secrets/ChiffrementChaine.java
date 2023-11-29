package codes_secrets;

public class ChiffrementChaine {

    private int delta;
    private String chaineAChiffrer;

    // Getters et Setters pour le main

    public String getChaineAChiffrer() {
        return chaineAChiffrer;
    }

    public void setChaineAChiffrer(String chaineAChiffrer) {
        this.chaineAChiffrer = chaineAChiffrer;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public ChiffrementChaine(){
        this.delta = 10;
        this.chaineAChiffrer = "";
    }
    public ChiffrementChaine(int delta){
        if (delta < -10 || delta > 100){
            this.delta = -1000;
        } else {
            this.delta = delta;
        }
        this.chaineAChiffrer = "";
    }


    // Plus bas jutilise du wrapping avec modulo,
    // Pour eviter les non-printable characters de la table ascii (0-31 et 127)
    // Puisquon travaille avec des Strings
    public String ChiffrerChaine(String chaine) {
        if (delta < -10 || delta > 100){
            return "";
        } else {
            char[] encryptedString = chaine.toCharArray();
            for (int i = 0; i < encryptedString.length; i++) {
                int ascii = encryptedString[i];
                int wrap = ((ascii - 32 + delta) % 95) + 32;
                encryptedString[i] = (char) wrap;
            }
            return new String(encryptedString);
        }
    }
    public String ChiffrerChaine(String chaine, int customDelta) {
        if (customDelta < -10 || customDelta > 100){
            return "";
        } else {
            char[] encryptedString = chaine.toCharArray();
            for (int i = 0; i < encryptedString.length; i++) {
                int ascii = encryptedString[i];
                int wrap = ((ascii - 32 + customDelta) % 95) + 32;
                encryptedString[i] = (char) wrap;
            }
            return new String(encryptedString);
        }
    }
    public static String DechiffrerChaine(String chaine, int delta) {
        if (delta < -10 || delta > 100){
            return "";
        } else {
            char[] decryptedString = chaine.toCharArray();
            for (int i = 0; i < decryptedString.length; i++) {
                int ascii = decryptedString[i];
                int wrap = ((ascii - 32 - delta + 95) % 95) + 32;

                decryptedString[i] = (char) wrap;
            }
            return new String(decryptedString);
        }
    }

    public static String DechiffrerChaine(int delta, String chaine) {
        if (delta < -10 || delta > 100){
            return "";
        } else {
            char[] decryptedString = chaine.toCharArray();
            for (int i = 0; i < decryptedString.length; i++) {
                int ascii = decryptedString[i];
                int wrap = ((ascii - 32 - delta + 95) % 95) + 32;

                decryptedString[i] = (char) wrap;
            }
            return new String(decryptedString);
        }
    }

}




