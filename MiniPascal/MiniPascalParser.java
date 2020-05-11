package Compiladores.MiniPascal;

import java.util.Stack;

import Compiladores.CompilerBase.LL.AbsTag;
import Compiladores.CompilerBase.LL.Parser;

public class MiniPascalParser extends Parser {

    public MiniPascalParser() {
        super(new MiniPascalControl(), new Scanner(), new Semantic(), new SymbolTable(null));
    }

    @Override
    protected void AttributeAdjust(AbsTag A, int rule, Stack<AbsTag> stk) {

        // int tos = stk.size() - 1; // topo da pilha

        switch(rule) {
            default: {
                // Nothing todo
                break;
            }
        }
    }

    @Override
    protected char getEndMark() {
        return '#';
    }
}
