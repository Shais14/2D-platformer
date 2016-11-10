package client.keyObject;

import client.networkManager.ClientWriteThread;
import client.util.Helper;
import commonObjects.DummyEventObject;
import commonObjects.KeyEventObjects;
import commonObjects.eventManager.EventObjects;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import static client.util.Helper.keyToEventObject;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class SendKeys {

    static ConcurrentLinkedQueue<KeyEventObjects> KeyEventList = new ConcurrentLinkedQueue<>();
    static ConcurrentLinkedQueue<EventObjects> KEList = new ConcurrentLinkedQueue<>();
    static ConcurrentLinkedQueue<DummyEventObject> serializedList = new ConcurrentLinkedQueue<>();

    public static void toServerAndBeyond(ConcurrentLinkedQueue<KeyObject> keyList) throws IOException {


        KeyEventList.addAll(keyList.stream().map(Helper::keyToEventObject).collect(Collectors.toList()));

        KEList.addAll(KeyEventList.stream().map(Helper::key2EventObject).collect(Collectors.toList()));

        ClientWriteThread.writeToClient(KEList);

        KeyEventList.clear();
        KEList.clear();
        serializedList.clear();

    }



}
