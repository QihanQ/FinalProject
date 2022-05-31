public class CollisionChecker {
    private GamePanel gamePanel;
    public CollisionChecker(GamePanel gp)
    {
        gamePanel = gp;
    }
    public void checkTileCollision(Player player)
    {
        int leftHitboxX = player.xCoord + player.hitBox.x;
        int rightHitboxX = player.xCoord + player.hitBox.x + player.hitBox.width;
        int topHitboxY = player.yCoord + player.hitBox.y;
        int bottomHitboxY = player.yCoord + player.hitBox.y + player.hitBox.height;

        int playerLeftCol = leftHitboxX / gamePanel.TILE_SIZE;
        int playerRightCol = rightHitboxX / gamePanel.TILE_SIZE;
        int playerTopRow = topHitboxY / gamePanel.TILE_SIZE;
        int playerBottomRow = bottomHitboxY / gamePanel.TILE_SIZE;

        int tileNum1 , tileNum2;

        switch(player.direction)
        {
            case "up":
            {
                playerTopRow = (topHitboxY - player.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileManager.mapLayout[playerLeftCol][playerTopRow];
                tileNum2 = gamePanel.tileManager.mapLayout[playerRightCol][playerTopRow];
                if(gamePanel.tileManager.mapTiles[tileNum1].isCollidable == true || gamePanel.tileManager.mapTiles[tileNum2].isCollidable == true)
                {
                    player.collisionOn = true;
                }
                break;
            }
            case "down":
            {
                playerBottomRow = (bottomHitboxY + player.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileManager.mapLayout[playerLeftCol][playerBottomRow];
                tileNum2 = gamePanel.tileManager.mapLayout[playerRightCol][playerBottomRow];
                if(gamePanel.tileManager.mapTiles[tileNum1].isCollidable == true || gamePanel.tileManager.mapTiles[tileNum2].isCollidable == true)
                {
                    player.collisionOn = true;
                }
                break;
            }
            case "left":
            {
                playerLeftCol = (leftHitboxX - player.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileManager.mapLayout[playerLeftCol][playerTopRow];
                tileNum2 = gamePanel.tileManager.mapLayout[playerLeftCol][playerBottomRow];
                if(gamePanel.tileManager.mapTiles[tileNum1].isCollidable == true || gamePanel.tileManager.mapTiles[tileNum2].isCollidable == true)
                {
                    player.collisionOn = true;
                }
                break;
            }
            case "right":
            {
                playerRightCol = (rightHitboxX + player.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileManager.mapLayout[playerRightCol][playerTopRow];
                tileNum2 = gamePanel.tileManager.mapLayout[playerRightCol][playerBottomRow];
                if(gamePanel.tileManager.mapTiles[tileNum1].isCollidable == true || gamePanel.tileManager.mapTiles[tileNum2].isCollidable == true)
                {
                    player.collisionOn = true;
                }
                break;
            }
        }
    }

    public void checkProjectileCollision(Player player)
    {

    }
}
