/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.UI.WordProcessor;

import GameShopEngine.LanguageProcessor.GameShopLanguageProcessor;
import GameShopEngine.UI.Characters.AlphaNumeric.GameShopCharacterUpperCaseA;
import GameShopEngine.UI.Characters.AlphaNumeric.GameShopCharacterUpperCaseB;
import GameShopEngine.UI.Characters.GameShopCharacter;
import GameShopEngine.UI.Components.GameShopUIComponent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lynden
 */
public class GameShopWordProcessor {
    
    public String word;
    public GameShopUIComponent uic;
    public GameShopCharacter[] gsc;
    public float fontSize;
    
    
    public GameShopWordProcessor(String word, float fontSize, GameShopUIComponent uic){
    
        this.word = word;
        this.uic = uic;
        this.gsc = new GameShopCharacter[1];
        this.fontSize = fontSize;
    }
    
    public void process(){
    
        ArrayList<GameShopCharacter> gsch = new ArrayList<GameShopCharacter>();
        
        //int i = 0;
        //this.gsc = new GameShopCharacter[this.word.toCharArray().length];
        for (int c = 0; c < this.word.length(); c++){
        
            System.out.println(this.word.charAt(c));
           
            if (this.word.charAt(c) == 'A'){
            
                if (c == 0){
            System.out.println("IN");
                this.uic.gscc.setStartPosition(new GameShopCharacterUpperCaseA("", fontSize, 'A', uic.gscc));
            }
                gsch.add(new GameShopCharacterUpperCaseA("", fontSize, 'A', uic.gscc));
               // this.addGameShopCharacters(gsc.length - 1, new GameShopCharacterUpperCaseA[]{ new GameShopCharacterUpperCaseA("", fontSize, 'A', uic.gscc)});
            } 
            else if (this.word.charAt(c) == 'B') {
             
                if (c == 0){
            System.out.println("IN");
                this.uic.gscc.setStartPosition(new GameShopCharacterUpperCaseB("", fontSize, 'B', uic.gscc));
            }
                gsch.add(new GameShopCharacterUpperCaseB("", fontSize, 'B', uic.gscc));
               // this.addGameShopCharacters(gsc.length - 1, new GameShopCharacterUpperCaseB[]{ new GameShopCharacterUpperCaseB("", fontSize, 'B', uic.gscc)});
           
            }
            
            
//            c++;
            System.out.println("DONE");
        }
        
         
            this.addGameShopCharacters(gsc.length - 1, (gsch.toArray((GameShopCharacter[]) new GameShopCharacter[0])));
           
        
        for (GameShopCharacter c: this.gsc){
        
            c.drawCharacter();
        }
//          for (int c = 0; c < this.word.length(); c++){
//         
//          }
    }
    
    public void addGameShopCharacters(int index, GameShopCharacter[] gsc){
    
       // public void addDrawCalls(int index, String[] drawCalls){

        boolean start = this.gsc[0] != null;

        ArrayList<GameShopCharacter> newGSRs = new ArrayList<>(Arrays.asList(gsc));

        ArrayList<GameShopCharacter> oldGSRs = null;

        if (start) {
            oldGSRs = new ArrayList<>(Arrays.asList(this.gsc));
        }

        ArrayList<GameShopCharacter> lowerGSRs = new ArrayList<>();

        ArrayList<GameShopCharacter> higherGSRs = new ArrayList<>();

        if (start) {
            for (int i = 0; i < index; i++) {
                lowerGSRs.add(oldGSRs.get(i));
            }

            for (int i = index; i < oldGSRs.size(); i++) {
                higherGSRs.add(oldGSRs.get(i));
            }
            this.gsc = new GameShopCharacter[(oldGSRs.size()) + (newGSRs.size())];

        } else {
            this.gsc = new GameShopCharacter[newGSRs.size()];
        }



        int i = 0;
        if (start) {
            for (GameShopCharacter dc : lowerGSRs) {


                this.gsc[i] = dc;
                i++;
            }
        }
//        System.out.println(Arrays.toString(oldDrawCalls.toArray()));
  //      System.out.println(Arrays.toString(newDrawCalls.toArray()));

        for (GameShopCharacter dc: newGSRs){

            this.gsc[i] = dc;
            i++;
        }

        if (start) {
            for (GameShopCharacter dc : higherGSRs) {

                this.gsc[i] = dc;
                i++;
            }
        }
        //newDrawCalls.addAll(index, drawCalls);
        //        String[] temp = new String[this.drawCalls.length];
//
//        int i = 0;
//        for (String dc: this.drawCalls){
//
//            temp[i] = dc;
//            i++;
//        }
//
//        this.drawCalls = new String[(this.drawCalls.length) + drawCalls.length];
//
//        System.out.println("dc " + this.drawCalls.length);
////        i = 0;
////        int j = 0;
//
//        for (i = 0; i < index; i++){
//
//            this.drawCalls[i] = temp[i];
//        }
//
//        for (i = index; i < index + drawCalls.length; i++){
//
//            this.drawCalls[i] = drawCalls[i - index];
//        }
//
//        for (i = index + drawCalls.length; i < this.drawCalls.length; i++){
//
//            this.drawCalls[i] = temp[i - (drawCalls.length)];
//        }

   // }
    }
}
