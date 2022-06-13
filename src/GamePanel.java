import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class GamePanel extends JPanel implements Runnable{
    public final int TILE_SIZE = 48;
    public final int SCREEN_COLS = 16;
    public final int SCREEN_ROWS = 16;
    public final int SCREEN_HEIGHT = SCREEN_ROWS * TILE_SIZE;
    public final int SCREEN_WIDTH = SCREEN_COLS * TILE_SIZE;
    private final int FPS = 60;
    public double playTime;
    public String timeSurvived;
    private Thread gameThread;
    public KeyControls keyControl;
    public Player player;
    public TileManager tileManager;
    public CollisionChecker collisionChecker;
    public CannonProjectile cannonProjectile;
    public DependentScreens dependentScreens;
    public SoundManager soundManager;

    public boolean onTitleScreen = true;
    public boolean gameOver = false;
    public boolean onGameOverScreen = false;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        keyControl = new KeyControls(this);
        this.addKeyListener(keyControl);
        this.setFocusable(true);

        player = new Player(this, keyControl);

        tileManager = new TileManager(this);

        collisionChecker = new CollisionChecker(this);

        cannonProjectile = new CannonProjectile(this);

        dependentScreens = new DependentScreens(this);

        soundManager = new SoundManager();
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
        cannonProjectile.upDateCannonBall();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D graphic = (Graphics2D)g;
        super.paintComponent(g);
        if(!onTitleScreen)
        {
            tileManager.drawTiles(graphic);

            player.draw(graphic);

            cannonProjectile.DrawCannonBall(graphic);

            timer(graphic);

            if(onGameOverScreen != true)
            {
                graphic.dispose();
            }
            if(gameOver)
            {
                stopMusic();
                dependentScreens.drawGameOverScreen(graphic);
                onGameOverScreen = true;
            }
        }
        else
        {
            dependentScreens.drawTitleScreen(graphic);
        }
    }

    public void playMusic(int i)
    {
        soundManager.setFile(i);
        soundManager.play();
        soundManager.loop();
    }

    public void stopMusic()
    {
        soundManager.stop();
    }

    public void timer(Graphics2D graphic)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        if(!gameOver)
        {
            playTime += (double) 1 / 60;
        }
        timeSurvived = df.format(playTime);
        graphic.setFont(dependentScreens.lorjuk.deriveFont(Font.BOLD,30F));
        graphic.setColor(Color.BLACK);

        graphic.drawString("Time: " + timeSurvived, TILE_SIZE * 13 - 32, 74);
    }
}
