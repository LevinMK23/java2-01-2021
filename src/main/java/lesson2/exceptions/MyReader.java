package lesson2.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyReader {

    private final InputStream is;

    public MyReader() throws IOException {
        is = new FileInputStream("1.txt");
    }

    public int readInt() throws IOException {
        return is.read();
    }

    public void close() throws IOException {
        is.close();
    }
}
