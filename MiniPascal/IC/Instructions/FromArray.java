package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class FromArray extends IntermediateInstruction {

    public FromArray(Address x, Address i, Address y, int level)
    // x = y[i] ===> tmp = y[i], x = tmp
    {
        super(level);

        TAC ic;
        ic = new TAC(Operator.FROMARRAY, y, i);
        pos = tuples.size();
        tuples.add(ic);
        ic = new TAC(Operator.CONTINUE, x, null);
        tuples.add(ic);
        target = ic.getArg1();
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += tuples.get(pos + 1).getArg1().toString() + " := " + tuples.get(pos).getArg1().toString() + "["
                + tuples.get(pos).getArg2().toString() + "]";

        return str;
    }
}