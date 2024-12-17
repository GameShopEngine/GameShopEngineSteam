/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_DEBUG_CONTEXT;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.opengl.GLUtil;

/**
 *
 * @author gameshopengine
 */
public class GameShopWindow implements Runnable {

    public static long window;
     public String vertexShader = "#version 330\n" +
"\n" +
                "#extension GL_ARB_explicit_uniform_location : require\n"+
"layout (location=0) in vec3 inputPosition;\n" +
"layout (location=1) uniform mat4 projMatrix;\n" +
 "layout (location=2) in vec2 texCoord;\n" +
                "out vec2 outTextCoord;\n" +
"\n" +
"void main()\n" +
"{\n" +
"    gl_Position = projMatrix * vec4(inputPosition, 1.0);\n" +
                "   outTextCoord = texCoord;\n" +
"}";
        public String fragmentShader = "#version 330\n" +
"\n" +
"out vec4 fragColor;\n" +
                "in vec2 outTextCoord;\n" +
                "uniform sampler2D txtSampler;\n"+
"\n" +
"void main()\n" +
"{\n" +
"    fragColor = texture(txtSampler, outTextCoord);\n" +
"}";
    @Override
    public void run() {
        // This line is critical for LWJGL's interoperation with GLFW's
		// OpenGL context, or any context that is managed externally.
		// LWJGL detects the context that is current in the current thread,
		// creates the GLCapabilities instance and makes the OpenGL
		// bindings available for use.
		GL.createCapabilities();
                
                //
glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GL_TRUE); // before creating the window
GLUtil.setupDebugMessageCallback();
               
		// Set the clear color
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//                   
//for (int i = 0; i < n; i++){
//
//    gsps[i] = new GameShopPoly( new Vector3f(-1f, -uiScaleY, uiScaleZ), new Vector3f(-1f,uiScaleY,uiScaleZ), new Vector3f(1f,uiScaleY,uiScaleZ), new Vector3f(1f,-uiScaleY,uiScaleZ));
//}

               // gsp = new GameShopPoly( new Vector3f(-1f, -uiScaleY, uiScaleZ), new Vector3f(-1f,uiScaleY,uiScaleZ), new Vector3f(1f,uiScaleY,uiScaleZ), new Vector3f(1f,-uiScaleY,uiScaleZ));
                GameShopShaderHash.getInstance().addShader("Hello GameShop", vertexShader, fragmentShader);
                GameShopShaderHash.getInstance().compileShader("Hello GameShop");
//                gsp.allocateBuffer();
//                for (int i = 0; i < n; i++){
//                
//                    gsps[i].allocateBuffer();
//                }
                
                
                //ENTER GSPS THREAD HERE
                
                
                  //GameShopCameraHub.getInstance().gsCameras.put("UI", new GameShopCamera(1920, 1080));
                GameShopUniformHub.getInstance().gsUniforms.add(new GameShopUniform(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")));
               
//                GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).createUniform("projectionMatrix");
//               
                System.out.println("vShader: " + GameShopShaderHash.getInstance().getVertexShader("Hello GameShop"));
               //System.out.println(glGetShaderInfoLog(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")));
         GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).createUniform("projMatrix");
         GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).createUniform("txtSampler");

    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        // Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		while ( !glfwWindowShouldClose(window) ) {
                    
                    System.out.println("Draw Call");
                    if (GameShopCursor.getInstance().clicked){
                    System.out.println("Cursor:" + GameShopCursor.getInstance().cursorPosition);
                    System.out.println("GL Position: " + GameShopCursor.getInstance().glPosition);
                    GameShopCursor.getInstance().clicked = false;
                    }
                    
                    //SET GAMESHOPRUNTIME THREAD TO LOOP
                    
                  //  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

//                        System.out.println(j);
//                        j++;

                
                //glUseProgram(0);
//                glUseProgram(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop"));
//                
//              GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).setUniform("projMatrix", GameShopCameraHub.getInstance().gsCameras.get("UI").projMatrix);
//             GameShopUniformHub.getInstance().get(GameShopShaderHash.getInstance().getGLShaderProgram("Hello GameShop")).setUniform("txtSampler", 0);
//                gsp.draw();
                
//                for (int i = 0; i < n; i++){
//                
//                    gsps[i].draw();
//                }
                
 
			glfwSwapBuffers(window); // swap the color buffers

			// Poll for window events. The key callback above will only be
			// invoked during this call.
			glfwPollEvents();
                       // GameShopCursor.getInstance().clicked = false;
		}
    }
    
    
    
}
