package server.render;

import processing.core.PApplet;
import server.gameObject.mapBased.Scene;
import server.packer.Packer;
import server.physicsEngine.ApplyPhysics;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class ProcessingServer extends PApplet{

        Packer packer;
        Scene scene;
        ApplyPhysics phy;
        public void settings() {
            size(500,500);
        }
        public void setup() {
            phy = new ApplyPhysics(this);
            packer =new Packer(this);
            scene = new Scene(this);
            scene.create();
        }

        public void draw() {

            background(255);
            packer.create();
            packer.draw();
            phy.physickzer();
            packer.create();
            packer.draw();
            packer.createDynamic();
            packer.drawDynamic();
        }

        public static void main(String args[]){

        }

    }

