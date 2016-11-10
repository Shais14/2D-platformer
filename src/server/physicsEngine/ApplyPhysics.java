package server.physicsEngine;

import commonObjects.Timeline;
import commonObjects.eventManager.EventObjects;
import processing.core.PApplet;
import server.gameBuilder.MapEditor;
import server.gameObject.GameObjects;

import java.util.Objects;

import static commonObjects.eventManager.EventManager.eventRaiser;
import static commonObjects.eventManager.EventManager.eventRegister;
import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class ApplyPhysics {

    PApplet parent;

    public ApplyPhysics(PApplet parent) {
        this.parent = parent;
    }

    public void physickzer(Timeline gameTime){

        Position.checkPosition();
        Slide.checkSlide(gameTime);
//        Gravity.checkGravity();
        Collision.checkCollision(parent, gameTime);
    }

    public static void displace(Timeline gameTime) {

        for (GameObjects obj: renderableObjects) {

            
            obj.position.add(obj.velocity);
            obj.velocity.x = 0;
            isDead(obj, gameTime);
        }
    }

    private static void isDead(GameObjects obj, Timeline gameTime) {

        for(GameObjects g : MapEditor.mapObjects){

                g.components.stream().filter(c -> c.getComponentId().contains("Killable")).filter(c -> obj.position.x > g.position.x && obj.position.x < g.position.x + g.width).filter(c -> obj.position.y > g.position.y && obj.position.y < g.position.y + g.height).forEachOrdered(c -> {

                    EventObjects deadObject = new EventObjects("DEAD", gameTime.getTime(), obj);
                    eventRaiser(deadObject);
                 });
        }


    }

    public static void kill(GameObjects obj) {

        float[] black = {0,0,0};
        obj.fillColor = black;
        obj.addToComponents("Dead");

    }


}
