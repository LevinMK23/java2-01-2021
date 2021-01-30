package lesson6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8189);
        Socket socket = server.accept();
        System.out.println("Client connected!");
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        byte[] buffer = new byte[256];
        while (true) {
            int read = is.read(buffer);
//            for (int i = 0; i < read; i++) {
//                System.out.print(buffer[i] + ", ");
//            }
            String message = new String(buffer, 0, read-2, StandardCharsets.UTF_8);
            System.out.println("from " + socket.getInetAddress() + " received:" + message);
            if (message.equals("get-time")) {
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                System.out.println(format.format(date));
                String response = format.format(date);
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }
        }
    }
}
