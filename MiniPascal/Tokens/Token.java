package Compiladores.MiniPascal.Tokens;

import Compiladores.CompilerBase.*;

import Compiladores.MiniPascal.*;

public class Token extends AbstractToken {

    protected Token(AbstractTag tag) { 
        super(tag); 
    }

    public static Token 
            // DEF = new Token(Tag.vt_0), // ::=
            // PT = new Token(Tag.vt_1), // .
            // ...
            // Declare aqui os tokens que NAO POSSUEM INFORMACOES COMPLEMENTARES conforme os dois exemplos acima
            // OBS: Modifique as constantes do tipo VT_\# conforme o projeto do scanner
            ENDMARK = new Token(Tag.ENDMARK), // "#"
            VT_1 = new Token(Tag.vt_1), // "program"
            // VT_2 = new Token(Tag.vt_2), // "id" => IdentifierToken
            VT_3 = new Token(Tag.vt_3), // "("
            VT_4 = new Token(Tag.vt_4), // ")"
            VT_5 = new Token(Tag.vt_5), // ";"
            VT_6 = new Token(Tag.vt_6), // "."
            VT_7 = new Token(Tag.vt_7), // "begin"
            VT_8 = new Token(Tag.vt_8), // "end"
            VT_9 = new Token(Tag.vt_9), // "array"
            VT_10 = new Token(Tag.vt_10), // "["
            // VT_11 = new Token(Tag.vt_11), // "num" => ConstantToken
            VT_12 = new Token(Tag.vt_12), // ".."
            VT_13 = new Token(Tag.vt_13), // "]"
            VT_14 = new Token(Tag.vt_14), // "of"
            VT_15 = new Token(Tag.vt_15), // "integer"
            VT_16 = new Token(Tag.vt_16), // "real"
            VT_17 = new Token(Tag.vt_17), // "function"
            VT_18 = new Token(Tag.vt_18), // ":"
            VT_19 = new Token(Tag.vt_19), // "procedure"
            VT_20 = new Token(Tag.vt_20), // "assignop"
            VT_21 = new Token(Tag.vt_21), // "if"
            VT_22 = new Token(Tag.vt_22), // "then"
            VT_23 = new Token(Tag.vt_23), // "else"
            VT_24 = new Token(Tag.vt_24), // "while"
            VT_25 = new Token(Tag.vt_25), // "do"
            // VT_26 = new Token(Tag.vt_26), // "idvar" => VarIdentifierToken
            // VT_27 = new Token(Tag.vt_27), // "idfunc" => FunctionIdToken
            // VT_28 = new Token(Tag.vt_28), // "idproc" => ProcedureIdToken
            // VT_29 = new Token(Tag.vt_29), // "addop" => AddOpToken
            VT_30 = new Token(Tag.vt_30), // "not"
            // VT_31 = new Token(Tag.vt_31), // "relop" => RelOpToken
            VT_32 = new Token(Tag.vt_32), // ","
            VT_33 = new Token(Tag.vt_33), // "var"
            // VT_34 = new Token(Tag.vt_34), // "mulop" => AddOpToken
            UnKnow = new Token(Tag.UNKNOW);
}
