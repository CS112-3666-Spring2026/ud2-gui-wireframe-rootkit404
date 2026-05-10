package war;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * WarGameApp.java - Main entry point for the War card game application.
 * Loads the FXML layout and launches the JavaFX window.
 *
 * @author Nathan Tshishimbi
 * @version 1.1 (UD2) / (05/09/2026)
 */
public class WarGameApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("War! Card Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
