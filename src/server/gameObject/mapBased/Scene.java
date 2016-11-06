package server.gameObject.mapBased;

import processing.core.PApplet;
import server.gameBuilder.MapEditor;
import server.packer.Packer;

import java.io.Serializable;

/**
 * Created by Shais Shaikh on 10/9/2016.
 *
 *
 * Create the map here
 * */

public class Scene extends MapBased implements Serializable {


    PApplet parent;

    public Scene(PApplet parent) {
        this.parent = parent;
    }

    @Override
    public void create() {
        Packer.pack(MapEditor.mapObjects);
    }


    @Override
    public void draw() {


    }

}
