package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;
import Compiladores.MiniPascal.IC.Instructions.Operator;

public class AddOpToken extends Token {

    private Operator _op;

    public AddOpToken(Operator op) {
        super(Tag.vt_29);

        this._op = op;
    }

    public Operator getOp() {
        return _op;
    }
}