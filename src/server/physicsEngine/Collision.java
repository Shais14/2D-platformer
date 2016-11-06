package server.physicsEngine;

import processing.core.PApplet;
import server.components.Components;
import server.gameObject.GameObjects;

import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class Collision {
    public static void checkCollision(PApplet parent) {

        int b;

        for (GameObjects ob : renderableObjects) {

            for (Components c : ob.components) {

                if(c.getComponentId().contains("Dead")){
                    continue;
                }


                if (c.getComponentId().contains("Collidable")) {
                    if (ob.velocity.y > 0) {
                        b = parent.get((int) ob.position.x, (int) (ob.position.y + ob.height / 2 + 1));
                        int x = parent.color(255);
                        if (x != b) {
                            ob.velocity.y = 0;
                        }

                    } else if (ob.velocity.y < 0) {

                        b = parent.get((int) ob.position.x, (int) (ob.position.y - ob.height / 2 - 1));
                        int x = parent.color(255);
                        if (x != b) {
                            ob.velocity.y = 0;
                        }

                    } else if (ob.velocity.x > 0) {

                        b = parent.get((int) (ob.position.x + ob.width / 2 + 1), (int) ob.position.y);
                        int x = parent.color(255);
                        if (x != b) {
                            ob.velocity.x = 0;
                        }

                    } else if (ob.velocity.x < 0) {

                        b = parent.get((int) (ob.position.x - ob.width / 2 - 1), (int) ob.position.y);
                        int x = parent.color(255);
                        if (x != b) {
                            ob.velocity.x = 0;
                        }
                    }
                }
            }
        }

    }
}
