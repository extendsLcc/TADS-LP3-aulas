package DesignPatterns.Decorator;

import java.lang.reflect.InvocationTargetException;

public interface Builder {

    public Builder setDecorator( Class<? extends MyData> decoratorClass );
    public Builder setConcreteData( MyData whichData );
    public MyData build() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    public Builder clear();

}
