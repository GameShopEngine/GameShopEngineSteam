/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.FileIO;

import GameShopEngine.Format.ATMS.GameShopATMSFrame;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
}
