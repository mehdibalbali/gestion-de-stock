
package gestionDeStock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MehdiBalbali
 */

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gestionDeStock/view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Gestion de Stock ");
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
