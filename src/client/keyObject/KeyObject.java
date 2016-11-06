package client.keyObject;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class KeyObject {

     public String Name;
    public static ConcurrentLinkedQueue<KeyObject> keyList = new ConcurrentLinkedQueue<>();

    public KeyObject(String str) {
        this.Name = str;
    }


    public static void addToKeyEvent(KeyObject k) {
        keyList.add(k);
    }

}
