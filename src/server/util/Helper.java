package server.util;

import commonObjects.DataObjects;
import commonObjects.KeyEventObjects;
import commonObjects.eventManager.EventObjects;
import processing.core.PApplet;
import processing.core.PVector;
import server.gameObject.GameObjects;
import server.keyObject.KeyObjects;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class Helper {


    public static int findShape(String s){

        switch (s) {
            case "CIRCLE":
                return PApplet.ELLIPSE;
            case "RECTANGLE":
                return PApplet.RECT;
            default:
                return Integer.parseInt(null);
        }
    }



    public static DataObjects gameToDataObject(GameObjects gameObjects) {

        DataObjects obj = new DataObjects();
        obj.Name = gameObjects.Name;
        obj.strokeColor = gameObjects.strokeColor;
        obj.fillColor = gameObjects.fillColor;
        obj.shape = gameObjects.shape;
        obj.position = new PVector(gameObjects.position.x, gameObjects.position.y);
        obj.width = gameObjects.width;
        obj.height = gameObjects.height;
        return  obj;
    }


    public static KeyObjects eventToKeyObject(KeyEventObjects kObject) {

        KeyObjects obj = new KeyObjects();
        obj.Name = kObject.keyName;
        obj.timeStamp = kObject.timeStamp;
        System.out.println("Helper.eventToKeyObject " + obj.Name);
        return  obj;
    }

    public static int keyToValue(String name) {

        switch (name) {
            case "left":
                return -10;
            case "right":
                return +10;
            case "up":
                return -30;
            default:
                return Integer.parseInt(null);
        }
    }



}
