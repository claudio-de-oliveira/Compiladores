package Compiladores.MiniPascal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {

    public static void main(final String[] args) {

        final MiniPascalParser parser = new MiniPascalParser();

        // ************************************
        // Auxílio ao processo de depuração
        String grammar = parser.getControl().grammar();

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
        // ************************************

        String text = 
            "program teste (input, output);\n" +
            "" +
            "var x : integer;" +
            "" +
            "function Max (a, b: integer) : integer;" +
            "   begin" +
            "       if a > b then Max := a else Max := b" +
            "   end" +
            "" +
            "begin\n" +
            "   x := Max(4, 5)" +
            "end.\n";

        try {
            parser.Parse(text);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}