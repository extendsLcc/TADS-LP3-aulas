package DesignPatterns.Iterator;

import DesignPatterns.Iterator.Contracts.Iterator;

import java.util.NoSuchElementException;

public class FibonacciIterable implements Iterator<Integer> {

    private final int termAmount;
    private int sequenceIndex;
    private int currentNumber;
    private int previousNumber;

    public FibonacciIterable(int termAmount) {

        this.termAmount = termAmount;
        this.sequenceIndex = 0;
        this.currentNumber = 1;
        this.previousNumber = -1;

    }

    @Override
    public Integer next() throws NoNextElementException {

        if (!this.hasNext()) {
            throw new NoNextElementException() ;
        }

        this.sequenceIndex++;
        int nextNumber = this.previousNumber + this.currentNumber;
        this.previousNumber = this.currentNumber;
        this.currentNumber = nextNumber;
        return nextNumber;

    }

    @Override
    public boolean hasNext() {

        return this.sequenceIndex < this.termAmount;

    }

}
