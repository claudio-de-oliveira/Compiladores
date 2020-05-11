package Compiladores.MiniPascal;

public class Test {

    public static void main(final String[] args) {

        final MiniPascalParser parser = new MiniPascalParser();

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