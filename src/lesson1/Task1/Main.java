package lesson1.Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class<?> cls = MyClass.class;
        
        
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((method.isAnnotationPresent(Test.class)) && (Modifier.isStatic(modifiers))) {
                Test test = method.getAnnotation(Test.class);
                int aaaResult = (Integer) method.invoke(null, test.a(), test.b());
                System.out.println(aaaResult);
            }
        }

        MyClass myClass = new MyClass();
        cls = myClass.getClass();

        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((method.isAnnotationPresent(Test.class)) && (!Modifier.isStatic(modifiers))) {
                Test test = method.getAnnotation(Test.class);
                int aaaResult = (Integer) method.invoke(myClass, test.a(), test.b());
                System.out.println(aaaResult);
            }
        }

    }

}


class MyClass {
    @Test(a = 4, b = 5)
    public static int sum1(int a, int b) {
        return a + b;
    }

    @Test( a = 4, b = 3)
    public  int sum2(int a, int b) {
        return a + b;
    }
}