package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;
import Compiladores.MiniPascal.IC.Instructions.Operator;

public class RelOpToken extends Token {

    private Operator _op;

    public RelOpToken(Operator op) {
        super(Tag.vt_31);

        this._op = op;
    }

    public Operator getOp() {
        return _op;
    }
}