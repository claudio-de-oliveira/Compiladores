package Compiladores.MiniPascal;

import java.util.*;

import Compiladores.CompilerBase.*;
import Compiladores.CompilerBase.LL.*;
import Compiladores.MiniPascal.IC.Instructions.Operator;
import Compiladores.MiniPascal.Tokens.*;
import Compiladores.MiniPascal.Types.*;

public class Scanner extends AbsScanner {

    private int _currentPosition;

    private Map<String, Token> reservedWords;

    public Scanner() {
        _currentPosition = 0;

        reservedWords = new HashMap<String, Token>();

        reservedWords.put("program", Token.VT_1);
        reservedWords.put("begin", Token.VT_7);
        reservedWords.put("end", Token.VT_8);
        reservedWords.put("array", Token.VT_9);
        reservedWords.put("integer", Token.VT_15);
        reservedWords.put("real", Token.VT_16);
        reservedWords.put("function", Token.VT_17);
        reservedWords.put("procedure", Token.VT_19);
        reservedWords.put("if", Token.VT_21);
        reservedWords.put("then", Token.VT_22);
        reservedWords.put("else", Token.VT_23);
        reservedWords.put("while", Token.VT_24);
        reservedWords.put("do", Token.VT_25);
        reservedWords.put("not", Token.VT_30);
        reservedWords.put("var", Token.VT_33);
        reservedWords.put("of", Token.VT_14);
    }

    @Override
    public AbstractToken nextToken(AbstractSymbolTable env, final String text) throws Exception {
        
        int state = 0;
        int integerPart = 0;
        double realPart = 0;
        double divisor = 10.0;
        String lexema = "";

        // Não usado no LL
        // ****************************************
        // if (_currentPosition >= text.length()) { 
        //     return Token.EMPTY;
        // }

        // SÍMBOLOS
        // *************************
        // VT_3 = "("
        // VT_4 = ")"
        // VT_5 = ";"
        // VT_6 = "."
        // VT_10 = "["
        // VT_11 = "num"
        // VT_12 = ".."
        // VT_13 = "]"
        // VT_18 = ":"
        // VT_20 = "assignop"
        // VT_29 = "addop"
        // VT_31 = "relop"
        // VT_32 = ","
        // VT_34 = "mulop"

        while (true) {

            char ch = text.charAt(_currentPosition);

            switch(state) {
                case 0:
                    if (Character.isWhitespace(ch)) {
                        state = 0;
                        _currentPosition++;
                        break;
                    };
                    if (Character.isDigit(ch)) {
                        integerPart = ch - '0';
                        state = 1;
                        _currentPosition++;
                        break;
                    };
                    if (Character.isLetter(ch)) {
                        lexema += ch;
                        state = 5;
                        _currentPosition++;
                        break;
                    }

                    if (ch == '(') {
                        state = 10;
                        _currentPosition++;
                        break;
                    }
                    if (ch == ')') {
                        state = 11;
                        _currentPosition++;
                        break;
                    }
                    if (ch == ';') {
                        state = 12;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '+' || ch == '-') {
                        lexema += ch;
                        state = 13;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '*' || ch == '/') {
                        lexema += ch;
                        state = 14;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '[') {
                        state = 15;
                        _currentPosition++;
                        break;
                    }
                    if (ch == ']') {
                        state = 16;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '<') {
                        state = 17;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '>') {
                        state = 18;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '=') {
                        state = 19;
                        _currentPosition++;
                        break;
                    }
                    if (ch == ',') {
                        state = 21;
                        _currentPosition++;
                        break;
                    }
                    if (ch == ':') {
                        state = 22;
                        _currentPosition++;
                        break;
                    }

                    if (ch == '.') {
                        state = 25;
                        _currentPosition++;
                        break;
                    }

                    if (ch == '#') {
                        return Token.ENDMARK;
                        // state = 99;
                        // _currentPosition++;
                        // break;
                    }

                    // outro: ERRO
                    state = 100;
                    _currentPosition++;
                    break;

                case 1:
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        integerPart = 10 * integerPart + text.charAt(_currentPosition) - '0';
                        state = 1;
                        _currentPosition++;
                        break;
                    };
                    if (text.charAt(_currentPosition) == '.') {
                        state = 2;
                        _currentPosition++;
                        break;
                    }
                    // outro: constante inteira
                    state = 4;
                    _currentPosition++;
                    break;

                case 2:
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        realPart = (text.charAt(_currentPosition) - '0') / divisor;
                        divisor = 10 * divisor;
                        state = 3;
                        _currentPosition++;
                        break;
                    };
                    // outro: constante inteira
                    state = 4;
                    // ------------------------------------------------------------------
                    // * Não incremente a posição corrente: o ponto encontrado não é 
                    // * o ponto decimal - então considere-o um caracter não pertencente
                    // * a uma constante
                    // ------------------------------------------------------------------
                    // _currentPosition++;
                    break;

                case 3:
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        realPart = realPart + (text.charAt(_currentPosition) - '0') / divisor;
                        divisor = 10 * divisor;
                        state = 3;
                        _currentPosition++;
                        break;
                    };
                    // outro: constante real
                    state = 4;
                    _currentPosition++;
                    break;

                case 4:
                    _currentPosition--; // RETRACT
                    return new ConstantToken(integerPart + realPart);

                case 5:
                    if (Character.isLetterOrDigit(ch)) {
                        lexema += ch;
                        state = 5;
                        _currentPosition++;
                        break;
                    }
                    state = 6;
                    _currentPosition++;
                    break;

                case 6:
                    // O QUE FAZER PARA DIFERENCIAR OS VÁRIOS TIPOS DE IDENTIFICADORES
                    // VT_2  = "id"
                    // ......................
                    // VT_26 = "idvar"
                    // VT_27 = "idfunc"
                    // VT_28 = "idproc"

                    // RETRACT
                    _currentPosition--;

                    // A linguagem pascal nao eh sensivel ao caso da letra!
                    lexema = lexema.toLowerCase();

                    if (reservedWords.containsKey(lexema)) {
                        return reservedWords.get(lexema);
                    }
                    else {
                        // Consultar a tabela de símbolos
                        SymbolTable table = (SymbolTable) env;

                        // Estou na parte de declarações?
                        if (!table.getInCode()) {
                            // Se se tratar de um símbolo
                            if (table.FindLocal(lexema) == null) {
                                return new IdentifierToken(lexema);
                            }
                            else {
                                assert(false): "Identificadores não podem ser redefinidos!";
                            }
                        } 
                        else {
                            // Dentro da parte de instrucoes imperativas
                            // (dentro de begin..end)
                            AbsType type = table.FindGlobal(lexema);

                            // o identificador é de uma variável?
                            if (type instanceof IntegerType || type instanceof RealType || type instanceof ArrayType) {
                                return new VarIdentifierToken(lexema);
                            }
                            // o identificador é de uma função?
                            if (type instanceof FuncType) {
                                return new FunctionIdToken(lexema);
                            }
                            // o identificador é de um procedimento?
                            if (type instanceof ProcType) {
                                return new ProcedureIdToken(lexema);
                            }
                        }
                    }

                case 10: // "("
                    return Token.VT_3;

                case 11: // ")"
                    return Token.VT_4;
                    
                case 12: // ";"
                    return Token.VT_5;

                case 13:
                    if (lexema == "+") {
                        return new AddOpToken(Operator.ADD);
                    }
                    if (lexema == "-") {
                        return new AddOpToken(Operator.SUB);
                    }
                    assert(false): "Não pode chegar aqui!"; 

                case 14:
                    if (lexema.equals("*")) {
                        return new MulOpToken(Operator.MUL);
                    }
                    if (lexema.equals("/")) {
                        return new MulOpToken(Operator.DIV);
                    }
                    throw new Exception("Não pode chegar aqui!"); 

                case 15: // "["
                    return Token.VT_10;

                case 16: // "]"
                    return Token.VT_13;

                case 17:
                    if (ch == '=') {
                        lexema += ch;
                        state = 20;
                        _currentPosition++;
                        break;
                    }
                    if (ch == '>') { // <>
                        lexema += ch;
                        state = 20;
                        _currentPosition++;
                        break;
                    }
                    state = 19;
                    _currentPosition++;
                    break;

                case 18:
                    if (ch == '=') {
                        lexema += ch;
                        state = 20;
                        _currentPosition++;
                        break;
                    }
                    state = 19;
                    _currentPosition++;
                    break;

                case 19: // relop
                    // RETRACT 
                    _currentPosition--;

                    if (lexema.equals("<")) {
                        return new RelOpToken(Operator.LT);
                    }
                    if (lexema.equals(">")) {
                        return new RelOpToken(Operator.GT);
                    }
                    if (lexema.equals("=")) { // =
                        return new RelOpToken(Operator.EQ);
                    }
                    throw new Exception("Não pode chegar aqui!"); 

                case 20: // relop
                    if (lexema.equals("<=")) {
                        return new RelOpToken(Operator.LE);
                    }
                    if (lexema.equals(">=")) {
                        return new RelOpToken(Operator.GE);
                    }
                    if (lexema.equals("<>")) {
                        return new RelOpToken(Operator.NEQ);
                    }
                    assert(false): "Não pode chegar aqui!"; 

                case 21:
                    return Token.VT_32;

                case 22:
                    if (ch == '=') {
                        state = 23;
                        _currentPosition++;
                        break;
                    }
                    state = 24;
                    _currentPosition++;
                    break;

                case 23: // :=
                    return Token.VT_20;

                case 24: // :
                    // RETRACT 
                    // _currentPosition--;
                    return Token.VT_18;

                case 25:
                    if (ch == '.') {
                        state = 26;
                        _currentPosition++;
                        break;
                    }
                    state = 27;
                    _currentPosition++;
                    break;

                case 26: // ..
                    return Token.VT_12;

                case 27: // .
                    // RETRACT 
                    _currentPosition--;
                    return Token.VT_6;

                case 99:
                    return Token.ENDMARK;

                case 100: // ERRO
                    _currentPosition--; // RETRACT
                    return new UnknowToken(ch);
            }
        }
    }
}
