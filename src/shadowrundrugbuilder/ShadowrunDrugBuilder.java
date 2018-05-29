/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrundrugbuilder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author wbolduc
 */
public class ShadowrunDrugBuilder extends Application {
       
    
    @Override
    public void start(Stage primaryStage) {
        
        AttributeSlider bodySlider       = new AttributeSlider("BODY");
        AttributeSlider agilitySlider    = new AttributeSlider("AGILITY");
        AttributeSlider reactionSlider   = new AttributeSlider("REACTION");
        AttributeSlider strengthSlider   = new AttributeSlider("STRENGTH");
        AttributeSlider willSlider       = new AttributeSlider("WILL");
        AttributeSlider logicSlider      = new AttributeSlider("LOGIC");
        AttributeSlider intuitionSlider  = new AttributeSlider("INTUITION");
        AttributeSlider charismaSlider   = new AttributeSlider("CHARISMA");
        
        //                                              //      bod agi rea str wil log int char
        Foundation[] foundations = {new Foundation("Tank",      2,  0,  0,  0,  1,  0,  0,  2,  new String[]{"Pain Resistance 3"}),
                                    new Foundation("Defender",  0,  1,  1, -1,  0, -1,  1,  0,  null),
                                    new Foundation("Genius",    0,  0, -1,  0, -1,  2,  2,  0,  null),
                                    new Foundation("Charmer",   0, -1,  0,  0,  0,  0,  0,  1,  new String[]{"Social Limit +1"}),
                                    new Foundation("Warrior",   1,  1,  0,  1, -1,  0,  0,  0,  null)};
        
        
        
        
        HBox sliders = new HBox();
        sliders.setSpacing(10);
        sliders.getChildren().add(bodySlider.getUI());
        sliders.getChildren().add(agilitySlider.getUI());
        sliders.getChildren().add(reactionSlider.getUI());
        sliders.getChildren().add(strengthSlider.getUI());
        sliders.getChildren().add(willSlider.getUI());
        sliders.getChildren().add(logicSlider.getUI());
        sliders.getChildren().add(intuitionSlider.getUI());
        sliders.getChildren().add(charismaSlider.getUI());
        
        
        StackPane root = new StackPane();
        root.getChildren().add(sliders);
        
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("ShadowRun Drug Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
