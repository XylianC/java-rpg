package util;

public enum Classes {
    KNIGHT("Knight", 3, 1, 20, 5),
    MAGE("Mage", 1, 3, 15, 20),
    MONK("Monk", 2, 2, 30, 25),
    SCHOLAR("Scholar", 0, 4, 5, 50),
    WARRIOR("Warrior", 5, 3, 30, 5);
    
    
    // Een interne variabele om extra data aan de enum te koppelen
    private final String displayName;
    private final int baseStr;
    private final int baseIntel;
    private final int baseHp;
    private final int baseMp;
    
    // Constructor voor de enum
    Classes(String displayName, int baseStr, int baseIntel, int baseHp, int baseMp) {
        this.displayName = displayName;
        this.baseStr = baseStr;
        this.baseIntel = baseIntel;
        this.baseHp = baseHp;
        this.baseMp = baseMp;
    }
    
    // Methode om de displayname op te vragen
    public String getDisplayName() {
        return displayName;
    }
    public int getBaseStr() { return baseStr; }
    public int getBaseIntel() { return baseIntel; }
    public int getBaseHP() { return baseHp; }
    public int getBaseMP() { return baseMp; }
}
