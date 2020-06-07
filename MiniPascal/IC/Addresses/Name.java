package Compiladores.MiniPascal.IC.Addresses;

public class Name extends Address {
    private String name;

    public Name(String name) {
        id = count;
        this.name = name;
        Symbols.add(this.toString());
    }

    public Name()
    {
        id = count;
        count++;
        this.name = "tmp" + String.valueOf(count);
        Symbols.add(this.toString());
    }

    @Override
    public String toString() { 
        return name; 
    }
}
