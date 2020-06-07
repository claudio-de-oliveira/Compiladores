package Compiladores.MiniPascal.Types;

public class ArrayType extends AbsType {
    private AbsType type;
    private Range range;

    public ArrayType(AbsType type, Range range) {
        this.type = type;
        this.range = range;
    }

    @Override
    public String toString() {
        return "array [" + range.toString() + "] of " + type.toString();
    }
}