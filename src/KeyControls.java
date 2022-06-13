import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;

public class KeyControls implements KeyListener {
    private GamePanel gamePanel;
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public FileWriter fileWriter;
    public File timeSurvived = new File("timeSurvived.txt");

    public KeyControls(GamePanel gp)
    {
        gamePanel = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(gamePanel.onTitleScreen)
        {
            onTitleScreen(keyCode);
        }

        if(gamePanel.onGameOverScreen) {

            onGameOverScreen(keyCode);
        }

        if(keyCode == KeyEvent.VK_W)
        {
            upPressed = true;
        }
        if(keyCode == KeyEvent.VK_S)
        {
            downPressed = true;
        }
        if(keyCode == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        if(keyCode == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if(keyCode == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if(keyCode == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if(keyCode == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
    }

    public void onTitleScreen(int keyCode)
    {
        if(keyCode == KeyEvent.VK_W)
        {
            gamePanel.dependentScreens.optionNumber--;
            if(gamePanel.dependentScreens.optionNumber < 0)
            {
                gamePanel.dependentScreens.optionNumber = 1;
            }
        }
        if(keyCode == KeyEvent.VK_S)
        {
            gamePanel.dependentScreens.optionNumber++;
            if(gamePanel.dependentScreens.optionNumber > 1)
            {
                gamePanel.dependentScreens.optionNumber = 0;
            }
        }
        if(keyCode == KeyEvent.VK_ENTER)
        {
            gamePanel.stopMusic();
            if(gamePanel.dependentScreens.optionNumber == 0)
            {
                gamePanel.playMusic(1);
                gamePanel.onTitleScreen = false;
            }
            if(gamePanel.dependentScreens.optionNumber == 1)
            {
                try {
                    timeSurvived = new File("timeSurvived.txt");
                    fileWriter = new FileWriter(timeSurvived, false);
                    if(gamePanel.playTime > 0)
                    {
                        fileWriter.write(gamePanel.timeSurvived);
                    }
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }

    public void onGameOverScreen(int keyCode)
    {
        if(keyCode == KeyEvent.VK_W)
        {
            gamePanel.dependentScreens.optionNumber--;
            if(gamePanel.dependentScreens.optionNumber < 0)
            {
                gamePanel.dependentScreens.optionNumber = 1;
            }
        }
        if(keyCode == KeyEvent.VK_S)
        {
            gamePanel.dependentScreens.optionNumber++;
            if(gamePanel.dependentScreens.optionNumber > 1)
            {
                gamePanel.dependentScreens.optionNumber = 0;
            }
        }
        if(keyCode == KeyEvent.VK_ENTER)
        {
            if(gamePanel.dependentScreens.optionNumber == 0)
            {
                try {
                    timeSurvived = new File("timeSurvived.txt");
                    fileWriter = new FileWriter(timeSurvived, false);
                    fileWriter.write(gamePanel.timeSurvived);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gamePanel.onGameOverScreen = false;
                gamePanel.onTitleScreen = true;
                gamePanel.dependentScreens.restartGame();
                gamePanel.gameOver = false;
                gamePanel.player.isDead = false;
            }
            if(gamePanel.dependentScreens.optionNumber == 1)
            {
                try {
                    timeSurvived = new File("timeSurvived.txt");
                    fileWriter = new FileWriter(timeSurvived, false);
                    fileWriter.write(gamePanel.timeSurvived);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }
}
