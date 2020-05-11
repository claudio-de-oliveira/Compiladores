package Compiladores.TesteLR;

public class ConstantToken extends Token {

    private double _value; // Informação complementar

    public ConstantToken(double value) { 
        super(Tag.CTE); 

        _value = value;
    }

    public double getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "<" + toTag().toString() + ", "+ _value + ">";
    }
}
