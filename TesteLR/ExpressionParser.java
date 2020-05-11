package TesteLR;

import CompilerBase.LR.Parser;

public class ExpressionParser extends Parser {

    public ExpressionParser() {
        super(new ExpressionControl(), new Scanner(), new Semantic(), null);
    }

    @Override
    protected char getEndMark() {
        return '#';
    }
}