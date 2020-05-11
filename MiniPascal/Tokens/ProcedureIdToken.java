package Compiladores.MiniPascal.Tokens;

import Compiladores.MiniPascal.*;

public class ProcedureIdToken extends Token {

    private String _id;

    public ProcedureIdToken(String id) {
        super(Tag.vt_28);

        this._id = id;
    }

    public String getId() {
        return _id;
    }
}