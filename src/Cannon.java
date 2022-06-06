import java.awt.*;

public class Cannon extends Entities{
    public boolean isShooting = false;
    public boolean cannonBallStillAlive = false;
    public boolean hitPlayer = false;
    public Cannon(int x, int y)
    {
        super(x,y);
        hitBox = new Rectangle(x, y, 32, 32);
    }
}
