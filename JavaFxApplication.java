
package javafx.application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class JavaFxApplication extends Application{ 
    
    int sphere_x_pos = 400;
    int sphere_y_pos = 250;
    int boxWidth = 700,boxHeight = 400;
    int box_x_pos = 400;
    int box_y_pos = 250;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
      Group layout = new Group();
      Box box = new Box(boxWidth,boxHeight,0);
      box.setTranslateX(box_x_pos);
      box.setTranslateY(box_y_pos);
      
      Button stepBtn = new Button("Step");
      stepBtn.setTranslateX(100);
      stepBtn.setTranslateY(0);
      
      
      Button resetBtn = new Button("Reset");
      resetBtn.setTranslateX(280);
      resetBtn.setTranslateY(0);
      
      TextField inputTxt = new TextField();
      inputTxt.setTranslateX(140);
      inputTxt.setTranslateY(0);
      
      Sphere sphere = new Sphere(15);
      sphere.setTranslateX(sphere_x_pos);
      sphere.setTranslateY(sphere_y_pos);

      
      
      stepBtn.setOnAction(new EventHandler() {

          @Override
          public void handle(Event t) {
             String userIn = inputTxt.getText();
             userIn = userIn.toUpperCase();
             switch(userIn){
                 case "R" : if(sphere_x_pos + 10 <= 750){ 
                            sphere_x_pos += 10;
                            }
                             break;
                 case "L" : if(sphere_x_pos - 10 >= 50 ){
                               sphere_x_pos -= 10;
                             }
                             break;
                 case "D" : if(sphere_y_pos + 10 <= 450 ){
                               sphere_y_pos += 10;
                             }
                             break;
                            
                 case "U" : if(sphere_y_pos - 10 >= 50 ){
                               sphere_y_pos -= 10;
                             }
                             break;
                 default  :  JOptionPane.showMessageDialog(null, "Hello,This app accepts only U,R,L orD!");
                
             }               
             sphere.setTranslateX(sphere_x_pos);
             sphere.setTranslateY(sphere_y_pos);

                   
                    
          }
      });
      
      resetBtn.setOnAction(new EventHandler() {

          @Override
          public void handle(Event t) {
             sphere_x_pos = box_x_pos;
             sphere_y_pos = box_y_pos;
             sphere.setTranslateX(sphere_x_pos);
             sphere.setTranslateY(sphere_y_pos);
              
          }
      });
      
      
      
      
      layout.getChildren().add(box);
      layout.getChildren().add(stepBtn);
      layout.getChildren().add(inputTxt);
      layout.getChildren().add(resetBtn);
      layout.getChildren().add(sphere);
      
      Scene scene = new Scene(layout,800,600);
      stage.setScene(scene);
      stage.setTitle("JavaFX Application ");
      stage.show();
      
      
    }
    
}
