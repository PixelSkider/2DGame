package Main.entity;

import Main.Draw;
import Main.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Zombie {
    int health = 100;
    int width = 96;
    int height = 96;
    int x = 0;
    int y = 50;
    Boolean moveRight = true;


    public Zombie(){

    }



    public void draw(Graphics g) throws IOException {
        Draw.drawImage(g,"zombie",x,y,width,height);
        Draw.drawHealthTop(g,x,y,health,height,width);
        if (moveRight) {
            x += 5;
            if (x >= Screen.screen_width - width -20) {
                x = Screen.screen_width - width -20;
                moveRight = false;
            }
        } else {
            x -= 5;
            if (x <= 0) {
                x = 0;
                moveRight = true;
            }
        }
    }

}
