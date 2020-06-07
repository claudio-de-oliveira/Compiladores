package Compiladores.MiniPascal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Compiladores.CompilerBase.LL.Control;
import Compiladores.MiniPascal.IC.*;
import Compiladores.MiniPascal.IC.Addresses.*;
import Compiladores.MiniPascal.IC.Instructions.*;

public class Test {

    private static void ImprimeGramatica(Control control) {

        String grammar = control.grammar();

        FileWriter arq;

        try {
            arq = new FileWriter(".\\Compiladores\\MiniPascal\\Grammar.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
             
            gravarArq.printf(grammar);
         
            arq.close();        
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static void TestaIntermediateCode() {

        Machine m = new Machine();

        m.CreateBinary(Operator.ADD, new Name("x"), new Name("y"), new Name("z"));
        m.CreateCopy(new Name("x"), new Name("y"));

        ArrayList<TAC> tuples = m.getTuples();
        ArrayList<IntermediateInstruction> instructions = m.getInstructions();
    }

    public static void main(final String[] args) {

        final MiniPascalParser parser = new MiniPascalParser();

        // ************************************
        // Auxílio ao processo de depuração
        ImprimeGramatica(parser.getControl());
        
        // ************************************
        // Testa o gerador de código intermediário
        TestaIntermediateCode();


        String text = 
            "program teste (input, output);\n" +
            "   var x, y, z : integer;\n" +
            "   var a, b, c : real;\n" +
            // "   var a : array [1..10] of integer;\n" +
            // "" +
            // "   procedure proc(a, b: integer);\n" +
            // "   begin\n" +
            // "   end;\n" +
            // "" +
            // "   function func(a, b: integer): integer;\n" +
            // "   begin\n" +
            // "   end;\n" +
            // "" +
            "begin\n" +
            "end.\n";

        try {
            parser.Parse(text);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}