/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hotel.prototype;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author keaton
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Group root = new Group();
        Scene scene = new Scene(root,Color.BLACK);
        
        stage.setTitle("Hotel Prototype");
        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);
        stage.setFullScreen(true);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
