/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import org.lwjgl.system.MemoryStack;

import java.nio.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import org.joml.Vector2f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL30.*;
/**
 *
 * @author gameshopengine
 */
public class GameShopLayer {
    
    public int width;
    public int height;
 
    public float[][] layer;
    //public Vector4f[][] layer;
    
    public GameShopLayer(int width, int height){
    
        this.width = width;
        this.height = height;
        
        layer = new float[height][width * 4];
        //drawCircle(width/2, height/2, width * 2, ColorRGBA.Black);
        //layer = new Vector4f[height][width];
    }
    
        public void copyLayer(GameShopLayer copy, Vector2f start) {

        for (int y = (int) start.y; y < start.y + copy.height; y++) {
            if (y >= 0 || y < height) {
                for (int x = (int) start.x; x < start.x + copy.width; x++) {

                    if (x >= 0 || x < width) {

                        if ( getPixel((int) (x - start.x), (int) (y - start.y)).a == 0) {
                            continue;
                        }
                         setPixel(x, y,  copy.getPixel((int) (x - start.x), (int) (y - start.y)));

                    }

                }
            }
        }

    }

    public void copyLayer(GameShopLayer copy, Vector2f start, Vector2f end) {

        for (int y = (int) start.y; y < start.y + end.y; y++) {
            if (y >= 0 || y < height) {
                for (int x = (int) start.x; x < start.x + end.x; x++) {

                    if (x >= 0 || x < width) {

                        if ( getPixel((int) (x - start.x), (int) (y - start.y)).a == 0) {
                            continue;
                        }
                         setPixel(x, y,  copy.getPixel((int) (x - start.x), (int) (y - start.y)));

                    }

                }
            }
        }

    }

    public void copyLayerAndAlpha(GameShopLayer copy, Vector2f start) {

        for (int y = (int) start.y; y < start.y + copy.height; y++) {
            if (y >= 0 || y < height) {
                for (int x = (int) start.x; x < start.x + copy.width; x++) {

                    if (x >= 0 || x < width) {

//                        if (copy.dir.getPixel((int) (x - start.x), (int) (y - start.y)).a == 0f){
//                            continue;
//                        }
                         setPixel(x, y,  copy.getPixel((int) (x - start.x), (int) (y - start.y)));

                    }

                }
            }
        }

    }

    public void copyLayerAndAlpha(GameShopLayer copy, Vector2f start, Vector2f end) {

        for (int y = (int) start.y; y < start.y + end.y; y++) {
            if (y >= 0 || y < height) {
                for (int x = (int) start.x; x < start.x + end.x; x++) {

                    if (x >= 0 || x < width) {

//                        if (copy.dir.getPixel((int) (x - start.x), (int) (y - start.y)).a == 0f){
//                            continue;
//                        }
                        setPixel(x, y, copy.getPixel((int) (x - start.x), (int) (y - start.y)));

                    }

                }
            }
        }

    }
    
    public void setPixel(int x, int y, ColorRGBA color){
    
        layer[y][x * 4] = (color.r);
        layer[y][(x * 4) + 1] = (color.g);
        layer[y][(x * 4) + 2] = (color.b);
        layer[y][(x * 4) + 3] = (color.a);
        
    }
    
    public ColorRGBA getPixel(int x, int y){
    
        ColorRGBA color = new ColorRGBA();
         (color.r) = layer[y][x * 4];
         (color.g) = layer[y][(x * 4) + 1];
         (color.b) = layer[y][(x * 4) + 2];
         (color.a) = layer[y][(x * 4) + 3];
         
         return color;
    }
    
    public void drawRectangle(Vector2f start, Vector2f end, ColorRGBA color){
    
             for (int y = (int) start.y; y <= end.y; y++){

            for (int x = (int) start.x; x <= end.x; x++) {
                setPixel(x,y, color);
//
            }
        }
        
    }
    
    /**
     color should be 0 to 255;
     */
    public void drawSquare(int pointX, int pointY, int currency, ColorRGBA color){
    
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;
        
        //start with pointX and pointY, subtract radius to get the startPoint
        //compare width and height bounds to edge
        //check if width and height is in radius bounds
        
         if (pointX - currency <= 0){
            startX = 0;
        } else {
            startX = ((pointX - currency) + 1);
        }

        if (pointY - currency <= 0){
            startY = 0;
        } else {
            startY =  ((pointY - currency) + 1);
        }

        if (pointX + currency >= width){
            endX = width;
        } else {
            endX = ((pointX + currency) - 1);
        }

        if (pointY + currency >= height){
            endY = height;
        } else {
            endY = ((pointY + currency) - 1);
        }
        
        //        System.out.println("StartX " + startX);
////
//        System.out.println("StartY " + startY);
//
//        System.out.println("EndX " + endX);
//
//        System.out.println("EndY " + endY);
        for (int y = startY; y < endY; y++){

            for (int x = startX; x < endX; x++) {
                setPixel(x,y,color);
//
            }
        }
    }
    
        public float[] outputLayer(){

        float[] output = new float[(width * height * 4)];
        int i = 0;
        for (short y = 0; y < height; y++){
            for (short x = 0; x < width; x++){

                output[i] =   getPixel(x,y).r;
                output[i + 1] =    getPixel(x,y).g;
                output[i + 2] =    getPixel(x,y).b;
                output[i + 3] =    getPixel(x,y).a;

                i += 4;
            }

        }

       //System.out.println("OutPutRED " + output[0]);
       
      // System.out.println("OutPutBLUE " + output[(2)]);
        return output;
    }
 
    public void drawPolyLine(GameShopPolyLine cl, short radius, ColorRGBA color){

        //int i = 0;
        //System.out.println(Arrays.asList(cl.infinitesimals));
        for (int i = 0; i < cl.infinitesimals.length - 1; i++){

            //if (i < cl.infinitesimals.length - 1) {
           
            drawLine(new Vector2f((int)cl.infinitesimals[i].x,(int)cl.infinitesimals[i].y), new Vector2f((int)cl.infinitesimals[i + 1].x,(int)cl.infinitesimals[i + 1].y), radius, color);
            // i++;
            //}


        }

    }
    public void drawLine(Vector2f pointA, Vector2f pointB, short radius, ColorRGBA color){

     //   System.out.println("drawLine " + pointA.toString(new DecimalFormat("##")) + " " + pointB.toString(new DecimalFormat("##")) + " " + radius + " " + color.toString(new DecimalFormat("##")));
//       float dist = pointA.distance(pointB);
//
//        int i = (int) (dist/radius);
//

//        Vector2f tempA = null;
//        Vector2f tempB = null;
//        
//        if (pointA.x <= pointB.x){
//        
//            tempA = pointA;
//            tempB = pointB;
//        } else {
//        
//            //System.out.println("ELSE");
//            tempA = pointB;
//            tempB = pointA;
//        }
//        
//        pointA = tempA;
//        pointB = tempB;

        float x =  pointA.x;
        float y =  pointA.y;
//
//        Vector2f distance = pointB.subtract(pointA);
//

        float distX =  (pointB.x - pointA.x);
        float distY =  (pointB.y - pointA.y);

        float lastX = x;
        float lastY = y;
        float addX =0f;
        float addY = 0f;
        while (true){

              lastX = x;
              lastY = y;
            if ((distX > 0 && x > pointB.x) || (distY > 0 && y > pointB.y)) {
                break;
            }


            if ((distX < 0 && x < pointB.x) || (distY < 0 && y < pointB.y)) {
                break;
            }

            if ((distX > 0 && x > pointB.x) || (distY < 0 && y < pointB.y)) {
                break;
            }


            if ((distX < 0 && x < pointB.x) || (distY > 0 && y > pointB.y)) {
                break;
            }
//
          //  System.out.println(distX + " " + distY);
            drawCircle((short)x, (short)y, radius, color);
            if (distX != 0){
            if (distX >= 1) {
                //System.out.println("x+ " + x);
                addX = (FastMath.sqrt(FastMath.sqr(radius * distX) - FastMath.sqr(radius)));
                addX /= (FastMath.abs(distY * 4));
                
                if (addX == 0 || Float.isNaN(addX) || Float.isInfinite(addX)){
                 
                     //System.out.println("NAN");
                    //addY = (FastMath.sqrt(FastMath.sqr(radius * distY) - FastMath.sqr(FastMath.abs(radius))));
                 addX = 1; 
                 }
                
                if (Float.isNaN(x)){
                    continue;
                }
                x += addX;
                 if (lastX == x) {
                
                    x = increment(lastX, x, 1);
                    //lastX = x;
                }
            }

            else if (distX <= -1) {
               // System.out.println("x- " + x);
                 addX = (FastMath.sqrt(FastMath.sqr(radius * distX) - FastMath.sqr(FastMath.abs(radius))));
                addX /= (FastMath.abs(distY * 4));
                if (addX == 0 || Float.isNaN(addX) || Float.isInfinite(addX)){
                 
                     //System.out.println("NAN");
                    //addY = (FastMath.sqrt(FastMath.sqr(radius * distY) - FastMath.sqr(FastMath.abs(radius))));
                 addX = 1; 
                 }
                if (Float.isNaN(x)){
                    continue;
                }
                x -= addX;

                 if (lastX == x) {
                
                    x = increment(lastX, x, -1);
                    //lastX = x;
                }
            }
            }
            if (distY != 0){
            if (distY >= 1) {
               // System.out.println("y+ " + y);
                 addY = (FastMath.sqrt(FastMath.sqr(radius * distY) - FastMath.sqr(radius)));
                addY /= (FastMath.abs(distX * 4));
             if (addY == 0 || Float.isNaN(addY) || Float.isInfinite(addY)){
                 
                     //System.out.println("NAN");
                    //addY = (FastMath.sqrt(FastMath.sqr(radius * distY) - FastMath.sqr(FastMath.abs(radius))));
                 addY = 1; 
                 }
                if (Float.isNaN(y)){
                    
                    continue;
                }
                y += addY;
                 if (lastY == y) {
                
                    y = increment(lastY, y, 1);
                    //lastY = y;
                }
            }

            else if (distY <= -1) {
              //  System.out.println("y- " + y);
                 addY = (FastMath.sqrt(FastMath.sqr(radius * distY) - FastMath.sqr(FastMath.abs(radius))));
                 addY /= FastMath.abs(distX * 4);
                // System.out.println("addY" + addY);
                 if (addY == 0 || Float.isNaN(addY) || Float.isInfinite(addY)){
                 
                     //System.out.println("NAN");
                    //addY = (FastMath.sqrt(FastMath.sqr(radius * distY) - FastMath.sqr(FastMath.abs(radius))));
                 addY = 1; 
                 }
                 if (Float.isNaN(y)){
                 
                     continue;
                 }
                y -= addY;
                if (lastY == y) {
                
                    y = increment(lastY, y, -1);
                   // lastY = y;
                }
                 //System.out.println("newY- " + y);

            }
            }
            
           
            if (distX == 0 && distY == 0){
            
                return;
            }

        }

//        while (x < pointB.x) {
//            drawCircle((short) (x), (short) (y), radius, color);
//            x += (short) (radius/distance.x);
//            y += (short) (radius/distance.y);
//        }
//        for (int y = (int) pointA.y; y < pointB.y; y += radius/2){
//            for (short x = (short) pointA.x; x < pointB.x; x += radius/2){
//
//                drawCircle((short) (x), (short) (y), radius, color);
//
//
//            }
//        }
//        for (int j = 0; j < i; j += radius/2){
//            drawCircle((short) (pointA.x + j), (short) (pointA.y + j), radius, color);
//        }

    }

    public float increment(float last, float current, float factor){
    
        float inc = current;
        
         if (last == current){
                
                if (factor >= 0){
                inc++;
                } else if (factor < 0){
                
                    inc--;
                }
                //System.out.println(inc);
                
               // lastX = x;
                //break;
            }
//            System.out.println(lastY + " " + y);
//            if (lastY == y){
//             if (addY >= 0){
//                y++;
//                } else if (addY < 0){
//                
//                    y--;
//                }
//                lastY = y;
//                break;
//            }
//            }
return  inc;
    }
    //0x0 center
    public void drawCircle(int pointX, int pointY, int radius, ColorRGBA color){

//        layer[((width - pointX) * (height - pointY) * 4)] = color.asBytesRGBA()[0];
//        layer[((width - pointX) * (height - pointY) * 4) + 1] = color.asBytesRGBA()[1];
//        layer[((width - pointX) * (height - pointY) * 4) + 2] = color.asBytesRGBA()[2];
//        layer[((width - pointX) * (height - pointY) * 4) + 3] = color.asBytesRGBA()[3];

        //System.out.println(ColorRGBA.White.getColorArray()[0]);
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;
        //start with pointX and pointY, subtract radius to get the startPoint
        //compare width and height bounds to edge
        //check if width and height is in radius bounds


        if (pointX - radius <= 0){
            startX = 0;
        } else {
            startX = (short) ((pointX - radius) + 1);
        }

        if (pointY - radius <= 0){
            startY = 0;
        } else {
            startY = (short) ((pointY - radius) + 1);
        }

        if (pointX + radius >= width){
            endX = (short) (width - 1);
        } else {
            endX = (short) ((pointX + radius) - 1);
        }

        if (pointY + radius >= height){
            endY = (short) (height - 1);
        } else {
            endY = (short) ((pointY + radius) - 1);
        }

//        System.out.println("StartX " + startX);
////
//        System.out.println("StartY " + startY);
//
//        System.out.println("EndX " + endX);
//
//        System.out.println("EndY " + endY);
        int i = 0;
        for (int y = startY; y <= endY; y++){

            for (int x = startX; x <= endX; x++){

//                if (x <= FastMath.sqrt(FastMath.sqr(radius) - FastMath.sqr(y - pointY)) + pointX &&
//                        y <= FastMath.sqrt(FastMath.sqr(radius) - FastMath.sqr(x - pointX)) + pointY) {

                //System.out.println("FastMath " + ((FastMath.sqr(FastMath.abs(((float) pointX) - ((float) x/4))) + FastMath.sqr(FastMath.abs(pointY - y)))));
                // if ((FastMath.sqr(FastMath.abs((((float) x/4) - (float) pointX))) + FastMath.sqr(FastMath.abs(y - pointY))) < FastMath.sqr(radius) )

//                System.out.println("INTRIANGLE " + FastMath.pointInsideTriangle(new Vector2f(FastMath.sqr(pointX), FastMath.sqr(pointY)), new Vector2f(FastMath.sqr(pointX + radius), FastMath.sqr(pointY)), new Vector2f(FastMath.sqr(pointX), FastMath.sqr(pointY + radius)), new Vector2f(FastMath.sqr(x), FastMath.sqr(y))) );
//               if(FastMath.pointInsideTriangle(new Vector2f(FastMath.sqr(pointX), FastMath.sqr(pointY)), new Vector2f(FastMath.sqr(pointX + radius), FastMath.sqr(pointY)), new Vector2f(FastMath.sqr(pointX), FastMath.sqr(pointY + radius)), new Vector2f(x, y)) == 1)
//
                //int i = (pointX - x / 4) * (pointX - x / 4);
//                System.out.println ("FastMath " +(float) ((pointX - x ) * (pointX - x )) + ((pointY - y) * (pointY - y)));
//               System.out.println ("Radius" + (radius * radius));

                if ( ((pointX - x ) * (pointX - x)) + ((pointY - y) * (pointY - y)) < (radius * radius))

                {
                    //if (FastMath.sqrt(FastMath.sqr((((float) x /4) + pointX * 4)) + FastMath.sqr((y + pointY))) < radius){
                    setPixel(x,y,color);
                    //System.out.println("IN");

                }
            }
        }

//        for (short h = 0; h < height; h++) {
//
//            for (short w = 0; w < width * 4; w += 4) {
//
//
//                if (startX == -1){
//
//                    startX = 0;
//                }
//
//
//            }
//        }




    }

}
