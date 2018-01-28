package lesson1.task3;

public class Main {
    public static void main(String[] args) throws Exception {

        MyClass myClass = new MyClass(1L,77, "Hello World");
        MyClass my = new MyClass(2L,666, "Test");
        myClass.setMy(my);
        System.out.println(myClass);

        String ser = Serializer.buildStr(myClass);
        System.out.println(ser);

        MyClass newClass = Serializer.desiarilize(ser, MyClass.class);
        System.out.println(newClass);

    }
}
