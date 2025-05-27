/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.FileIO;

import GameShopEngine.Format.ATMS.GameShopATMSFrame;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
}
