package server;

import commonObjects.Timeline;
import processing.core.PApplet;
import server.gameBuilder.MapEditor;
import server.networkManager.ServerStart;

public class Server {

    public static Timeline serverTime;

    public static void main(String[] args) {

        serverTime = new Timeline(1, null);
        MapEditor map = new MapEditor();
        map.create();
        ServerStart gameServer = new ServerStart();
        PApplet.main(new String[]{"server.render.ProcessingServer"});


    }
}
