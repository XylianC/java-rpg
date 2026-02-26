package overworld;

import util.TileType;
import util.TriggerType;

import javafx.scene.image.Image;


public class Tile {
    private final String tileName;
    private final int tileCode;
    
    private final TileType tileType;
    private final boolean isWalkable;
    
    private final boolean hasTrigger;
    private final TriggerType triggerType;
    
    private final Image sprite;
    
    
    
    
    
    ///  --- Setters --- ///
    public Tile(String tileName, int tileCode, boolean isWalkable, boolean hasTrigger, TileType tileType, TriggerType triggerType, Image sprite) {
        this.tileName = tileName;
        this.tileCode = tileCode;
        this.isWalkable = isWalkable;
        
        this.hasTrigger = hasTrigger;
        this.tileType = tileType;
        this.triggerType = triggerType;
        this.sprite = sprite;
    }
    
    /// --- Getters --- ///
    public String getTileName() {
        return this.tileName;
    }
    
    public int getTileCode() {
        return this.tileCode;
    }
    
    public boolean isWalkable() {
        return this.isWalkable;
    }
    
    public boolean hasTrigger() {
        return this.hasTrigger;
    }
    
    public TileType getTileType() {
        return this.tileType;
    }
    
    public TriggerType getTriggerType() {
        return this.triggerType;
    }
    
    public Image getSprite() { return this.sprite; }
    
    /// --- TileMethods --- ///
    
}
