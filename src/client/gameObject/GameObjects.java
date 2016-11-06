package client.gameObject;

import processing.core.PVector;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class GameObjects {

    public String Name;
    public float strokeColor[] = new float[3];
    public float fillColor[] = new float[3];
    public PVector position = new PVector();
    public int width, height;  //radius;
    public String shape;

    public GameObjects() {
    }
}

