package Compiladores.MiniPascal.IC.Instructions;

public class Nop extends IntermediateInstruction {
    
    public Nop(int level) {
        super(level);
        // Nothing more todo
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < level; i++)
            str += "   ";

        return str + "nop";
    }
}