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
public class GameShopATMSCanvas implements Serializable {
    
    public String name;
    public ArrayList<GameShopATMSArray> canvas;


    public GameShopATMSCanvas(String name) {

        this.name = name;
        this.canvas = new ArrayList<>();

    }
}
