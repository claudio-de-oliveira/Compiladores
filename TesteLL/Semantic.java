package Compiladores.TesteLL;

import java.util.Stack;

import Compiladores.CompilerBase.*;
import Compiladores.CompilerBase.LL.*;

public class Semantic extends AbsSemantic {

    @Override
    public void Execute(AbstractSymbolTable env, AbsTag action, Stack<AbsTag> stk, AbstractToken token) {

        int tos = stk.size() - 1;

        if (action.equals(Tag._Add)) {
            double a = (double)action.GetAttribute(1);
            double b = (double)action.GetAttribute(0);
            stk.peek().SetAttribute(0, a + b);
        }
        else if (action.equals(Tag._Sub)) {
            double a = (double)action.GetAttribute(1);
            double b = (double)action.GetAttribute(0);
            stk.peek().SetAttribute(0, a - b);
        }
        else if (action.equals(Tag._Mul)) {
            double a = (double)action.GetAttribute(1);
            double b = (double)action.GetAttribute(0);
            stk.peek().SetAttribute(0, a * b);
        }
        else if (action.equals(Tag._Div)) {
            double a = (double)action.GetAttribute(1);
            double b = (double)action.GetAttribute(0);
            stk.peek().SetAttribute(0, a / b);
        }
        else if (action.equals(Tag._Number)) {
            stk.peek().SetAttribute(0, ((ConstantToken)token).getValue());
        }
        else if (action.equals(Tag._Echo)) {
            stk.peek().SetAttribute(0, action.GetAttribute(0));
        }
        else if (action.equals(Tag._Skip)) {
            stk.elementAt(tos - 1).SetAttribute(0, action.GetAttribute(0));
        }
        else if (action.equals(Tag._Print)) {
            System.out.println("Resultado: " + action.GetAttribute(0));
        }
    }
}