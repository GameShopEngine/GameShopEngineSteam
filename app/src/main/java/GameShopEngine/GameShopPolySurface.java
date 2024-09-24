/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine;

import com.jme3.math.Vector3f;
import org.joml.Vector2f;
//import org.joml.Vector3f;

/**
 *
 * @author chrx
 */
public class GameShopPolySurface {
    
    
    public GameShopPolyLine[] polyLines;
    public GameShopPolyLine[] vInfinitesimals;
    
    public float width;
    public float height;
    
    public float infWidth;
    public float infHeight;
    
    public GameShopPolySurface(GameShopPolyLine[] polyLines){
        
        this.polyLines = polyLines;
        makeVerticalLines();
        
    
    }
    
    public int getTotalVertices(){
    
          // for (GameShopPolySurface gsps: this.gspSurfaces){
        
           // totalVertices += gsps.vInfinitesimals[0].infinitesimals.length * 4;
        
           int totalVertices = 0;
           
           for (GameShopPolyLine vi: vInfinitesimals){
           
               totalVertices += vi.infinitesimals.length;
           }
        
           infWidth = vInfinitesimals[0].infinitesimals.length;
           infHeight = vInfinitesimals.length;
           return totalVertices;
    }
    
    public void makeVerticalLines(){
//     this.dim = 3;
//
        width = (polyLines[0].points[polyLines[0].points.length - 1].x - polyLines[0].points[0].x);
        height = (polyLines[polyLines.length - 1].points[0].y - polyLines[0].points[0].y);
        this.vInfinitesimals = new GameShopPolyLine[polyLines[0].infinitesimals.length];

        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i] = new GameShopPolyLine(new Vector3f[]{polyLines[0].infinitesimals[i], polyLines[1].infinitesimals[i], polyLines[2].infinitesimals[i], polyLines[3].infinitesimals[i]}, 16);

        }
    }
    /**
    public CurrencyLine[] vInfinitesimals;
    public SimpleMesh[] simpleMeshes;

    public CurrencyLine[] currencyLines;
    public float width;
    public float height;

    public float dim;

    SimpleApplication app;

    Texture2D texture;
    Node node;

    public GameShopPolySurface(GameShopCurrencyLine[] currencyLines, Texture2D texture, Node node){

        this.app = app;
        this.currencyLines = currencyLines;
        this.texture = texture;
        this.node = node;

        setDimensions();
        setImageArray();
        drawSimpleMeshes();

    }

    public void updateTexture(Texture2D texture){
        this.texture = texture;
    }
    public SimpleMesh getMeshFromValue(int x, int y){

        return  simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * x) + y];
    }

    public void modCurrencyLine(byte line, byte point, Vector3f newPoint){
        this.currencyLines[line].modCurrency(point, newPoint);
        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i].modCurrency((byte) 0, currencyLines[0].infinitesimals[i]); ;//= new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
            this.vInfinitesimals[i].modCurrency((byte) 1, currencyLines[1].infinitesimals[i]);
            this.vInfinitesimals[i].modCurrency((byte) 2, currencyLines[2].infinitesimals[i]);
            this.vInfinitesimals[i].modCurrency((byte) 3, currencyLines[3].infinitesimals[i]);
        }
        updateSimpleMeshes();
    }

    public void updateSimpleMeshes(){

        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;
        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
                Vector2f[] texCoord = new Vector2f[4];

                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);

                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord = texCoord;
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices = simpleMesh;

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices));
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord));
                //m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createShortBuffer(indexes));

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.updateBound();

                //simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].geom.updateModelBound();




            }
        }
    }

    public void setDimensions(){

        this.dim = 3;

        width = currencyLines[0].points[currencyLines[0].points.length - 1].x - currencyLines[0].points[0].x;
        height = currencyLines[currencyLines.length - 1].points[0].y - currencyLines[0].points[0].y;
        this.vInfinitesimals = new CurrencyLine[currencyLines[0].infinitesimals.length];

        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i] = new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);

        }
    }

    public void setImageArray(){
        int imageArray = 1;

        width = this.vInfinitesimals.length;
        height = this.vInfinitesimals[0].infinitesimals.length;

        imageArray = (int)width * (int)height;

        simpleMeshes = new SimpleMesh[imageArray];
    }
    public void drawSimpleMeshes(){
        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;
        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
                Vector2f[] texCoord = new Vector2f[4];

                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);

                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x] = new SimpleMesh(app, simpleMesh, texCoord, texture, node);

            }
        }
    }
    */
}