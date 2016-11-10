package client.util;

import client.gameObject.GameObjects;
import client.keyObject.KeyObject;
import commonObjects.DataObjects;
import commonObjects.KeyEventObjects;
import commonObjects.eventManager.EventObjects;
import processing.core.PApplet;

/**
 * Created by Shais Shaikh on 10/19/2016.
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



    public static GameObjects dataToGameObject(DataObjects dataObjects) {

        GameObjects obj = new GameObjects();
        obj.Name = dataObjects.Name;
        obj.strokeColor = dataObjects.strokeColor;
        obj.fillColor = dataObjects.fillColor;
        obj.shape = dataObjects.shape;
        obj.position = dataObjects.position;
        obj.width = dataObjects.width;
        obj.height = dataObjects.height;
        return  obj;
    }


    public static KeyEventObjects keyToEventObject(KeyObject kObject) {

        KeyEventObjects obj = new KeyEventObjects();
        obj.keyName = kObject.Name;
        obj.timeStamp = kObject.timeStamp;
        return  obj;
    }


    public static EventObjects key2EventObject(KeyEventObjects kObject) {

        EventObjects obj = new EventObjects("KEY", kObject.timeStamp.getTime() ,kObject);

        return  obj;
    }


}
