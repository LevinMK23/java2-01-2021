package lesson1.logging;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileLogger implements Logger, Closeable {

    private final String src;
    private final FileOutputStream os;

    public FileLogger(String src) throws FileNotFoundException {
        this.src = src;
        os = new FileOutputStream(src);
    }

    @Override
    public void log(String message) throws IOException {
        message = message + "\n";
        os.write(message.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }

    @Override
    public void close() throws IOException {
        os.close();
    }
}
