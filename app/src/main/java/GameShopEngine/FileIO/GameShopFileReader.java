/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.FileIO;

import GameShopEngine.App;
import GameShopEngine.Format.ATMS.GameShopATMSFrame;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
}
