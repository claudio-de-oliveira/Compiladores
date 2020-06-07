package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class Param extends IntermediateInstruction {

    public Param(Address x, int level)
    // param x
    {
        super(level);

        TAC ic = new TAC(Operator.PARAM, x, null);
        pos = tuples.size();
        tuples.add(ic);
    }

    @Deprecated
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += "param " + tuples.get(pos).getArg1().toString();

        return str;
    }
}