package DesignPatterns.Decorator;

import java.lang.reflect.InvocationTargetException;

public class DecoratorBuilder implements Builder {

    private Class<? extends MyData> decoratorClass;
    private MyData myData;

    @Override
    public Builder setDecorator(Class<? extends MyData> whichData) {
        this.decoratorClass = whichData;
        return this;
    }

    @Override
    public Builder setConcreteData(MyData whichData) {
        this.myData = whichData;
        return this;
    }

    @Override
    public MyData build() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return this.decoratorClass
            .getConstructor(MyData.class)
            .newInstance(this.myData);
    }

    @Override
    public Builder clear() {
        this.decoratorClass = null;
        this.myData = null;
        return this;
    }

}
