package MiniPascal;

import java.util.Stack;

import CompilerBase.*;
import CompilerBase.LL.*;

public class Semantic extends AbsSemantic {

    @Override
    public void Execute(Environment env, AbsTag action, Stack<AbsTag> stk, AbstractToken token) {

        // int tos = stk.size() - 1;

        if (action.equals(Tag._Echo)) {
            // stk.peek().SetAttribute(0, action.GetAttribute(0));
        }

        if (action.equals(Tag._Begin)) {

        }
        if (action.equals(Tag._End)) {
            
        }

    }
}