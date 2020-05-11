package MiniPascal.Tokens;

import MiniPascal.*;

public class MulOpToken extends Token {

    private Operators _op;

    public MulOpToken(Operators op) {
        super(Tag.vt_34);

        this._op = op;
    }

    public Operators getOp() {
        return _op;
    }
}