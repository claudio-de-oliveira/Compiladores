package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class IfExp extends IntermediateInstruction {

    public IfExp(Operator oprel, Address x, Address y, Label L, int level)
    // if x oprel y goto L ===> tmp := x oprel y, if tmp goto L
    {
        super(level);

        TAC ic;
        ic = new TAC(Operator.IFEXP, null, L);
        pos = tuples.size();
        tuples.add(ic);
        ic = new TAC(oprel, x, y);
        tuples.add(ic);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += "if " + tuples.get(pos + 1).getArg1().toString();

        switch (tuples.get(pos + 1).getOp()) {
            case LT:
                str += " < ";
                break;
            case LE:
                str += " <= ";
                break;
            case GT:
                str += " > ";
                break;
            case GE:
                str += " >= ";
                break;
            case EQ:
                str += " == ";
                break;
            case NEQ:
                str += " != ";
                break;
            default:
                break;
        }

        str += tuples.get(pos + 1).getArg2().toString() + " goto " + tuples.get(pos).getArg2().toString();

        return str;
    }
}