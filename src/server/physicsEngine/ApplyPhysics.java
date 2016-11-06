package server.physicsEngine;

import processing.core.PApplet;
import server.gameBuilder.MapEditor;
import server.gameObject.GameObjects;

import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class ApplyPhysics {

    PApplet parent;

    public ApplyPhysics(PApplet parent) {
        this.parent = parent;
    }

    public void physickzer(){

        Position.checkPosition();
        Slide.checkSlide();
        Gravity.checkGravity();
        Collision.checkCollision(parent);

        displace();


    }

    private static void displace() {

        for (GameObjects obj: renderableObjects) {
            obj.position.add(obj.velocity);
            obj.velocity.x = 0;
            isDead(obj);
        }
    }

    private static void isDead(GameObjects obj) {



        float[] black = {0,0,0};

        for(GameObjects g : MapEditor.mapObjects){

                g.components.stream().filter(c -> c.getComponentId().contains("Killable")).filter(c -> obj.position.x > g.position.x && obj.position.x < g.position.x + g.width).filter(c -> obj.position.y > g.position.y && obj.position.y < g.position.y + g.height).forEachOrdered(c -> {
                obj.fillColor = black;
                obj.addToComponents("Dead");
                System.out.println(obj.components);
            });
        }


    }


}
