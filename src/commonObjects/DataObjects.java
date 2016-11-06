package commonObjects;

import processing.core.PVector;

import java.io.Serializable;

/**
 * Created by Shais Shaikh on 10/18/2016.

 */
public class  DataObjects implements Serializable {
    public String Name;
    public float[] strokeColor = new float[3];
    public float[] fillColor = new float[3];
    public PVector position = new PVector();
    public int width, height;  //radius;
    public String shape;

}
