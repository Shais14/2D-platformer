package server.gameObject.clientBased;

import processing.core.PApplet;
import server.gameBuilder.PlayerEditor;
import server.gameObject.GameObjects;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class Player {

    public static ConcurrentHashMap<Socket, GameObjects> playerMap = new ConcurrentHashMap<>();

    private PApplet parent;

    public Player(PApplet parent) {
        this.parent = parent;
    }

    public static void addPlayer(Socket clientSocket){

        playerMap.putIfAbsent(clientSocket, PlayerEditor.create());
    }
}
