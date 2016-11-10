package commonObjects;

import java.io.Serializable;
import java.net.Socket;

/**
 * Created by Shais Shaikh on 11/8/2016.
 */
public class DummyEventObject implements Serializable {


    public String type;
    public long timestamp;
    public Object evtObject;
    public Socket soc;


}
