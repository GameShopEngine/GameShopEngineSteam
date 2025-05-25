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
public class GameShopATMSLayer implements Serializable {
    
    public ArrayList<GameShopATMSCanvas> layers;

    public GameShopATMSLayer() {
        layers = new ArrayList<>();
    }

    public GameShopATMSCanvas getLayerByName(String name) {
        for (GameShopATMSCanvas ac : layers) {

            if (ac.name.equals(name)) {

                return ac;
            }
        }

        return null;
    }
}
