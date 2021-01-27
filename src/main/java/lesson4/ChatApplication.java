package lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("chat.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Чат");
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
}
