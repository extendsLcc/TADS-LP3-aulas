package DesignPatterns.Decorator;

import java.util.ArrayList;
import java.util.List;

public class MyDataConcrete implements MyData {

    List<String> myList = new ArrayList<String>();

    @Override
    public void write(String msg) {
        myList.add(msg);
    }

    @Override
    public String read() {
        return myList.remove(0);
    }

    public String toString() {
        return myList.toString();
    }
}
