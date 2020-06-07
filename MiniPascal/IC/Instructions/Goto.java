package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class Goto extends IntermediateInstruction {

    public Goto(Label L, int level)
    // goto L
    {
        super(level);

        TAC ic = new TAC(Operator.GOTO, null, L);
        pos = tuples.size();
        tuples.add(ic);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += "goto " + tuples.get(pos).getArg2().toString();

        return str;
    }
}