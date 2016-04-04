package br.com.wgbn.pw_20160330_singleton_arraylist;

import java.util.ArrayList;

public class ArraySingleton {
    private static ArraySingleton ourInstance = new ArraySingleton();
    private ArrayList<String> lista;

    public static ArraySingleton getInstance() {
        return ourInstance;
    }

    private ArraySingleton() {
        lista = new ArrayList<String>();
    }

    public ArrayList<String> getLista(){
        return lista;
    }

    public void addItem(String item){
        lista.add(item);
    }
}
