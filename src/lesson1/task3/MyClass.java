package lesson1.task3;

public class MyClass {

    @Save
    private Long id;
    @Save
    public int value;
    @Save
    private String str;
    @Save
    private MyClass my;

    public MyClass() {
    }

    public MyClass(Long id, int value, String str) {
        this.id = id;
        this.value = value;
        this.str = str;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyClass getMy() {
        return my;
    }

    public void setMy(MyClass my) {
        this.my = my;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id- " + id +
                ", value- " + value +
                ", str- '" + str + '\'' +
                '}';
    }
}
