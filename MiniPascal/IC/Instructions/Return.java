package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class Return extends IntermediateInstruction {

    public Return(int level) {
        super(level);

        TAC ic = new TAC(Operator.RETURN, null, null);
        pos = tuples.size();
        tuples.add(ic);
    }

    public Return(Address x, int level) {
        super(level);

        TAC ic = new TAC(Operator.RETVAL, x, null);
        pos = tuples.size();
        tuples.add(ic);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        if (tuples.get(pos).getArg1() != null)
            return str + "return " + tuples.get(pos).getArg1().toString();
        else
            return str + "return";
    }
}
