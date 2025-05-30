/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.GameShopUI.WordProcessor;

import GameShopEngine.GameShopATMS;
import GameShopEngine.GameShopUI.Widgets.GameShopAlphabet;
import com.jme3.math.Vector2f;

/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopWordProcessor {
  
    public Vector2f cursor;
    public Vector2f location;
    public int width;
    public int height;

    public String word;

    public GameShopAlphabet alphabet;
    public GameShopATMS dest;

    public GameShopWordProcessor(String word, GameShopAlphabet alphabet, GameShopATMS dest, Vector2f location, Vector2f cursor, int width, int height) {

        this.word = word;
        this.alphabet = alphabet;
        this.cursor = cursor;
        this.location = location;
        this.width = width;
        this.height = height;
        this.dest = dest;
        processWord();

    }

    public void processWord() {

        for (char c : word.toCharArray()) {

            alphabet.drawCharacter(dest, String.valueOf(c), location.add(cursor));
            cursor = cursor.add(new Vector2f(alphabet.width, 0));

        }
    }
}
