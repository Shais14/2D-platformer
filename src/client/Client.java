package client;

import client.keyObject.KeyObject;
import client.networkManager.CreateClient;
import commonObjects.Timeline;
import processing.core.PApplet;

import java.io.IOException;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class Client {

    public static Timeline clientTime;

    public static void main(String args[]) throws IOException {

        clientTime = new Timeline(1, null);

        CreateClient gameClient = new CreateClient();
        PApplet.main(new String[]{"client.render.ProcessingClient"});
    }

}
