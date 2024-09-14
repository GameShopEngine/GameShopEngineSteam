/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import static org.lwjgl.glfw.GLFW.*;
//import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL46.*;

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
        assert(shader.get(name) == glCreateProgram());
        
    }
    
    public int getGLShaderProgram(String name){
    
        for (HashMap<String, Integer> shader: glShaderProgram.keySet()){
        
            return shader.get(name);
            
        }
        
        return -1;
    }
    
    public String getVertexShader(String name){
    
        int i = 0;
        
       for (HashMap<String, Integer> shader: glShaderProgram.keySet()){
        
            i = shader.get(name);
            
        }
       
       int j = 0;
       for (HashMap<String, String> values: glShaderProgram.values()){
        
            //return shader.get(name);
            if (j == i){
            
                for (String s: values.values()){
                
                    return s;
                }
            }
        }
       
       return "";
       
    }
    
    public String getFragmentShader(String name){
    
        int i = 0;
        
       for (HashMap<String, Integer> shader: glShaderProgram.keySet()){
        
            i = shader.get(name);
            
        }
       
       int j = 0;
       for (HashMap<String, String> values: glShaderProgram.values()){
        
            //return shader.get(name);
            if (j == i){
            
                for (String s: values.keySet()){
                
                    return s;
                }
            }
        }
       
       return "";
    }
    
    public void compileShader(String name){
    
        glShaderSource(GL_VERTEX_SHADER, getVertexShader(name));
                glCompileShader(GL_VERTEX_SHADER);
                //glDeleteShader(GL_VERTEX_SHADER);
                
                glShaderSource(GL_FRAGMENT_SHADER, getFragmentShader(name));
                glCompileShader(GL_FRAGMENT_SHADER);
               // glDeleteShader(GL_FRAGMENT_SHADER);
                
                
                glAttachShader (getGLShaderProgram(name), GL_VERTEX_SHADER);
                glAttachShader (getGLShaderProgram(name), GL_FRAGMENT_SHADER);
                
                glLinkProgram(getGLShaderProgram(name));
                
                glDetachShader(getGLShaderProgram(name), GL_VERTEX_SHADER);
                glDetachShader(getGLShaderProgram(name), GL_FRAGMENT_SHADER);
                
                glDeleteShader(GL_VERTEX_SHADER);
                glDeleteShader(GL_FRAGMENT_SHADER);
    }
    
    
    
}
