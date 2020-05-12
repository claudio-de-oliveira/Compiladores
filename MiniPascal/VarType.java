package Compiladores.MiniPascal;

public class VarType extends IdType {
    
    // tipo da variável
    public BasicType type;

    public VarType(BasicType type) {
        this.type = type;
    }
}
