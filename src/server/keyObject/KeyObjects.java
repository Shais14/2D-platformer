package server.keyObject;

import client.keyObject.KeyObject;
import commonObjects.Timeline;

import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class KeyObjects {

    public static ConcurrentHashMap<Socket, KeyObjects>  keyMap = new ConcurrentHashMap<>();
    public String Name;
    public Timeline timeStamp;
    public KeyObjects() {
    }




}
