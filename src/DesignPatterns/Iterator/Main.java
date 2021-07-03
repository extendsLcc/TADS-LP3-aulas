package DesignPatterns.Iterator;

import DesignPatterns.Iterator.Contracts.Iterator;

public class Main {

    public static void main(String[] args) throws Iterator.NoNextElementException {

        FibonacciIterable fibonacciIterable = new FibonacciIterable(20);

        while (fibonacciIterable.hasNext()) {

            System.out.println(fibonacciIterable.next());

        }

    }

}
