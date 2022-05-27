public class CollisionChecker {
    GamePanel gamePanel;
    public CollisionChecker(GamePanel gp)
    {
        gamePanel = gp;
    }
    public void checkTile(Player player)
    {
        int leftHitboxX = player.x + player.hitBox.x;
        int rightHitboxX = player.x + player.hitBox.x + player.hitBox.width;
        int topHitboxY = player.y + player.hitBox.y;
        int bottomHitboxY = player.y + player.hitBox.y + player.hitBox.height;

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
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
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
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
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
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
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
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    player.collisionOn = true;
                }
                break;
            }
        }
    }
}
