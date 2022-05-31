import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    private GamePanel gamePanel;

    public BackgroundTile[] mapTiles;
    public int[][] mapLayout;

    public TileManager(GamePanel gp)
    {
        gamePanel = gp;
        mapTiles = new BackgroundTile[3];
        mapLayout = new int[gamePanel.SCREEN_ROWS][gamePanel.SCREEN_COLS];
        getTileImage();
        drawMap();
    }

    public void getTileImage()
    {
        try{
            mapTiles[0] = new BackgroundTile();
            mapTiles[0].tileImage = ImageIO.read(new File("Tiles/dirt (2).png"));
            mapTiles[1] = new BackgroundTile();
            mapTiles[1].tileImage = ImageIO.read(new File("Tiles/tree1.png"));
            mapTiles[1].isCollidable = true;
            mapTiles[2] = new BackgroundTile();
            mapTiles[2].tileImage = ImageIO.read(new File("Tiles/cannon2.png"));
            mapTiles[2].isCollidable = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMap()
    {
        try
        {
            InputStream inputStream = new FileInputStream("Map/map.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            for(int r = 0; r < gamePanel.SCREEN_ROWS; r++)
            {
                String line = bufferedReader.readLine();
                for(int c = 0; c < gamePanel.SCREEN_COLS; c++)
                {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[c]);
                    mapLayout[r][c] = num;
                }
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2)
    {
        for(int row = 0; row < gamePanel.SCREEN_ROWS; row++)
        {
            for(int col = 0; col < gamePanel.SCREEN_COLS; col++)
            {
                int tileNum = mapLayout[row][col];
                g2.drawImage(mapTiles[tileNum].tileImage, col * gamePanel.TILE_SIZE, row * gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            }
        }
    }

}
