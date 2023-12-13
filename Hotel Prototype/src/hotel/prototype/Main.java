/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hotel.prototype;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;
    private static Scene reviewPurchaseScene;
    
    /**
     * Method for starting program scenes
     * @param stage 
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("StartMenu"));
        stage.setScene(scene);
        Image icon = new Image(getClass().getResourceAsStream("images/hotel-svgrepo-com.svg"));
        stage.getIcons().add(icon);

        //stage.setTitle("Hotel Regex");
        stage.setTitle("Hotel Regex");
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * changes scene to reviewPurchase screen
     * @param stage
     * @throws IOException
     */
    public void switchToReviewScreen(Stage stage) throws IOException {
        if (reviewPurchaseScene == null) {
            reviewPurchaseScene = new Scene(loadFXML("ReviewPurchase"));
        }

        stage.setScene(reviewPurchaseScene);
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * Program's Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
}
}
