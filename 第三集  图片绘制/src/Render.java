import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Layiur!!!
 * @create: 2023/5/1
 * @Description:
 * @FileName: Render
 * @History:
 */
public class Render {
    static Files files = new Files();

    public static Font loadFont(String fontFileName, float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File(files.getPath() + "\\resource\\font\\" + fontFileName + ".ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font font1 = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font font2 = font1.deriveFont(fontSize);
            aixing.close();
            return font2;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            return new java.awt.Font("宋体", Font.PLAIN, 12);
        }
    }

    public static void drawImg(Graphics graphics,String imgName,int x,int y) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(files.getPath() + "\\resource\\img\\" + imgName + ".png"));
        graphics.drawImage(bufferedImage,x,y,null);
    }

    public static void drawImg(Graphics graphics,String imgName,int x,int y,int widh,int height) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(files.getPath() + "\\resource\\img\\" + imgName + ".png"));
        graphics.drawImage(bufferedImage,x,y,widh,height,null);
    }

    public static void drawString(Graphics graphics,Color color,String text,int x,int y,Font font){
        if (color == null){
            color = Color.BLACK;
        }

        if (font == null){
            font = new Font("宋体",Font.PLAIN,20);
        }

        graphics.setColor(color);
        graphics.setFont(font);
        graphics.drawString(text,x,y);


    }
}
