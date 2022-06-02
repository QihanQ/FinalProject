import java.awt.*;

public class Cannon extends Entities{
    public boolean isShooting = false;
    public boolean cannonBallStillAlive = false;
    public Cannon(int x, int y)
    {
        super(x,y);
        hitBox = new Rectangle();
    }
}
