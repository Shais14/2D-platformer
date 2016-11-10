package commonObjects.eventManager;

import java.io.Serializable;
import java.net.Socket;

/**
 * Created by Shais Shaikh on 11/7/2016.
 */
public class EventObjects implements Comparable, Serializable{

    public String type;
    public long timestamp;
    public Object evtObject;
    public Socket soc;


    public EventObjects(String type, long timestamp, Object evtObject) {
        this.type = type;
        this.timestamp = timestamp;
        this.evtObject = evtObject;
    }

    @Override
    public int compareTo(Object o) {

        EventObjects e = (EventObjects) o;

        double typePriority = getTypePriority(this.type, e.type);
        double timePriority = getTimePriority(this.timestamp, e.timestamp);

        int priority = (int) (typePriority + timePriority);

        if(priority > 0){
            return 1;
        }else if(priority < 0){
            return -1;
        }
        return 0;
    }

    private double getTimePriority(long timestamp, long timestamp1) {

        return (timestamp - timestamp1) * 0.4;
    }

    private double getTypePriority(String type, String type1) {

    return (Helper.findPriority(type) - Helper.findPriority(type1)) * 0.6;

    }
}
