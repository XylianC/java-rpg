package persistence;

public enum Elements {
    NORMAL("Normal", "None"),
    FIRE("Fire", "Water"),
    ICE("Ice", "Fire"),
    ELECTRIC("Electric", "Ice"),
    DARK("Dark", "Light"),
    LIGHT("Light", "Dark");
    
    // Een interne variabele om extra data aan de enum te koppelen
    private final String displayName;
    private final String weakness;
    
    // Constructor voor de enum
    Elements(String displayName, String weakness) {
        this.displayName = displayName;
        this.weakness = weakness;
    }
    
    // Methode om de zwakte op te vragen
    public String getWeakness() {
        return weakness;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
