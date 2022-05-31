import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CannonProjectile extends Entities {
    private BufferedImage cannonBall;
    private GamePanel gamePanel;
    private Cannon[] cannons;
    private int cannonBallSpeed;
    public CannonProjectile(GamePanel gp) {
        gamePanel = gp;
        getCannonBallImage();
        direction = "down";
        initializeCannons();
        cannonBallSpeed = 4;
    }

    public void initializeCannons()
    {
        cannons = new Cannon[14];
        cannons[0] = new Cannon(48, 32);
        cannons[1] = new Cannon(48 + 48 * 1, 32);
        cannons[2] = new Cannon(48 + 48 * 2, 32);
        cannons[3] = new Cannon(48 + 48 * 3, 32);
        cannons[4] = new Cannon(48 + 48 * 4, 32);
        cannons[5] = new Cannon(48 + 48 * 5, 32);
        cannons[6] = new Cannon(48 + 48 * 6, 32);
        cannons[7] = new Cannon(48 + 48 * 7, 32);
        cannons[8] = new Cannon(48 + 48 * 8, 32);
        cannons[9] = new Cannon(48 + 48 * 9, 32);
        cannons[10] = new Cannon(48 + 48 * 10, 32);
        cannons[11] = new Cannon(48 + 48 * 11, 32);
        cannons[12] = new Cannon(48 + 48 * 12, 32);
        cannons[13] = new Cannon(48 + 48 * 13, 32);
    }
    public void getCannonBallImage() {
        try {
            cannonBall = ImageIO.read(new File("Projectile/cannonProjectile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upDateCannonBall() {
        switch(direction)
        {
            case "down":
            {
                for(int n = 0; n < cannons.length; n++)
                {
                    cannons[n].yCoord += cannonBallSpeed;
                    if(cannons[n].yCoord + cannonBallSpeed > gamePanel.TILE_SIZE * 15 - 20)
                    {
                        cannons[n].yCoord = 32;
                    }
                }
                break;
            }
        }
    }

    public void DrawCannonBall(Graphics2D g2)
    {
        for(int n = 0; n < cannons.length; n++)
        {
            g2.drawImage(cannonBall, cannons[n].xCoord, cannons[n].yCoord, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}