package client.networkManager;

import client.keyObject.KeyObject;
import client.keyObject.SendKeys;
import client.networkManager.CreateClient;
import commonObjects.KeyEventObjects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import static client.keyObject.KeyObject.keyList;
import static client.networkManager.CreateClient.oos;

/**
 * Created by Shais Shaikh on 10/9/2016.
 */

public class ClientWriteThread extends Thread implements Runnable {

    private static Socket serverSocket;
    private static boolean count = true;

    public ClientWriteThread(Socket s) {
        serverSocket = s;
    }

    public void run() {

        while (true) {

                if(!keyList.isEmpty()){
                    try {
                        SendKeys.toServerAndBeyond(keyList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    keyList.clear();
                }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }

    public static void writeToClient(ConcurrentLinkedQueue<KeyEventObjects> keList) throws IOException {
        for (KeyEventObjects ke: keList) {
            ObjectOutputStream out = CreateClient.oos;
            out.writeObject(ke);
        }
        keList.clear();
    }
}
