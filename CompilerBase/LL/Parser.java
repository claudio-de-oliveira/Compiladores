package Compiladores.CompilerBase.LL;

import java.util.Stack;

import Compiladores.CompilerBase.*;
import Compiladores.MiniPascal.SymbolTable;

public abstract class Parser {

    private final Control _control;
    public final Control getControl() { return _control; }

    private final AbsScanner _scanner;
    private final AbsSemantic _semantic;
    private final Stack<AbsTag> _stk; // Pilha do parser

    public Parser(Control control, AbsScanner scanner, AbsSemantic semantic) {
        _control = control;
        _scanner = scanner;
        _semantic = semantic;
        _stk = new Stack<AbsTag>();
    }

    private void PushRHS(Stack<AbsTag> stk, int r) {
        AbsTag[] rhs = _control.getRHS(r);
        for (int i = rhs.length - 1; i >= 0; i--)
            stk.push(rhs[i].Clone());
    }

    public boolean Parse(final String text) {
        String txt = text + getEndMark();

        // Configuração inicial
        PushRHS(_stk, 0);

        AbstractToken token = null;

        try {
            token = _scanner.nextToken(SymbolTable.actual, txt);

            System.out.println(token);

            AbstractToken previous = null;

            while (true) {

                AbsTag A = _stk.pop();

                if (A.isVariable()) {

                    int r = _control.getEntry(A, token);

                    if (r == -1) {
                        return false; // ERRO
                    }

                    PushRHS(_stk, r);

                    AttributeAdjust(A, r, _stk);
                } 
                else if (A.isTerminal()) {

                    if (A.equals(token.toTag())) // Eh pop?
                    {
                        if (A.isEndMark()) { // Eh accept?
                            return true;
                        }

                        // pop
                        previous = token;
                        token = _scanner.nextToken(SymbolTable.actual, txt);
                        System.out.println(token);
                    } 
                    else {
                        return false;
                    }
                } 
                else {
                    _semantic.Execute(SymbolTable.actual, A, _stk, previous);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    // Sobrecarregar na classe concreta
    protected abstract void AttributeAdjust(AbsTag A, int rule, Stack<AbsTag> stk);

    protected abstract char getEndMark();
}
