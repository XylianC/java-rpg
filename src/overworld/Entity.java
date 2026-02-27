package overworld;

import javafx.scene.image.Image;

import java.util.Objects;

public class Entity {
    private int gridX;
    private int gridY;
    
    private final String entityName;
    
    private final static int tileSize = 16;
    
    private Image sprite;
    
    public Entity(int gridX, int gridY, String entityName, String spriteName) {
        this.gridX = gridX;
        this.gridY = gridY;
        this.entityName = entityName;
        
        this.sprite = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sprites/npcs/spr_" + spriteName + ".png")));
        
        
    }
    
    public String getEntityName() {
        return entityName;
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
