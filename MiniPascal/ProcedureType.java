package Compiladores.MiniPascal;

public class ProcedureType extends IdType {
    
    // Escopo do procedimento
    public SymbolTable scopo;

    // Cria um novo escopo para o procedimento e atualiza o 
    // escopo corrente
    public ProcedureType() {
        scopo = new SymbolTable(SymbolTable.actual);
        SymbolTable.actual = scopo;
    }
}

