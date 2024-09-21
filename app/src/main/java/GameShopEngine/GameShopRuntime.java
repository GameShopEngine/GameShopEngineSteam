/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.joml.Vector3f;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL20.glUseProgram;

/**
 *
 * @author gameshopengine
 */
public class GameShopRuntime implements Runnable {

    int n = 100000;
        
    GameShopPoly[] gsps = new GameShopPoly[n];
    
        public final float uiScaleZ = -.97f;
        public final float uiScaleY = .56f;
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameShopRuntime.class.getName()).log(Level.SEVERE, null, ex);
        }
                  for (int i = 0; i < n; i++){
      
        
 
    gsps[i] = new GameShopPoly( new Vector3f(-1f, -uiScaleY, uiScaleZ), new Vector3f(-1f,uiScaleY,uiScaleZ), new Vector3f(1f,uiScaleY,uiScaleZ), new Vector3f(1f,-uiScaleY,uiScaleZ));
                
    gsps[i].allocateBuffer();  
           
 }
    while(true){
          
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glUseProgram(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop"));
         GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).setUniform("projMatrix", GameShopCameraHub.getInstance().gsCameras.get("UI").projMatrix);
             GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).setUniform("txtSampler", 0);
//           
        for (int i = 0; i < n; i++){
                
                    gsps[i].draw();
                }
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

//    


    }
    
}
