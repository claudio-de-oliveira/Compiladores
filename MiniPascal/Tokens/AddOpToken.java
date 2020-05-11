package MiniPascal.Tokens;

import MiniPascal.*;

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