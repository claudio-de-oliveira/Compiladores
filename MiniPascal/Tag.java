package Compiladores.MiniPascal;

import Compiladores.CompilerBase.LL.*;

public class Tag extends AbsTag {

    public static Tag 
            program_line_line = new Tag(VARIABLE | 0, "program''", 0),
            program = new Tag(VARIABLE | 1, "program", 0),
            identifier_list = new Tag(VARIABLE | 2, "identifier_list", 0),
            identifier_list_line = new Tag(VARIABLE | 3, "identifier_list'", 1),
            declarations = new Tag(VARIABLE | 4, "declarations", 0),
            declarations_line = new Tag(VARIABLE | 5, "declarations'", 0), 
            type = new Tag(VARIABLE | 6, "type", 0),
            standard_type = new Tag(VARIABLE | 7, "standard_type", 0),
            subprogram_declarations = new Tag(VARIABLE | 8, "subprogram_declarations", 0),
            subprogram_declarations_line = new Tag(VARIABLE | 9, "subprogram_declarations'", 0),
            subprogram_head = new Tag(VARIABLE | 10, "subprogram_head", 0),
            arguments = new Tag(VARIABLE | 11, "arguments", 0),
            parameter_list = new Tag(VARIABLE | 12, "parameter_list", 0),
            parameter_list_line = new Tag(VARIABLE | 13, "parameter_list'", 0),
            compound_statement = new Tag(VARIABLE | 14, "compound_statement", 0),
            optional_statements = new Tag(VARIABLE | 15, "optional_statements", 0),
            statement_list = new Tag(VARIABLE | 16, "statement_list", 0),
            statement = new Tag(VARIABLE | 17, "statement", 0), 
            variable = new Tag(VARIABLE | 18, "variable", 0),
            variable_line = new Tag(VARIABLE | 19, "variable'", 0),
            expression = new Tag(VARIABLE | 20, "expression", 0),
            simple_expression = new Tag(VARIABLE | 21, "simple_expression", 0),
            term = new Tag(VARIABLE | 22, "term", 0), 
            factor = new Tag(VARIABLE | 23, "factor", 0),
            factor_line = new Tag(VARIABLE | 24, "factor'", 0),
            expression_list = new Tag(VARIABLE | 25, "expression_list", 0),
            simple_expression_line = new Tag(VARIABLE | 26, "simple_expression'", 0),
            expression_line = new Tag(VARIABLE | 27, "expression'", 0),
            expression_list_line = new Tag(VARIABLE | 28, "expression_list'", 0),
            sign = new Tag(VARIABLE | 29, "sign", 0), 
            term_line = new Tag(VARIABLE | 30, "term'", 0),
            procedure_statement = new Tag(VARIABLE | 31, "procedure_statement", 0),
            procedure_statement_line = new Tag(VARIABLE | 32, "procedure_statement'", 0),
            statement_list_line = new Tag(VARIABLE | 33, "statement_list'", 0);

    public static Tag 
            ENDMARK = new Tag(TERMINAL | 0, "#"), 
            vt_1 = new Tag(TERMINAL | 1, "program"), // Palavra reservada
            vt_2 = new Tag(TERMINAL | 2, "id"), // Identificador não declarado
            vt_3 = new Tag(TERMINAL | 3, "("), 
            vt_4 = new Tag(TERMINAL | 4, ")"),
            vt_5 = new Tag(TERMINAL | 5, ";"), 
            vt_6 = new Tag(TERMINAL | 6, "."), 
            vt_7 = new Tag(TERMINAL | 7, "begin"), // Palavra reservada
            vt_8 = new Tag(TERMINAL | 8, "end"), // Palavra reservada
            vt_9 = new Tag(TERMINAL | 9, "array"), // Palavra reservada
            vt_10 = new Tag(TERMINAL | 10, "["), 
            vt_11 = new Tag(TERMINAL | 11, "num"), // Constante numérica
            vt_12 = new Tag(TERMINAL | 12, ".."), 
            vt_13 = new Tag(TERMINAL | 13, "]"),
            vt_14 = new Tag(TERMINAL | 14, "of"), // Palavra reservada
            vt_15 = new Tag(TERMINAL | 15, "integer"), // Palavra reservada
            vt_16 = new Tag(TERMINAL | 16, "real"), // Palavra reservada
            vt_17 = new Tag(TERMINAL | 17, "function"), // Palavra reservada
            vt_18 = new Tag(TERMINAL | 18, ":"), 
            vt_19 = new Tag(TERMINAL | 19, "procedure"), // Palavra reservada
            vt_20 = new Tag(TERMINAL | 20, ":="),
            vt_21 = new Tag(TERMINAL | 21, "if"), // Palavra reservada
            vt_22 = new Tag(TERMINAL | 22, "then"), // Palavra reservada
            vt_23 = new Tag(TERMINAL | 23, "else"), // Palavra reservada
            vt_24 = new Tag(TERMINAL | 24, "while"), // Palavra reservada
            vt_25 = new Tag(TERMINAL | 25, "do"), // Palavra reservada
            vt_26 = new Tag(TERMINAL | 26, "idvar"), // Identificador de variável
            vt_27 = new Tag(TERMINAL | 27, "idfunc"), // Identificador de função
            vt_28 = new Tag(TERMINAL | 28, "idproc"), // Identificador de procedimento
            vt_29 = new Tag(TERMINAL | 29, "addop"), // Operador de adição + ou -
            vt_30 = new Tag(TERMINAL | 30, "not"), // Palavra reservada !
            vt_31 = new Tag(TERMINAL | 31, "relop"), // Operador relacional <, <=, >, >=, <> (diferente), = (igual)
            vt_32 = new Tag(TERMINAL | 32, ","), 
            vt_33 = new Tag(TERMINAL | 33, "var"), // Palavra reservada
            vt_34 = new Tag(TERMINAL | 34, "mulop"), // Operador de multiplicação * ou /
            UNKNOW = new Tag(TERMINAL | 35, "unknow");

    public static Tag 
            _Echo = new Tag(SEMANTIC | 0, "Echo", 1), 
            _Done = new Tag(SEMANTIC | 1, "Done"),
            _Begin = new Tag(SEMANTIC | 2, "Begin"),
            _End = new Tag(SEMANTIC | 3, "End"),
            _VarDec = new Tag(SEMANTIC | 4, "VarDec", 2),
            _Real  = new Tag(SEMANTIC | 5, "Real"),
            _Integer = new Tag(SEMANTIC | 6, "Integer"),
            _CreateList = new Tag(SEMANTIC | 7, "CreateList"),
            _InsertList = new Tag(SEMANTIC | 8, "InsertList", 1),
            _VarIdList = new Tag(SEMANTIC | 9, "VarIdList", 1),
            _ProcId = new Tag(SEMANTIC | 10, "ProcId"),
            _FuncId = new Tag(SEMANTIC | 11, "FuncId"),
            _BeginRange = new Tag(SEMANTIC | 12, "_BeginRange"),
            _EndRange = new Tag(SEMANTIC | 13, "_EndRange"),
            _ArrayDec = new Tag(SEMANTIC | 14, "_ArrayDec", 3),
            _ProgramArguments = new Tag(SEMANTIC | 900, "ProgramArguments", 1)
            ;

    public Tag(final int valor, final String nome, final int nAtributes) {

        super(valor, nome, nAtributes);
    }

    public Tag(final int valor, final String nome) {
        this(valor, nome, 0);
    }

    @Override // Não mudar
    public AbsTag Clone() {
        if (_inherited != null && _inherited.length > 0) {
            return new Tag(this._value, this._name, this._inherited.length);
        }
        return this;
    }

    @Override
    public boolean isEndMark() {
        return this.equals(ENDMARK);
    }

}