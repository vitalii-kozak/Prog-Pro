package lesson1.Task1;

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
