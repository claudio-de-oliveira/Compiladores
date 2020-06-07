package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class ToArray extends IntermediateInstruction {

    public ToArray(Address x, Address i, Address y, int level)
    // x[i] = y ===> tmp = x[i], *tmp = y
    {
        super(level);

        TAC ic;
        ic = new TAC(Operator.TOARRAY, x, i);
        pos = tuples.size();
        tuples.add(ic);
        ic = new TAC(Operator.CONTINUE, y, null);
        tuples.add(ic);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += tuples.get(pos).getArg1().toString() + "[" + tuples.get(pos).getArg2().toString() + "] := "
                + tuples.get(pos + 1).getArg1().toString();

        return str;
    }
}