package client.render;

import client.keyObject.KeyObject;
import client.unpacker.Unpacker;
import commonObjects.Timeline;
import processing.core.PApplet;

import static client.Client.clientTime;
import static client.keyObject.KeyObject.addToKeyEvent;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class ProcessingClient extends PApplet {


    private Unpacker unpacker;
    Timeline gameTime;
    public void settings() {
        size(500, 500);
    }

    public void setup() {
        gameTime = new Timeline(1, clientTime);
        unpacker = new Unpacker(this);
    }


    public void keyPressed() {
        if (keyPressed) {
            int activeKey = (key == CODED) ? keyCode : key;
            switch (activeKey) {
                case LEFT:
                    System.out.println("left");
                    addToKeyEvent(new KeyObject("left", gameTime));
                    break;
                case RIGHT:
                    System.out.println("right");
                    addToKeyEvent(new KeyObject("right", gameTime));
                    break;
                case UP:
                    System.out.println("up");
                    addToKeyEvent(new KeyObject("up", gameTime));
                    break;
                default:
            }
        }
    }

    public void draw() {
        background(255);
        unpacker.create();
        unpacker.draw();
    }
}
