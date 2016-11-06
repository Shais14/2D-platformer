package server;

import processing.core.PApplet;
import server.gameBuilder.MapEditor;
import server.networkManager.ServerStart;

public class Server {

    public static void main(String[] args) {
	// write your code herepublic static void main(String[] args) throws Exception {

        MapEditor map = new MapEditor();
        map.create();
        ServerStart gameServer = new ServerStart();
        PApplet.main(new String[]{"server.render.ProcessingServer"});


    }
}
