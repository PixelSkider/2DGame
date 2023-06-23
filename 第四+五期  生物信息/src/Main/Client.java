package Main;

import Main.entity.Farmer;
import Main.entity.Zombie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Client extends JFrame {
    public static int screen_width = 750;
    public static int screen_height = 450;
    public static int screen_width_half = screen_width / 2;
    public static int screen_height_half = screen_height / 2;
    int count = 0;
    long startTime = System.currentTimeMillis();

    Farmer farmer = new Farmer();
    Zombie zombie = new Zombie();


    public static void main(String[] args) throws IOException {
        new Client();
    }

    public Client() throws IOException {
        this.setSize(750,450);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(Client.EXIT_ON_CLOSE);
        this.setResizable(false);
        zombie.draw(this.getGraphics());
        farmer.draw(this.getGraphics());


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                farmer.move(e);
            }
        });

        new Thread(() -> {
           while (true){
               try {
                   count++;
                   repaint();
                   zombie.draw(this.getGraphics());
                   farmer.draw(this.getGraphics());
                   Thread.sleep(10);
                   long endTime = System.currentTimeMillis();
                   long totalTime = endTime - startTime;
                   if (totalTime >= 1000) {
                       double fps = (double) count / (totalTime / 1000.0);
                       count = 0;
                       startTime = System.currentTimeMillis();



                   }
               } catch (InterruptedException | IOException e) {
                   throw new RuntimeException(e);
               }

           }
        }).start();


    }

}
