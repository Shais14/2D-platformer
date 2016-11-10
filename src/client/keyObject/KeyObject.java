package client.keyObject;

import commonObjects.Timeline;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class KeyObject implements Serializable{

    public String Name;
    public Timeline timeStamp;
    public static ConcurrentLinkedQueue<KeyObject> keyList = new ConcurrentLinkedQueue<>();

    public KeyObject(String str, Timeline timeStamp) {
        this.Name = str;
        this.timeStamp = timeStamp;
    }


    public static void addToKeyEvent(KeyObject k) {
        keyList.add(k);
    }

}
