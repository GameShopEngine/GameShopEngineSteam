/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.util.HashMap;
import static org.lwjgl.opengl.GL11.glGenTextures;

/**
 *
 * @author gameshopengine
 */
public class GameShopATMSHash {
    
    private static GameShopATMSHash _instance;
    
    public HashMap<GameShopATMS, Integer> atmsHash;
    
    private GameShopATMSHash(){
    
        atmsHash = new HashMap<GameShopATMS, Integer>();
    }
    
    public static GameShopATMSHash getInstsance(){
    
        if (_instance == null){
        
            _instance = new GameShopATMSHash();
        }
        return _instance;
    }
    
    public void addATMS(GameShopATMS atms){
    
        atmsHash.put(atms, glGenTextures());
        //System.out.println(atmsHash.keySet().toString());
        //System.out.println(atmsHash.values().toString());
    }
}
