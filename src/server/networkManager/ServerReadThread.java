package server.networkManager;


import commonObjects.KeyEventObjects;
import server.keyObject.KeyObjects;
import server.util.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import static server.networkManager.ServerStart.clientMap;
import static server.networkManager.ServerStart.ois;


/**
 * Created by Shais Shaikh on 10/9/2016.
 */
public class ServerReadThread extends Thread implements Runnable {
    Socket clientSocket;
    int clientID = 0;

    ServerReadThread(Socket s, int i) {
        clientSocket = s;
        clientID = i;
    }

    public void run() {

        while (true) {
            try {

                ObjectInputStream in = ois.get(clientSocket);
                KeyEventObjects Q = (KeyEventObjects) in.readObject();

                if (Q != null) {
                    System.out.println(Q.keyName);
                    KeyObjects.keyMap.putIfAbsent(clientSocket, Helper.eventToKeyObject(Q));
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
