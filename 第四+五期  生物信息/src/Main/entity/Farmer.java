package Main.entity;

import Main.Draw;
import Main.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Farmer {

    int health = 100;
    int width = 80;
    int height = 100;
    int x = Screen.screen_width_half - 40;
    int y = Screen.screen_height - height - 50;
    int steps = 3;
    Zombie zombie = new Zombie();
    Dir dir;

    public Farmer(){

    }


    public void draw(Graphics g) throws IOException {
        Draw.drawImage(g,"farmer",x,y,width,height);
        health(g);
    }

    public void move(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                if (x <= Screen.screen_width - width - 30){
                    dir = Dir.D;
                }
                break;
            case KeyEvent.VK_A:
                if (x >= 30){
                   dir = Dir.A;
                }
                break;
            case KeyEvent.VK_S:
                if (y <= Screen.screen_height - height - 35){
                    dir = Dir.S;
                }
                break;
            case KeyEvent.VK_W:
                if (y >= 30){
                    dir = Dir.W;
                }
                break;
        }

        switch (dir){
            case A:
                if (x != 10) {
                    x -= 5;
                }
                break;
            case D:
                if (x != Screen.screen_width - width - 20) {
                    x += 5;
                }
                break;
            case S:
                if (y <= Screen.screen_height - height - 35) {
                    y += 5;
                }
                break;
            case W:
                if (y >= 30) {
                    y -= 5;
                }
                break;
        }

    }

    public void health(Graphics g){
        Draw.drawHealthBottom(g,x,y,health,height,width);
        Rectangle rectZombie = new Rectangle(zombie.x, zombie.y, zombie.width, zombie.height);
        Rectangle rectFarmer = new Rectangle(x, y, width, height);
        if (rectZombie.intersects(rectFarmer)) {
            health -= 10;
            System.out.println(health);
        }

    }




}
