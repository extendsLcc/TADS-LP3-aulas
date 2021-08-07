package DesignPatterns.Decorator;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        DecoratorDirector decoratorDirector = new DecoratorDirector();
        Builder decoratorBuilder = new DecoratorBuilder();
        MyData myData = decoratorDirector.createCryptDecorator(decoratorBuilder);

        for (int i = 0; i < 5; i++) {
            myData.write("testing:" + i);
        }

        System.out.println(myData);
        System.out.println(myData.read());
        System.out.println(myData);

    }

}
