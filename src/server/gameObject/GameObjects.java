package server.gameObject;

import processing.core.PVector;
import server.components.*;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Shais Shaikh on 10/18/2016.
 */
public class GameObjects {

        public String Name;
        public float strokeColor[] = new float[3];
        public float fillColor[] = new float[3];
        public PVector position = new PVector();
        public PVector velocity = new PVector();
        public int width, height;  //radius;
        public String shape;
        public ConcurrentLinkedQueue<Components> components = new ConcurrentLinkedQueue<>();

        public GameObjects(String name, float[] stroke, float[] col, float posx, float posy, int w, int h, String s, String... comps ) {
            Name = name;
            strokeColor = stroke;
            fillColor = col;
            position.x = posx;
            position.y = posy;
            width = w;
            height = h;
            shape = s;
            velocity.x = 0;
            velocity.y = 0;

            for (String str: comps
                 ) {
                addToComponents(str);
            }
        }


        public void addToComponents(String str) {

            switch (str) {
                case "Renderable":
                    components.add(new Renderable());
                    break;
                case "Movable":
                    components.add(new Movable());
                    break;
                case "Collidable":
                    components.add(new Collidable());
                    break;
                case "Slidable":
                    components.add(new Slidable());
                    break;
                case "Killable":
                    components.add(new Killable());
                    break;
                case "Dead":
                    components.add(new Dead());
                    break;
                default:
                    break;
            }

        }
    }

