package Compiladores.MiniPascal;

import java.util.Stack;

import Compiladores.CompilerBase.LL.AbsTag;
import Compiladores.CompilerBase.LL.Parser;

public class MiniPascalParser extends Parser {

    public MiniPascalParser() {
        super(new MiniPascalControl(), new Scanner(), new Semantic(), SymbolTable.actual);
    }

    @Override
    protected void AttributeAdjust(AbsTag A, int rule, Stack<AbsTag> stk) {

        int tos = stk.size() - 1; // topo da pilha

        switch(rule) {
            // 3. <identifier_list'> ::= @Echo .
            case 3: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }
            // 4. <identifier_list'> ::= "," "id" @InsertList <identifier_list'> .
            case 4: {
                stk.elementAt(tos - 2).SetAttribute(0, A.GetAttribute(0));
                break;
            }
            
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
