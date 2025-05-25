/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.Format.ATMS;

import com.jme3.math.Vector4f;
import java.io.Serializable;

/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopATMSMap implements Serializable {
    
    public String argument;
    public boolean whole; //whole or percentage
    public Vector4f value;
    
    public GameShopATMSMap(String argument, Vector4f value, boolean whole){
        this.argument = argument;
        this.value = value;
        this.whole = whole;
    }
    
}
