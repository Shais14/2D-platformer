package client.networkManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Shais Shaikh on 10/9/2016.
 */
public class CreateClient {

    public static ObjectInputStream ois;
    public static ObjectOutputStream oos;

    public CreateClient() throws IOException {
        Socket client = new Socket("localhost", 1234);
        ois = new ObjectInputStream(client.getInputStream());
        oos = new ObjectOutputStream(client.getOutputStream());
        System.out.println("my name is " + client.getLocalSocketAddress());
        ClientReadThread cliReadThread = new ClientReadThread(client);
        ClientWriteThread cliWriteThread = new ClientWriteThread(client);
        cliReadThread.start();
        cliWriteThread.start();
    }

}
