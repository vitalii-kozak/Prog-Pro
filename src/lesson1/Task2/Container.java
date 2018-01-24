package lesson1.Task2;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "c:\\!\\java\\111test.txt")
public class Container {
    String str = "TEST TEST";

    @Saver
    public void save(String path) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(str);
        }

    }
}
