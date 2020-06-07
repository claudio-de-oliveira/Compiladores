package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class Call extends IntermediateInstruction {

    public Call(Label p, int n, int level) {
        super(level);

        TAC ic = new TAC(Operator.CALL, Constant.Create(n), p);
        pos = tuples.size();
        tuples.add(ic);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        str += "call " + tuples.get(pos).getArg2().toString() + ", " + tuples.get(pos).getArg1().toString();

        return str;
    }
}