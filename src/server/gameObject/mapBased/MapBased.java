package server.gameObject.mapBased;

import processing.core.PApplet;

/**
 * Created by Shais Shaikh on 10/9/2016.
 */
public abstract class MapBased extends PApplet {
    public PApplet parent;

    public abstract void create();

    public abstract void draw();

}
