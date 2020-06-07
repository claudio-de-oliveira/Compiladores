package Compiladores.MiniPascal.IC.Addresses;

import java.util.HashSet;

public class Address {
    protected static int count = 0;
    public static HashSet<String> Symbols = new HashSet<String>();
    protected int id;

    public Address() {
        id = -1;
    }

    public static void Reinitilize()
    {
        count = 0;
        Symbols = new HashSet<String>();
    }

    public int toInt() { 
        return id; 
    }
    public static int Count() { 
        return count; 
    }
}