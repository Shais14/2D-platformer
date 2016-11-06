package server.networkManager;

import server.gameObject.clientBased.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class ServerStart extends Thread {


    static ConcurrentHashMap<Integer, Socket> clientMap = new ConcurrentHashMap();
    private static ServerSocket serverSocket;
    static ConcurrentHashMap<Socket, ObjectOutputStream> oos = new ConcurrentHashMap<>();
    static ConcurrentHashMap<Socket, ObjectInputStream> ois = new ConcurrentHashMap<>();
    private int count = 0;
    static ServerReadThread cliReadThread;
    private ServerStart(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("ServerStarted");
    }

    public void run(){

        int id = 0;
        while (true) {
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
                clientMap.putIfAbsent(count++, clientSocket);
                oos.putIfAbsent(clientSocket, new ObjectOutputStream(clientSocket.getOutputStream()));
                ois.putIfAbsent(clientSocket, new ObjectInputStream(clientSocket.getInputStream()));
                Player.addPlayer(clientSocket);
                cliReadThread = new ServerReadThread(clientSocket, id++);
                cliReadThread.start();
                ServerWriteThread cliWriteThread = new ServerWriteThread(clientSocket, id++);
                cliWriteThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public ServerStart() {
        int port = 1234;

        try {
            Thread t = new ServerStart(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
