package client.unpacker;

import client.gameObject.GameObjects;
import client.util.Helper;
import commonObjects.DataObjects;
import processing.core.PApplet;
import processing.core.PShape;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class Unpacker {


    private static ConcurrentLinkedQueue<GameObjects> renderableObjects;
    private PApplet parent;
    private static ConcurrentLinkedQueue<DataObjects> dObjList = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<PShape> toDraw = new ConcurrentLinkedQueue<>();

    public Unpacker(PApplet parent) {
        this.parent= parent;
    }

    public static void unpack(ConcurrentLinkedQueue q){

        renderableObjects = new ConcurrentLinkedQueue<>();
         for(Object d: q) {
            dObjList.add((DataObjects) d);
        }

        for (DataObjects dObj: dObjList) {

            GameObjects obj = Helper.dataToGameObject(dObj);
            renderableObjects.add(obj);
        }
        dObjList.clear();
    }

    public void create() {

        for (GameObjects obj : renderableObjects) {

            PShape dummy = parent.createShape(PApplet.GROUP);
            parent.stroke(obj.strokeColor[0], obj.strokeColor[1], obj.strokeColor[2]);
            parent.fill(obj.fillColor[0], obj.fillColor[1], obj.fillColor[2]);

            PShape temp = parent.createShape(Helper.findShape(obj.shape), obj.position.x, obj.position.y, obj.width, obj.height);
            dummy.addChild(temp);
            toDraw.add(dummy);
        }

    }

    public void draw() {

        for (PShape tempShape : toDraw) {
            parent.shape(tempShape);
        }
        toDraw.clear();
        renderableObjects.clear();
    }
}
