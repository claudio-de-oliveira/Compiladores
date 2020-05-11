package MiniPascal;

public enum Operators {

    ADD(0), SUB(1), MUL(2), DIV(3), LT(4), LE(5), GT(6), GE(7), EQ(8), NEQ(9);

    private int _value;
    
    Operators(int value) {
        this._value = value;
    }

    public int getValue() {
        return _value;
    }
}
