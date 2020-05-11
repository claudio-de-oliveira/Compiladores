
package Compiladores.CompilerBase.LL;

import Compiladores.CompilerBase.AbstractTag;

public abstract class AbsTag extends AbstractTag {

    // Em um parser LL(1), os atributos podem ser manipulados dentro de uma pilha do
    // próprio
    // analisador semântico ou podem ser manipulados dentro da própria pilha de
    // símbolos do parser.
    // Quando os atributos são manipulados dentro da pilha do parser, os símbolos
    // devem possuir um
    // vetor de atributos herdados.
    protected Object[] _inherited;

    // Sobrecarregar os construtores na classe derivada
    protected AbsTag(int value, String name, int nAtributes) {
        
        super(value, name);

        _inherited = new Object[nAtributes];
    }

    protected AbsTag(int value, String name, char endmark) {
        this(value, name, 0);
    }

    protected AbsTag(AbsTag tag) {
        this(tag._value, tag._name, tag._inherited.length);
    }

    // Sobrecarregar nas classes derivadas
    public abstract AbsTag Clone();
    // E X E M P L O
    // ----------------------------------------------------------
    // @Override
    // public abstract AbsTag Clone() {
    // if (_inherited != null && _inherited.length > 0)
    // return new DerivedClassName(this);
    // return this;
    // }

    // Acesso aos atributos
    public boolean TestNullAttribute(int index) {
        assert (index >= 0 && index < _inherited.length) : this.toString() + " deve herdar, pelo menos, " + (index + 1)
                + " atributo(s)!";

        return (_inherited[index] == null);
    }

    public Object GetAttribute(int index) {
        assert (index >= 0 && index < _inherited.length) : this.toString() + " deve herdar, pelo menos, " + (index + 1)
                + " atributo(s)!";
        assert (_inherited[index] != null) : this.toString() + ".Inherited[" + index + "] não deve ser nulo!";

        return _inherited[index];
    }

    public void SetAttribute(int index, Object attribute) {
        assert (index >= 0 && index < _inherited.length) : this.toString() + " deve herdar, pelo menos, " + (index + 1)
                + " atributo(s)!";

        _inherited[index] = attribute;
    }

    // Sobrecarregar na classe concreta
    public abstract boolean isEndMark();
}