package Compiladores.MiniPascal.Types;

import Compiladores.MiniPascal.SymbolTable;

public class ProcType extends AbsType {
    
    // Escopo do procedimento
    public SymbolTable env;

    // Cria um novo escopo para o procedimento e atualiza o 
    // escopo corrente
    public ProcType() {
        env = new SymbolTable(SymbolTable.actual);
        SymbolTable.actual = env;
    }

    @Override
    public String toString() {
        int i;

        String str = "PROCEDURE";

        str += " (";

        String[] keys;

        keys = new String[env._parameters.size()];

        i = 0;
        for (String id : env._parameters.keySet()) {
            keys[i++] = id;
        }

        for (i = 0; i < keys.length - 1; i++)
            str += keys[i] + " : " + env.FindLocal(keys[i]) + "; ";
        if (i > 0)
            str += keys[i] + " : " + env.FindLocal(keys[i]);

        str += ")";

        return str;

    }
}
