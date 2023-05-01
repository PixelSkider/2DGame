import javax.swing.*;
import java.awt.*;

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
    public Main(){
        panel = new JPanel();
        panel.setSize(screen_w,screen_h);
        add(panel);
        setVisible(true);
        setSize(screen_w,screen_h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);

        Graphics g = this.getRootPane().getGraphics();
        g.setColor(Color.YELLOW);
        g.drawString("test",50,50);
    }

    public static void main(String[] args) {
        new Main();
    }
}
