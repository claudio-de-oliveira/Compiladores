package Compiladores.CompilerBase;

import java.util.*;

public abstract class AbstractTag {

    protected int _value;
    protected String _name;

    protected static int VARIABLE = 0x8000; // Não pode ser final
    protected static int TERMINAL = 0x4000; // Não pode ser final
    protected static int SEMANTIC = 0x2000; // Não pode ser final

    // ************************************
    // Auxílio ao processo de depuração
    private static Map<Integer, AbstractTag> _variables = new HashMap<Integer, AbstractTag>();
    private static Map<Integer, AbstractTag> _terminals = new HashMap<Integer, AbstractTag>();
    private static Map<Integer, AbstractTag> _actions = new HashMap<Integer, AbstractTag>();

    public static AbstractTag getVariableFromInteger(final int value) {
        assert (_variables.containsKey(value)) : "Não existe um não terminal cujo valor é " + value;
        return _variables.get(value);
    }

    public static AbstractTag getTerminalFromInteger(final int value) {
        assert (_terminals.containsKey(value)) : "Não existe um símbolo terminal cujo valor é " + value;
        return _terminals.get(value);
    }

    public static AbstractTag getActionFromInteger(final int value) {
        assert(_actions.containsKey(value)): "Não existe uma ação semântica cujo valor é " + value;
        return _actions.get(value);
    }
    // ************************************

    // Sobrecarregar os construtores na classe derivada
    protected AbstractTag(final int value, final String name) {
        _value = value;
        _name = name;

        // ************************************
        // Auxílio ao processo de depuração
        if ((_value & 0xF000) == VARIABLE) {
            _variables.put(_value & 0x0FFF, this);
        }
        else if ((_value & 0xF000) == TERMINAL) {
            _terminals.put(_value & 0x0FFF, this);
        }
        else if ((_value & 0xF000) == SEMANTIC) {
            _actions.put(_value & 0x0FFF, this);
        }
        else {
            assert(false): "A execução não deveria chegar a este ponto!";
        }
        // ************************************
    }

    // Testa o tipo de tag
    public boolean isVariable() {
        return (_value & 0xF000) == VARIABLE;
    }

    public boolean isTerminal() {
        return (_value & 0xF000) == TERMINAL;
    }

    public boolean isSemantic() {
        return (_value & 0xF000) == SEMANTIC;
    }

    // Valor absoluto do TAG
    public int toInt() {
        return _value & 0x0FFF;
    }

    // Sobrecarregar na classe concreta
    public abstract boolean isEndMark();

    @Override
    public int hashCode() {
        return toInt();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) // Mesma referência?
            return true;

        if (obj == null) // obj == null -> false
            return false;

        if (getClass() != obj.getClass()) // Classes diferentes?
            return false;

        final AbstractTag other = (AbstractTag) obj;

        return (other._value == _value);    
    }    

    @Override 
    public String toString() {
        if (isVariable()) {
            return "<" + _name + ">";
        }
        if (isTerminal()) {
            return "\"" + _name + "\"";
        }
        if (isSemantic()) {
            return "@" + _name;
        }

        assert(false): "A execução não deveria chegar a este ponto!";

        return _name;
    }
}
