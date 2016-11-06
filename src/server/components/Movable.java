package server.components;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class Movable extends Components {

    static String str = "Movable";

    public Movable() {

    }

    @Override
    public String getComponentId() {
        return str;
    }


    public static void kill(){
            str = "";
    }
}
