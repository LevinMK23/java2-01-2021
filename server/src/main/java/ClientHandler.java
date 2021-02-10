import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private Server server;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean running;
    private String nickName;
    private static int cnt = 0;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        running = true;
        cnt++;
        nickName = "user" + cnt;
    }


    public String getNickName() {
        return nickName;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("[DEBUG] client start processing");
            server.broadCastMessage(UserListMessage.of(server.getUserNickNames()));
            while (running) {
                AbstractMessage msg = (AbstractMessage) in.readObject();
                if (msg instanceof TextMessage) {
                    TextMessage message = (TextMessage) msg;
                    if (message.getTo() != null) {
                        server.sendMessageTo(message);
                    } else {
                        server.broadCastMessage(message);
                    }
                }
                if (msg instanceof NickRequest) {
                    out.writeObject(new NickResponse(nickName));
                    out.flush();
                }

                if (msg instanceof QuitRequest) {
                    out.writeObject(msg);
                    out.flush();
                }
                System.out.println("[DEBUG] message from client: " + msg);

            }
        } catch (Exception e) {
            System.err.println("Handled connection was broken");
            server.removeClient(this);
            try {
                server.broadCastMessage(UserListMessage.of(server.getUserNickNames()));
            } catch (IOException ignored) {
            }
        }
    }

    public void sendMessage(AbstractMessage message) throws IOException {
        out.writeObject(message);
        out.flush();
    }
}
