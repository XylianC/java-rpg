package util;

import overworld.Tile;

public enum TileType {
    GRASS(0, "grassTile", true, false, TriggerType.NONE),
    GRASSSPAWN(1, "grassTileSpawn", true, true, TriggerType.START_BATTLE),
    TREE(2, "treeTile", false, false, TriggerType.NONE),
    
    DIRT(3,"dirtTile", true, false, TriggerType.NONE),
    BOULDER(4, "boulderTile", false, false, TriggerType.NONE),
    
    SAND(5, "sandTile",  true, false, TriggerType.NONE),
    WATER(6, "waterTile", false, false, TriggerType.NONE),
    
    TOWN(10,"townTile", true, true, TriggerType.OPEN_CHEST),
    CHEST(11,"chestTile", false, true, TriggerType.OPEN_CHEST);
    
    // Een interne variabele om extra data aan de enum te koppelen
    private final int tileCode;
    private final String tileName;
    private final boolean isWalkable;
    private final boolean hasTrigger;
    private final TriggerType triggerType;
    private final String spritepath;
    
    // Constructor voor de enum
    TileType(int tilecode, String tileName, boolean isWalkable, boolean hasTrigger, TriggerType triggerType) {
        this.tileCode = tilecode;
        this.tileName = tileName;
        this.isWalkable = isWalkable;
        this.hasTrigger = hasTrigger;
        this.triggerType = triggerType;
        this.spritepath = "/images/tiles/spr_" + tileName + ".png";
    }
    
    public String getName() {
        return tileName;
    }
    
    public int getTileCode() {
        return tileCode;
    }
    
    public boolean isWalkable() {
        return isWalkable;
    }
    
    public boolean hasTrigger() {
        return hasTrigger;
    }
    
    public TriggerType getTriggerType() {
        return triggerType;
    }
    
    public String getSpritepath() {
        return this.spritepath;
    }
    
    public static TileType getTileTypeFromCode(int input) {
        TileType[] typeToGive = TileType.values();
        for (int i = 0; i < typeToGive.length; i++) {
            if (typeToGive[i].tileCode == input) {
                return typeToGive[i];
            }
        }
        return null;
    }
}

