package Compiladores.TesteLR;

import Compiladores.CompilerBase.LR.*;

public class ExpressionControl extends Control {

/*********************
0. S -> E #
1. E -> E + T
2. E -> E - T
3. E -> T
4. T -> T * F
5. T -> T / F
6. T -> F
7. F -> i
8. F -> ( E )
9. F -> { E } 
10. F -> [ E ] 
**********************/    
    private static AbsTag[] _lhs = new AbsTag[] {
        null, Tag.E, Tag.E, Tag.E, Tag.T, Tag.T, Tag.T, Tag.F, Tag.F
    };

    private static int[] _size = new int[] {
        2, 3, 3, 1, 3, 3, 1, 1, 3
    };

    private static int[][] FG = new int[][] {
        // Conforme indexação definida nas definições dos Tags
        // ---------------------------------------------------------------------------------------------------------
        //          E      T      F           +      -      *      /      i     (       )      #      e
        new int[] { G( 1), G( 2), G( 3), /**/ E(  ), E(  ), E(  ), E(  ), G( 4), G( 5), E(  ), E(  ), E(  ) }, //  0
        new int[] { E(  ), E(  ), E(  ), /**/ G( 7), G( 8), E(  ), E(  ), E(  ), E(  ), E(  ), G( 6), E(  ) }, //  1
        new int[] { E(  ), E(  ), E(  ), /**/ R( 3), R( 3), G( 9), G(10), E(  ), E(  ), E(  ), R( 3), E(  ) }, //  2
        new int[] { E(  ), E(  ), E(  ), /**/ R( 6), R( 6), R( 6), R( 6), E(  ), E(  ), E(  ), R( 6), E(  ) }, //  3
        new int[] { E(  ), E(  ), E(  ), /**/ R( 7), R( 7), R( 7), R( 7), E(  ), E(  ), E(  ), R( 7), E(  ) }, //  4
        new int[] { G(11), G(12), G(13), /**/ E(  ), E(  ), E(  ), E(  ), G(14), G(15), E(  ), E(  ), E(  ) }, //  5
        new int[] { E(  ), E(  ), E(  ), /**/ E(  ), E(  ), E(  ), E(  ), E(  ), E(  ), E(  ), E(  ), A(  ) }, //  6
        new int[] { E(  ), G(16), G( 3), /**/ E(  ), E(  ), E(  ), E(  ), G( 4), G( 5), E(  ), E(  ), E(  ) }, //  7
        new int[] { E(  ), G(17), G( 3), /**/ E(  ), E(  ), E(  ), E(  ), G( 4), G( 5), E(  ), E(  ), E(  ) }, //  8
        new int[] { E(  ), E(  ), G(18), /**/ E(  ), E(  ), E(  ), E(  ), G( 4), G( 5), E(  ), E(  ), E(  ) }, //  9
        new int[] { E(  ), E(  ), G(19), /**/ E(  ), E(  ), E(  ), E(  ), G( 4), G( 5), E(  ), E(  ), E(  ) }, // 10
        new int[] { E(  ), E(  ), E(  ), /**/ G(21), G(22), E(  ), E(  ), E(  ), E(  ), G(20), E(  ), E(  ) }, // 11
        new int[] { E(  ), E(  ), E(  ), /**/ R( 3), R( 3), G(23), G(24), E(  ), E(  ), R( 3), E(  ), E(  ) }, // 12
        new int[] { E(  ), E(  ), E(  ), /**/ R( 6), R( 6), R( 6), R( 6), E(  ), E(  ), R( 6), E(  ), E(  ) }, // 13
        new int[] { E(  ), E(  ), E(  ), /**/ R( 7), R( 7), R( 7), R( 7), E(  ), E(  ), R( 7), E(  ), E(  ) }, // 14
        new int[] { G(25), G(12), G(13), /**/ E(  ), E(  ), E(  ), E(  ), G(14), G(15), E(  ), E(  ), E(  ) }, // 15
        new int[] { E(  ), E(  ), E(  ), /**/ R( 1), R( 1), G( 9), G(10), E(  ), E(  ), E(  ), R( 1), E(  ) }, // 16
        new int[] { E(  ), E(  ), E(  ), /**/ R( 2), R( 2), G( 9), G(10), E(  ), E(  ), E(  ), R( 2), E(  ) }, // 17
        new int[] { E(  ), E(  ), E(  ), /**/ R( 4), R( 4), R( 4), R( 4), E(  ), E(  ), E(  ), R( 4), E(  ) }, // 18
        new int[] { E(  ), E(  ), E(  ), /**/ R( 5), R( 5), R( 5), R( 5), E(  ), E(  ), E(  ), R( 5), E(  ) }, // 19
        new int[] { E(  ), E(  ), E(  ), /**/ R( 8), R( 8), R( 8), R( 8), E(  ), E(  ), E(  ), R( 8), E(  ) }, // 20
        new int[] { E(  ), G(26), G(13), /**/ E(  ), E(  ), E(  ), E(  ), G(14), G(15), E(  ), E(  ), E(  ) }, // 21
        new int[] { E(  ), G(27), G(13), /**/ E(  ), E(  ), E(  ), E(  ), G(14), G(15), E(  ), E(  ), E(  ) }, // 22
        new int[] { E(  ), E(  ), G(28), /**/ E(  ), E(  ), E(  ), E(  ), G(14), G(15), E(  ), E(  ), E(  ) }, // 23
        new int[] { E(  ), E(  ), G(29), /**/ E(  ), E(  ), E(  ), E(  ), G(14), G(15), E(  ), E(  ), E(  ) }, // 24
        new int[] { E(  ), E(  ), E(  ), /**/ G(21), G(22), E(  ), E(  ), E(  ), E(  ), G(30), E(  ), E(  ) }, // 25
        new int[] { E(  ), E(  ), E(  ), /**/ R( 1), R( 1), G(23), G(24), E(  ), E(  ), R( 1), E(  ), E(  ) }, // 26
        new int[] { E(  ), E(  ), E(  ), /**/ R( 2), R( 2), G(23), G(24), E(  ), E(  ), R( 2), E(  ), E(  ) }, // 27
        new int[] { E(  ), E(  ), E(  ), /**/ R( 4), R( 4), R( 4), R( 4), E(  ), E(  ), R( 4), E(  ), E(  ) }, // 28
        new int[] { E(  ), E(  ), E(  ), /**/ R( 5), R( 5), R( 5), R( 5), E(  ), E(  ), R( 5), E(  ), E(  ) }, // 29
        new int[] { E(  ), E(  ), E(  ), /**/ R( 8), R( 8), R( 8), R( 8), E(  ), E(  ), R( 8), E(  ), E(  ) }, // 30
    };

    public ExpressionControl() {
        super(_lhs, _size, FG);
    }

    @Override
    protected int getNumberOfVariables() { return 3; }

}
