package Compiladores.MiniPascal;

import java.util.*;

import Compiladores.CompilerBase.*;
import Compiladores.CompilerBase.LL.*;
import Compiladores.MiniPascal.Tokens.ConstantToken;
import Compiladores.MiniPascal.Tokens.IdentifierToken;
import Compiladores.MiniPascal.Types.*;

public class Semantic extends AbsSemantic {

    @Override
    public void Execute(AbstractSymbolTable env, AbsTag action, Stack<AbsTag> stk, AbstractToken token) {

        SymbolTable table = (SymbolTable)env;

        int tos = stk.size() - 1;

        if (action.equals(Tag._Echo)) {
            stk.peek().SetAttribute(0, action.GetAttribute(0));
            return;
        }
        if (action.equals(Tag._Begin)) {
            // Entrando na área de código
            table.setInCode(true);
            return;
        }
        if (action.equals(Tag._End)) {
            // Saindo na área de código
            table.setInCode(false);
            return;
        }
        if (action.equals(Tag._VarDec)) {
            AbsType type = (AbsType)action.GetAttribute(0);
            @SuppressWarnings("unchecked")
            List<String> ids = (List<String>)action.GetAttribute(1);
 
            for(String id: ids) {
                table.InsertLocal(id, type);
            }
            return;
        }
        if (action.equals(Tag._Integer)) {
            stk.peek().SetAttribute(0, new IntegerType()); // *** Atividade: Modificar para uma instancia de IntegerType
            return;
        }
        if (action.equals(Tag._Real)) {
            stk.peek().SetAttribute(0, new RealType()); // *** Atividade: Modificar para uma instancia de RealType
            return;
        }
        if (action.equals(Tag._CreateList)) {
            List<String> list = new ArrayList<String>();
            String id = ((IdentifierToken)token).getId();
            list.add(id);
            stk.peek().SetAttribute(0, list);
            return;
        }
        if (action.equals(Tag._InsertList)) {
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)action.GetAttribute(0);
            String id = ((IdentifierToken)token).getId();
            list.add(id);
            stk.peek().SetAttribute(0, list);
            return;
        }
        if (action.equals(Tag._VarIdList)) {
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)action.GetAttribute(0);
            stk.elementAt(tos-2).SetAttribute(1, list);
            return;
        }
        if (action.equals(Tag._ProgramArguments)) {
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)action.GetAttribute(0);

            // Argumentos do programa serão declarados como "undefined"
            for(String id: list) {
                table.InsertParameter(id, new UndefinedType());
            }
            return;
        }
        if (action.equals(Tag._ProcId)) {
            String id = ((IdentifierToken)token).getId();
            SymbolTable actual = SymbolTable.actual;
            actual.InsertLocal(id, new ProcType());
            return;
        }
        if (action.equals(Tag._FuncId)) {
            String id = ((IdentifierToken)token).getId();
            SymbolTable actual = SymbolTable.actual;
            actual.InsertLocal(id, new FuncType());
            return;
        }

        // * Ações Semânticas para declaração de arrays
        // Veja a classe auxiliar Range.java
        if (action.equals(Tag._BeginRange)) {
            int cte = (int)((ConstantToken)token).getValue();
            stk.elementAt(tos-6).SetAttribute(2, cte);
            return;
        }
        if (action.equals(Tag._EndRange)) {
            int cte = (int)((ConstantToken)token).getValue();
            stk.elementAt(tos-3).SetAttribute(1, cte);
            return;
        }
        if (action.equals(Tag._ArrayDec)) {
            AbsType type = (AbsType)action.GetAttribute(0);
            int range_finish = (int)action.GetAttribute(1);
            int range_start = (int)action.GetAttribute(2);
            Range range = new Range(range_start, range_finish);
            
            stk.peek().SetAttribute(0, new ArrayType(type, range));
            return;
        }

    }
}