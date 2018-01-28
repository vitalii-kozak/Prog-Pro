package lesson1.task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Container container = new Container();
        Class<?> cls = container.getClass();

        if(!cls.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Error! There no annotation SaveTo");
            return;
        }

        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        System.out.println(path);
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(container, path);
                System.out.println("Saver run has done");
                break;
            }
        }
    }
}
