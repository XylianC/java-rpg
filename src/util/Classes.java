package util;

public enum Classes {
    KNIGHT("Knight"),
    MAGE("Mage"),
    MONK("Monk"),
    SCHOLAR("Scholar"),
    WARRIOR("Warrior");
    
    
    // Een interne variabele om extra data aan de enum te koppelen
    private final String displayName;
    
    // Constructor voor de enum
    Classes(String displayName) {
        this.displayName = displayName;
    }
    
    // Methode om de displayname op te vragen
    public String getDisplayName() {
        return displayName;
    }
}
