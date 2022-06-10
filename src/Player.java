import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entities {
    private GamePanel gp;
    private KeyControls key;
    private BufferedImage up1;
    private BufferedImage up2;
    private BufferedImage up3;
    private BufferedImage down1;
    private BufferedImage down2;
    private BufferedImage down3;
    private BufferedImage left1;
    private BufferedImage left2;
    private BufferedImage left3;
    private BufferedImage right1;
    private BufferedImage right2;
    private BufferedImage right3;
    public boolean isDead;

    public Player(GamePanel g, KeyControls k)
    {
        gp =g;
        key = k;
        direction = "down";
        getPlayerImage();
        xCoord = 384;
        yCoord = 384;
        speed = 5;
        hitBox = new Rectangle();
        hitBox.x = 8;
        hitBox.y = 16;
        hitBox.width = 32;
        hitBox.height = 32;
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(new File("PlayerSprites/u1.png"));
            up2 = ImageIO.read(new File("PlayerSprites/u2.png"));
            up3 = ImageIO.read(new File("PlayerSprites/u3.png"));
            down1 = ImageIO.read(new File("PlayerSprites/d1.png"));
            down2 = ImageIO.read(new File("PlayerSprites/d2.png"));
            down3 = ImageIO.read(new File("PlayerSprites/d3.png"));
            left1 = ImageIO.read(new File("PlayerSprites/l1.png"));
            left2 = ImageIO.read(new File("PlayerSprites/l2.png"));
            left3 = ImageIO.read(new File("PlayerSprites/l3.png"));
            right1 = ImageIO.read(new File("PlayerSprites/r1.png"));
            right2 = ImageIO.read(new File("PlayerSprites/r2.png"));
            right3 = ImageIO.read(new File("PlayerSprites/r3.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update()
    {
        if(key.upPressed == true || key.downPressed == true || key.leftPressed == true || key.rightPressed == true)
        {
            if(key.upPressed)
            {
                direction = "up";
            }
            if(key.downPressed)
            {
                direction = "down";
            }
            if(key.leftPressed)
            {
                direction = "left";
            }
            if(key.rightPressed)
            {
                direction = "right";
            }

            collisionOn = false;
            gp.collisionChecker.checkTileCollision(this);

            if(collisionOn == false && !isDead)
            {
                switch(direction)
                {
                    case "up":
                    {
                        yCoord -= speed;
                        break;
                    }
                    case "down":
                    {
                        yCoord += speed;
                        break;
                    }
                    case "left":
                    {
                        xCoord -= speed;
                        break;
                    }
                    case "right":
                    {
                        xCoord += speed;
                        break;
                    }
                }
            }
            spriteCounter++;
            if(spriteCounter > 10)
            {
                if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if(spriteNum == 2)
                {
                    spriteNum = 3;
                }
                else
                {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        switch (direction) {
            case ("up") -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
            }
            case ("down") -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
            }
            case ("left") -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
            }
            case ("right") -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
            }
        }
        g2.drawImage(image, xCoord , yCoord, gp.TILE_SIZE, gp.TILE_SIZE , null);
    }
}
