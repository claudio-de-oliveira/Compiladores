package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;

public class FunctionIdToken extends Token {

    private String _id;

    public FunctionIdToken(String id) {
        super(Tag.vt_27);

        this._id = id;
    }

    public String getId() {
        return _id;
    }
}