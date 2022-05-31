import java.awt.*;
import java.awt.image.BufferedImage;

public class Entities {
    public GamePanel gamePanel;
    public int xCoord;
    public int yCoord;
    public int speed;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle hitBox;
    public boolean collisionOn = false;

    public Entities()
    {

    }

    public Entities(int x , int y)
    {
        xCoord = x;
        yCoord = y;
    }
}
