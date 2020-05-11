package Compiladores.CompilerBase.LR;

import Compiladores.CompilerBase.AbstractTag;

public abstract class AbsTag extends AbstractTag {
    
    // Em um parser LR(1), os atributos são manipulados dentro de uma pilha do próprio analisador semântico.
    // Portanto, os símbolos de um parser LR(1) não possuem um vetor de atributos (inherited)!
    protected AbsTag(final int value, final String name) {
        super(value, name);
    }

    // Sobrecarregar na classe concreta
    public abstract boolean isEndMark();
}