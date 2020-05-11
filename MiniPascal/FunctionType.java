package Compiladores.MiniPascal;

public class FunctionType extends IdType {
    // tipo da função
    public BasicType type;
    public SymbolTable scopo;

    public FunctionType() {
        scopo = new SymbolTable(SymbolTable.actual);
        SymbolTable.actual = scopo;
    }
    
}
