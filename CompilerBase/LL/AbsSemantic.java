package CompilerBase.LL;

import java.util.*;

import CompilerBase.*;

public abstract class AbsSemantic {

    public abstract void Execute(Environment env, AbsTag action, Stack<AbsTag> stk, AbstractToken token);
}
