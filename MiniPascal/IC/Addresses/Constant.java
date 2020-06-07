package Compiladores.MiniPascal.IC.Addresses;

public class Constant extends Value {
    private int val;

    public static Constant Create(int val)
    { return new Constant(val); }

    private Constant(int val)
    {
        this.val = val;
    }

    public int Value() { 
        return val; 
    }

    @Override
    public String toString() { 
        return String.valueOf(val);
    }
}