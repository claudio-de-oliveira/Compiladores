package Compiladores.CompilerBase.LR;

import Compiladores.CompilerBase.*;

public abstract class Control {

    private AbsTag[] _lhs; // Lado esquerdo das regras
    private int[] _size;   // Tamanhp das regras
    private int[][] FG;    // Funções F e G

    public AbsTag getLHS(int prod) {
        assert (prod > 0 && prod < _lhs.length) : "Regra de produção inexistente!";
        return _lhs[prod];
    }

    public int getSize(int prod) {
        assert (prod > 0 && prod < _size.length) : "Regra de produção inexistente!";
        return _size[prod];
    }

    // Empacotamento das funções F e G
    protected static int G(int value) {
        return Acao.SHIFT.getValue() | value;
    }
    protected static int R(int value) {
        return Acao.REDUCE.getValue() | value;
    }
    protected static int E() {
        return Acao.ERROR.getValue();
    }
    protected static int A() {
        return Acao.ACCEPT.getValue();
    }

    protected Control(AbsTag[] lhs, int[] size, int[][] FG) {
        this._lhs = lhs;
        this._size = size;
        this.FG = FG;
    }

    protected abstract int getNumberOfVariables(); // Ajusta indexação das colunas de FG

    public boolean isReduce(final Integer state, final AbstractTag symbol) {
        assert (symbol.isTerminal()) : "A função só pode ser aplicada a terminais!";
        return (FG[state][getNumberOfVariables() + symbol.toInt()] & 0xF000) == Acao.REDUCE.getValue();
    }

    public boolean isShift(final Integer state, final AbstractTag symbol) {
        assert (symbol.isTerminal()) : "A função só pode ser aplicada a terminais!";
        return (FG[state][getNumberOfVariables() + symbol.toInt()] & 0xF000) == Acao.SHIFT.getValue();
    }

    public boolean isAccept(final Integer state, final AbstractTag symbol) {
        assert (symbol.isTerminal()) : "A função só pode ser aplicada a terminais!";
        return (FG[state][getNumberOfVariables() + symbol.toInt()] & 0xF000) == Acao.ACCEPT.getValue();
    }

    public int toInt(final Integer state, final AbstractTag symbol) {
        if (symbol.isVariable()) {
            return (FG[state][symbol.toInt()] & 0x0FFF);
        }
        else if (symbol.isTerminal()) {
            return (FG[state][getNumberOfVariables() + symbol.toInt()] & 0x0FFF);
        }
        else {
            assert (false) : "A função só pode ser aplicada a terminais ou não terminais!";
        }

        return -1;
    }
}