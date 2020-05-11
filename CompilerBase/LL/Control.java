package CompilerBase.LL;

import CompilerBase.*;

public abstract class Control {

    private AbsTag[][] _rhs;
    
    private int[][] M;

    protected Control(AbsTag[][] rhs, int[][] M) {
        this._rhs = rhs;
        this.M = M;
    }

    public AbsTag[] getRHS(int prod) {
        assert (prod >= 0 && prod < _rhs.length) : "Regra de produção inexistente!";
        return _rhs[prod];
    }
    
    public int getEntry(AbsTag variable, AbstractToken tk) {
        int row = variable.toInt();
        assert (row < _rhs.length) : "Fora das dimensões da função M!";

        int col = tk.toTag().toInt();
        assert (col < M[row].length) : "Fora das dimensões da função M!";

        return M[row][col];
    }
}