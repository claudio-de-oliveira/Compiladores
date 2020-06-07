package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class ToMemory extends IntermediateInstruction {

    public ToMemory(Address x, Address y, int level)
    // *x = y
    {
        super(level);

        TAC ic = new TAC(Operator.TOMEMORY, x, y);
        pos = tuples.size();
        tuples.add(ic);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += "*" + tuples.get(pos).getArg1().toString() + " := " + tuples.get(pos).getArg2().toString();

        return str;
    }
}