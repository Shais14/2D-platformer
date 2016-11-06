package client.keyObject;

import client.networkManager.ClientWriteThread;
import client.util.Helper;
import commonObjects.KeyEventObjects;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class SendKeys {

    static ConcurrentLinkedQueue<KeyEventObjects> KEList = new ConcurrentLinkedQueue<>();

    public static void toServerAndBeyond(ConcurrentLinkedQueue<KeyObject> keyList) throws IOException {

        KEList.addAll(keyList.stream().map(Helper::keyToEventObject).collect(Collectors.toList()));

        ClientWriteThread.writeToClient(KEList);

        KEList.clear();

    }



}
