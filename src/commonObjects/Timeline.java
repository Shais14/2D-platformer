package commonObjects;

import java.io.Serializable;

/**
 * Created by Shais Shaikh on 11/6/2016.
 */
public class Timeline implements Serializable {

    private long origin;
    private Timeline anchorTime;
    private int ticSize;

    public Timeline(int tick, Timeline parentAnchorRef) {
        ticSize = tick;
        anchorTime = parentAnchorRef;

        if (anchorTime == null) {
            origin = System.nanoTime();
        } else {
            origin = anchorTime.getTime();
        }
    }

    public long getTime() {

        if (anchorTime == null) {
            return System.nanoTime();
        }

        return (anchorTime.getTime() - origin) / ticSize;
    }

    private void changeSpeed(int factor) {

        ticSize /= factor;

    }


}
