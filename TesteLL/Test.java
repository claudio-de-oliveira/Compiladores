package TesteLL;

import CompilerBase.LL.*;

public class Test {
    public static void main(final String[] args) {

        final Parser parser = new ExpressionParser();

        try {
            parser.Parse("[{(4+4)*2/8-1} + ((4+4)*2/8-1)]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}