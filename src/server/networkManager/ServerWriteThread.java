package server.networkManager;

import server.gameObject.clientBased.Player;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import static server.networkManager.ServerStart.clientMap;
import static server.networkManager.ServerStart.oos;
import static server.packer.Packer.toClientAndBeyond;

/**
 * Created by Shais Shaikh on 10/9/2016.
 */

public class ServerWriteThread extends Thread implements Serializable {

    private Socket clientSocket;
    private int clientID = 0;


    ServerWriteThread(Socket s, int i) {
        clientSocket = s;
        clientID = i;
    }

    public void run() {

        ConcurrentLinkedQueue<Socket> newSocket = new ConcurrentLinkedQueue<>();
        while(true) {

            for (int i = 0; i < ServerStart.clientMap.size(); i++) {

                if (!newSocket.contains(clientMap.get(i))) {
                    newSocket.add(clientMap.get(i));
                    Socket clientSocket = clientMap.get(i);

                    System.out.println("new client connected");
                }
            }

            for (Integer currentKey : clientMap.keySet()) {
                synchronized (this) {
                    toClientAndBeyond(this);
                }
            }
        }
    }

    private void write(Socket client, ConcurrentLinkedQueue<commonObjects.DataObjects> dObj) throws IOException {
        ObjectOutputStream out = oos.get(client);
        out.writeObject(dObj);
    }

    public void writeToClient(ConcurrentLinkedQueue<commonObjects.DataObjects> dObj) {

            try {
                write(clientSocket, dObj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
