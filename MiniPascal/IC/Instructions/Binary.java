package Compiladores.MiniPascal.IC.Instructions;

import Compiladores.MiniPascal.IC.Addresses.*;

public class Binary extends IntermediateInstruction {
    
    public Binary(Operator op, Address x, Address y, Address z, int level) {
        super(level);
        
        TAC ic;
        ic = new TAC(op, y, z);
        pos = tuples.size();
        tuples.add(ic);
        ic = new TAC(Operator.CONTINUE, null, x);
        tuples.add(ic);
        target = ic.getArg2();
    }
    
    @Override
    public String toString()
    {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        switch (tuples.get(pos).getOp())
        {
            case MUL:
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " * " + tuples.get(pos).getArg2().toString();
                break;                                        
            case DIV:                                
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " / " + tuples.get(pos).getArg2().toString();
                break;                                        
            case ADD:                                
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " + " + tuples.get(pos).getArg2().toString();
                break;                                        
            case SUB:                                
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " - " + tuples.get(pos).getArg2().toString();
                break;                                        
            case EQ:                                 
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " = " + tuples.get(pos).getArg2().toString();
                break;
            case NEQ:
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " <> " + tuples.get(pos).getArg2().toString();
                break;
            case GT:
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " > " + tuples.get(pos).getArg2().toString();
                break;
            case GE:
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " >= " + tuples.get(pos).getArg2().toString();
                break;
            case LT:
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " < " + tuples.get(pos).getArg2().toString();
                break;
            case LE:
                str += tuples.get(pos + 1).getArg2().toString() + " := " + tuples.get(pos).getArg1().toString() + " <= " + tuples.get(pos).getArg2().toString();
                break;
            default:
                break;
        }
        return str;
    }
}