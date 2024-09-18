/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import org.joml.*;

/**
 *
 * @author gameshopengine
 */
public class GameShopCamera {
    
    public static final float FOV = (float)org.joml.Math.toRadians(60f);
    public static final float Z_FAR = 1000f;
    public static final float Z_NEAR = 0.01f;
    
    public Matrix4f projMatrix;
    
    public GameShopCamera(int width, int height){
    
        projMatrix = new Matrix4f();
        updateProjMatrix(width, height);
        
    }
    
    public void updateProjMatrix(int width, int height){
    
        projMatrix.setPerspective(FOV, (float)width/height, Z_NEAR, Z_FAR);
    }
    
}
