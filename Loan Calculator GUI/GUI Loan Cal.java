package org.openjfx.hellofx;



import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.*;

public class App extends Application {
    private Ball circle;
    
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {    
    // Create a pane to hold the circle 
    HBox box = new HBox();
    BorderPane pane = new BorderPane();
    
    circle = new Ball(3,10,10);
    pane.setCenter(circle);
    // Create a circle and set its properties


    pane.getChildren().add(circle); // Add circle to the pane

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("ShowCircleCentered"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}