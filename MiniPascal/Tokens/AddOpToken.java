package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;

public class AddOpToken extends Token {

    private Operators _op;

    public AddOpToken(Operators op) {
        super(Tag.vt_29);

        this._op = op;
    }

    public Operators getOp() {
        return _op;
    }
}