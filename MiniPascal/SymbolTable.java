package MiniPascal;

import java.util.HashMap;
import java.util.Map;

import CompilerBase.Environment;

public class SymbolTable extends Environment {

    private boolean _incode; // Declarativa

    private SymbolTable _parent;

    private Map<String, IdType> _hash;

    public SymbolTable(SymbolTable parent) {

        _hash = new HashMap<String, IdType>();

        _parent = parent;
    }

    public boolean getInCode() {
        return _incode;
    }

    public void setInCode(boolean flag) {
        _incode = flag;
    }

    public IdType Find(String key) {
        // Procura no escopo local
        if (_hash.containsKey(key)) {
            return _hash.get(key);
        }
        // Procura no escopo pai
        if (_parent != null) {
            return _parent.Find(key);
        }
        // Não encontrado
        return null;
    }
}
