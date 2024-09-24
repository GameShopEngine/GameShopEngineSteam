/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.joml.Vector3f;
import org.joml.Vector4f;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_POINTS;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_SHORT;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import org.lwjgl.opengl.GL20;
import static org.lwjgl.opengl.GL20.glBindAttribLocation;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glGetAttribLocation;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import org.lwjgl.opengl.GL30;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengl.GL45.glDisableVertexArrayAttrib;
import static org.lwjgl.opengl.GL45.glEnableVertexArrayAttrib;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.system.MemoryUtil.memFree;

/**
 *
 * @author gameshopengine
 */
//public class GameShopPoly {
//    
//    //This Should Always Be A Square
//    
//    //Transitioning To Array Elements
//    
//    public float[] vertices;
//    public int[] indices;
//    public Vector3f[] positions;
//    public float[] texCoords;
//    
//    public GameShopATMS atms;
//    
//    public int vaoId;
////    public GameShopPoly(float[] vertices){
////    
////         atms = new GameShopATMS(100, 100);
////         atms.layer.drawCircle(50, 50, 25, new Vector4f(0,0,1,1));
////         atms.makeATMS();
////         
////        this.vertices = vertices;
//////        FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
//////        verticesBuffer.put(vertices).flip();
////    }
//    
//    //Should always be 4 vertices
//    
//    public GameShopPoly(Vector3f... vertices){
//           atms = new GameShopATMS(100, 100);
//         atms.layer.drawCircle(50, 50, 25, new Vector4f(0,0,1,1));
//         atms.makeATMS();
//      allocateVertices(vertices);
//      this.indices = new int[]{
//        0, 1, 3, 3, 1, 2,
//    };
//      this.texCoords = new float[]{
//      
//          0,0, 0,1, 1,1, 1,0
//          
//      };
//    }
//    
//    public void allocateVertices(Vector3f[] vertices){
//        
//      this.positions = new Vector3f[vertices.length];
//      this.positions = vertices;
//        
//      this.vertices = new float[vertices.length * 3];
//         
//        int i = 0;
//        for (Vector3f vertex: vertices){
//        
//            this.vertices[i] = vertex.x;
//            this.vertices[i + 1] = vertex.y;
//            this.vertices[i + 2] = vertex.z;
//            
//            i += 3;
//        }
//    }
//    
//         FloatBuffer verticesBuffer;// = MemoryUtil.memAllocFloat(vertices.length);
//        IntBuffer indicesBuffer;// = MemoryUtil.memAllocInt(indices.length);
//        FloatBuffer textureCoordinatesBuffer;
//        
//    public void allocateBuffer(){
//        
//       bindVertexArrayObject();
//       bindVerticesBuffer();
//       bindIndicesBuffer();
//       bindTextureCoordinatesBuffer();
//       unbind();
//        
//    }
//    
//    public void unbind(){
//    glBindBuffer(GL_ARRAY_BUFFER, 0);
//            glBindVertexArray(0);
//
//    }
//    
//    public void outputHashValues(){
//    
//      System.out.println(GameShopIndexHash.getInstance().indexHash.get(this));
//      System.out.println(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop"));
//      System.out.println(GameShopShapeHash.getInstance().shapeHash.get(this));
//      System.out.println(GameShopVertexHash.getInstance().vertexHash.get(this));
//    }
//    public void bindVertexArrayObject(){
//    
//       GameShopVertexHash.getInstance().addVertexArrayObject(this);
//     glBindVertexArray(GameShopVertexHash.getInstance().vertexHash.get(this));
//    }
//    
//    public void bindVerticesBuffer(){
//       verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
//        verticesBuffer.put(vertices).flip(); 
//GameShopShapeHash.getInstance().addPoly(this);
//glBindBuffer(GL_ARRAY_BUFFER, GameShopShapeHash.getInstance().shapeHash.get(this));
//glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
//  glEnableVertexAttribArray(0);
//            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
//memFree(verticesBuffer);
//    }
//    
//    public void bindIndicesBuffer(){
//    indicesBuffer = MemoryUtil.memAllocInt(indices.length); 
//
//       indicesBuffer.put(indices).flip();
//     GameShopIndexHash.getInstance().addIndex(this);
//     glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, GameShopIndexHash.getInstance().indexHash.get(this));
//     glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
//     memFree(indicesBuffer);
//    }
//    
//    public void bindTextureCoordinatesBuffer(){
//    
//        textureCoordinatesBuffer = MemoryUtil.memAllocFloat(texCoords.length);
//        textureCoordinatesBuffer.put(texCoords).flip();
//        GameShopTextureCoordsHash.getInstance().addPoly(this);
//        glBindBuffer(GL_ARRAY_BUFFER, GameShopTextureCoordsHash.getInstance().textureCoordsHash.get(this));
//        glBufferData(GL_ARRAY_BUFFER, textureCoordinatesBuffer, GL_STATIC_DRAW);
//        glEnableVertexAttribArray(2);
//        glVertexAttribPointer(2, 2, GL_FLOAT, false, 0, 0);
//        memFree(textureCoordinatesBuffer);
//    }
//    
//    public void draw(){
//       // assert(GameShopATMSHash.getInstsance().atmsHash.get(atms) != null);
//       
//      // System.out.println(atms);
//       glActiveTexture(GL_TEXTURE0);
//       glBindTexture(GL_TEXTURE_2D, GameShopATMSHash.getInstsance().atmsHash.get(atms));
//        // Draw the mesh
//    glBindVertexArray(GameShopVertexHash.getInstance().vertexHash.get(this));
// 
//        glDrawElements(GL_TRIANGLES, indices.length,GL_UNSIGNED_INT, 0);
//    
//   
//    }
//}
