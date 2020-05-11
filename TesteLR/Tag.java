package Compiladores.TesteLR;

import Compiladores.CompilerBase.LR.*;

public class Tag extends AbsTag {

    private Tag(int value, String name) {
        super(value, name);
    }

    // Índices conforme as tabelas F e G
    public static Tag 
        E = new Tag(0 | VARIABLE, "E"),
        T = new Tag(1 | VARIABLE, "T"),
        F = new Tag(2 | VARIABLE, "F")
        ;

    // Índices conforme as tabelas F e G
    public static Tag 
        ADD = new Tag(0 | TERMINAL, "+"),
        SUB = new Tag(1 | TERMINAL, "-"),
        MUL = new Tag(2 | TERMINAL, "*"),
        DIV = new Tag(3 | TERMINAL, "/"),
        CTE = new Tag(4 | TERMINAL, "i"),
        LPAR = new Tag(5 | TERMINAL, "("),
        RPAR = new Tag(6 | TERMINAL, ")"),
        ENDMARK = new Tag(7 | TERMINAL, "#"),
        EMPTY = new Tag(8 | TERMINAL, "e")
        ;

    public static Tag 
        UNKNOW = new Tag(1000 | TERMINAL, "Unknow");

    @Override
    public boolean isEndMark() {
        return this.equals(ENDMARK);
    }

}