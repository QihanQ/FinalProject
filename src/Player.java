import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Characters{
    private GamePanel gp;
    private KeyControls key;

    public Player(GamePanel g , KeyControls k)
    {
        gp = g;
        key = k;
        y = 100;
        x = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/PlayerSprite/right2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update()
    {
        if(key.upPressed == true)
        {
            direction = "up";
            y -= speed;
        }
        if(key.downPressed == true)
        {
            direction = "down";
            y += speed;
        }
        if(key.leftPressed == true)
        {
            direction = "left";
            x -= speed;
        }
        if(key.rightPressed == true)
        {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        switch(direction)
        {
            case("up"):
                image = up1;
                break;
            case("down"):
                image = up1;
                break;
            case("left"):
                image = up1;
                break;
            case("right"):
                image = up1;
                break;

        }
    }
}
