package client;

import client.keyObject.KeyObject;
import client.networkManager.CreateClient;
import processing.core.PApplet;

import java.io.IOException;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class Client {


    public static void main(String args[]) throws IOException {

        CreateClient gameClient = new CreateClient();
        KeyObject l = new KeyObject("left");
        KeyObject r = new KeyObject("right");
        KeyObject u = new KeyObject("up");
        PApplet.main(new String[]{"client.render.ProcessingClient"});
    }

}
