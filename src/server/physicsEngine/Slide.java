package server.physicsEngine;

import server.gameObject.GameObjects;

import static server.packer.Packer.renderableObjects;

/**
 * Created by Shais Shaikh on 10/20/2016.
 */
public class Slide {
    public static void checkSlide() {

        for (GameObjects obj : renderableObjects) {

            obj.components.stream().filter(c -> c.getComponentId().contains("Slidable")).forEachOrdered(c -> obj.velocity.x += 3);

            if(obj.position.x > 500){
                obj.position.x = -200;
            }


        }

    }
}
