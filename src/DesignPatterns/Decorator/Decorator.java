package DesignPatterns.Decorator;

public abstract class Decorator implements MyData {

    protected MyData decoratedMyData;

    public Decorator(MyData decoratedMyData) {
        this.decoratedMyData = decoratedMyData;
    }

    @Override
    public void write(String msg) {
        this.decoratedMyData.write(msg);
    }

    @Override
    public String read() {
        return this.decoratedMyData.read();
    }

    public String toString() {
        return this.decoratedMyData.toString();
    }

}
