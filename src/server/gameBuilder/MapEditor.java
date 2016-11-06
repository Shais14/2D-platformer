package server.gameBuilder;

import server.gameObject.GameObjects;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class MapEditor {

    public static ConcurrentLinkedQueue<GameObjects> mapObjects;

    public void create() {

        mapObjects = new ConcurrentLinkedQueue<>();

        float[] stroke = {75, 75, 75};
        float[] color = {75, 75, 75};

        GameObjects wall1 = new GameObjects("Wall",  stroke, color, 0, 0, 500, 10, "RECTANGLE", "Renderable", "Collidable");
        mapObjects.add(wall1);

        GameObjects wall2 = new GameObjects("Wall",  stroke, color, 0, 0, 10, 500, "RECTANGLE", "Renderable", "Collidable");
        mapObjects.add(wall2);

        GameObjects wall3 = new GameObjects("Wall",  stroke, color, 0, 490, 500, 10, "RECTANGLE", "Renderable", "Collidable");
        mapObjects.add(wall3);

        GameObjects wall4 = new GameObjects("Wall",  stroke, color, 490, 0, 10, 500, "RECTANGLE", "Renderable", "Collidable");
        mapObjects.add(wall4);

        GameObjects wall5 = new GameObjects("Wall",  stroke, color, 0, 350, 200, 10, "RECTANGLE", "Renderable", "Collidable");
        mapObjects.add(wall5);

        GameObjects wall6 = new GameObjects("Wall",  stroke, color, 300, 350, 200, 10, "RECTANGLE", "Renderable", "Collidable");
        mapObjects.add(wall6);

        GameObjects wallE = new GameObjects("wallE",  stroke, color, 0, 100, 200, 10, "RECTANGLE", "Renderable", "Slidable");
        mapObjects.add(wallE);

        GameObjects dangerZone = new GameObjects("Archer",  stroke, color, 200, 350, 100, 150, "RECTANGLE", "Killable");
        mapObjects.add(dangerZone);

        GameObjects spawnZone = new GameObjects("Morty",  stroke, color, 0, 0, 200, 200, "RECTANGLE");
        mapObjects.add(spawnZone);

    }
}
