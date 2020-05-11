package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;

public class IdentifierToken extends Token {

    private String _id;

    public IdentifierToken(String id) {
        super(Tag.vt_2);

        this._id = id;
    }

    public String getId() {
        return _id;
    }
}