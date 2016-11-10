package server.physicsEngine;

import commonObjects.Timeline;
import commonObjects.eventManager.EventObjects;
import server.gameObject.GameObjects;

import static commonObjects.eventManager.EventManager.eventRaiser;
import static commonObjects.eventManager.EventManager.eventRegister;
import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/20/2016.
 */

public class Slide {
    static void checkSlide(Timeline t) {

        for (GameObjects obj : renderableObjects) {

            obj.components.stream().filter(c -> c.getComponentId().contains("Slidable")).forEachOrdered(
            c -> obj.velocity.x += 3);


            if(obj.position.x > 500){

                EventObjects slideEventObject = new EventObjects("SLIDE", t.getTime(), obj);
                eventRaiser(slideEventObject);
            }


        }

    }

    public static void actSlide(GameObjects o){

        o.position.x = -200;

    }



}
