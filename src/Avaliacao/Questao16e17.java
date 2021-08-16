package Avaliacao;


import java.util.Iterator;

class MyFibo implements Iterator<Integer> {

    private static MyFibo singleton;

    int[] fibonacci = {0, 1};
    private int sequenceAmount = 10;

    private MyFibo() {
    }

    public static MyFibo getInstance() {
        if (MyFibo.singleton == null) {
            MyFibo.singleton = new MyFibo();
        }
        return MyFibo.singleton;
    }

    @Override
    public boolean hasNext() {
        return this.sequenceAmount > 0;
    }

    @Override
    public Integer next() {
        int valor = this.fibonacci[0] + this.fibonacci[1];
        this.fibonacci[0] = this.fibonacci[1];
        this.fibonacci[1] = valor;
        this.sequenceAmount -= 1;
        return valor;
    }
}

public class Questao16e17 {

    public static void main(String[] args) {
        MyFibo myFibo = MyFibo.getInstance();
        while (myFibo.hasNext()) {
            System.out.println("Fibonacci, valor atual = " + myFibo.next());
        }
        myFibo = MyFibo.getInstance();
        System.out.println( "singleton instance has next? " + myFibo.hasNext() );


    }

}
