package DesignPatterns.Iterator.Contracts;

import DesignPatterns.Iterator.FibonacciIterable;

public interface Iterator<T> {

    public T next() throws NoNextElementException;

    public boolean hasNext();

    public class NoNextElementException extends Exception {
    }

}
