package Compiladores.TesteLL;

import java.util.Stack;

import Compiladores.CompilerBase.LL.AbsTag;
import Compiladores.CompilerBase.LL.Parser;

public class ExpressionParser extends Parser {

    public ExpressionParser() {
        super(new ExpressionControl(), new Scanner(), new Semantic());
    }

    @Override
    protected void AttributeAdjust(AbsTag A, int rule, Stack<AbsTag> stk) {

        int tos = stk.size() - 1; // topo da pilha

        switch(rule) {
            //  0. S -> E @Print #
            case 0: {
                // Nothing todo
                break;
            }
            //  1. E -> T E'
            case 1: {
                // Nothing todo
                break;
            }
            //  2. E' -> + T @Add E'
            case 2: {
                stk.elementAt(tos - 2).SetAttribute(1, A.GetAttribute(0));
                break;
            }
            //  3. E' -> - T @Sub E'
            case 3: {
                stk.elementAt(tos - 2).SetAttribute(1, A.GetAttribute(0));
                break;
            }
            //  4. E' -> @Echo
            case 4: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }
            //  5. T -> F T'
            case 5: {
                // Nothing todo
                break;
            }
            //  6. T' -> * F @Mul T'
            case 6: {
                stk.elementAt(tos - 2).SetAttribute(1, A.GetAttribute(0));
                break;
            }
            //  7. T' -> / F @Div T'
            case 7: {
                stk.elementAt(tos - 2).SetAttribute(1, A.GetAttribute(0));
                break;
            }
            //  8. T' -> @Echo
            case 8: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }
            //  9. F -> i @Number
            case 9: {
                // Nothing todo
                break;
            }
            // 10. F -> (E @Skip )
            case 10: {
                // Nothing todo
                break;
            }
            // 11. F -> (E @Skip )
            case 11: {
                // Nothing todo
                break;
            }
            // 12. F -> (E @Skip )
            case 12: {
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
