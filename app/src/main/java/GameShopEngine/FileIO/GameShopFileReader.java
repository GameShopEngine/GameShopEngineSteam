/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.FileIO;

import GameShopEngine.App;
import GameShopEngine.Format.ATMS.GameShopATMSFrame;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopFileReader<T> {
    
    public T toObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        T obj = (T) objectStream.readObject();
        objectStream.close();
        return obj;
    }
    
    public T read(String filename){
    
        T characters = null;
                
                try (FileInputStream fis = new FileInputStream(filename)){
                
                    byte[] byteArray = fis.readAllBytes();
                    characters = toObject(byteArray);
                } catch (IOException e) {
                
                    e.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                
                    System.out.println(characters);
                }
                
                return characters;
 
    }
    
    public String readTextFromAssets(String filename){
    
        return readText(getAssets().getAbsolutePath() + filename);
       
        
        
    }
    
    public String readText(String filename){
    
        File textFile = new File(filename);
       // System.out.println(textFile);
        String text = "";
        
        Scanner scanner;
        try {
            scanner = new Scanner(textFile);
            while (scanner.hasNextLine()) {
                text += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameShopFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println(text);
        return text;
    }
    
    public T readFromAssets(String filename){
    
        
        return read(getAssets().getAbsolutePath() + filename);
    }
    
    public File getAssets(){
    
        
        File userDir = new File(System.getProperty("user.dir"));
        File assetsFolder = new File(userDir.getParent() + "/assets");
        
        return assetsFolder;
    }
}
