/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.GameShopUI.Widgets;

import GameShopEngine.GameShopATMS;
import GameShopEngine.Format.ATMS.*;
import com.jme3.math.Vector4f;
import com.jme3.math.Vector2f;
/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopAlphabet {

    public GameShopATMS atms;

    public GameShopATMSFrame characters;
   // public char c;
    public int width;
    public int height;
    public GameShopAlphabet(int width, int height){

        characters = new GameShopATMSFrame();
//        characters.init();
        this.atms = new GameShopATMS("Alphabet", width, height, new Vector4f[]{new Vector4f(0, 1, 0, 1)});
        this.width = width;
        this.height = height;
     //   this.c = c;

        //this.layer = new GameShopLayer(width, height);
    }

    public void drawCharacter(GameShopATMS dest, String character, Vector2f location){

        //atms.clear();
        GameShopATMSProcessor ap = new GameShopATMSProcessor(atms, characters, 0);
        ap.process(new String[]{character});

        dest.layer.copyLayer(ap.atms.layer, new org.joml.Vector2f(location.x, location.y));
    }

    public void initFrame(){

        characters.frames.add(new GameShopATMSLayer());
    }

    public void initCharacter(String character){
        characters.frames.get(0).layers.add(new GameShopATMSCanvas(character));

    }

    public void initLine(String character){
        characters.frames.get(0).getLayerByName(character).canvas.add(new GameShopATMSArray());
        int length = characters.frames.get(0).getLayerByName(character).canvas.size() - 1;
        if (characters.frames.get(0).getLayerByName(character) != null){
            characters.frames.get(0).getLayerByName(character).canvas.get(length).command = "drawPolyLine";
            //characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(0,0,60,100), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("Point1", new Vector4f(), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("Point2", new Vector4f(), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("Point3", new Vector4f(), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("Point4", new Vector4f(), false));

            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(length).arguments.add(new GameShopATMSMap("Color", new Vector4f(0,0,0,100), false));

        }
    }

    public void drawPolyLine(String character, int num, Vector4f[] currencyLinePoints){

        if (characters.frames.get(0).getLayerByName(character) != null){
            characters.frames.get(0).getLayerByName(character).canvas.get(num).command = "drawPolyLine";
            //characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(0,0,60,100), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("Point1", currencyLinePoints[0], false));
            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("Point2", currencyLinePoints[1], false));
            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("Point3", currencyLinePoints[2], false));
            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("Point4", currencyLinePoints[3], false));

            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName(character).canvas.get(num).arguments.add(new GameShopATMSMap("Color", new Vector4f(0,0,0,100), false));

        }

    }

    public Vector4f getCurrencyLineVector4f(String character, int num, int point){
        
        if (characters.frames.get(0).getLayerByName(character) != null){
            
            if (point == 0) {
               return  characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point1").value;
               // characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point1").value = new Vector4f(p.add(delta));
            }
            else if (point == 1) {
               return  characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point2").value;
                //characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point2").value = new Vector4f(p.add(delta));
            }
            else if (point == 2) {
                return characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point3").value;
                //characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point3").value = new Vector4f(p.add(delta));
            }
            else if (point == 3) {
                return characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point4").value;
                //characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point4").value = new Vector4f(p.add(delta));
            }
        }

        return null;
    }
    public void moveCurrencyLine(String character, int num, int point, Vector4f delta) {

        if (characters.frames.get(0).getLayerByName(character) != null){
            
            if (point == 0) {
                Vector4f p = characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point1").value;
                characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point1").value = new Vector4f(p.add(delta));
            }
            else if (point == 1) {
                Vector4f p = characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point2").value;
                characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point2").value = new Vector4f(p.add(delta));
            }
            else if (point == 2) {
                Vector4f p = characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point3").value;
                characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point3").value = new Vector4f(p.add(delta));
            }
            else if (point == 3) {
                Vector4f p = characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point4").value;
                characters.frames.get(0).getLayerByName(character).canvas.get(num).getArgumentByName("Point4").value = new Vector4f(p.add(delta));
            }
        }
    }
    public void generateCharacters(Vector4f color){

        characters.frames.add(new GameShopATMSLayer());
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("A"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("a"));

        characters.frames.get(0).layers.add(new GameShopATMSCanvas("B"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("b"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("C"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("c"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("D"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("d"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("E"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("e"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("F"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("f"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("G"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("g"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("H"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("h"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("I"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("i"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("J"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("j"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("K"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("k"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("L"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("l"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("M"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("m"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("N"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("n"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("O"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("o"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("P"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("p"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("Q"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("q"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("R"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("r"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("S"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("s"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("T"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("t"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("U"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("u"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("V"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("v"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("W"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("w"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("X"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("x"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("Y"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("y"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("Z"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("z"));

        characters.frames.get(0).layers.add(new GameShopATMSCanvas("0"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("1"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("2"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("3"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("4"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("5"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("6"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("7"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("8"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("9"));

        characters.frames.get(0).layers.add(new GameShopATMSCanvas("("));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas(")"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("`"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("~"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("["));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("]"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("{"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("}"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("-"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("_"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("/"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("?"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("<"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas(">"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas(","));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("."));

        characters.frames.get(0).layers.add(new GameShopATMSCanvas("'"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("\\"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("|"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas("\""));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas(":"));
        characters.frames.get(0).layers.add(new GameShopATMSCanvas(";"));


        if (characters.frames.get(0).getLayerByName("A") != null){

            characters.frames.get(0).getLayerByName("A").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("A").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("A").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("A").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("A").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(0,0,60,100), false));
            characters.frames.get(0).getLayerByName("A").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("A").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("A").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("A").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(40,100,100,0), false));
            characters.frames.get(0).getLayerByName("A").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("A").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("A").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("A").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(20,50,65,50), false));
            characters.frames.get(0).getLayerByName("A").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("A").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));


        }

        if (characters.frames.get(0).getLayerByName("a") != null){

            characters.frames.get(0).getLayerByName("a").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("a").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("a").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("a").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("a").canvas.get(0).command = "drawPolyLine";
            //characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(0,0,60,100), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,40,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(60,50,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(90,50,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(100,20,0,0), false));

            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("a").canvas.get(1).command = "drawPolyLine";
            //characters.frames.get(0).getLayerByName("a").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(0,0,60,100), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,15,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(60,30,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(90,30,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(100,15,0,0), false));


            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            
            characters.frames.get(0).getLayerByName("a").canvas.get(2).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,15,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("Point2", new Vector4f(60,0,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("Point3", new Vector4f(90,0,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("Point4", new Vector4f(100,15,0,0), false));


            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("a").canvas.get(3).command = "drawLine";
            characters.frames.get(0).getLayerByName("a").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,40,95,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("a").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        
        if (characters.frames.get(0).getLayerByName("B") != null){
            
            
            characters.frames.get(0).getLayerByName("B").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("B").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("B").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("B").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("B").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));
        
            characters.frames.get(0).getLayerByName("B").canvas.get(1).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,50,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,50,0,0), false));

            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("B").canvas.get(2).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,50,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,50,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,5,0,0), false));

            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("B").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));
        
        }

          if (characters.frames.get(0).getLayerByName("b") != null){


            characters.frames.get(0).getLayerByName("b").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("b").canvas.add(new GameShopATMSArray());
           
            characters.frames.get(0).getLayerByName("b").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("b").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("b").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("b").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));
 

            characters.frames.get(0).getLayerByName("b").canvas.get(1).command = "drawPolyLine";

            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,50,0,0), false));
            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(45,50,0,0), false));
            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(45,5,0,0), false));
            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,5,0,0), false));

            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("b").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }

          if (characters.frames.get(0).getLayerByName("C") != null){
            
            
            characters.frames.get(0).getLayerByName("C").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("C").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,5,0,0), false));

            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("C").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        
          if (characters.frames.get(0).getLayerByName("c") != null){
            
            
            characters.frames.get(0).getLayerByName("c").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("c").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(95,45,0,0), false));
            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,45,0,0), false));
            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,5,0,0), false));

            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("c").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


        } 
        
        if (characters.frames.get(0).getLayerByName("D") != null){
            
            
            characters.frames.get(0).getLayerByName("D").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("D").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("D").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,5,0,0), false));

            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("D").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("D").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("D").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("D").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("D").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));
 
        }  
         
          if (characters.frames.get(0).getLayerByName("d") != null){


            characters.frames.get(0).getLayerByName("d").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("d").canvas.add(new GameShopATMSArray());
           
            characters.frames.get(0).getLayerByName("d").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("d").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
            characters.frames.get(0).getLayerByName("d").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("d").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));
 

            characters.frames.get(0).getLayerByName("d").canvas.get(1).command = "drawPolyLine";

            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(95,50,0,0), false));
            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(45,50,0,0), false));
            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(45,5,0,0), false));
            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,5,0,0), false));

            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("d").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
          
          if (characters.frames.get(0).getLayerByName("E") != null){
            
            
            characters.frames.get(0).getLayerByName("E").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("E").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("E").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("E").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("E").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("E").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("E").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("E").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("E").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("E").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,95,50), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("E").canvas.get(3).command = "drawLine";
            characters.frames.get(0).getLayerByName("E").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,95), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("E").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }

          if (characters.frames.get(0).getLayerByName("e") != null){


            characters.frames.get(0).getLayerByName("e").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("e").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("e").canvas.get(0).command = "drawPolyLine";

            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(45,45,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,45,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(45,5,0,0), false));

            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("e").canvas.get(1).command = "drawPolyLine";

            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(45,45,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,25,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(45,25,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,30,0,0), false));

            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("e").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
          
            if (characters.frames.get(0).getLayerByName("F") != null){
            
            
            characters.frames.get(0).getLayerByName("F").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("F").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("F").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("E").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("F").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("F").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("F").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("F").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("F").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("F").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,95,50), false));
            characters.frames.get(0).getLayerByName("F").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("F").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("F").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("F").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,95), false));
            characters.frames.get(0).getLayerByName("F").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("F").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }


            if (characters.frames.get(0).getLayerByName("f") != null){
            
            
            characters.frames.get(0).getLayerByName("f").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("f").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("f").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("E").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("f").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("f").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,95), false));
            characters.frames.get(0).getLayerByName("f").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("f").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

//            characters.frames.get(0).getLayerByName("F").canvas.get(1).command = "drawLine";
//            characters.frames.get(0).getLayerByName("F").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
//            characters.frames.get(0).getLayerByName("F").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
//            characters.frames.get(0).getLayerByName("F").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("f").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("f").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(25,50,75,50), false));
            characters.frames.get(0).getLayerByName("f").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("f").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("f").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("f").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,95,75,95), false));
            characters.frames.get(0).getLayerByName("f").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("f").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
            
            if (characters.frames.get(0).getLayerByName("G") != null){
            
            
            characters.frames.get(0).getLayerByName("G").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("G").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("G").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("G").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,5,0,0), false));

            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("G").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("G").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,45), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("G").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("G").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(55,45,95,45), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("G").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
            
            if (characters.frames.get(0).getLayerByName("g") != null){
            
            
            characters.frames.get(0).getLayerByName("g").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("g").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("g").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("g").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("g").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("g").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("g").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,45), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("g").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("g").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(45,45,95,45), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("g").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("g").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(45,5,95,5), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("g").canvas.get(3).command = "drawLine";
            characters.frames.get(0).getLayerByName("g").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(45,25,95,25), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("g").canvas.get(4).command = "drawLine";
            characters.frames.get(0).getLayerByName("g").canvas.get(4).arguments.add(new GameShopATMSMap("Location", new Vector4f(45,25,45,45), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(4).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("g").canvas.get(4).arguments.add(new GameShopATMSMap("Color", color, false));

            }
            
            if (characters.frames.get(0).getLayerByName("H") != null){
            
            
            characters.frames.get(0).getLayerByName("H").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("H").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("H").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("H").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("H").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("H").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("H").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("H").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("H").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,95,50), false));
            characters.frames.get(0).getLayerByName("H").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("H").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("H").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("H").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,95,95,5), false));
            characters.frames.get(0).getLayerByName("H").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("H").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        
            if (characters.frames.get(0).getLayerByName("h") != null){
            
            
            characters.frames.get(0).getLayerByName("h").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("h").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("h").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("h").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("h").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("h").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("h").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("h").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("h").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,95,50), false));
            characters.frames.get(0).getLayerByName("h").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("h").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("h").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("h").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,50,95,5), false));
            characters.frames.get(0).getLayerByName("h").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("h").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }    
            
            if (characters.frames.get(0).getLayerByName("I") != null){
            
            
            characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("I").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("I").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,95), false));
            characters.frames.get(0).getLayerByName("I").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("I").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("I").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("I").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,95), false));
            characters.frames.get(0).getLayerByName("I").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("I").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("I").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("I").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
            characters.frames.get(0).getLayerByName("I").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("I").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }

            if (characters.frames.get(0).getLayerByName("i") != null){
            
            
            characters.frames.get(0).getLayerByName("i").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("i").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("i").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("i").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("i").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,50), false));
            characters.frames.get(0).getLayerByName("i").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("i").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("i").canvas.get(1).command = "drawCircle";
            characters.frames.get(0).getLayerByName("i").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,65,0,0), false));
            characters.frames.get(0).getLayerByName("i").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("i").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

 
        }
            
               if (characters.frames.get(0).getLayerByName("J") != null){
            
            
            characters.frames.get(0).getLayerByName("J").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("J").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("J").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("J").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("J").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
            characters.frames.get(0).getLayerByName("J").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("J").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("J").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("J").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(45,5,95,5), false));
            characters.frames.get(0).getLayerByName("J").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("J").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("J").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("J").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(45,5,45,45), false));
            characters.frames.get(0).getLayerByName("J").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("J").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
               
               if (characters.frames.get(0).getLayerByName("j") != null){
            
            
            characters.frames.get(0).getLayerByName("j").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("j").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("j").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("j").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("i").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("j").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("j").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,50), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("j").canvas.get(1).command = "drawCircle";
            characters.frames.get(0).getLayerByName("j").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,65,0,0), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));
            
            characters.frames.get(0).getLayerByName("j").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("j").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,5,5), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("j").canvas.get(3).command = "drawLine";
            characters.frames.get(0).getLayerByName("j").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,25), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("j").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }

               if (characters.frames.get(0).getLayerByName("K") != null){
            
            
            characters.frames.get(0).getLayerByName("K").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("K").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("K").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("K").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("K").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("K").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("K").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("K").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("K").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,75,100), false));
            characters.frames.get(0).getLayerByName("K").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("K").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("K").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("K").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,75,0), false));
            characters.frames.get(0).getLayerByName("K").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("K").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }

               if (characters.frames.get(0).getLayerByName("k") != null){


            characters.frames.get(0).getLayerByName("k").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("k").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("k").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("k").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("k").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("k").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("k").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("k").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("k").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,50,75), false));
            characters.frames.get(0).getLayerByName("k").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("k").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("k").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("k").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,50,50,0), false));
            characters.frames.get(0).getLayerByName("k").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("k").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }

               if (characters.frames.get(0).getLayerByName("L") != null){
            
            
            characters.frames.get(0).getLayerByName("L").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("L").canvas.add(new GameShopATMSArray());
//            characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("L").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("L").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("L").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("L").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
//            characters.frames.get(0).getLayerByName("I").canvas.get(1).command = "drawLine";
//            characters.frames.get(0).getLayerByName("I").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,95), false));
//            characters.frames.get(0).getLayerByName("I").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
//            characters.frames.get(0).getLayerByName("I").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("L").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("L").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
            characters.frames.get(0).getLayerByName("L").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("L").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
               
               if (characters.frames.get(0).getLayerByName("l") != null){
            
            
            characters.frames.get(0).getLayerByName("l").canvas.add(new GameShopATMSArray());
//            characters.frames.get(0).getLayerByName("l").canvas.add(new GameShopATMSArray());
//            characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

                   characters.frames.get(0).getLayerByName("l").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("l").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("l").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("l").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));



        }
               
               if (characters.frames.get(0).getLayerByName("M") != null){
            
            
            characters.frames.get(0).getLayerByName("M").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("M").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("M").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("M").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("M").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("M").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("M").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("M").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,50,50), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("M").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("M").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,50,95,95), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("M").canvas.get(3).command = "drawLine";
            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }
               
                    if (characters.frames.get(0).getLayerByName("m") != null){
            
            
            characters.frames.get(0).getLayerByName("m").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("m").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("m").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("m").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("m").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("m").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,55), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("m").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("m").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,55,50,20), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("m").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("m").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,20,95,55), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("m").canvas.get(3).command = "drawLine";
            characters.frames.get(0).getLayerByName("m").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,55), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("m").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }

                    

                      if (characters.frames.get(0).getLayerByName("N") != null){
            
            
            characters.frames.get(0).getLayerByName("N").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("N").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("N").canvas.add(new GameShopATMSArray());
           // characters.frames.get(0).getLayerByName("M").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("N").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("N").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("N").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("N").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("N").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("N").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,50,5), false));
            characters.frames.get(0).getLayerByName("N").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("N").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("N").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("N").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,95), false));
            characters.frames.get(0).getLayerByName("N").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("N").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

//            characters.frames.get(0).getLayerByName("M").canvas.get(3).command = "drawLine";
//            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
//            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
//            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }

                      if (characters.frames.get(0).getLayerByName("n") != null){
            
            
            characters.frames.get(0).getLayerByName("n").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("n").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("n").canvas.add(new GameShopATMSArray());
           // characters.frames.get(0).getLayerByName("M").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("n").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("n").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,55), false));
            characters.frames.get(0).getLayerByName("n").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("n").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("n").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("n").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,55,50,5), false));
            characters.frames.get(0).getLayerByName("n").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("n").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("n").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("n").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,55), false));
            characters.frames.get(0).getLayerByName("n").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("n").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

//            characters.frames.get(0).getLayerByName("M").canvas.get(3).command = "drawLine";
//            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
//            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
//            characters.frames.get(0).getLayerByName("M").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

        }
                      
                      if (characters.frames.get(0).getLayerByName("O") != null){
            
            
            characters.frames.get(0).getLayerByName("O").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("O").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("O").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,95,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50,5,0,0), false));

            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

                characters.frames.get(0).getLayerByName("O").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,95,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50,5,0,0), false));

            characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("O").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        
      if (characters.frames.get(0).getLayerByName("o") != null){
            
            
            characters.frames.get(0).getLayerByName("o").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("o").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("o").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,55,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,55,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50,5,0,0), false));

            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

                characters.frames.get(0).getLayerByName("o").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,55,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,55,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50,5,0,0), false));

            characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("o").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
      
       if (characters.frames.get(0).getLayerByName("P") != null){
            
            
            characters.frames.get(0).getLayerByName("P").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("P").canvas.add(new GameShopATMSArray());

           characters.frames.get(0).getLayerByName("P").canvas.get(0).command = "drawLine";
           characters.frames.get(0).getLayerByName("P").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
           characters.frames.get(0).getLayerByName("P").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("P").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
                characters.frames.get(0).getLayerByName("P").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,55,0,0), false));
            characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,55,0,0), false));
            characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,95,0,0), false));

            characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("P").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
       
           if (characters.frames.get(0).getLayerByName("p") != null){
            
            
            characters.frames.get(0).getLayerByName("p").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("p").canvas.add(new GameShopATMSArray());

           characters.frames.get(0).getLayerByName("p").canvas.get(0).command = "drawLine";
           characters.frames.get(0).getLayerByName("p").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,65), false));
           characters.frames.get(0).getLayerByName("p").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("p").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
                characters.frames.get(0).getLayerByName("p").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,35,0,0), false));
            characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,35,0,0), false));
            characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,65,0,0), false));
            characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,65,0,0), false));

            characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("p").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
           
           if (characters.frames.get(0).getLayerByName("Q") != null){
            
            
            characters.frames.get(0).getLayerByName("Q").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("Q").canvas.add(new GameShopATMSArray());

           characters.frames.get(0).getLayerByName("Q").canvas.get(0).command = "drawLine";
           characters.frames.get(0).getLayerByName("Q").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
           characters.frames.get(0).getLayerByName("Q").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("Q").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
                characters.frames.get(0).getLayerByName("Q").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(95,55,0,0), false));
            characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,55,0,0), false));
            characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,95,0,0), false));

            characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Q").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
       
           if (characters.frames.get(0).getLayerByName("q") != null){
            
            
            characters.frames.get(0).getLayerByName("q").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("q").canvas.add(new GameShopATMSArray());

           characters.frames.get(0).getLayerByName("q").canvas.get(0).command = "drawLine";
           characters.frames.get(0).getLayerByName("q").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,65), false));
           characters.frames.get(0).getLayerByName("q").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("q").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
                characters.frames.get(0).getLayerByName("q").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(95,35,0,0), false));
            characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,35,0,0), false));
            characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,65,0,0), false));
            characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,65,0,0), false));

            characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("q").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
           
           if (characters.frames.get(0).getLayerByName("R") != null){
            
            
            characters.frames.get(0).getLayerByName("R").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("R").canvas.add(new GameShopATMSArray());
               characters.frames.get(0).getLayerByName("R").canvas.add(new GameShopATMSArray());


               characters.frames.get(0).getLayerByName("R").canvas.get(0).command = "drawLine";
           characters.frames.get(0).getLayerByName("R").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
           characters.frames.get(0).getLayerByName("R").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("R").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
                characters.frames.get(0).getLayerByName("R").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(5,55,0,0), false));
            characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,55,0,0), false));
            characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,95,0,0), false));

            characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("R").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

               characters.frames.get(0).getLayerByName("R").canvas.get(2).command = "drawLine";
           characters.frames.get(0).getLayerByName("R").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,55,95,5), false));
           characters.frames.get(0).getLayerByName("R").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("R").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
       
           if (characters.frames.get(0).getLayerByName("r") != null){
            
            
            characters.frames.get(0).getLayerByName("r").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("r").canvas.add(new GameShopATMSArray());

           characters.frames.get(0).getLayerByName("r").canvas.get(0).command = "drawLine";
           characters.frames.get(0).getLayerByName("r").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,65), false));
           characters.frames.get(0).getLayerByName("r").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("r").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
             characters.frames.get(0).getLayerByName("r").canvas.get(1).command = "drawLine";
           characters.frames.get(0).getLayerByName("r").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,65,65,65), false));
           characters.frames.get(0).getLayerByName("r").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
           characters.frames.get(0).getLayerByName("r").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
           
            if (characters.frames.get(0).getLayerByName("S") != null){
            
            
            characters.frames.get(0).getLayerByName("S").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("S").canvas.add(new GameShopATMSArray());

            
 
                characters.frames.get(0).getLayerByName("S").canvas.get(0).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,95,0,0), false));

            characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

               characters.frames.get(0).getLayerByName("S").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,5,0,0), false));

            characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("S").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
       
               if (characters.frames.get(0).getLayerByName("s") != null){
            
            
            characters.frames.get(0).getLayerByName("s").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("s").canvas.add(new GameShopATMSArray());

            
 
                characters.frames.get(0).getLayerByName("s").canvas.get(0).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,55,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,75,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(95,75,0,0), false));

            characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

               characters.frames.get(0).getLayerByName("s").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(55,55,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(5,5,0,0), false));

            characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("s").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }

                     if (characters.frames.get(0).getLayerByName("T") != null){


            characters.frames.get(0).getLayerByName("T").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("T").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("T").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("T").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,95), false));
            characters.frames.get(0).getLayerByName("T").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("T").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("T").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("T").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,95), false));
            characters.frames.get(0).getLayerByName("T").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("T").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

 
        }
                     
                                  if (characters.frames.get(0).getLayerByName("t") != null){


            characters.frames.get(0).getLayerByName("t").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("t").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("t").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("t").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,65), false));
            characters.frames.get(0).getLayerByName("t").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("t").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("t").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("t").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(35,55,65,55), false));
            characters.frames.get(0).getLayerByName("t").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("t").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

 
        }

        if (characters.frames.get(0).getLayerByName("U") != null){


            characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("U").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("U").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,95), false));
            characters.frames.get(0).getLayerByName("U").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("U").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("U").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("U").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,95), false));
            characters.frames.get(0).getLayerByName("U").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("U").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("U").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("U").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
            characters.frames.get(0).getLayerByName("U").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("U").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));


        }
        
        if (characters.frames.get(0).getLayerByName("u") != null){


            characters.frames.get(0).getLayerByName("u").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("u").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("u").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("u").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("u").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,5,45), false));
            characters.frames.get(0).getLayerByName("u").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("u").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("u").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("u").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(95,5,95,45), false));
            characters.frames.get(0).getLayerByName("u").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("u").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("u").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("u").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
            characters.frames.get(0).getLayerByName("u").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("u").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));


        }
        
        if (characters.frames.get(0).getLayerByName("V") != null){


            characters.frames.get(0).getLayerByName("V").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("V").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("V").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("V").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,5,95), false));
            characters.frames.get(0).getLayerByName("V").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("V").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("V").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("V").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,95,95), false));
            characters.frames.get(0).getLayerByName("V").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("V").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        
             if (characters.frames.get(0).getLayerByName("v") != null){


            characters.frames.get(0).getLayerByName("v").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("v").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("v").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("v").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,5,50), false));
            characters.frames.get(0).getLayerByName("v").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("v").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("v").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("v").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,95,50), false));
            characters.frames.get(0).getLayerByName("v").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("v").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
             
                if (characters.frames.get(0).getLayerByName("W") != null){


            characters.frames.get(0).getLayerByName("W").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("W").canvas.add(new GameShopATMSArray());

                    characters.frames.get(0).getLayerByName("W").canvas.add(new GameShopATMSArray());
                    characters.frames.get(0).getLayerByName("W").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("W").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("W").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(25,5,5,95), false));
            characters.frames.get(0).getLayerByName("W").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("W").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("W").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("W").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(25,5,50,95), false));
            characters.frames.get(0).getLayerByName("W").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("W").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

                    characters.frames.get(0).getLayerByName("W").canvas.get(2).command = "drawLine";
                    characters.frames.get(0).getLayerByName("W").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,95,75,5), false));
                    characters.frames.get(0).getLayerByName("W").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
                    characters.frames.get(0).getLayerByName("W").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));


                    characters.frames.get(0).getLayerByName("W").canvas.get(3).command = "drawLine";
                    characters.frames.get(0).getLayerByName("W").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(75,5,95,95), false));
                    characters.frames.get(0).getLayerByName("W").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
                    characters.frames.get(0).getLayerByName("W").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

                }
        
           if (characters.frames.get(0).getLayerByName("w") != null){


            characters.frames.get(0).getLayerByName("w").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("w").canvas.add(new GameShopATMSArray());

                    characters.frames.get(0).getLayerByName("w").canvas.add(new GameShopATMSArray());
                    characters.frames.get(0).getLayerByName("w").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("w").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("w").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(25,5,5,45), false));
            characters.frames.get(0).getLayerByName("w").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("w").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("w").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("w").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(25,5,50,45), false));
            characters.frames.get(0).getLayerByName("w").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("w").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

                    characters.frames.get(0).getLayerByName("w").canvas.get(2).command = "drawLine";
                    characters.frames.get(0).getLayerByName("w").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,45,75,5), false));
                    characters.frames.get(0).getLayerByName("w").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
                    characters.frames.get(0).getLayerByName("w").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));


                    characters.frames.get(0).getLayerByName("w").canvas.get(3).command = "drawLine";
                    characters.frames.get(0).getLayerByName("w").canvas.get(3).arguments.add(new GameShopATMSMap("Location", new Vector4f(75,5,95,45), false));
                    characters.frames.get(0).getLayerByName("w").canvas.get(3).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
                    characters.frames.get(0).getLayerByName("w").canvas.get(3).arguments.add(new GameShopATMSMap("Color", color, false));

                }
           
            if (characters.frames.get(0).getLayerByName("X") != null){


            characters.frames.get(0).getLayerByName("X").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("X").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("X").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("X").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,95), false));
            characters.frames.get(0).getLayerByName("X").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("X").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("X").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("X").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,5), false));
            characters.frames.get(0).getLayerByName("X").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("X").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        

            if (characters.frames.get(0).getLayerByName("x") != null){


            characters.frames.get(0).getLayerByName("x").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("x").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("U").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("x").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("x").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,45,45), false));
            characters.frames.get(0).getLayerByName("x").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("x").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("x").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("x").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,45,45,5), false));
            characters.frames.get(0).getLayerByName("x").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("x").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

        }
            
                if (characters.frames.get(0).getLayerByName("Y") != null){


            characters.frames.get(0).getLayerByName("Y").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("Y").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("Y").canvas.add(new GameShopATMSArray());
            //characters.frames.get(0).getLayerByName("I").canvas.add(new GameShopATMSArray());

            characters.frames.get(0).getLayerByName("Y").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("Y").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,50,95,95), false));
            characters.frames.get(0).getLayerByName("Y").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Y").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("Y").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("Y").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,50,5,95), false));
            characters.frames.get(0).getLayerByName("Y").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Y").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("Y").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("Y").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(50,5,50,50), false));
            characters.frames.get(0).getLayerByName("Y").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Y").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
        

            if (characters.frames.get(0).getLayerByName("y") != null){


            characters.frames.get(0).getLayerByName("y").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("y").canvas.add(new GameShopATMSArray());
 
            characters.frames.get(0).getLayerByName("y").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("y").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,45,45), false));
            characters.frames.get(0).getLayerByName("y").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("y").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));


            characters.frames.get(0).getLayerByName("y").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("y").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,45,25,25), false));
            characters.frames.get(0).getLayerByName("y").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("y").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

 
        }
            
                if (characters.frames.get(0).getLayerByName("Z") != null){
            
            
            characters.frames.get(0).getLayerByName("Z").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("Z").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("Z").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("Z").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("Z").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,95), false));
            characters.frames.get(0).getLayerByName("Z").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Z").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("Z").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("Z").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,95,95,95), false));
            characters.frames.get(0).getLayerByName("Z").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Z").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("Z").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("Z").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,95,5), false));
            characters.frames.get(0).getLayerByName("Z").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("Z").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
                
           if (characters.frames.get(0).getLayerByName("z") != null){
            
            
            characters.frames.get(0).getLayerByName("z").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("z").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("z").canvas.add(new GameShopATMSArray());
            
            characters.frames.get(0).getLayerByName("z").canvas.get(0).command = "drawLine";
            characters.frames.get(0).getLayerByName("z").canvas.get(0).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,45,45), false));
            characters.frames.get(0).getLayerByName("z").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("z").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

 
            characters.frames.get(0).getLayerByName("z").canvas.get(1).command = "drawLine";
            characters.frames.get(0).getLayerByName("z").canvas.get(1).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,45,45,45), false));
            characters.frames.get(0).getLayerByName("z").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("z").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

            characters.frames.get(0).getLayerByName("z").canvas.get(2).command = "drawLine";
            characters.frames.get(0).getLayerByName("z").canvas.get(2).arguments.add(new GameShopATMSMap("Location", new Vector4f(5,5,45,5), false));
            characters.frames.get(0).getLayerByName("z").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("z").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        }
           
               if (characters.frames.get(0).getLayerByName("0") != null){
            
            
            characters.frames.get(0).getLayerByName("0").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("0").canvas.add(new GameShopATMSArray());
            characters.frames.get(0).getLayerByName("0").canvas.add(new GameShopATMSArray());


            characters.frames.get(0).getLayerByName("0").canvas.get(0).command = "drawPolyLine";
            
            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,95,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("Point2", new Vector4f(5,95,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("Point3", new Vector4f(5,5,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50,5,0,0), false));

            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(0).arguments.add(new GameShopATMSMap("Color", color, false));

                characters.frames.get(0).getLayerByName("0").canvas.get(1).command = "drawPolyLine";


                characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50,95,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95,95,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95,5,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50,5,0,0), false));

            characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50,0,0,0), true));
            characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5,0,0,0), false));
            characters.frames.get(0).getLayerByName("0").canvas.get(1).arguments.add(new GameShopATMSMap("Color", color, false));

                   characters.frames.get(0).getLayerByName("0").canvas.get(2).command = "drawPolyLine";

                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("Point1", new Vector4f(50, 95, 0, 0), false));
                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("Point2", new Vector4f(95, 95, 0, 0), false));
                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("Point3", new Vector4f(95, 5, 0, 0), false));
                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("Point4", new Vector4f(50, 5, 0, 0), false));

                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("NumPoints", new Vector4f(50, 0, 0, 0), true));
                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("Radius", new Vector4f(5, 0, 0, 0), false));
                   characters.frames.get(0).getLayerByName("0").canvas.get(2).arguments.add(new GameShopATMSMap("Color", color, false));

        } 


    }
}

