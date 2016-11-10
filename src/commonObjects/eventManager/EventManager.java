package commonObjects.eventManager;

import client.keyObject.KeyObject;
import commonObjects.KeyEventObjects;
import server.gameObject.GameObjects;
import server.keyObject.KeyObjects;
import server.physicsEngine.Slide;
import server.util.*;

import java.net.Socket;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import static server.physicsEngine.ApplyPhysics.kill;
import static server.physicsEngine.Collision.collisionX;
import static server.physicsEngine.Collision.collisionY;
import static server.physicsEngine.Gravity.checkGravity;

/**
 * Created by Shais Shaikh on 11/8/2016.
 */
public class EventManager {

    public static PriorityQueue<EventObjects> PQ =  new PriorityQueue<>();

    public static ConcurrentHashMap<String , ConcurrentLinkedQueue<EventListener>> eventMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<EventListener>>();

    public static void eventRaiser(EventObjects evt){
        PQ.add(evt);
    }

    public static void eventRegister(String evtType, EventListener e ){

        if(eventMap.get(evtType) == null){
            ConcurrentLinkedQueue<EventListener> listenerList = new ConcurrentLinkedQueue<>();
            listenerList.add(e);
            eventMap.putIfAbsent(evtType, listenerList);
        }else{
            ConcurrentLinkedQueue<EventListener> temp = eventMap.get(evtType);
            temp.add(e);
        }

    }
    public static void eventHandler(){

        while( PQ.size() > 0 ) {

            EventObjects eObj = PQ.poll();


            int count  =0;

                    while(count < eventMap.get(eObj.type).size()){
                        EventListener el = eventMap.get(eObj.type).peek();
                        el.execute(eObj);
                        count++;
            }
        }

        PQ.clear();
    }


    public static void initEventMap(){

        eventRegister("SLIDE", data -> Slide.actSlide((GameObjects) data.evtObject));
        eventRegister("DEAD", data -> kill((GameObjects) data.evtObject));
        eventRegister("COLLIDEX", data -> collisionX((GameObjects) data.evtObject));
        eventRegister("COLLIDEY", data -> collisionY((GameObjects) data.evtObject));
        eventRegister("GRAVITY", data -> checkGravity((GameObjects) data.evtObject));
        eventRegister("KEY", data -> KeyObjects.keyMap.putIfAbsent(data.soc, server.util.Helper.eventToKeyObject((KeyEventObjects) data.evtObject)));

    }


}
