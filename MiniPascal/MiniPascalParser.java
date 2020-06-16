package Compiladores.MiniPascal;

import java.util.Stack;

import Compiladores.CompilerBase.LL.AbsTag;
import Compiladores.CompilerBase.LL.Parser;

public class MiniPascalParser extends Parser {

    public MiniPascalParser() {
        super(new MiniPascalControl(), new Scanner(), new Semantic());
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
            // 33. <variable'> ::= @Echo .
            case 33: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }            
            // 44. <factor'> ::= @SimpleVar .
            case 44: {
//                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }
            // 45. <factor'> ::= "[" <expression> @Skip "]" @ArrayVar .
            case 45: {
                stk.elementAt(tos - 4).SetAttribute(1, A.GetAttribute(0));
                break;
            }
            // 48. <simple_expression'> ::= @Echo .
            case 48: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }
            // 50. <expression'> ::= @Echo .
            case 50: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }
            // 55. <term'> ::= @Echo .
            case 55: {
                stk.peek().SetAttribute(0, A.GetAttribute(0));
                break;
            }            
            // 56. <term'> ::= "mulop" <factor> @MulOp <term'> .            
            
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
