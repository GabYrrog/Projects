package validations_speciales;

public class Validation {
    private static final String REG_CODE_CLIENT = "([A-Za-z]{3})(\\d{8})([#*]?)";
    private static final String REG_NO_SERIE = "([A-Za-z]{3,8})(\\d{6})(-)(\\S)";
    private static final String REG_TELEPHONE = "(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\d{3} \\d{3}-\\d{4}|\\d{3} \\d{3} \\d{4}|\\(\\d{3}\\)\\d{3}-\\d{4}|\\(\\d{3}\\) \\d{3}-\\d{4}|\\[\\d{3}\\]\\d{3}-\\d{4}|\\[\\d{3}\\] \\d{3}-\\d{4})";

    public Validation() {
    }

    public static boolean ValiderCodeClient(String CodeClient){
        return CodeClient.matches(REG_CODE_CLIENT);
    }

    public static boolean ValiderNoSerie(String NoSerie){
        return NoSerie.matches(REG_NO_SERIE);
    }

    public static boolean ValiderTelephone(String Telephone){
        return Telephone.matches(REG_TELEPHONE);
    }

}
