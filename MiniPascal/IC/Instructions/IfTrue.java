package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class IfTrue extends IntermediateInstruction {
    
    public IfTrue(Address x, Label L, int level) 
    // if x goto L
    {
        super(level);
        
        TAC ic = new TAC(Operator.IFTRUE, x, L);
        pos = tuples.size();
        tuples.add(ic);
    }

    @Override
    public String toString()
    {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += "if " + tuples.get(pos).getArg1().toString() + " goto " + tuples.get(pos).getArg2().toString();

        return str;
    }
}
