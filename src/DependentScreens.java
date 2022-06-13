import java.awt.*;
import java.io.*;
import java.nio.file.Files;

public class DependentScreens {
    private GamePanel gamePanel;
    public Font lorjuk;
    public int optionNumber;

    public DependentScreens(GamePanel gp)
    {
        gamePanel = gp;
        InitializeFont();
    }

    public void InitializeFont(){
        try{
            InputStream is = new FileInputStream("Font/Lorjuk.ttf");
            lorjuk = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }
    public void drawTitleScreen(Graphics2D g)
    {
        g.setFont(lorjuk.deriveFont(Font.BOLD,77F));
        String text = "Dodge The Cannon Balls!";
        int x = 30;
        int y = gamePanel.TILE_SIZE * 3;

        g.setColor(Color.gray);
        g.drawString(text, x + 2, y+5);

        g.setColor(Color.white);
        g.drawString(text, x, y);


        x = gamePanel.SCREEN_WIDTH / 2 - (gamePanel.TILE_SIZE * 4) / 2 - 15;
        y += gamePanel.TILE_SIZE * 2;
        g.drawImage(gamePanel.player.down1, x , y, gamePanel.TILE_SIZE * 4, gamePanel.TILE_SIZE * 4, null);

        g.setFont(lorjuk.deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = gamePanel.SCREEN_WIDTH / 3;
        y += gamePanel.TILE_SIZE * 6;
        g.drawString(text, x, y);
        if(optionNumber == 0)
        {
            g.drawString(">", x - gamePanel.TILE_SIZE, y - 8);
        }

        text = "QUIT";
        x = gamePanel.SCREEN_WIDTH / 2 - gamePanel.TILE_SIZE - 21;
        y += gamePanel.TILE_SIZE + 10;
        g.drawString(text, x, y);
        if(optionNumber == 1)
        {
            g.drawString(">", x - gamePanel.TILE_SIZE, y - 8);
        }
    }

    public void drawGameOverScreen(Graphics2D g)
    {
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);

        int x;
        int y;
        String text;
        g.setFont(lorjuk.deriveFont(Font.BOLD, 100f));

        text = "GAME OVER!";
        g.setColor(Color.WHITE);
        x = 110;
        y = gamePanel.TILE_SIZE * 4;
        g.drawString(text, x, y);

        y += gamePanel.TILE_SIZE * 3;
        g.setFont(lorjuk.deriveFont(50f));
        g.setColor(Color.WHITE);
        g.drawString("Time: " + gamePanel.timeSurvived, x + gamePanel.TILE_SIZE * 2  - 4, y);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("timeSurvived.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        if(gamePanel.keyControl.timeSurvived.length() > 0) {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            y += gamePanel.TILE_SIZE;
            g.drawString("Prev Time: " + line, x + gamePanel.TILE_SIZE * 2, y);
        }
        else
        {
            y += gamePanel.TILE_SIZE;
            g.drawString("Prev Time: NONE" , x + gamePanel.TILE_SIZE * 2, y);
        }

        g.setFont(lorjuk.deriveFont(50f));

        text = "RETRY";
        x = gamePanel.SCREEN_WIDTH / 2 - gamePanel.TILE_SIZE - 32;
        y += gamePanel.TILE_SIZE * 6;
        g.drawString(text, x, y);
        if(optionNumber == 0)
        {
            g.drawString(">", x - 40, y - 8);
        }
        text = "QUIT";
        x = gamePanel.SCREEN_WIDTH / 2 - gamePanel.TILE_SIZE - 16;
        y += 55;
        g.drawString(text, x, y);
        if(optionNumber == 1)
        {
            g.drawString(">", x - 40, y - 8);
        }
    }

    public void restartGame()
    {
        gamePanel.playTime = 0;
        gamePanel.playMusic(0);
        gamePanel.player.xCoord = 336;
        gamePanel.player.yCoord = 520;
        gamePanel.cannonProjectile.initializeCannons();
    }
}
