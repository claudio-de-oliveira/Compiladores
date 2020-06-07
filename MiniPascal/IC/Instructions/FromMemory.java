package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class FromMemory extends IntermediateInstruction {

    public FromMemory(Address x, Address y, int level)
    // x = *y
    {
        super(level);

        TAC ic = new TAC(Operator.FROMMEMORY, x, y);
        pos = tuples.size();
        tuples.add(ic);
        target = ic.arg1;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += tuples.get(pos).getArg1().toString() + " := *" + tuples.get(pos).getArg2().toString();

        return str;
    }
}