package Compiladores.CompilerBase.LR;

import Compiladores.CompilerBase.*;

public abstract class AbsScanner {

    public abstract AbstractToken nextToken(Environment env, String text);
}