package Tests.Math;

public class MyMath {

    public int sum(int a, int b) {
        return Math.addExact(a, b);
    }

    public int sub(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public int mult(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        MyMath math = new MyMath();
        int sumResult = math.sum(2, 2);
        System.out.println("sum(2, 2) --> " + sumResult);
    }

}
