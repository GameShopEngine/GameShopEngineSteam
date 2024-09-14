/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengl.GL45.glEnableVertexArrayAttrib;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.system.MemoryUtil.memFree;

/**
 *
 * @author gameshopengine
 */
public class GameShopPoly {
    
    public float[] vertices;
    public int vaoId;
    public GameShopPoly(float[] vertices){
    
        this.vertices = vertices;
//        FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
//        verticesBuffer.put(vertices).flip();
    }
    
    public void allocateBuffer(){
    
         FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
         verticesBuffer.put(vertices).flip();
GameShopShapeHash.getInstance().addPoly(this);
glBindBuffer(GL_ARRAY_BUFFER, GameShopShapeHash.getInstance().shapeHash.get(this));
GameShopVertexHash.getInstance().addVertexArrayObject(this);
//int vaoId = glGenVertexArrays();
glBindVertexArray(GameShopVertexHash.getInstance().vertexHash.get(this));
glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
memFree(verticesBuffer);

    }
    
    public void draw(){
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexArrayAttrib(GameShopVertexHash.getInstance().vertexHash.get(this), 0);
        glDrawArrays(GL_TRIANGLES, 0, 3);
    }
}
