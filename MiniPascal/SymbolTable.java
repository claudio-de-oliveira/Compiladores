package Compiladores.MiniPascal;

import java.util.HashMap;
import java.util.Map;

import Compiladores.CompilerBase.Environment;

public class SymbolTable extends Environment {

    private static SymbolTable global = new SymbolTable(null);
    public static SymbolTable actual = global;

    private boolean _incode; // Declarativa

    public SymbolTable _parent;

    // Declaração dos parâmetros
    private Map<String, IdType> _parameters;
    // Declarações de variáveis, funções e procedimentos 
    private Map<String, IdType> _locals;

    public SymbolTable(SymbolTable parent) {

        _parameters = new HashMap<String, IdType>();
        _locals = new HashMap<String, IdType>();

        _parent = parent;
    }

    public boolean getInCode() {
        return _incode;
    }

    public void setInCode(boolean flag) {
        _incode = flag;
    }

    public IdType FindLocal(String key) {
        // Procura no escopo local
        if (_parameters.containsKey(key)) {
            return _parameters.get(key);
        }
        if (_locals.containsKey(key)) {
            return _locals.get(key);
        }
        // Não encontrado
        return null;
    }

    public IdType FindGlobal(String key) {
        
        IdType ret = FindLocal(key);

        if (ret != null) {
            return ret;
        }
        
        // Procura no escopo pai
        if (_parent != null) {
            return _parent.FindGlobal(key);
        }
        
        // Não encontrado
        return null;
    }
}
