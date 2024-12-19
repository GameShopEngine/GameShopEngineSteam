/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.UI;

import GameShopEngine.GameShopATMS;
import GameShopEngine.GameShopATMSHash;
import GameShopEngine.LanguageProcessor.GameShopLanguageProcessor;
import GameShopEngine.UI.Components.GameShopUIComponent;
import com.jme3.math.Vector4f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import org.joml.Vector2f;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.GL_BYTE;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNPACK_ALIGNMENT;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glPixelStorei;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

/**
 *
 * @author lynden
 */
public class GameShopUIATMS extends GameShopATMS {
    
    public GameShopUIComponent[] components;
    public GameShopUILayer uiLayer;
    
    public GameShopUIATMS(int width, int height, Vector4f[] textureSamples) {
        super(width, height, textureSamples);
        
        components = new GameShopUIComponent[1];
        uiLayer = new GameShopUILayer(width, height);
      //  this.
    }
    
    public void addGameShopComponents(int index, GameShopUIComponent[] components){
    
       // public void addDrawCalls(int index, String[] drawCalls){

        boolean start = this.components[0] != null;

        ArrayList<GameShopUIComponent> newGSRs = new ArrayList<>(Arrays.asList(components));

        ArrayList<GameShopUIComponent> oldGSRs = null;

        if (start) {
            oldGSRs = new ArrayList<>(Arrays.asList(this.components));
        }

        ArrayList<GameShopUIComponent> lowerGSRs = new ArrayList<>();

        ArrayList<GameShopUIComponent> higherGSRs = new ArrayList<>();

        if (start) {
            for (int i = 0; i < index; i++) {
                lowerGSRs.add(oldGSRs.get(i));
            }

            for (int i = index; i < oldGSRs.size(); i++) {
                higherGSRs.add(oldGSRs.get(i));
            }
            this.components = new GameShopUIComponent[(oldGSRs.size()) + (newGSRs.size())];

        } else {
            this.components = new GameShopUIComponent[newGSRs.size()];
        }



        int i = 0;
        if (start) {
            for (GameShopUIComponent dc : lowerGSRs) {


                this.components[i] = dc;
                i++;
            }
        }
//        System.out.println(Arrays.toString(oldDrawCalls.toArray()));
  //      System.out.println(Arrays.toString(newDrawCalls.toArray()));

        for (GameShopUIComponent dc: newGSRs){

            this.components[i] = dc;
            i++;
        }

        if (start) {
            for (GameShopUIComponent dc : higherGSRs) {

                this.components[i] = dc;
                i++;
            }
        }
        //newDrawCalls.addAll(index, drawCalls);
        //        String[] temp = new String[this.drawCalls.length];
//
//        int i = 0;
//        for (String dc: this.drawCalls){
//
//            temp[i] = dc;
//            i++;
//        }
//
//        this.drawCalls = new String[(this.drawCalls.length) + drawCalls.length];
//
//        System.out.println("dc " + this.drawCalls.length);
////        i = 0;
////        int j = 0;
//
//        for (i = 0; i < index; i++){
//
//            this.drawCalls[i] = temp[i];
//        }
//
//        for (i = index; i < index + drawCalls.length; i++){
//
//            this.drawCalls[i] = drawCalls[i - index];
//        }
//
//        for (i = index + drawCalls.length; i < this.drawCalls.length; i++){
//
//            this.drawCalls[i] = temp[i - (drawCalls.length)];
//        }

   // }
    }
    
    
    @Override
       public void makeATMS(){
     //textureId = glGenTextures();

     
     ByteBuffer pixels = BufferUtils.createByteBuffer(uiLayer.outputLayer().length);
     pixels.put(uiLayer.outputLayer());
     pixels.flip();
     GameShopATMSHash.getInstance().addATMS(this);
        glBindTexture(GL_TEXTURE_2D, GameShopATMSHash.getInstance().atmsHash.get(this));
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
       // glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
       //         GL_RGBA, GL_FLOAT, uiLayer.outputLayer());
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
                GL_RGBA, GL_BYTE, pixels );
        glGenerateMipmap(GL_TEXTURE_2D);
        //assert (GameShopATMSHash.getInstance().atmsHash.get(this) != null);
    }
    
    public void onClick (Vector2f clickPos){
    
        for (GameShopUIComponent ui: components){
        
            ui.onClick(clickPos);
        }
    }
    
    public void render(){
     for (GameShopUIComponent ui: components){
        
            ui.render();
        }
    }
    
    @Override
    public void process(){
       
           for (GameShopLanguageProcessor gs: this.gslp){
           
               gs.process();
               if (gs.methodName.equals("drawCircle")){
               
                   String[] color = gs.parseArg(gs.args[3]);
                   this.uiLayer.drawCircle(Integer.parseInt(gs.args[0].trim()), Integer.parseInt(gs.args[1].trim()), Integer.parseInt(gs.args[2].trim()),  (new org.joml.Vector4f(Float.parseFloat(color[0].trim()), Float.parseFloat(color[1].trim()), Float.parseFloat(color[2].trim()), Float.parseFloat(color[3].trim()))));
               }
           }
           
           makeATMS();
       }
}
