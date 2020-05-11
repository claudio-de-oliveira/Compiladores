package MiniPascal.Tokens;

import MiniPascal.*;

public class RelOpToken extends Token {

    private Operators _op;

    public RelOpToken(Operators op) {
        super(Tag.vt_31);

        this._op = op;
    }

    public Operators getOp() {
        return _op;
    }
}