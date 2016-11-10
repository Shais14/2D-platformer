package commonObjects.eventManager;

import commonObjects.DummyEventObject;

import java.util.EventObject;

/**
 * Created by Shais Shaikh on 11/8/2016.
 */
public class    Helper {

    public static int findPriority(String s){

        switch (s) {
            case "KEY":
                return 1;
            case "COLLIDEY":
                return 2;
            case "COLLIDEX":
                return 3;
            case "SPAWN":
                return 4;
            case "DEAD":
                return 5;
            case "SLIDE":
                return 6;
            case "GRAVITY":
                return 7;

            default:
                return Integer.parseInt(null);
        }
    }


    public static DummyEventObject makeEventSerializable(EventObjects eObj){

        DummyEventObject obj = new DummyEventObject();
        obj.type = eObj.type;
        obj.timestamp = eObj.timestamp;
        obj.evtObject = eObj.evtObject;
        return obj;
    }

    public static EventObjects dummyToEventObject(DummyEventObject eObj){

        EventObjects obj = new EventObjects(eObj.type, eObj.timestamp, eObj.evtObject);
        return obj;
    }




}
