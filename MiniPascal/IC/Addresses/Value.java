package Compiladores.MiniPascal.IC.Addresses;

import Compiladores.MiniPascal.IC.Instructions.*;

public class Value extends Address {

    private static Value binaryOperation(Operator op, Value v1, Value v2)
    {
        if (v1 instanceof Nac || v2 instanceof Nac)
            return Nac.Create();
        if (v1 instanceof Undef || v2 instanceof Undef)
            return Undef.Create();
        switch (op)
        {
            case MUL:
                return Constant.Create(((Constant)v1).Value() * ((Constant)v2).Value());
            case DIV:
                return Constant.Create(((Constant)v1).Value() / ((Constant)v2).Value());
            case ADD:
                return Constant.Create(((Constant)v1).Value() + ((Constant)v2).Value());
            case SUB:
                return Constant.Create(((Constant)v1).Value() - ((Constant)v2).Value());
            default:
                break;
        }

        return null;
    }

    private static Value unaryOperation(Operator op, Value v1)
    {
        if (v1 instanceof Nac)
            return Nac.Create();
        if (v1 instanceof Undef)
            return Undef.Create();
        switch (op)
        {
            case INC:
                return Constant.Create(((Constant)v1).Value() + 1);
            case DEC:
                return Constant.Create(((Constant)v1).Value() - 1);
            case NEG:
                return Constant.Create(-((Constant)v1).Value());
            case NOT:
                return Constant.Create(((Constant)v1).Value() == 0 ? -1 : 0);
            default:
                break;
        }

        return null;
    }

    public static Value Add(Value v1, Value v2)
    { return binaryOperation(Operator.ADD, v1, v2); }
    public static Value Sub(Value v1, Value v2)
    { return binaryOperation(Operator.SUB, v1, v2); }
    public static Value Mul(Value v1, Value v2)
    { return binaryOperation(Operator.MUL, v1, v2); }
    public static Value Div(Value v1, Value v2)
    { return binaryOperation(Operator.DIV, v1, v2); }
    public static Value Minus(Value v1)
    { return unaryOperation(Operator.NEG, v1); }
    public static Value Not(Value v1)
    { return unaryOperation(Operator.NOT, v1); }
    public static Value Inc(Value v1)
    { return unaryOperation(Operator.INC, v1); }
    public static Value Dec(Value v1)
    { return unaryOperation(Operator.DEC, v1); }

}