package Compiladores.MiniPascal.IC.Instructions;

public enum Operator {
    COPY,
    MUL, DIV, ADD, SUB,
    INC, DEC, NEG, NOT,
    GOTO,
    IFTRUE, IFFALSE, IFEXP,
    PARAM,
    CALL,
    RETURN,
    RETVAL,
    ADDRESS,
    LT, LE, GT, GE,
    EQ, NEQ,
    FROMMEMORY, TOMEMORY,
    FROMARRAY, TOARRAY,
    CONTINUE,
}