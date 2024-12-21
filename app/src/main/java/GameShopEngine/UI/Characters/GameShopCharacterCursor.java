/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.UI.Characters;

import GameShopEngine.UI.Components.GameShopUIComponent;
import org.joml.Vector2f;

/**
 *
 * @author lynden
 */
public class GameShopCharacterCursor {
    
    public Vector2f position;
    public GameShopUIComponent uic;
    
    public GameShopCharacterCursor(GameShopUIComponent uic){
    
        position = new Vector2f();
        //this.uic = new GameShopUIComponent();
        this.uic = uic;
    }
    
    public void setStartPosition(GameShopCharacter gsc){
    
        this.position = new Vector2f(uic.position.x, (uic.position.y + uic.size.y) - gsc.fontSize);
        
    }
}
