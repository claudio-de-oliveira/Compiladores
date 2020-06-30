package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;
import Compiladores.MiniPascal.IC.Instructions.Operator;

public class MulOpToken extends Token {

    private Operator _op;

    public MulOpToken(Operator op) {
        super(Tag.vt_34);

        this._op = op;
    }

    public Operator getOp() {
        return _op;
    }
}