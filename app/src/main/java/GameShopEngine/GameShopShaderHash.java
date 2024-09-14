/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author gameshopengine
 */
public class GameShopShaderHash {
    
    
 
    /**
     Name, GlProgram, VertexShader, FragmentShader
     */
    public HashMap<HashMap<String, Integer>, HashMap<String, String>> glShaderProgram;
    
    private static GameShopShaderHash _instance;
    
    private GameShopShaderHash(){
    
        glShaderProgram = new HashMap<HashMap<String, Integer>, HashMap<String, String>>();
    }
    
    public static GameShopShaderHash getInstance(){
    
        if (_instance == null){
        
            _instance = new GameShopShaderHash();
            
        }
        
        return _instance;
        
    }
  
    public void addShader(String name, String vertexShader, String fragmentShader) {
    
        HashMap <String, Integer> shader = new HashMap<String, Integer>();
        HashMap<String, String> vertexAndFragment = new HashMap<String, String>();
        
        shader.put(name, shader.size());
        vertexAndFragment.put(fragmentShader, vertexShader);
        glShaderProgram.put(shader, vertexAndFragment);
        
    }
    
    public int getGLShaderProgram(String name){
    
        for (HashMap<String, Integer> shader: glShaderProgram.keySet()){
        
            return shader.get(name);
            
        }
        
        return 0;
    }
    
    public void compileShader(){
    
        
    }
    
    
    
}
