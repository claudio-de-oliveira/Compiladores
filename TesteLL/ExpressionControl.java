package Compiladores.TesteLL;

import Compiladores.CompilerBase.LL.*;

public class ExpressionControl extends Control {

    // Função de parsing
    private static AbsTag[][] _rhs = new Tag[][] {
        new Tag[] { Tag.E, Tag._Print, Tag.ENDMARK, },      //  0. S -> E @Print #
        new Tag[] { Tag.T, Tag.El, },                       //  1. E -> T E'
        new Tag[] { Tag.ADD, Tag.T, Tag._Add, Tag.El, },    //  2. E' -> + T @Add E'
        new Tag[] { Tag.SUB, Tag.T, Tag._Sub, Tag.El, },    //  3. E' -> - T @Sub E'
        new Tag[] { Tag._Echo, },                           //  4. E' -> @Echo
        new Tag[] { Tag.F, Tag.Tl, },                       //  5. T -> F T'
        new Tag[] { Tag.MUL, Tag.F, Tag._Mul, Tag.Tl, },    //  6. T' -> * F @Mul T'
        new Tag[] { Tag.DIV, Tag.F, Tag._Div, Tag.Tl, },    //  7. T' -> / F @Div T'
        new Tag[] { Tag._Echo, },                           //  8. T' -> @Echo
        new Tag[] { Tag.CTE, Tag._Number, },                //  9. F -> i @Number
        new Tag[] { Tag.LPAR, Tag.E, Tag._Skip, Tag.RPAR, },// 10. F -> (E @Skip )
        new Tag[] { Tag.LBRA, Tag.E, Tag._Skip, Tag.RBRA, },// 11. F -> {E @Skip }
        new Tag[] { Tag.LCOL, Tag.E, Tag._Skip, Tag.RCOL, },// 12. F -> [E @Skip ]
    };

    private static int[][] _M = new int[][] {
        //           +   -   *   /   (   )   {   }   [   ]   i   #
        new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, }, // S
        new int[] { -1, -1, -1, -1,  1, -1,  1, -1,  1, -1,  1, -1, }, // E
        new int[] {  2,  3, -1, -1, -1,  4, -1,  4, -1,  4, -1,  4, }, // E'
        new int[] { -1, -1, -1, -1,  5, -1,  5, -1,  5, -1,  5, -1, }, // T
        new int[] {  8,  8,  6,  7, -1,  8, -1,  8, -1,  8, -1,  8, }, // T'
        new int[] { -1, -1, -1, -1, 10, -1, 11, -1, 12, -1,  9, -1, }, // F
    };    

    public ExpressionControl() {
        super(_rhs, _M);
    }
}