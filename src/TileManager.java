import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tile;

    public TileManager(GamePanel gp)
    {
        gamePanel = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage()
    {
        try{
            tile[0] = new Tile();
            tile[0].tileImage = ImageIO.read(new File("Tiles/floor.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2)
    {
        for(int row = 0; row < gamePanel.SCREEN_ROWS; row++)
        {
            for(int col = 0; col < gamePanel.SCREEN_COLS; col++)
            {
                g2.drawImage(tile[0].tileImage, row * gamePanel.TILE_SIZE, col * gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            }
        }
    }

}
