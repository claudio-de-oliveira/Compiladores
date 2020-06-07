package Compiladores.MiniPascal.IC.Instructions;

import java.util.ArrayList;

import Compiladores.MiniPascal.IC.Addresses.*;

public class IntermediateInstruction {
    
    public static ArrayList<TAC> tuples = new ArrayList<TAC>();

    protected int pos;
    protected Address target;
    protected int level;

    public int position;
    public static int nextPosition() { return tuples.toArray().length; }

    public IntermediateInstruction(int level) {
        target = null;
        this.level = level;
    }

    public Address getTarget() {
        return target;
    }
    public void setTarget(Address target) {
        this.target = target;
    }

    public TAC elementAt(int i) { 
        if (pos < 0) return null; else return tuples.get(pos + i);
    }
}