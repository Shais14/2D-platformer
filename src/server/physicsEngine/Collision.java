package server.physicsEngine;

import commonObjects.Timeline;
import commonObjects.eventManager.EventObjects;
import processing.core.PApplet;
import server.components.Components;
import server.gameObject.GameObjects;

import java.util.Objects;

import static commonObjects.eventManager.EventManager.eventRaiser;
import static server.packer.Packer.renderableObjects;
import static server.physicsEngine.Gravity.checkGravity;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class Collision {
    public static void checkCollision(PApplet parent, Timeline t) {

        int b;

        for (GameObjects ob : renderableObjects) {

            boolean gravityflag = true;

            for (Components c : ob.components) {

                if (c.getComponentId().contains("Dead")) {
                    continue;
                }
                if (c.getComponentId().contains("Collidable")) {
                    if (ob.velocity.y >= 0) {

                        b = parent.get((int) ob.position.x, (int) (ob.position.y + ob.height / 2 + 1));
                        int x = parent.color(255);
                        if (x != b) {
//                              ob.velocity.y = 0;
                            EventObjects CollisionYEventObject = new EventObjects("COLLIDEY", t.getTime(), ob);
                            eventRaiser(CollisionYEventObject);
                            gravityflag = false;
                        }

                    } else if (ob.velocity.y < 0) {

                        b = parent.get((int) ob.position.x, (int) (ob.position.y - ob.height / 2 - 1));
                        int x = parent.color(255);
                        if (x != b) {
//                            ob.velocity.y = 0;
                            EventObjects CollisionYEventObject = new EventObjects("COLLIDEY", t.getTime(), ob);
                            eventRaiser(CollisionYEventObject);

                            for (Components c1 : ob.components) {
                                if (c1.getComponentId().contains("Movable")) {

                                    checkGravity(ob);
                                    gravityflag = false;
//                                        System.out.println("Collision.checkCollision ==> Gravity event");
//
//                                        EventObjects GravityEventObject = new EventObjects("GRAVITY", t.getTime(), ob);
//                                        eventRaiser(GravityEventObject);
//
                                }
                            }
                        }

                    }

                    for (Components c1 : ob.components) {
                        if (c1.getComponentId().contains("Movable")) {

                            if (gravityflag) {

                                checkGravity(ob);
                            }
                        }
                    }




                    if (ob.velocity.x > 0) {

                        b = parent.get((int) (ob.position.x + ob.width / 2 + 1), (int) ob.position.y);
                        int x = parent.color(255);
                        if (x != b) {
//                            ob.velocity.x = 0;
                            EventObjects CollisionXEventObject = new EventObjects("COLLIDEX", t.getTime(), ob);
                            eventRaiser(CollisionXEventObject);
                        }

                    } else if (ob.velocity.x < 0) {

                        b = parent.get((int) (ob.position.x - ob.width / 2 - 1), (int) ob.position.y);
                        int x = parent.color(255);
                        if (x != b) {
//                            ob.velocity.x = 0;

                            EventObjects CollisionXEventObject = new EventObjects("COLLIDEX", t.getTime(), ob);
                            eventRaiser(CollisionXEventObject);

                        }
                    }
                }


            }


        }

    }

    public static void collisionY(GameObjects obj) {
        obj.velocity.y = 0;
    }

    public static void collisionX(GameObjects obj) {
        obj.velocity.x = 0;
    }


}
