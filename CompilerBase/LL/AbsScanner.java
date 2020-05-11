package CompilerBase.LL;

import CompilerBase.*;

public abstract class AbsScanner {

    public abstract AbstractToken nextToken(Environment env, String text) throws Exception;
}
