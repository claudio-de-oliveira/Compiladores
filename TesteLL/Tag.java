package Compiladores.TesteLL;

import Compiladores.CompilerBase.LL.*;

public class Tag extends AbsTag {

    public static Tag 
        S = new Tag(0 | VARIABLE, "S"),
        E = new Tag(1 | VARIABLE, "E"),
        El = new Tag(2 | VARIABLE, "E'", 1),
        T = new Tag(3 | VARIABLE, "T"),
        Tl = new Tag(4 | VARIABLE, "T'", 1),
        F = new Tag(5 | VARIABLE, "F");

    public static Tag 
        ADD = new Tag(0 | TERMINAL, "+"),
        SUB = new Tag(1 | TERMINAL, "-"),
        MUL = new Tag(2 | TERMINAL, "*"),
        DIV = new Tag(3 | TERMINAL, "/"),
        LPAR = new Tag(4 | TERMINAL, "("),
        RPAR = new Tag(5 | TERMINAL, ")"),
        LBRA = new Tag(6 | TERMINAL, "{"),
        RBRA = new Tag(7 | TERMINAL, "}"),
        LCOL = new Tag(8 | TERMINAL, "["),
        RCOL = new Tag(9 | TERMINAL, "]"),
        CTE = new Tag(10 | TERMINAL, "i"),
        ENDMARK = new Tag(11 | TERMINAL, "#"),
        UNKNOW = new Tag(12 | TERMINAL, "unknow");    

    public static Tag 
        _Add = new Tag(0 | SEMANTIC, "@Add", 2),
        _Sub = new Tag(1 | SEMANTIC, "@Sub", 2),
        _Mul = new Tag(2 | SEMANTIC, "@Mul", 2),
        _Div = new Tag(3 | SEMANTIC, "@Div", 2),
        _Number = new Tag(4 | SEMANTIC, "@Number"),
        _Echo = new Tag(5 | SEMANTIC, "@Echo", 1),
        _Print = new Tag(6 | SEMANTIC, "@Print", 1),
        _Skip = new Tag(7 | SEMANTIC, "@Skip", 1);


    public Tag(int valor, String nome, int nAtributes) {
        super(valor, nome, nAtributes);
    }

    public Tag(int valor, String nome) {
        this(valor, nome, 0);
    }

    @Override // Não mudar
    public AbsTag Clone() {
        if (_inherited != null && _inherited.length > 0) {
            return new Tag(this._value, this._name, this._inherited.length);
        }
        return this;
    }

    @Override
    public boolean isEndMark() {
        return this.equals(ENDMARK);
    }

}