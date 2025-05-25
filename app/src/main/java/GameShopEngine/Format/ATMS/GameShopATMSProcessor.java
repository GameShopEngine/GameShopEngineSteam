/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.Format.ATMS;

import GameShopEngine.GameShopATMS;
import GameShopEngine.GameShopPolyLine;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

/**
 *
 * @author jmonkeygamesinc
 */
public class GameShopATMSProcessor {
    
    public GameShopATMSFrame frames;
    public GameShopATMS atms;

    int currentFrame;

    public GameShopATMSProcessor(GameShopATMS atms, GameShopATMSFrame frames, int startingFrame) {

        this.atms = atms;
        this.frames = new GameShopATMSFrame();
        this.frames = frames;
        this.currentFrame = startingFrame;
    }

    public void process(String[] layers) {

        //atms.clear(ColorRGBA.fromRGBA255(0, 0, 0, 0));

        boolean draw = false;

        for (GameShopATMSCanvas ac : frames.frames.get(currentFrame).layers) {
            draw = false;
            //if (Arrays.stream(layers).anyMatch())
            for (String s : layers) {
                if (s.equals(ac.name)) {
                    draw = true;
                    break;
                }
            }

            if (draw) {
                for (GameShopATMSArray i : ac.canvas) {
                    if (i.command.equals("drawCircle") || i.command.equals("drawSquare")) {
                        Vector4f location = new Vector4f();
                        Vector4f radius = new Vector4f();
                        Vector4f color = new Vector4f();
                        for (GameShopATMSMap map : i.arguments) {
                            if (map.argument.equals("Location")) {
                                if (map.whole) {
                                    location = new Vector4f(map.value);
                                } else {
                                    location = new Vector4f(((map.value.x / 100) * (float) atms.width), ((map.value.y / 100) * (float) atms.height), 0, 0);
                                }
                            } else if (map.argument.equals("Radius")) {
                                if (map.whole) {
                                    radius = new Vector4f(map.value);
                                } else {
                                    radius = new Vector4f(((map.value.x / 100) * (atms.width + atms.height) / 2), 0, 0, 0);
                                }
                            } else if (map.argument.equals("Color")) {
                                if (map.whole) {
                                    color = new Vector4f(map.value);
                                } else {
                                    color = new Vector4f(map.value).mult(2.55f);
                                }
                            }
                        }

                        if (i.command.equals("drawCircle")) {
                            atms.layer.drawCircle((int) (location.x), (int) (location.y), (int) (radius.x), ColorRGBA.fromRGBA255((int) color.x, (int) color.y, (int) color.z, (int) color.w));
                        }
                        if (i.command.equals("drawSquare")) {
                            atms.layer.drawSquare((int) (location.x), (int) (location.y), (int) (radius.x), ColorRGBA.fromRGBA255((int) color.x, (int) color.y, (int) color.z, (int) color.w));
                        }

                    }
                    if (i.command.equals("drawLine")) {
                        Vector4f location = new Vector4f();
                        Vector4f radius = new Vector4f();
                        Vector4f color = new Vector4f();
                        for (GameShopATMSMap map : i.arguments) {
                            if (map.argument.equals("Location")) {
                                if (map.whole) {
                                    location = new Vector4f(map.value);
                                } else {
                                    location = new Vector4f(((map.value.x / 100) * (float) atms.width), ((map.value.y / 100) * (float) atms.height), ((map.value.z / 100) * (float) atms.width), ((map.value.w / 100) * (float) atms.height));
                                }
                            } else if (map.argument.equals("Radius")) {
                                if (map.whole) {
                                    radius = new Vector4f(map.value);
                                } else {
                                    radius = new Vector4f(((map.value.x / 100) * (atms.width + atms.height) / 2), 0, 0, 0);
                                }
                            } else if (map.argument.equals("Color")) {
                                if (map.whole) {
                                    color = new Vector4f(map.value);
                                } else {
                                    color = new Vector4f(map.value).mult(2.55f);
                                }
                            }
                        }

                        atms.layer.drawLine(new org.joml.Vector2f(location.x, location.y), new org.joml.Vector2f(location.z, location.w), (short) radius.x, ColorRGBA.fromRGBA255((int) color.x, (int) color.y, (int) color.z, (int) color.w));

                    }

                    if (i.command.equals("drawPolyLine")) {
                        //Vector4f location = new Vector4f();
                        Vector4f point1 = new Vector4f();
                        Vector4f point2 = new Vector4f();
                        Vector4f point3 = new Vector4f();
                        Vector4f point4 = new Vector4f();
                        Vector4f radius = new Vector4f();
                        Vector4f color = new Vector4f();
                        Vector4f numPoints = new Vector4f();
                        for (GameShopATMSMap map : i.arguments) {
                            if (map.argument.equals("Point1")) {
                                if (map.whole) {
                                    point1 = new Vector4f(map.value);
                                } else {
                                    point1 = new Vector4f(((map.value.x / 100) * (float) atms.width), ((map.value.y / 100) * (float) atms.height), ((map.value.z / 100) * (float) atms.width), ((map.value.w / 100) * (float) atms.height));
                                }
                            } else if (map.argument.equals("Point2")) {
                                if (map.whole) {
                                    point2 = new Vector4f(map.value);
                                } else {
                                    point2 = new Vector4f(((map.value.x / 100) * (float) atms.width), ((map.value.y / 100) * (float) atms.height), ((map.value.z / 100) * (float) atms.width), ((map.value.w / 100) * (float) atms.height));
                                }
                            } else if (map.argument.equals("Point3")) {
                                if (map.whole) {
                                    point3 = new Vector4f(map.value);
                                } else {
                                    point3 = new Vector4f(((map.value.x / 100) * (float) atms.width), ((map.value.y / 100) * (float) atms.height), ((map.value.z / 100) * (float) atms.width), ((map.value.w / 100) * (float) atms.height));
                                }
                            } else if (map.argument.equals("Point4")) {
                                if (map.whole) {
                                    point4 = new Vector4f(map.value);
                                } else {
                                    point4 = new Vector4f(((map.value.x / 100) * (float) atms.width), ((map.value.y / 100) * (float) atms.height), ((map.value.z / 100) * (float) atms.width), ((map.value.w / 100) * (float) atms.height));
                                }
                            } else if (map.argument.equals("Radius")) {
                                if (map.whole) {
                                    radius = new Vector4f(map.value);
                                } else {
                                    radius = new Vector4f(((map.value.x / 100) * (atms.width + atms.height) / 2), 0, 0, 0);
                                }
                            } else if (map.argument.equals("Color")) {
                                if (map.whole) {
                                    color = new Vector4f(map.value);
                                } else {
                                    color = new Vector4f(map.value).mult(2.55f);
                                }
                            } else if (map.argument.equals("NumPoints")) {
                                if (map.whole) {
                                    numPoints = new Vector4f(map.value);
                                } else {
                                    numPoints = new Vector4f(((map.value.x / 100) * atms.width), 0, 0, 0);
                                }
                            }
                        }

                        atms.layer.drawPolyLine(new GameShopPolyLine(new Vector3f[]{new Vector3f(point1.x, point1.y, 0f), new Vector3f(point2.x, point2.y, 0f), new Vector3f(point3.x, point3.y, 0f), new Vector3f(point4.x, point4.y, 0f)}, (int) numPoints.x), (short) radius.x, ColorRGBA.fromRGBA255((int) color.x, (int) color.y, (int) color.z, (int) color.w));
                    }
                }
            }
        }
    }
}
