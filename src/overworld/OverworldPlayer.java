package overworld;

import javafx.scene.image.Image;

import java.util.Objects;

public class OverworldPlayer {
    private int gridX;
    private int gridY;
    
    private final static int tileSize = 16;
    
    private Image sprite;
    
    private int lastDirection;
    
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
                lastDirection = 1;
                if(map.isWalkable((gridY - 1), gridX)) {
                    gridY--;
                } else {
                    break;
                }
                break;
            }
            case 2: {
                //DOWN
                lastDirection = 2;
                if(map.isWalkable((gridY + 1), gridX)) {
                    gridY++;
                } else {
                    break;
                }
                break;
            }
            case 3: {
                //LEFT
                lastDirection = 3;
                if(map.isWalkable(gridY, (gridX- 1))) {
                    gridX--;
                } else {
                    break;
                }
                break;
            }
            case 4: {
                //RIGHT
                lastDirection = 4;
                if(map.isWalkable(gridY, (gridX + 1 ))) {
                    gridX++;
                } else {
                    break;
                }
                break;
            }
        }
        
    }
    
    public Entity getNearbyEntity(GameMap map) {
        for (int i = 0; i < map.getEntities().size(); i++) {
            Entity entityToCheck = map.getEntities().get(i);
            
            if(entityToCheck.getGridX() == this.gridX && entityToCheck.getGridY() == this.gridY - 1) {
                return entityToCheck;
            } else  if(entityToCheck.getGridX() == this.gridX && entityToCheck.getGridY() == this.gridY + 1) {
                return entityToCheck;
            } else  if(entityToCheck.getGridX() == this.gridX - 1 && entityToCheck.getGridY() == this.gridY) {
                return entityToCheck;
            } else  if(entityToCheck.getGridX() == this.gridX + 1 && entityToCheck.getGridY() == this.gridY) {
                return entityToCheck;
            }
        }
        return null;
    }
    
    public Tile getNearbyInteractable(GameMap map) {
        
        Tile tileUp = map.getTile(gridY - 1, gridX);
        if(tileUp != null && tileUp.hasTrigger()) {
            return tileUp;
        }
        
        Tile tileDown = map.getTile(gridY + 1, gridX);
        if(tileDown != null && tileDown.hasTrigger()) {
            return tileDown;
        }
        
        Tile tileLeft = map.getTile(gridY, gridX - 1);
        if(tileLeft != null && tileLeft.hasTrigger()) {
            return tileLeft;
        }
        
        Tile tileRight = map.getTile(gridY, gridX + 1);
        if(tileRight != null && tileRight.hasTrigger()) {
            return tileRight;
        }
        
        
        return null;
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
