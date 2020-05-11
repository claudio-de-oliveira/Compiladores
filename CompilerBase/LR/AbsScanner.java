package CompilerBase.LR;

import CompilerBase.*;

public abstract class AbsScanner {

    public abstract AbstractToken nextToken(Environment env, String text);
}