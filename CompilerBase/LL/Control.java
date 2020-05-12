package Compiladores.CompilerBase.LL;

import java.util.*;

import Compiladores.CompilerBase.*;

public abstract class Control {

    private AbsTag[][] _rhs;
    
    private int[][] _M;

    protected Control(AbsTag[][] rhs, int[][] M) {
        this._rhs = rhs;
        this._M = M;
    }

    public AbsTag[] getRHS(int prod) {
        assert (prod >= 0 && prod < _rhs.length) : "Regra de produção inexistente!";
        return _rhs[prod];
    }
    
    public int getEntry(AbsTag variable, AbstractToken tk) {
        int row = variable.toInt();
        assert (row < _rhs.length) : "Fora das dimensões da função M!";

        int col = tk.toTag().toInt();
        assert (col < _M[row].length) : "Fora das dimensões da função M!";

        return _M[row][col];
    }

    // ************************************
    // Auxílio ao processo de depuração
    public String grammar() {
        String str = "";

        for (int i = 0; i < _M.length; i++) {
            HashSet<Integer> rules = new HashSet<Integer>();

            for (int j = 0; j < _M[i].length; j++) {
                if (_M[i][j] != -1) {
                    rules.add(_M[i][j]);
                }
            }

            String variable = AbsTag.getVariableFromInteger(i).toString();

            for (int rule: rules) {
                String strRule = rule + ". " + variable + " ::= ";

                for (int j = 0; j < _rhs[rule].length; j++) {
                    strRule += _rhs[rule][j].toString() + " ";
                }
                strRule += ".\n";

                str += strRule;
            }
        }

        return str;
    }
    // ************************************
}