package CompilerBase;

public abstract class AbstractTag {

    protected int _value;
    protected String _name;

    protected static int VARIABLE = 0x8000; // Não pode ser final
    protected static int TERMINAL = 0x4000; // Não pode ser final
    protected static int SEMANTIC = 0x2000; // Não pode ser final

    // Sobrecarregar os construtores na classe derivada
    protected AbstractTag(final int value, final String name) {
        _value = value;
        _name = name;
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
        return _name;
    }
}
