package Compiladores.TesteLR;

import Compiladores.CompilerBase.*;
import Compiladores.CompilerBase.LR.*;

import java.util.*; 

public class Semantic extends AbsSemantic {

    Stack<Double> stkSem;

    public Semantic() {
        stkSem = new Stack<Double>();
    }

    @Override
    public void Execute(AbstractSymbolTable env, int rule, AbstractToken token) {

        switch(rule) {
            // 0. S -> E # @Print
            case 0: {
                double a = (double) stkSem.pop();
                System.out.println("Resultado: " + a);
                break;
            }
            // 1. E -> E + T @Add
            case 1: {
                double b = (double) stkSem.pop();
                double a = (double) stkSem.pop();
                stkSem.push(a + b);
                break;
            }
            // 2. E -> E - T @Sub
            case 2: {
                double b = (double) stkSem.pop();
                double a = (double) stkSem.pop();
                stkSem.push(a - b);
                break;
            }
            // 3. E -> T
            case 3: {
                // Nothing todo
                break;
            }
            // 4. T -> T * F @Mul
            case 4: {
                double b = (double) stkSem.pop();
                double a = (double) stkSem.pop();
                stkSem.push(a * b);
                break;
            }
            // 5. T -> T / F @Div
            case 5: {
                double b = (double) stkSem.pop();
                double a = (double) stkSem.pop();
                stkSem.push(a / b);
                break;
            }
            // 6. T -> F
            case 6: {
                // Nothing todo
                break;
            }
            // 7. F -> i @Number
            case 7: {
                assert (token instanceof ConstantToken) : "Esperando uma constante!";
                stkSem.push(((ConstantToken)token).getValue());
                break;
            }
            // 8. F -> ( E )
            case 8: {
                // Nothing todo
                break;
            }
        }
    }
}