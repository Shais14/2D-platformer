package server.physicsEngine;

import processing.core.PApplet;
import server.gameObject.GameObjects;

import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class Gravity {


    public static void checkGravity() {


        for (GameObjects obj : renderableObjects) {



            obj.components.stream().filter(c -> c.getComponentId().contains("Movable")).forEachOrdered(c -> obj.velocity.y += 3);

        }
    }
}