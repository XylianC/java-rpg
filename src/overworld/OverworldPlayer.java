package overworld;

import javafx.scene.image.Image;

import java.util.Objects;

public class OverworldPlayer {
    private int gridX;
    private int gridY;
    
    private final static int tileSize = 16;
    
    private Image sprite;
    
    public OverworldPlayer(int gridY, int gridX) {
        this.gridY = gridY;
        this.gridX = gridX;
        
        this.sprite = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sprites/spr_knight.png")));
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
    
    public Image getSprite() {
        return sprite;
    }
}
