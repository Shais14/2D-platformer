package client.networkManager;

import client.networkManager.CreateClient;
import client.unpacker.Unpacker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import static client.networkManager.CreateClient.ois;

/**
 * Created by Shais Shaikh on 10/9/2016.
 */

public class ClientReadThread extends Thread implements Serializable {

    private Socket clientReadSocket;

    public ClientReadThread(Socket s) {
        clientReadSocket = s;
    }

    public void run() {
        while(true) {
            try {
                ObjectInputStream in = CreateClient.ois;
                ConcurrentLinkedQueue<commonObjects.DataObjects> Q = (ConcurrentLinkedQueue<commonObjects.DataObjects>) in.readObject();
                if(Q!= null) {
                   Unpacker.unpack(Q);
                }
            } catch (ClassNotFoundException | IOException e) {
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

