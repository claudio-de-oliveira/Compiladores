package Compiladores.TesteLR;

import Compiladores.CompilerBase.*;

public class Token extends AbstractToken {

    protected Token(AbstractTag tag) { 
        super(tag); 
    }

    public static Token 
        ADD = new Token(Tag.ADD),
        SUB = new Token(Tag.SUB),
        MUL = new Token(Tag.MUL),
        DIV = new Token(Tag.DIV),
        // CTE = new Token(Tag.CTE), // Contém informações complementares
        LPAR = new Token(Tag.LPAR),
        RPAR = new Token(Tag.RPAR),
        ENDMARK = new Token(Tag.ENDMARK),
        EMPTY = new Token(Tag.EMPTY);
}
