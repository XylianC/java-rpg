package util;

import overworld.Tile;

public enum TileType {
    GRASS(0, "grassTile", true, false, TriggerType.NONE),
    DIRT(1,"dirtTile", true, false, TriggerType.NONE),
    SAND(2, "sandTile",  true, false, TriggerType.NONE),
    WATER(3, "waterTile", false, false, TriggerType.NONE),
    TOWN(4,"townTile", true, true, TriggerType.OPEN_CHEST),
    CHEST(5,"chestTile", false, true, TriggerType.OPEN_CHEST);
    
    // Een interne variabele om extra data aan de enum te koppelen
    private final int tileCode;
    private final String tileName;
    private final boolean isWalkable;
    private final boolean hasTrigger;
    private final TriggerType triggerType;
    
    // Constructor voor de enum
    TileType(int tilecode, String tileName, boolean isWalkable, boolean hasTrigger, TriggerType triggerType) {
        this.tileCode = tilecode;
        this.tileName = tileName;
        this.isWalkable = isWalkable;
        this.hasTrigger = hasTrigger;
        this.triggerType = triggerType;
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

