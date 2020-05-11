package Compiladores.CompilerBase.LR;

import Compiladores.CompilerBase.*;

public abstract class AbsSemantic {

    public abstract void Execute(Environment env, int rule, AbstractToken token);
}

