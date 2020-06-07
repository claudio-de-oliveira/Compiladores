package Compiladores.MiniPascal.IC.Addresses;

public class Label extends Address {
    private int val;

    public Label(int val) {
        this.val = val;
    }

    public int getValue() { 
        return val;
    }

    public void setValue(int val) { 
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val); 
    }
}