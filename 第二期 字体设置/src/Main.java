import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: Layiur!!!
 * @create: 2023/5/1
 * @Description:
 * @FileName: Main
 * @History:
 */
public class Main extends JFrame {
    //窗口的基本数据~
    int screen_w = 800,screen_h = 500;
    //创建一个Panel~
    JPanel panel;
    public Main() throws IOException {
        panel = new JPanel();
        panel.setSize(screen_w,screen_h);
        add(panel);
        setVisible(true);
        setSize(screen_w,screen_h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);

        Font font = Render.loadFont("Light",40);
        Graphics g = panel.getRootPane().getGraphics();
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Layiur sum gang!!!!",60,60);



    }


    public static void main(String[] args) throws IOException {
        new Main();
    }


}
