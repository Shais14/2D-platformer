package server.render;

import commonObjects.Timeline;
import processing.core.PApplet;

import server.gameObject.mapBased.Scene;
import server.packer.Packer;
import server.physicsEngine.ApplyPhysics;

import static commonObjects.eventManager.EventManager.eventHandler;
import static commonObjects.eventManager.EventManager.initEventMap;
import static server.Server.serverTime;
import static server.physicsEngine.ApplyPhysics.displace;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class ProcessingServer extends PApplet {

    private Packer packer;
    private ApplyPhysics phy;
    private Timeline gameTime;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        gameTime = new Timeline(1, serverTime);
        phy = new ApplyPhysics(this);
        packer = new Packer(this);
        Scene scene = new Scene(this);
        initEventMap();
        scene.create();
    }

    public void draw() {

        background(255);
        packer.create();
        packer.draw();
        phy.physickzer(gameTime);
        eventHandler();
        displace(gameTime);
    }

    public static void main(String args[]) {

    }

}

