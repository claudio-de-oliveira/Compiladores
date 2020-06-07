package Compiladores.MiniPascal.IC.Addresses;

public class Undef extends Value {
    private static Undef undef = new Undef();

    public static Undef Create()
    { return undef; }

    protected Undef()
    {
        // Nothing todo
    }

    @Override 
    public String toString()
    { return "top"; }
}