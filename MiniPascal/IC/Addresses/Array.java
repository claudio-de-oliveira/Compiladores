package Compiladores.MiniPascal.IC.Addresses;

public class Array extends Address {
    public Address name;
    public Address index;

    public Array(Address name, Address index)
    {
        id = count;
        count++;
        this.name = name;
        this.index = index;
        Symbols.add(this.toString());
    }

    @Override
    public String toString() { 
        return name + "[" + String.valueOf(index) + "]"; 
    }
}
