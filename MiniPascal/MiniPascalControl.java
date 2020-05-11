package MiniPascal;

import CompilerBase.LL.*;

public class MiniPascalControl extends Control {

    // Função de parsing
    private static AbsTag[][] _rhs = new Tag[][] {
        /* 0*/ new Tag[] {Tag.program, Tag.ENDMARK, },
        /* 1*/ new Tag[] {Tag.vt_1, Tag.vt_2, Tag.vt_3, Tag.identifier_list, Tag.vt_4, Tag.vt_5, Tag.declarations, Tag.subprogram_declarations, Tag.compound_statement, Tag.vt_6, },
        /* 2*/ new Tag[] {Tag.vt_2, Tag.identifier_list_line, },
        /* 3*/ new Tag[] {},
        /* 4*/ new Tag[] {Tag.vt_32, Tag.vt_2, Tag.identifier_list_line, },
        /* 5*/ new Tag[] {Tag.declarations_line, },
        /* 6*/ new Tag[] {},
        /* 7*/ new Tag[] {Tag.vt_33, Tag.identifier_list, Tag.vt_18, Tag.type, Tag.vt_5, Tag.declarations_line, },
        /* 8*/ new Tag[] {Tag.standard_type, },
        /* 9*/ new Tag[] {Tag.vt_9, Tag.vt_10, Tag.vt_11, Tag.vt_12, Tag.vt_11, Tag.vt_13, Tag.vt_14, Tag.standard_type, },
        /* 10*/ new Tag[] {Tag.vt_15, },
        /* 11*/ new Tag[] {Tag.vt_16, },
        /* 12*/ new Tag[] {Tag.subprogram_declarations_line, },
        /* 13*/ new Tag[] {},
        /* 14*/ new Tag[] {Tag.subprogram_head, Tag.declarations, Tag.compound_statement, Tag.vt_5, Tag.subprogram_declarations_line, },
        /* 15*/ new Tag[] {Tag.vt_17, Tag.vt_2, Tag.arguments, Tag.vt_18, Tag.standard_type, Tag.vt_5, },
        /* 16*/ new Tag[] {Tag.vt_19, Tag.vt_2, Tag.arguments, Tag.vt_5, },
        /* 17*/ new Tag[] {},
        /* 18*/ new Tag[] {Tag.vt_3, Tag.parameter_list, Tag.vt_4, },
        /* 19*/ new Tag[] {Tag.vt_2, Tag.identifier_list_line, Tag.vt_18, Tag.type, Tag.parameter_list_line, },
        /* 20*/ new Tag[] {},
        /* 21*/ new Tag[] {Tag.vt_5, Tag.identifier_list, Tag.vt_18, Tag.type, Tag.parameter_list_line, },
        /* 22*/ new Tag[] {Tag.vt_7, Tag.optional_statements, Tag.vt_8, },
        /* 23*/ new Tag[] {},
        /* 24*/ new Tag[] {Tag.statement_list, },
        /* 25*/ new Tag[] {Tag.statement, Tag.statement_list_line, },
        /* 26*/ new Tag[] {Tag.variable, Tag.vt_20, Tag.expression, },
        /* 27*/ new Tag[] {Tag.procedure_statement, },
        /* 28*/ new Tag[] {Tag.vt_7, Tag.optional_statements, Tag.vt_8, },
        /* 29*/ new Tag[] {Tag.vt_21, Tag.expression, Tag.vt_22, Tag.statement, Tag.vt_23, Tag.statement, },
        /* 30*/ new Tag[] {Tag.vt_24, Tag.expression, Tag.vt_25, Tag.statement, },
        /* 31*/ new Tag[] {Tag.vt_26, Tag.variable_line, },
        /* 32*/ new Tag[] {Tag.vt_27, },
        /* 33*/ new Tag[] {},
        /* 34*/ new Tag[] {Tag.vt_10, Tag.expression, Tag.vt_13, },
        /* 35*/ new Tag[] {Tag.simple_expression, Tag.expression_line, },
        /* 36*/ new Tag[] {Tag.term, Tag.simple_expression_line, },
        /* 37*/ new Tag[] {Tag.sign, Tag.term, Tag.simple_expression_line, },
        /* 38*/ new Tag[] {Tag.factor, Tag.term_line, },
        /* 39*/ new Tag[] {Tag.vt_26, Tag.factor_line, },
        /* 40*/ new Tag[] {Tag.vt_27, Tag.vt_3, Tag.expression_list, Tag.vt_4, },
        /* 41*/ new Tag[] {Tag.vt_11, },
        /* 42*/ new Tag[] {Tag.vt_3, Tag.expression, Tag.vt_4, },
        /* 43*/ new Tag[] {Tag.vt_30, Tag.factor, },
        /* 44*/ new Tag[] {},
        /* 45*/ new Tag[] {Tag.vt_10, Tag.expression, Tag.vt_13, },
        /* 46*/ new Tag[] {Tag.term, Tag.simple_expression_line, Tag.expression_line, Tag.expression_list_line, },
        /* 47*/ new Tag[] {Tag.sign, Tag.term, Tag.simple_expression_line, Tag.expression_line, Tag.expression_list_line, },
        /* 48*/ new Tag[] {},
        /* 49*/ new Tag[] {Tag.vt_29, Tag.term, Tag.simple_expression_line, },
        /* 50*/ new Tag[] {},
        /* 51*/ new Tag[] {Tag.vt_31, Tag.simple_expression, },
        /* 52*/ new Tag[] {},
        /* 53*/ new Tag[] {Tag.vt_32, Tag.expression, Tag.expression_list_line, },
        /* 54*/ new Tag[] {Tag.vt_29, },
        /* 55*/ new Tag[] {},
        /* 56*/ new Tag[] {Tag.vt_34, Tag.factor, Tag.term_line, },
        /* 57*/ new Tag[] {Tag.vt_28, Tag.procedure_statement_line, },
        /* 58*/ new Tag[] {},
        /* 59*/ new Tag[] {Tag.vt_3, Tag.expression_list, Tag.vt_4, },
        /* 60*/ new Tag[] {},
        /* 61*/ new Tag[] {Tag.vt_5, Tag.statement, Tag.statement_list_line, },
        };

    private static int[][] _M = new int[][] {
        // program_line_line
        new int[] {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // program
        new int[] {-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // identifier_list
        new int[] {-1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // identifier_list_line
        new int[] {-1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, },
        // declarations
        new int[] {-1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, },
        // declarations_line
        new int[] {-1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 7, -1, },
        // type
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, 9, -1, -1, -1, -1, -1, 8, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // standard_type
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // subprogram_declarations
        new int[] {-1, -1, -1, -1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // subprogram_declarations_line
        new int[] {-1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // subprogram_head
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // arguments
        new int[] {-1, -1, -1, 18, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // parameter_list
        new int[] {-1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // parameter_list_line
        new int[] {-1, -1, -1, -1, 20, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // compound_statement
        new int[] {-1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // optional_statements
        new int[] {-1, -1, -1, -1, -1, -1, -1, 24, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, -1, -1, 24, -1, 24, 24, 24, -1, -1, -1, -1, -1, -1, },
        // statement_list
        new int[] {-1, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, -1, 25, -1, 25, 25, 25, -1, -1, -1, -1, -1, -1, },
        // statement
        new int[] {-1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, 30, -1, 26, 26, 27, -1, -1, -1, -1, -1, -1, },
        // variable
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, 32, -1, -1, -1, -1, -1, -1, -1, },
        // variable_line
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // expression
        new int[] {-1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, 35, -1, 35, 35, -1, -1, -1, -1, },
        // simple_expression
        new int[] {-1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, 36, -1, 37, 36, -1, -1, -1, -1, },
        // term
        new int[] {-1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, 38, -1, -1, 38, -1, -1, -1, -1, },
        // factor
        new int[] {-1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 40, -1, -1, 43, -1, -1, -1, -1, },
        // factor_line
        new int[] {-1, -1, -1, -1, 44, 44, -1, -1, 44, -1, 45, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, 44, 44, -1, 44, -1, -1, -1, 44, -1, 44, 44, -1, 44, },
        // expression_list
        new int[] {-1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, 46, -1, 47, 46, -1, -1, -1, -1, },
        // simple_expression_line
        new int[] {-1, -1, -1, -1, 48, 48, -1, -1, 48, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, 48, 48, -1, 48, -1, -1, -1, 49, -1, 48, 48, -1, -1, },
        // expression_line
        new int[] {-1, -1, -1, -1, 50, 50, -1, -1, 50, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, -1, -1, -1, 50, 50, -1, 50, -1, -1, -1, -1, -1, 51, 50, -1, -1, },
        // expression_list_line
        new int[] {-1, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, -1, -1, },
        // sign
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, },
        // term_line
        new int[] {-1, -1, -1, -1, 55, 55, -1, -1, 55, -1, -1, -1, -1, 55, -1, -1, -1, -1, -1, -1, -1, -1, 55, 55, -1, 55, -1, -1, -1, 55, -1, 55, 55, -1, 56, },
        // procedure_statement
        new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, -1, },
        // procedure_statement_line
        new int[] {-1, -1, -1, 59, -1, 58, -1, -1, 58, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        // statement_list_line
        new int[] {-1, -1, -1, -1, -1, 61, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
        };

     public MiniPascalControl() {
        super(_rhs, _M);
    }
}


