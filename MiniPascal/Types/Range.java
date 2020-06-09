package Compiladores.MiniPascal.Types;

public class Range {
    
    private int start, finish;

    public Range(int s, int f) { 
        start = s; 
        finish = f; 
    }

    @Override
    public String toString() {
        return start + ".." + finish;
    }
}