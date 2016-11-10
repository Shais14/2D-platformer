package server.physicsEngine;

import processing.core.PApplet;
import server.components.Components;
import server.gameObject.GameObjects;

import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class Gravity {


    public static void checkGravity(GameObjects ob) {
        ob.components.stream().filter(c -> c.getComponentId().contains("Movable")).forEachOrdered(c -> {
            ob.velocity.y += 3;

        });
    }
}