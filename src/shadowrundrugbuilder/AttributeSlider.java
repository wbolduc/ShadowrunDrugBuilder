/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrundrugbuilder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

/**
 *
 * @author wbolduc
 */


/* restrictions
• Total Initiative dice from all sources cannot be
  increased beyond +4D6.
• The total allowable bonus through all sources to
  any one Attribute is +4.
• No Attribute can be modified below 1.
• The maximum level of a block that positively
  modifies an Attribute that the chosen foundation
  negatively modifies is Level 2.
• The Stun damage of a crash effect is unresisted
  when the drug’s effects end. If this damage fills
  the user’s Stun Condition Monitor, the remaining
  damage overflows into the Physical Condition
  Monitor at the rate of 1 box of Physical
  damage for every 2 boxes of Stun damage (or
  portion thereof) left over.
*/
public class AttributeSlider{
    
    public enum Attribute {
        BODY, AGILITY, REACTION, STRENGTH, WILL, LOGIC, INTUITION, CHARISMA
    }
    
    private VBox sliderUI;        
    private Slider slider;
    private TextField currentValue;
       
    private String attribute;
    private Boolean locked;
    
    AttributeSlider(String attribute)
    {
        this.attribute = attribute;
        createUI(attribute, -4, 4);
    }
    
    AttributeSlider(String attribute, int min)
    {
        this.attribute = attribute;
        createUI(attribute, min, 4);
    }
    
    private void createUI(String name, int min, int max)
    {
                //LABEL STUFF
        Label label = new Label(name);
        
        //current value field
        currentValue = new TextField("0");
        currentValue.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("-?\\d*")) {
                    // force the field to be numeric only
                    currentValue.setText(newValue.replaceAll("-?[^\\d]", ""));
                }
                else //is valid
                {
                    slider.setValue(Integer.parseInt(newValue));
                }
            }
        });
        //reload current value if field is left blank                                   //TODO: I am pretty sure this implementation is giving me a jittery slider then sliding
        currentValue.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (!newPropertyValue)
                {
                    currentValue.setText(Integer.toString((int)slider.getValue()));
                }
            }
        });
        
        //SLIDER STUFF
        slider = new Slider();
        //TODO: size should scale to window
        slider.setMinHeight(200); 
        slider.setMin(min);
        slider.setMax(max);
        slider.setValue(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setOrientation(Orientation.VERTICAL);
        slider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                currentValue.setText(Integer.toString(Math.round(newValue.floatValue())));
            }
        });
        
        
        //LOCK STUFF
        ToggleButton lock = new ToggleButton("Lock");
        lock.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (lock.isSelected())
                {
                    lock.setText("Locked"); //TODO: change colour when locked, (can be done with javafx css)
                    slider.setStyle("-fx-control-inner-background: darkslategray");
                    slider.setMouseTransparent(true);
                    currentValue.setMouseTransparent(true);
                }
                else
                {
                    lock.setText("Lock");
                    slider.setStyle(null);
                    slider.setMouseTransparent(false);
                    currentValue.setMouseTransparent(false);
                }
            }
        });
        
        
        sliderUI = new VBox();
        //TODO: find a way to globally set this sliderUI.setMaxWidth(maxWidth);
        sliderUI.getChildren().add(label);
        sliderUI.getChildren().add(currentValue);
        sliderUI.getChildren().add(slider);
        sliderUI.getChildren().add(lock);
    }
    
    public VBox getUI()
    {
        return sliderUI;
    }
    
    
    
}
