package overworld;

public class OverworldPlayer {
    private int gridX;
    private int gridY;
    
    private final static int tileSize = 16;
    
    public OverworldPlayer(int gridY, int gridX) {
        this.gridY = gridY;
        this.gridX = gridX;
    }
    
    public void move(int direction, GameMap map) {
        // movement code;
        switch (direction) {
            case 1: {
                //UP
                if(map.isWalkable((gridY - 1), gridX)) {
                    gridY--;
                } else {
                    break;
                }
                break;
            }
            case 2: {
                //DOWN
                if(map.isWalkable((gridY + 1), gridX)) {
                    gridY++;
                } else {
                    break;
                }
                break;
            }
            case 3: {
                //LEFT
                if(map.isWalkable(gridY, (gridX- 1))) {
                    gridX--;
                } else {
                    break;
                }
                break;
            }
            case 4: {
                //RIGHT
                if(map.isWalkable(gridY, (gridX + 1 ))) {
                    gridX++;
                } else {
                    break;
                }
                break;
            }
        }
        
    }
    
    public int getGridX() {
        return gridX;
    }
    
    public int getGridY() {
        return gridY;
    }
    
    public int getPixelX() {
        return gridX * tileSize;
    }
    
    public int getPixelY() {
        return gridY * tileSize;
    }
}
