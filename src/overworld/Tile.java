package overworld;

import util.TileType;
import util.TriggerType;

import javafx.scene.image.Image;

import java.util.Objects;


public class Tile {
    private final String tileName;
    private final int tileCode;
    
    private final TileType tileType;
    private final boolean isWalkable;
    
    private final boolean hasTrigger;
    private final TriggerType triggerType;
    
    private Image sprite;
    
    public Tile(TileType tileType) {
        this.tileName = tileType.getName();
        this.tileCode = tileType.getTileCode();
        
        this.tileType = tileType;
        this.isWalkable = tileType.isWalkable();
        
        this.hasTrigger = tileType.hasTrigger();
        this.triggerType = tileType.getTriggerType();
        
        this.sprite = new Image(Objects.requireNonNull(getClass().getResourceAsStream(tileType.getSpritepath())));
    }
    
    /// --- Setters --- ///
    public void setTileSprite(Image sprite) {
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
