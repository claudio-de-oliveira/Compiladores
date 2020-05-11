package Compiladores.CompilerBase.LL;

import java.util.*;

import Compiladores.CompilerBase.*;

public abstract class AbsSemantic {

    public abstract void Execute(Environment env, AbsTag action, Stack<AbsTag> stk, AbstractToken token);
}
