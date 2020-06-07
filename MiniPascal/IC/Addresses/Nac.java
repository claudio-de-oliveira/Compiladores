package Compiladores.MiniPascal.IC.Addresses;

public class Nac extends Value {
    private static Nac nac = new Nac();

    public static Nac Create()
    { return nac; }

    @Override 
    public String toString()
    { return "bot"; }
}