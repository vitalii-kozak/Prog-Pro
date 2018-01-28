package lesson1.task3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Serializer {
    public static String buildStr(Object obj){
        StringBuilder sb = new StringBuilder();
        Class<?> cls = obj.getClass();

        Field fields[] = cls.getDeclaredFields();
        for(Field field:fields){
            if(!field.isAnnotationPresent(Save.class)){
                continue;
            }
            if(Modifier.isPrivate(field.getModifiers())){
                field.setAccessible(true);
            }

            sb.append(field.getName()+"=");

            try{

                if (field.getType() == String.class) {
                    sb.append((String) field.get(obj));
                } else if (field.getType() == int.class) {
                    sb.append(field.getInt(obj));
                } else if (field.getType() == long.class) {
                    sb.append(field.getLong(obj));
                }else if (field.getType() == Long.class) {
                    sb.append((Long) field.get(obj));
                }else if (field.getType() == MyClass.class) {
                    sb.append((Object) field.get(obj));
                }

            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
            sb.append(";");
        }
        return sb.toString();
    }

    public static <T> T desiarilize(String str, Class<T> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        System.out.println(cls);
        MyClass temp = new MyClass();
        Class<?> c = temp.getClass();
        T result = (T) c.newInstance();

        String[] pairs = str.split(";");

        for (String s :pairs) {
            String[] nv = s.split("=");

            if(nv.length != 2) {
                System.out.println(nv.length);
                System.out.println(Arrays.toString(nv));

                throw new IllegalArgumentException();
            }

            String name = nv[0];
            String value = nv[1];

            Field f = cls.getDeclaredField(name);
            if(Modifier.isPrivate(f.getModifiers())){
                f.setAccessible(true);
            }
            if(f.isAnnotationPresent(Save.class)){
                if (f.getType() == String.class) {
                    f.set(result, value);
                } else if (f.getType() == int.class) {
                    f.setInt(result, Integer.parseInt(value));
                }else if (f.getType() == long.class) {
                    f.setLong(result, Long.parseLong(value));
                }else if (f.getType() == Long.class) {
                    f.set(result, (Long) Long.parseLong(value));
                }else if (f.getType() == MyClass.class) {
//                    System.out.println(value);
//                    f.set(result, value);
                }
            }
        }

        return result;
    }

}
