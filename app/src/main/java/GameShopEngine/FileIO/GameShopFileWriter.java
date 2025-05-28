/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.FileIO;

import GameShopEngine.Format.ATMS.GameShopATMSFrame;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopFileWriter<T> {
    
    public GameShopFileWriter(){
    
    }
    
    public byte[] toByteArray(T obj) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
        objectStream.writeObject(obj);
        objectStream.close();
        return byteStream.toByteArray();
    }
    
    public void write(String filename, T obj){
    
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(toByteArray(obj));
            // Write data to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeText(String filename, String text){
    
        try {
            PrintWriter printer = new PrintWriter(filename);
            Scanner scanner = new Scanner(text);
            while (scanner.hasNextLine()){
            
                printer.println(scanner.nextLine() + "\n");
            }
            scanner.close();
            printer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameShopFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
