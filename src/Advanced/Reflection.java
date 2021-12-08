package Advanced;

import java.lang.reflect.InvocationTargetException;

public class Reflection {

    public static void main(String[] args) {

        ReflectedClass reflectedInstance = new ReflectedClass();
        Class classType = reflectedInstance.getClass();

        try {
            Object newReflectedInstance = classType.getConstructor().newInstance();

            System.out.println("Class instancied by reflection");
            System.out.println(newReflectedInstance.getClass().getName());

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


}

class ReflectedClass {
    public ReflectedClass() {
    }
}