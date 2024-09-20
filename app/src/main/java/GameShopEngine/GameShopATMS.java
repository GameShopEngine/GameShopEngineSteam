/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;


import java.nio.*;

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
    public GameShopATMS(int width, int height){
    
        this.width = width;
        this.height = height;
        this.layer = new GameShopLayer(width, height);
    }
    
       public void makeATMS(){
     //textureId = glGenTextures();

     //ByteBuffer pixels = ByteBuffer.allocate(layer.outputLayer().length);
     //pixels.put(0, layer.outputLayer()).flip();
     GameShopATMSHash.getInstsance().addATMS(this);
        glBindTexture(GL_TEXTURE_2D, GameShopATMSHash.getInstsance().atmsHash.get(this));
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
                GL_RGBA, GL_FLOAT, layer.outputLayer());
        glGenerateMipmap(GL_TEXTURE_2D);
        assert (GameShopATMSHash.getInstsance().atmsHash.get(this) != null);
    }
}
