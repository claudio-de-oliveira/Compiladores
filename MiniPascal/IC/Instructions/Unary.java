package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class Unary extends IntermediateInstruction {

    public Unary(Operator op, Address x, Address y, int level) 
    // x = op y
    {
        super(level);
    
        TAC ic = new TAC(op, x, y);
        pos = tuples.size();
        tuples.add(ic);
        target = ic.getArg1();
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        switch (tuples.get(pos).getOp())
        {
            case INC:
                str += tuples.get(pos).getArg1().toString() + " := " + tuples.get(pos).getArg2().toString() + " + 1";
                break;
            case DEC:
                str += tuples.get(pos).getArg1().toString() + " := " + tuples.get(pos).getArg2().toString() + " - 1";
                break;
            case NEG:
                str += tuples.get(pos).getArg1().toString() + " := -" + tuples.get(pos).getArg2().toString();
                break;
            case NOT:
                str += tuples.get(pos).getArg1().toString() + " := !" + tuples.get(pos).getArg2().toString();
                break;
            default:
                break;
        }
        return str;
    }

}