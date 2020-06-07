package Compiladores.MiniPascal.Types;

// Vai representar o "tipo" dos parâmetros do programa 
// principal (input, output)
public class UndefinedType extends AbsType {

    public UndefinedType() {
        // Nothing more todo
    }

    @Override
    public String toString() {
        return "undefined";
    }
}