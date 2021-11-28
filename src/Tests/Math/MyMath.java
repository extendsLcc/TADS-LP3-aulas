package Tests.Math;

public class MyMath {

    public int sum(int a, int b) {
        return Math.addExact(a, b);
    }

    public static void main(String[] args) {
        MyMath math = new MyMath();
        int sumResult = math.sum(2, 2);
        System.out.println("sum(2, 2) --> " + sumResult);
    }

}
