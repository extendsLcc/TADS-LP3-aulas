package DesignPatterns.Decorator;

public class DecoratorCrypt extends Decorator {

    public DecoratorCrypt(MyData decoratedMyData) {
        super(decoratedMyData);
    }

    public void write(String msg) {
        this.decoratedMyData.write(this.crypt(msg));
    }

    public String read() {
        return this.decrypt(this.decoratedMyData.read());
    }

    private String crypt(String msg) {
        System.out.println("criptografando os dados...");
        return msg;
    }

    private String decrypt(String msg) {
        System.out.println("descriptografando os dados...");
        return msg;
    }

}
