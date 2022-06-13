import javax.swing.*;

public class GameWindowInitializer {

    public GameWindowInitializer()
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Avoid the Cannon Ball Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.playMusic(0);
        gamePanel.startGameThread();
    }

}
