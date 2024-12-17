/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;


import com.jme3.math.Vector4f;
import java.nio.*;
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
    public String[] drawCalls;
    
    public GameShopATMS(int width, int height, Vector4f[] textureSamples){
    
        this.width = width;
        this.height = height;
        this.layer = new GameShopLayer(width, height);
        this.textureSamples = textureSamples;
        this.drawCalls = new String[1];
    }
    
       public void makeATMS(){
     //textureId = glGenTextures();

      ByteBuffer pixels = BufferUtils.createByteBuffer(layer.outputLayer().length);
     pixels.put(layer.outputLayer());
     pixels.flip();
     GameShopATMSHash.getInstsance().addATMS(this);
        glBindTexture(GL_TEXTURE_2D, GameShopATMSHash.getInstsance().atmsHash.get(this));
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
       // glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
         //       GL_RGBA, GL_FLOAT, layer.outputLayer());
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
                GL_RGBA, GL_BYTE, pixels);
        glGenerateMipmap(GL_TEXTURE_2D);
        //assert (GameShopATMSHash.getInstsance().atmsHash.get(this) != null);
    }
}
