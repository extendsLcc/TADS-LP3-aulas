package DesignPatterns.Decorator;

import java.lang.reflect.InvocationTargetException;

public class DecoratorDirector {

    public MyData createCryptDecorator(Builder builder) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return builder
            .setDecorator(DecoratorCrypt.class)
            .setConcreteData( new MyDataConcrete() )
            .build();
    }

}
