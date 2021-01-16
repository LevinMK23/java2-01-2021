package lesson2.exceptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyWriter {

    private final OutputStream os;

    public MyWriter() throws IOException {
        os = new FileOutputStream("1.txt");
    }

    public void writeInt(int x) throws IOException {
        os.write(x);
        os.flush();
    }
}
