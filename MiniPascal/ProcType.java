package Compiladores.MiniPascal;

public class ProcType extends IdType {
    
    // Escopo do procedimento
    public SymbolTable scopo;

    // Cria um novo escopo para o procedimento e atualiza o 
    // escopo corrente
    public ProcType() {
        scopo = new SymbolTable(SymbolTable.actual);
        SymbolTable.actual = scopo;
    }
}

