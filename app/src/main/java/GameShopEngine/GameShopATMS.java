/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;


import GameShopEngine.LanguageProcessor.GameShopLanguageProcessor;
//import GameShopEngine.UI.Components.GameShopLanguageProcessor;
import com.jme3.math.Vector4f;
import java.nio.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL30.*;


/**
 *
 * @author gameshopengine
 */
public class GameShopATMS {
    
    public int width;
    public int height;
    public int textureId;
    public GameShopLayer layer;
    public Vector4f[] textureSamples;
    //public String[] drawCalls;
    public GameShopLanguageProcessor[] gslp;
    
    public GameShopATMS(int width, int height, Vector4f[] textureSamples){
    
        this.width = width;
        this.height = height;
        this.layer = new GameShopLayer(width, height);
        this.textureSamples = textureSamples;
        gslp = new GameShopLanguageProcessor[1];
        //this.drawCalls = new String[1];
    }
    
       public void makeATMS(){
     //textureId = glGenTextures();

      ByteBuffer pixels = BufferUtils.createByteBuffer(layer.outputLayer().length);
     pixels.put(layer.outputLayer());
     pixels.flip();
     GameShopATMSHash.getInstance().addATMS(this);
        glBindTexture(GL_TEXTURE_2D, GameShopATMSHash.getInstance().atmsHash.get(this));
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
       // glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
         //       GL_RGBA, GL_FLOAT, layer.outputLayer());
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
                GL_RGBA, GL_BYTE, pixels);
        glGenerateMipmap(GL_TEXTURE_2D);
        //assert (GameShopATMSHash.getInstance().atmsHash.get(this) != null);
    }
       
       public void addGameShopLanguageProcessors(int index, GameShopLanguageProcessor[] gslp){
    
       // public void addDrawCalls(int index, String[] drawCalls){

        boolean start = this.gslp[0] != null;

        ArrayList<GameShopLanguageProcessor> newGSRs = new ArrayList<>(Arrays.asList(gslp));

        ArrayList<GameShopLanguageProcessor> oldGSRs = null;

        if (start) {
            oldGSRs = new ArrayList<>(Arrays.asList(this.gslp));
        }

        ArrayList<GameShopLanguageProcessor> lowerGSRs = new ArrayList<>();

        ArrayList<GameShopLanguageProcessor> higherGSRs = new ArrayList<>();

        if (start) {
            for (int i = 0; i < index; i++) {
                lowerGSRs.add(oldGSRs.get(i));
            }

            for (int i = index; i < oldGSRs.size(); i++) {
                higherGSRs.add(oldGSRs.get(i));
            }
            this.gslp = new GameShopLanguageProcessor[(oldGSRs.size()) + (newGSRs.size())];

        } else {
            this.gslp = new GameShopLanguageProcessor[newGSRs.size()];
        }



        int i = 0;
        if (start) {
            for (GameShopLanguageProcessor dc : lowerGSRs) {


                this.gslp[i] = dc;
                i++;
            }
        }
//        System.out.println(Arrays.toString(oldDrawCalls.toArray()));
  //      System.out.println(Arrays.toString(newDrawCalls.toArray()));

        for (GameShopLanguageProcessor dc: newGSRs){

            this.gslp[i] = dc;
            i++;
        }

        if (start) {
            for (GameShopLanguageProcessor dc : higherGSRs) {

                this.gslp[i] = dc;
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
       
       public void process(){
       
           for (GameShopLanguageProcessor gs: this.gslp){
           
               gs.process();
               
               if (gs.methodName.equals("drawCircle")){
               
                   String[] color = gs.parseArg(gs.args[3]);
                   this.layer.drawCircle(Integer.parseInt(gs.args[0]), Integer.parseInt(gs.args[1]), Integer.parseInt(gs.args[2]),  (new org.joml.Vector4f(Float.parseFloat(color[0]), Float.parseFloat(color[1]), Float.parseFloat(color[2]), Float.parseFloat(color[3]))));
               }
               
               else if (gs.methodName.equals("drawSquare")){
               
                   
               }
               
               else if (gs.methodName.equals("drawRectangle")){
               
               }
               
               else if (gs.methodName.equals("drawLine")){
               
               } 
               
               else if (gs.methodName.equals("drawPolyLine")) {
               
               }
           }
           
           makeATMS();
       }
}
