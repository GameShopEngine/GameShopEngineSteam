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
public class GameShopATMSArray implements Serializable {
    
    
    public String command;
    public ArrayList<GameShopATMSMap> arguments;

    public GameShopATMSArray() {

        arguments = new ArrayList<>();
    }

     

    public GameShopATMSMap getArgumentByName(String name) {

        for (GameShopATMSMap am : arguments) {

            if (am.argument.equals(name)) {

                return am;
            }
        }
        return null;
    }
}
