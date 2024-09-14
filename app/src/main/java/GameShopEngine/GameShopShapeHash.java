/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.util.HashMap;
import static org.lwjgl.opengl.GL46.*;


/**
 *
 * @author gameshopengine
 */
public class GameShopShapeHash {
  
    private static GameShopShapeHash _instance;
    
    public HashMap<GameShopPoly, Integer> shapeHash;
    
    private GameShopShapeHash(){
    
        shapeHash = new HashMap<GameShopPoly, Integer>();
        
    }
    
    public static GameShopShapeHash getInstance(){
    
        if (_instance == null){
        
            _instance = new GameShopShapeHash();
        }
        return _instance;
    }
    
    public void addPoly(GameShopPoly gsp){
    
        shapeHash.put(gsp, glGenBuffers());
 
    }
}
