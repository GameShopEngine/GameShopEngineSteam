/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.system.MemoryUtil.memFree;

/**
 *
 * @author chrx
 */
public class GameShopPolyMesh {
    
    //Implement everything in GameShopPolyMesh
    //50 000 vertices expected
    
    public float[] vertices;
    public int[] indices;
    //public Vector3f[] positions;
    public float[] texCoords;
    
    public GameShopATMS atms;
    
    public int vaoId;
    
    public GameShopObject gso;
    
    public GameShopPolySurface[] gspSurfaces;
    //Groups Of 4. [group][4x]
   //public GameShopPolyLine[][] gspLines;
    
    public GameShopPolyMesh(GameShopPolySurface[] gspSurfaces, Vector2f numTextureSlices, GameShopATMS atms){
        
    this.gspSurfaces = new GameShopPolySurface[gspSurfaces.length];
    this.gspSurfaces = gspSurfaces;
    
    this.atms = atms;
    
    
    
       // this.gspLines = new GameShopPolyLine[gspLines.length][4];
      //  this.gspLines = gspLines;
        
//         atms = new GameShopATMS(100, 100);
//         atms.layer.drawCircle(50, 50, 25, new Vector4f(0,0,1,1));
//         atms.makeATMS();
     // allocateVertices(gspLines);
//      this.indices = new int[]{
//        0, 1, 3, 3, 1, 2,
//    };
      this.texCoords = new float[]{
      
          0,0, 0,1, 1,1, 1,0
          
      };
    }
    
    public void allocateVertices(){
 
        int totalVertices = 0;
        for (GameShopPolySurface gsps: this.gspSurfaces){
        
           // totalVertices += gsps.vInfinitesimals[0].infinitesimals.length * 4;
        
           totalVertices += gsps.getTotalVertices();
//           for (GameShopPolyLine vi: gsps.vInfinitesimals){
//           
//               totalVertices += vi.infinitesimals.length;
//           }
//        }
        }
        
        vertices = new float[totalVertices];
        int i = 0;
        for (GameShopPolySurface gsps: this.gspSurfaces){
         
           for (GameShopPolyLine vi: gsps.vInfinitesimals){
             
              for (com.jme3.math.Vector3f v : vi.infinitesimals){
              
                  vertices[i] = v.x;
                  vertices[i + 1] = v.y;
                  vertices[i + 2] = v.z;
              
                  i += 3;
              }
           }
        }
        
    }
    
    public void allocateIndices(){
    
        //Find Poly Surface.  Determine Dimensions.  Go To Where In Array Start And End
        //Indices Seem To Be Half Of The Vertices.
        
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        
        this.indices = new int[(this.vertices.length * 1)/2];
        
        
        
    }
    
    public void allocateTexCoords(){
    
    }
    
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
    
         FloatBuffer verticesBuffer;// = MemoryUtil.memAllocFloat(vertices.length);
        IntBuffer indicesBuffer;// = MemoryUtil.memAllocInt(indices.length);
        FloatBuffer textureCoordinatesBuffer;
        
    public void allocateBuffer(){
        
       bindVertexArrayObject();
       bindVerticesBuffer();
       bindIndicesBuffer();
       bindTextureCoordinatesBuffer();
       unbind();
        
    }
    
    public void unbind(){
    glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindVertexArray(0);

    }
    
    public void outputHashValues(){
    
      System.out.println(GameShopIndexHash.getInstance().indexHash.get(this));
      System.out.println(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop"));
      System.out.println(GameShopShapeHash.getInstance().shapeHash.get(this));
      System.out.println(GameShopVertexHash.getInstance().vertexHash.get(this));
    }
    public void bindVertexArrayObject(){
    
       GameShopVertexHash.getInstance().addVertexArrayObject(this);
     glBindVertexArray(GameShopVertexHash.getInstance().vertexHash.get(this));
    }
    
    public void bindVerticesBuffer(){
       verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
        verticesBuffer.put(vertices).flip(); 
GameShopShapeHash.getInstance().addPoly(this);
glBindBuffer(GL_ARRAY_BUFFER, GameShopShapeHash.getInstance().shapeHash.get(this));
glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
  glEnableVertexAttribArray(0);
            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
memFree(verticesBuffer);
    }
    
    public void bindIndicesBuffer(){
    indicesBuffer = MemoryUtil.memAllocInt(indices.length); 

       indicesBuffer.put(indices).flip();
     GameShopIndexHash.getInstance().addIndex(this);
     glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, GameShopIndexHash.getInstance().indexHash.get(this));
     glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
     memFree(indicesBuffer);
    }
    
    public void bindTextureCoordinatesBuffer(){
    
        textureCoordinatesBuffer = MemoryUtil.memAllocFloat(texCoords.length);
        textureCoordinatesBuffer.put(texCoords).flip();
        GameShopTextureCoordsHash.getInstance().addPoly(this);
        glBindBuffer(GL_ARRAY_BUFFER, GameShopTextureCoordsHash.getInstance().textureCoordsHash.get(this));
        glBufferData(GL_ARRAY_BUFFER, textureCoordinatesBuffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(2);
        glVertexAttribPointer(2, 2, GL_FLOAT, false, 0, 0);
        memFree(textureCoordinatesBuffer);
    }
    
    public void draw(){
       // assert(GameShopATMSHash.getInstsance().atmsHash.get(atms) != null);
       
      // System.out.println(atms);
       glActiveTexture(GL_TEXTURE0);
       glBindTexture(GL_TEXTURE_2D, GameShopATMSHash.getInstsance().atmsHash.get(atms));
        // Draw the mesh
    glBindVertexArray(GameShopVertexHash.getInstance().vertexHash.get(this));
 
        glDrawElements(GL_TRIANGLES, indices.length,GL_UNSIGNED_INT, 0);
    
   
    }
}
