/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.util.HashMap;

/**
 *
 * @author gameshopengine
 */
public class GameShopShaderHash {
    
    
    public HashMap<String, Integer> vertexShaders;
    public HashMap<String, Integer> fragmentShaders;
    
    private static GameShopShaderHash _instance;
    
    private GameShopShaderHash(){
    
    }
    
    public static GameShopShaderHash getInstance(){
    
        if (_instance == null){
        
            _instance = new GameShopShaderHash();
            
        }
        
        return _instance;
        
    }
    
    
    
    
}
