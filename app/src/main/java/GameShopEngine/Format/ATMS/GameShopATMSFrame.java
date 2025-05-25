/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.Format.ATMS;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopATMSFrame implements Serializable {
    
    public ArrayList<GameShopATMSLayer> frames;

  

    public GameShopATMSFrame() {
        frames = new ArrayList<>();
    }
    
    @Override
    public String toString(){
    
        String output = "";
        
        for (GameShopATMSLayer layer: frames){
        
            for (GameShopATMSCanvas canvas : layer.layers){
            
                output += canvas.name + " ";
                
                for (GameShopATMSArray array: canvas.canvas){
                
                    output+= array.command + " ";
                    
                    for (GameShopATMSMap map : array.arguments){
                    
                        output+= map.argument + " " + map.value + " " + map.whole + " ";
                    }
                }
            }
        }
        
        return output;
    }
}
