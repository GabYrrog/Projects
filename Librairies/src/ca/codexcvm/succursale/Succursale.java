package ca.codexcvm.succursale;

public class Succursale {

    private int noSuccursale;
    private String nomSuccursale;

    private double margeProfit = 0.25;

    public int getNoSuccursale(){
    return noSuccursale;
    }

    public String getNomSuccursale(){
        return nomSuccursale;
    }

    protected double getMargeProfit() {
        return margeProfit;
    }

    public int setnoSuccursale(int newNoSuccursale){
        this.noSuccursale = newNoSuccursale;
        return newNoSuccursale;
    }

    public String setnomSuccursale(String NouveauNom){
        this.nomSuccursale = NouveauNom;
        return NouveauNom;
    }

    public double setMargeProfit(double NouvelleMarge){
        this.margeProfit = NouvelleMarge;
        return NouvelleMarge;
    }

}
