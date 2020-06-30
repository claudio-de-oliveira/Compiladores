package Compiladores.MiniPascal;

import java.util.*;

import Compiladores.CompilerBase.*;
import Compiladores.CompilerBase.LL.*;
import Compiladores.MiniPascal.Tokens.*;
import Compiladores.MiniPascal.Types.*;
import Compiladores.MiniPascal.IC.Addresses.*;
import Compiladores.MiniPascal.IC.Machine;
import Compiladores.MiniPascal.IC.Instructions.IntermediateInstruction;
import Compiladores.MiniPascal.IC.Instructions.Operator;

public class Semantic extends AbsSemantic {

    private void Imprime() {
        String str = "";

        for (int i = 0; i < Machine.getCount(); i++)
            str += Machine.getIntermediateInstruction(i).toString() + "\n";
        System.out.println(str);
    }

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
            // **************************
            stk.elementAt(tos-3).SetAttribute(1, id);
            // **************************
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

        if (action.equals(Tag._Teste)) {
            stk.elementAt(tos-2).SetAttribute(1, action.GetAttribute(0));
            return;
        }

        if (action.equals(Tag._ListDec)) {
            AbsType type = (AbsType)action.GetAttribute(0);
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)action.GetAttribute(1);
            SymbolTable actual = SymbolTable.actual;
            for (String id : list) {
                actual.InsertParameter(id, type);
            }
            return;
        }

        if (action.equals(Tag._FuncType)) {
            AbsType type = (AbsType)action.GetAttribute(0);
            String id = (String)action.GetAttribute(1);
            FuncType ftype = (FuncType)SymbolTable.actual._parent.FindLocal(id);
            ftype.type = type;
            return;
        }

        if (action.equals(Tag._RestoreEnv)) {
            SymbolTable.actual = SymbolTable.actual._parent;
            return;
        }

        if (action.equals(Tag._LValue)) {
            Address id = (Address) action.GetAttribute(0);
            stk.elementAt(tos-2).SetAttribute(1, id);
            return;
        }
        if (action.equals(Tag._Assign)) {
            Name id = (Name)action.GetAttribute(1);
            Name address = (Name)action.GetAttribute(0);
            Machine.CreateCopy(id, address);
            Imprime();
            return;
        }
        // Expressões
        if (action.equals(Tag._Number)) {
            int cte = (int)((ConstantToken)token).getValue();
            Name tmp = new Name();
            IntermediateInstruction inst = Machine.CreateCopy(tmp, Constant.Create(cte));
            stk.peek().SetAttribute(0, inst.getTarget());
            return;
        }
        if (action.equals(Tag._Variable)) {
            String id = ((VarIdentifierToken)token).getId();
            stk.peek().SetAttribute(0, new Name(id));
            return;
        }
        if (action.equals(Tag._SimpleVar)) {
            String v = ((VarIdentifierToken)token).getId();
            stk.peek().SetAttribute(0, new Name(v));
            return;
        }
        if (action.equals(Tag._Skip)) {
            stk.elementAt(tos-1).SetAttribute(0, action.GetAttribute(0));
            return;
        }
        if (action.equals(Tag._ArrayVar)) {
            Address index = (Address)action.GetAttribute(0);
            Name id = (Name)action.GetAttribute(1);
            IntermediateInstruction inst = Machine.CreateFromArray(new Name(), index, id);
            stk.peek().SetAttribute(0, inst.getTarget());
            return;
        }
        if (action.equals(Tag._IdFuncCall)) {
            String idFunc = ((IdentifierToken)token).getId();
            stk.elementAt(tos-4).SetAttribute(1, idFunc);
            return;
        }
        if (action.equals(Tag._DoNothing)) {
            stk.peek().SetAttribute(0, action.GetAttribute(0));
            return;
        }
        if (action.equals(Tag._Not)) {
            Address fator = (Address)action.GetAttribute(0);
            Name tmp = new Name();
            Machine.CreateUnary(Operator.NOT, tmp, fator);
            stk.peek().SetAttribute(0, tmp);
            return;
        }

        if (action.equals(Tag._ActualParameters)) {
            
        }
        if (action.equals(Tag._FunctionCall)) {
            
        }
        if (action.equals(Tag._Operator)){
            Operator op = ((MulOpToken)token).getOp();
            stk.elementAt(tos-1).SetAttribute(1, op);
            return;
        }
        if (action.equals(Tag._MulOp)) {
            Address left = (Address)action.GetAttribute(2);
            Operator op = (Operator)action.GetAttribute(1);
            Address right = (Address)action.GetAttribute(0);
            Name tmp = new Name();
            Machine.CreateBinary(op, tmp, left, right);
            stk.peek().SetAttribute(0, tmp);
            return;
        }
        if (action.equals(Tag._Dump)){
            Imprime();
            return;
        }
    }
}
