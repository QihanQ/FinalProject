import java.awt.*;
import java.awt.image.BufferedImage;

public class Characters {
    public int x;
    public int y;
    public int speed;
    public BufferedImage up1;
    public BufferedImage up2;
    public BufferedImage up3;
    public BufferedImage down1;
    public BufferedImage down2;
    public BufferedImage down3;
    public BufferedImage left1;
    public BufferedImage left2;
    public BufferedImage left3;
    public BufferedImage right1;
    public BufferedImage right2;
    public BufferedImage right3;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle hitBox;
    public boolean collisionOn = false;
}
