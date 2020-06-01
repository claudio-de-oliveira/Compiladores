package Compiladores.MiniPascal;

public class FuncType extends IdType {

    // tipo da função
    public BasicType type;
    // Escopo da função
    public SymbolTable scopo;

    // Cria um novo escopo para o procedimento e atualiza o 
    // escopo corrente
    public FuncType() {
        scopo = new SymbolTable(SymbolTable.actual);
        SymbolTable.actual = scopo;
    }
}
