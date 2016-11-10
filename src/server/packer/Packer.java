package server.packer;

import commonObjects.DataObjects;
import processing.core.PApplet;
import processing.core.PShape;
import server.gameObject.GameObjects;
import server.networkManager.ServerWriteThread;
import server.util.Helper;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import static server.util.Helper.gameToDataObject;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */

public class Packer {

    public static ConcurrentLinkedQueue<GameObjects> renderableObjects = new ConcurrentLinkedQueue<>();
    private PApplet parent;
    private ConcurrentLinkedQueue<PShape> toDraw = new ConcurrentLinkedQueue<>();


    public Packer(PApplet parent) {
        this.parent = parent;
    }


    public static void packNew(GameObjects obj) {
        renderableObjects.add(obj);

    }

    public static void pack(ConcurrentLinkedQueue<GameObjects> obj) {

        for (GameObjects ob: obj) {
            renderableObjects.addAll(ob.components.stream().filter(components -> components.getComponentId().contains("Renderable")).map(components -> ob).collect(Collectors.toList()));

        }
    }

    public void create() {

        for (GameObjects obj : renderableObjects) {

            obj.components.stream().filter(c -> !c.getComponentId().contains("Movable")).forEachOrdered(c -> {

                PShape dummy = parent.createShape(PApplet.GROUP);
                parent.stroke(obj.strokeColor[0], obj.strokeColor[1], obj.strokeColor[2]);
                parent.fill(obj.fillColor[0], obj.fillColor[1], obj.fillColor[2]);

                PShape temp = parent.createShape(Helper.findShape(obj.shape), obj.position.x, obj.position.y, obj.width, obj.height);
                dummy.addChild(temp);
                toDraw.add(dummy);
            });
        }
    }

    public void draw() {
        for (PShape tempShape : toDraw) {
            parent.shape(tempShape);
        }
        toDraw.clear();
    }


    public void createDynamic() {

        for (GameObjects obj : renderableObjects) {

            obj.components.stream().filter(c -> c.getComponentId().contains("Movable")).forEachOrdered(c -> {

                PShape dummy = parent.createShape(PApplet.GROUP);
                parent.stroke(obj.strokeColor[0], obj.strokeColor[1], obj.strokeColor[2]);
                parent.fill(obj.fillColor[0], obj.fillColor[1], obj.fillColor[2]);

                PShape temp = parent.createShape(Helper.findShape(obj.shape), obj.position.x, obj.position.y, obj.width, obj.height);
                dummy.addChild(temp);
                toDraw.add(dummy);
            });
        }
    }

    public void drawDynamic() {
        for (PShape tempShape : toDraw) {
            parent.shape(tempShape);
        }
        toDraw.clear();
    }

    public static void toClientAndBeyond(ServerWriteThread serverWriteThread) {

        ConcurrentLinkedQueue<DataObjects> sendObj = new ConcurrentLinkedQueue<DataObjects>();
        for (GameObjects obj : renderableObjects) {
            DataObjects dObj = gameToDataObject(obj);
            sendObj.add(dObj);
        }
        serverWriteThread.writeToClient(sendObj);
    }
}
