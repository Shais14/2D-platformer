package server.physicsEngine;

import server.components.Components;
import server.util.Helper;
import server.gameObject.GameObjects;
import server.gameObject.clientBased.Player;
import server.keyObject.KeyObjects;

import java.net.Socket;

import static server.keyObject.KeyObjects.keyMap;

/**
 * Created by Shais Shaikh on 10/19/2016.
 */
public class Position {


    public static void checkPosition() {


        for (Socket s1 : keyMap.keySet()) {

            Player.playerMap.keySet().stream().filter(s2 -> s1 == s2).forEachOrdered(s2 -> updateX(keyMap.get(s1), Player.playerMap.get(s2)));
        }
        keyMap.clear();

    }

    private static void updateX(KeyObjects kObj, GameObjects gObj) {

        System.out.println("kObj = [" + kObj.Name + "]");

        if (!kObj.Name.equals("up")) {
            gObj.velocity.x = Helper.keyToValue(kObj.Name);
        } else {
            if (gObj.velocity.y == 0) {
                gObj.velocity.y = Helper.keyToValue(kObj.Name);
            }
        }
    }


}
