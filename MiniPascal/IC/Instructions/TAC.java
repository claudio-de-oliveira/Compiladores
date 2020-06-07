package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;


public class TAC {

    private Operator op;
    protected Address arg1;
    protected Address arg2;

    public TAC(Operator op, Address arg1, Address arg2) {
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public Operator getOp() {
        return op;
    }

    public void setOp(Operator op) {
        this.op = op;
    }

    public Address getArg1() {
        return arg1;
    }

    public void setArg1(Address arg) {
        arg1 = arg;
    }

    public Address getArg2() {
        return arg2;
    }

    public void setArg2(Address arg) {
        arg2 = arg;
    }

    @Override
    public String toString() {
        String str = "";

        String op1, op2;

        if (arg1 != null)
            op1 = arg1.toString();
        else
            op1 = "---";

        if (arg2 != null)
            op2 = arg2.toString();
        else
            op2 = "---";

        switch (op) {
            case COPY:
                str += "(COPY, " + op1 + ", " + op2 + ")";
                break;
            case MUL:
                str += "(*, " + op1 + ", " + op2 + ")";
                break;
            case DIV:
                str += "(/, " + op1 + ", " + op2 + ")";
                break;
            case ADD:
                str += "(+, " + op1 + ", " + op2 + ")";
                break;
            case SUB:
                str += "(-, " + op1 + ", " + op2 + ")";
                break;
            case INC:
                str += "(++, " + op1 + ", " + op2 + ")";
                break;
            case DEC:
                str += "(--, " + op1 + ", " + op2 + ")";
                break;
            case NEG:
                str += "(-, " + op1 + ", " + op2 + ")";
                break;
            case NOT:
                str += "(!, " + op1 + ", " + op2 + ")";
                break;
            case PARAM:
                str += "(Param, " + op1 + ", " + op2 + ")";
                break;
            case GOTO:
                str += "(Goto, " + op1 + ", " + op2 + ")";
                break;
            case IFTRUE:
                str += "(IfTrue, " + op1 + ", " + op2 + ")";
                break;
            case IFFALSE:
                str += "(IfFalse, " + op1 + ", " + op2 + ")";
                break;
            case CALL:
                str += "(Call, " + op1 + ", " + op2 + ")";
                break;
            case ADDRESS:
                str += "(&, " + op1 + ", " + op2 + ")";
                break;
            case LT:
                str += "(<, " + op1 + ", " + op2 + ")";
                break;
            case LE:
                str += "(<=, " + op1 + ", " + op2 + ")";
                break;
            case GT:
                str += "(>, " + op1 + ", " + op2 + ")";
                break;
            case GE:
                str += "(>=, " + op1 + ", " + op2 + ")";
                break;
            case EQ:
                str += "(==, " + op1 + ", " + op2 + ")";
                break;
            case NEQ:
                str += "(!=, " + op1 + ", " + op2 + ")";
                break;
            case FROMMEMORY:
                str += "(FROMMEMORY, " + op1 + ", " + op2 + ")";
                break;
            case TOMEMORY:
                str += "(TOMEMORY, " + op1 + ", " + op2 + ")";
                break;
            case FROMARRAY:
                str += "(FROMARRAY, " + op1 + ", " + op2 + ")";
                break;
            case TOARRAY:
                str += "(TOARRAY, " + op1 + ", " + op2 + ")";
                break;
            case IFEXP:
                str += "(IFEXP, " + op1 + ", " + op2 + ")";
                break;
            case RETURN:
                str += "(RETURN, " + op1 + ", " + op2 + ")";
                break;
            case RETVAL:
                str += "(RETVAL, " + op1 + ", " + op2 + ")";
                break;
            case CONTINUE:
                str += "(CONTINUE, " + op1 + ", " + op2 + ")";
                break;
        }

        return str;
    }
}