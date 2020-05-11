package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;

public class UnknowToken extends Token {

    private char _value;

    public UnknowToken(char value) { 
        super(Tag.UNKNOW); 

        _value = value;
    }

    public char getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "<" + toTag().toString() + ", "+ _value + ">";
    }
}
