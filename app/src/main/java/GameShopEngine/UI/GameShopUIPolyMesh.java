/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.UI;

import GameShopEngine.GameShopATMS;
import GameShopEngine.GameShopPolyMesh;
import GameShopEngine.GameShopPolySurface;

/**
 *
 * @author lynden
 */
public class GameShopUIPolyMesh extends GameShopPolyMesh {
    
    public GameShopUIATMS uiATMS;
    
    public GameShopUIPolyMesh(GameShopPolySurface[] gspSurfaces, GameShopUIATMS uiATMS) {
        super(gspSurfaces, uiATMS);
        this.uiATMS = uiATMS;
    }
    
}
