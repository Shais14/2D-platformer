package server.networkManager;


import commonObjects.DummyEventObject;
import commonObjects.KeyEventObjects;
import commonObjects.eventManager.EventObjects;
import server.gameObject.GameObjects;
import server.keyObject.KeyObjects;
import server.physicsEngine.Slide;
import server.util.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

import static commonObjects.eventManager.EventManager.eventRaiser;
import static commonObjects.eventManager.EventManager.eventRegister;
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
                EventObjects Q = (EventObjects) in.readObject();

                if (Q != null) {
                    System.out.println(Q.type);

                    if(Objects.equals(Q.type, "KEY")) {
                        EventObjects keyObject = new EventObjects(Q.type, Q.timestamp, Q.evtObject);
                        keyObject.soc = clientSocket;
                        eventRaiser(keyObject);
                    }
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
