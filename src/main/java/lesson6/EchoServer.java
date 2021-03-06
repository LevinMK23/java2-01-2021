package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private boolean running;

    public EchoServer() {
        running = true;
        try (ServerSocket server = new ServerSocket(8189)) {
            while (running) {
                Socket socket = server.accept(); // wait client

                new Thread(() -> {
                    try {
                        handle(socket);
                    } catch (IOException ioException) {
                        System.out.println("Client connection was broken");
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EchoServer();
    }

    private void handle(Socket socket) throws IOException {
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        while (true) {
            String msg = is.readUTF();
            System.out.println("From client: " + msg);
            if (msg.equals("exit")) {
                os.writeUTF("Good buy!");
                os.flush();
                break;
            }
            os.writeUTF(msg);
            os.flush();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
