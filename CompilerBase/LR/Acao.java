package Compiladores.CompilerBase.LR;

public enum Acao {

    SHIFT(0x8000),
    REDUCE(0x4000),
    ACCEPT(0x2000),
    ERROR(0x1000); // Último item termina com ;

    private int _value;
    
    Acao(int value) {
        this._value = value;
    }

    public int getValue() {
        return _value;
    }
}
