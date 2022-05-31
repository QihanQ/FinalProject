import java.awt.*;

public class Cannon extends Entities{
    public boolean isShooting = false;
    public Cannon(int x, int y)
    {
        super(x,y);
        hitBox = new Rectangle();
        hitBox.x = 8;
        hitBox.y = 16;
        hitBox.width = 32;
        hitBox.height = 32;
    }
}
