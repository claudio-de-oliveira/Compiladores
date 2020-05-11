package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;

public class ConstantToken extends Token {

    private double _value; // Informação complementar

    public ConstantToken(double value) { 
        super(Tag.vt_11); 

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
