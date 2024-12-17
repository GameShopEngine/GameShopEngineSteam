/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.UI.Characters;

/**
 *
 * @author lynden
 */
public class GameShopCharacter {
    
    public String font;
    public Character character;
    public float fontSize;
    public GameShopCharacterContainer cc;
    
    public GameShopCharacter(String font, float fontSize, Character character, GameShopCharacterContainer cc){
    
        this.font = font;
        this.character = character;
        this.fontSize = fontSize;
        this.cc = cc;
    }
    
    public void drawCharacter(){
    
    }
        
}
