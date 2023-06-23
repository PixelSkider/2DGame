package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class Draw {

    public static void drawString(Graphics g,String str,int x,int y){
        g.drawString(str,x,y);
    }

    public static void drawString(Graphics g, String str, int x, int y, Color fontColor){
        g.setColor(fontColor);
        g.drawString(str,x,y);
    }

    public static void drawImage(Graphics g,String name, int x, int y,int width,int height) throws IOException {
        File file = new File(getRunPath() + "\\resource\\" + name + ".png");
        BufferedImage image = ImageIO.read(file);
        g.drawImage(image,x,y,width,height,null);
    }

    public static void drawHealthBottom(Graphics g, int x, int y, int health,int height,int width){
        g.setColor(Color.RED);
        g.draw3DRect(x - (120 -width) / 2,y + height + 10,120,10,false);
        g.fillRect(x - (120 -width) / 2,y + height + 10,health + 20,10);
    }

    public static void drawHealthTop(Graphics g, int x, int y, int health,int height,int width){
        g.setColor(Color.RED);
        g.draw3DRect(x - (120 -width) / 2,y - 15,120,10,false);
        g.fillRect(x - (120 -width) / 2,y - 15,health + 20,10);
    }


    public void setFont(Graphics2D g2,Font font){
        g2.setFont(font);
    }

    public static String getRunPath() {
        return System.getProperty("user.dir");
    }

}
