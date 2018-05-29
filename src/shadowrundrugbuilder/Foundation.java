/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrundrugbuilder;

/**
 *
 * @author wbolduc
 */
public class Foundation {
    
    private String name;
    
    private int body;
    private int agility;
    private int reaction;
    private int strength;
    private int will;
    private int logic;
    private int intuition;
    private int charisma;
    
    private String[] effects;

    public Foundation(String name, int body, int agility, int reaction, int strength, int will, int logic, int intuition, int charisma, String[] effects) {
        this.name = name;
        this.body = body;
        this.agility = agility;
        this.reaction = reaction;
        this.strength = strength;
        this.will = will;
        this.logic = logic;
        this.intuition = intuition;
        this.charisma = charisma;
        this.effects = effects;
    }
    
   
    
    
    
}
