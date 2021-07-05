package DesignPatterns.Iterator;

import DesignPatterns.Iterator.Contracts.Iterator;


public class FibonacciIterable implements Iterator<Integer> {

    private int sequenceIndex;
    private int currentNumber;
    private int previousNumber;

    public FibonacciIterable(int termAmount) {

        this.sequenceIndex = termAmount;
        this.currentNumber = 1;
        this.previousNumber = -1;

    }

    @Override
    public Integer next() throws NoNextElementException {

        if (!this.hasNext()) {
            throw new NoNextElementException() ;
        }

        this.sequenceIndex--;
        int nextNumber = this.previousNumber + this.currentNumber;
        this.previousNumber = this.currentNumber;
        this.currentNumber = nextNumber;
        return nextNumber;

    }

    @Override
    public boolean hasNext() {

        return this.sequenceIndex > 0;

    }

}
