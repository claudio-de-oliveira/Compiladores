package Compiladores.MiniPascal.IC;

import java.util.ArrayList;

import Compiladores.MiniPascal.IC.Addresses.*;
import Compiladores.MiniPascal.IC.Instructions.*;

public class Machine {
    
    private static ArrayList<IntermediateInstruction> instructions 
        = new ArrayList<IntermediateInstruction>();

    public static IntermediateInstruction getIntermediateInstruction(int i) {
        return instructions.get(i);
    }

    public static int getCount() { 
        return instructions.toArray().length; 
    } 

    public static IntermediateInstruction get(int index) {
        return instructions.get(index);
    }

    public static ArrayList<IntermediateInstruction> getInstructions() {
        return instructions;
    }
    public static ArrayList<TAC> getTuples() {
        return IntermediateInstruction.tuples;
    }

    public static void AddInstruction(IntermediateInstruction inst) {
        instructions.add(inst);
    }

    public static IntermediateInstruction CreateBinary(Operator op, Address x, Address y, Address z) {
        return CreateBinary(op, x, y, z, 0);
    }
    public static IntermediateInstruction CreateBinary(Operator op, Address x, Address y, Address z, int level)
    // x = y op z
    {
        assert (x instanceof Name) : "Invalid Parameter Type";
        IntermediateInstruction inst = new Binary(op, x, y, z, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateUnary(Operator op, Address x, Address y) {
        return CreateUnary(op, x, y, 0);
    }
    public static IntermediateInstruction CreateUnary(Operator op, Address x, Address y, int level)
    // op x
    {
        assert (x instanceof Name) : "Invalid Parameter Type";
        IntermediateInstruction inst = new Unary(op, x, y, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateCopy(Address x, Address y) {
        return CreateCopy(x, y, 0);
    }
    public static IntermediateInstruction CreateCopy(Address x, Address y, int level)
    // x = y
    {
        assert (x instanceof Name) : "Invalid Parameter Type";
        IntermediateInstruction inst = new Copy(x, y, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateGoto(Label L) {
        return CreateGoto(L, 0);
    }
    public static IntermediateInstruction CreateGoto(Label L, int level)
    // goto L
    {
        IntermediateInstruction inst = new Goto(L, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateIfTrue(Address x, Label L) {
        return CreateIfTrue(x, L, 0);
    }
    public static IntermediateInstruction CreateIfTrue(Address x, Label L, int level)
    // if x goto L
    {
        IntermediateInstruction inst = new IfTrue(x, L, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateIfFalse(Address x, Label L) {
        return CreateIfFalse(x, L, 0);
    }
    public static IntermediateInstruction CreateIfFalse(Address x, Label L, int level)
    // ifFalse x goto L
    {
        IntermediateInstruction inst = new IfFalse(x, L, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateIfExp(Operator oprel, Address x, Address y, Label L) {
        return CreateIfExp(oprel, x, y, L, 0);
    }
    public static IntermediateInstruction CreateIfExp(Operator oprel, Address x, Address y, Label L, int level)
    // if x oprel y goto L ===> tmp := x oprel y, if tmp goto L
    {
        IntermediateInstruction inst = new IfExp(oprel, x, y, L, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateParam(Address x) {
        return CreateParam(x, 0);
    }
    public static IntermediateInstruction CreateParam(Address x, int level)
    // param x
    {
        IntermediateInstruction inst = new Param(x, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateCall(Label p, int n) {
        return CreateCall(p, n, 0);
    }
    public static IntermediateInstruction CreateCall(Label p, int n, int level)
    {
        IntermediateInstruction inst = new Call(p, n, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateReturn() {
        return CreateReturn(0);
    }
    public static IntermediateInstruction CreateReturn(int level)
    // return
    {
        IntermediateInstruction inst = new Return(level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateRetVal(Address x) {
        return CreateRetVal(x, 0);
    }
    public static IntermediateInstruction CreateRetVal(Address x, int level)
    // return x
    {
        IntermediateInstruction inst = new Return(x, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateFromArray(Address x, Address i, Address y) {
        return CreateFromArray(x, i, y, 0);
    }
    public static IntermediateInstruction CreateFromArray(Address x, Address i, Address y, int level)
    // x = y[i] ===> tmp = y[i], x = tmp
    {
        assert (x instanceof Name) : "Invalid Parameter Type";
        IntermediateInstruction inst = new FromArray(x, i, y, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateToArray(Address x, Address i, Address y) {
        return CreateToArray(x, i, y, 0);
    }
    public static IntermediateInstruction CreateToArray(Address x, Address i, Address y, int level)
    // x[i] = y
    {
        IntermediateInstruction inst = new ToArray(x, i, y, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateAddressOf(Address x, Address y) {
        return CreateAddressOf(x, y, 0);
    }
    public static IntermediateInstruction CreateAddressOf(Address x, Address y, int level)
    // x = &y
    {
        assert (x instanceof Name) : "Invalid Parameter Type";
        IntermediateInstruction inst = new AddressOf(x, y, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateFromMemory(Address x, Address y) {
        return CreateFromMemory(x, y, 0);
    }
    public static IntermediateInstruction CreateFromMemory(Address x, Address y, int level)
    // x = *y
    {
        assert (x instanceof Name) : "Invalid Parameter Type";
        IntermediateInstruction inst = new FromMemory(x, y, level);
        instructions.add(inst);
        return inst;
    }

    public static IntermediateInstruction CreateToMemory(Address x, Address y) {
        return CreateToMemory(x, y, 0);
    }
    public static IntermediateInstruction CreateToMemory(Address x, Address y, int level)
    // *x = y
    {
        IntermediateInstruction inst = new ToMemory(x, y, level);
        instructions.add(inst);
        return inst;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < instructions.size(); i++)
            str += instructions.get(i).toString() + "\n";
        return str;
    }
}
