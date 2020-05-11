package Compiladores.CompilerBase;

public abstract class AbstractToken {

    protected AbstractTag _tag;

    protected AbstractToken(AbstractTag tag) { 
        this._tag = tag; 
    }

    public AbstractTag toTag() { 
        return _tag; 
    }

    @Override
    public String toString() {
        return "<" + _tag.toString() + ">";
    }
}
