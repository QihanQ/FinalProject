import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    public final int TILE_SIZE = 48;
    private final int SCREEN_COLS = 16;
    private final int SCREEN_ROWS = 12;
    private final int SCREEN_HEIGHT = SCREEN_ROWS * TILE_SIZE;
    private final int SCREEN_WIDTH = SCREEN_COLS * TILE_SIZE;
    private Thread gameThread;
    private KeyControls keyControl;
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 4;
    private final int FPS = 60;
    private Player player;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setDoubleBuffered(true);

        keyControl = new KeyControls();
        this.addKeyListener(keyControl);
        this.setFocusable(true);

        player = new Player(this, keyControl);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null)
        {
            update();

            repaint();
            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update()
    {
        player.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D graphic = (Graphics2D)g;

        player.draw(graphic);

        graphic.dispose();
    }
}
