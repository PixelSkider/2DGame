package client.entity;

import client.main.Screen;
import client.utils.RenderUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Farmer {

    int health = 100;
    int width = 80;
    int height = 100;
    int x = Screen.screen_width_half - 40;
    int y = Screen.screen_height - height - 50;
    int steps = 3;
    Zombie zombie = new Zombie();
    Dir dir = Dir.Stop;

    public Farmer(){

    }

    public void render(Graphics g){
        RenderUtil.drawImage(g,"farmer",x,y,width,height);
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

        if (e.getKeyCode() != KeyEvent.VK_W &&
                e.getKeyCode() != KeyEvent.VK_S &&
                e.getKeyCode() != KeyEvent.VK_A &&
                e.getKeyCode() != KeyEvent.VK_D) {
            dir = Dir.Stop;
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
            case Stop:
                return;
        }

    }
    public void health(Graphics g){
        if (health != 0){
            RenderUtil.drawHealthBottom(g,x,y,health,height,width);
        }else {
            RenderUtil.drawString(g,"You Died",x,y + height + 10,Color.BLACK);
        }

    }

    public void press(boolean a){
        new Thread(() ->{
            while (a){
                try {
                    if(health != 0){
                        health = health - 10;
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
