package server.gameBuilder;

import server.gameObject.GameObjects;
import server.packer.Packer;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class PlayerEditor {

    private static ConcurrentLinkedQueue<GameObjects> playerObjects = new ConcurrentLinkedQueue<>();

    public static GameObjects create() {

        int r = (int) Math.ceil(255 * Math.random());
        int g = (int) Math.ceil(255 * Math.random());
        int b = (int) Math.ceil(255 * Math.random());
        float stroke[] = {r, g, b};
        float color[] = {r, g, b};

        GameObjects character = new GameObjects("Rick",  stroke, color, 100, 100, 50, 50, "CIRCLE", "Renderable", "Movable", "Collidable");
        playerObjects.add(character);
        Packer.packNew(character);
        return character;
    }
}
