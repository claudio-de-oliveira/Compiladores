package MiniPascal.Tokens;

import MiniPascal.*;

public class VarIdentifierToken extends Token {

    private String _id;

    public VarIdentifierToken(String id) {
        super(Tag.vt_26);

        this._id = id;
    }

    public String getId() {
        return _id;
    }
}