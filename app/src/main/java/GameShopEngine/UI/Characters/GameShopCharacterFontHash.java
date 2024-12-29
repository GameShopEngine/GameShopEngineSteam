/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.UI.Characters;

import GameShopEngine.LanguageProcessor.GameShopLanguageProcessor;
import java.util.HashMap;
import java.util.Map;
import org.joml.Vector2f;

/**
 *
 * @author lynden
 */
public class GameShopCharacterFontHash {
    
    private static GameShopCharacterFontHash _instance;
    
    public HashMap<String, HashMap<Character, GameShopLanguageProcessor[]>> drawCalls;
    
    private GameShopCharacterFontHash(){
    
        drawCalls = new HashMap<>();
    }
    
    public static GameShopCharacterFontHash getInstance(){
    
        if (_instance == null){
        
            _instance = new GameShopCharacterFontHash();
        }
        
        return _instance;
        
    }
    
    public void addGameShopCharacterFont(String font, char c, GameShopLanguageProcessor[] gslp){
    
        HashMap <Character, GameShopLanguageProcessor[]> characterValue = new HashMap<>();
        characterValue.put(c, gslp);
        if (!drawCalls.isEmpty()){
        for (Map.Entry<Character, GameShopLanguageProcessor[]> cv: drawCalls.get(font).entrySet()){
        
            characterValue.put(cv.getKey(), cv.getValue());
        }
        }
        drawCalls.put(font, characterValue);
        
        System.out.println(drawCalls);
//        if (drawCalls.isEmpty()){
//            System.out.println("EMPTY");
//             drawCalls.put(font, characterValue);
//             
//        } else if(!(drawCalls.get(font).containsKey(c))) {
//        
//        
//        drawCalls.put(font, characterValue);
//        
//        }
        
//        else if (!drawCalls.get(font).containsKey(c)){
//        characterValue.put(c, gslp);
//        
//       // characterValue.putAll(drawCalls.get(font));
//         
//      
//        drawCalls.put(font, characterValue);
//        }
        
    }
    
    public GameShopLanguageProcessor[] retGSLP(String font, char c){
    
        return drawCalls.get(font).get(c);
    }
    public void createFontStandard(){
    
       GameShopLanguageProcessor[] drawGSLP = new GameShopLanguageProcessor[3];
       drawGSLP[0] = new GameShopLanguageProcessor("drawLine((" + "${gsc.position.x}"+ ","  + "${gsc.position.y}"+")" + "," + "("+ "${gsc.position.x + ((fontSize/2) + 5)}"+ "," + "${gsc.position.y + fontSize}"+ ")" + "," + "${fontSize/8}"+ "," + "(" +"${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}"+ ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");
       drawGSLP[1] = new GameShopLanguageProcessor("drawLine((" + "${gsc.position.x + (((fontSize)/2) - 5)}"+ ","  + "${gsc.position.y + fontSize}"+")" + "," + "("+ "${gsc.position.x + ((fontSize))}"+ "," + "${gsc.position.y}"+ ")" + "," + "${fontSize/8}"+ "," + "(" +"${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}"+ ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");
       drawGSLP[2] = new GameShopLanguageProcessor("drawLine((" + "${gsc.position.x + (((fontSize)/4) + 1)}" + ","  + "${gsc.position.y + ((fontSize * 2)/5)}" + ")" + "," + "(" + "${gsc.position.x + ((fontSize * 3)/5)}" + "," + "${gsc.position.y + ((fontSize * 2)/5)}" + ")" + ","+ "${fontSize/8}"+ "," + "(" +"${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}"+ ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");
        
       addGameShopCharacterFont("Standard", 'A', drawGSLP);
     
        
       GameShopLanguageProcessor[] drawGSLP_B = new GameShopLanguageProcessor[3];

       drawGSLP_B[0] = new GameShopLanguageProcessor("drawLine((" + "${gsc.position.x}" + ","  + "${gsc.position.y + fontSize}" + ")" + "," + "(" + "${gsc.position.x}" + "," + "${gsc.position.y}"+ ")" + "," + "${fontSize / 8}" + "," + "(" + "${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}" + ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");
       drawGSLP_B[1] =  new GameShopLanguageProcessor("drawPolyLine((" + "${gsc.position.x}" + ","  + "${gsc.position.y + fontSize}" + ",${0})" + ",(" + "${gsc.position.x + fontSize/2}" + ","  + "${gsc.position.y + fontSize}" + ",${0})" + ",(" + "${gsc.position.x + fontSize/2}" + ","  + "${gsc.position.y + fontSize/2}" + ",${0})"  + ",(" + "${gsc.position.x}" + ","  + "${gsc.position.y + fontSize/2}" + ",${0})" + "," + "${fontSize/8}" + "," + "(" + "${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}" + ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");
       drawGSLP_B[2] = new GameShopLanguageProcessor("drawPolyLine((" + "${gsc.position.x}" + ","  + "${gsc.position.y + fontSize/2}" + ",${0})" + ",(" + "${gsc.position.x + fontSize/2}" + ","  + "${gsc.position.y + fontSize/2}" + ",${0})" + ",(" + "${gsc.position.x + fontSize/2}" + ","  + "${gsc.position.y}" + ",${0})"  + ",(" + "${gsc.position.x}" + ","  + "${gsc.position.y}" + ",${0})" + "," + "${fontSize/8}"  + "," + "(" + "${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}" + ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");

       addGameShopCharacterFont("Standard", 'B', drawGSLP_B);
       
       GameShopLanguageProcessor[] drawGSLP_C = new GameShopLanguageProcessor[1];
       
       drawGSLP_C[0] = new GameShopLanguageProcessor("drawPolyLine((" + "${gsc.position.x + fontSize/2}" + "," + "${gsc.position.y}" + ",${0})" + ",(" + "${gsc.position.x}" + "," + "${gsc.position.y}" + ",${0})" + ",(" + "${gsc.position.x}" + "," + "${gsc.position.y + fontSize}" + ",${0})" + ",(" + "${gsc.position.x + fontSize/2}" + "," + "${gsc.position.y + fontSize}" + ",${0})" + "," + "${fontSize/8}"  + "," + "(" + "${gsc.uic.textColor.x}" + "," +  "${gsc.uic.textColor.y}" + ","+ "${gsc.uic.textColor.z}" + "," + "${gsc.uic.textColor.w}" + ")" + ")");
       
       addGameShopCharacterFont("Standard", 'C', drawGSLP_C);
         
    }
}
