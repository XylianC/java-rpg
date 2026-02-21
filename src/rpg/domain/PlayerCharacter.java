package rpg.domain;

public class PlayerCharacter {
    // -- Attributen -- //
    private final String charName;
    
    private int charLevel;
    private int exp;
    private int expToNextLevel;
    
    private int charStrength;
    private int charIntelligence;
    
    private int hp;
    private int maxHP;
    
    
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SKILL_LEVEL = 1;
    
    
    // -- Constructors -- //
    
    public PlayerCharacter(String name, int lvl, int str, int intel) {
        checkName(name);
        this.charName = name;
        
        setCharLevel(lvl);
        setCharStrength(str);
        setCharIntelligence(intel);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
    
    public PlayerCharacter(String name) {
        checkName(name);
        this.charName = name;
        
        setCharLevel(DEFAULT_SKILL_LEVEL);
        setCharStrength(DEFAULT_SKILL_LEVEL);
        setCharIntelligence(DEFAULT_SKILL_LEVEL);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
    
    
    // -- Getters -- //
    public String getCharName() {
        return charName;
    }
    
    public int getCharLevel() {
        return charLevel;
    }
    
    public int getExp() {
        return exp;
    }
    
    public int getExpToNextLevel() {
        return expToNextLevel;
    }
    
    public int getCharStrength() {
        return charStrength;
    }
    
    public int getCharIntelligence() {
        return charIntelligence;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getMaxHP() {
        return maxHP;
    }
    
    // -- Setters -- //
    public void setCharLevel(int charLevel) {
        this.charLevel = charLevel;
    }
    
    public void setCharStrength(int charStrength) {
        this.charStrength = charStrength;
    }
    
    public void setCharIntelligence(int charIntelligence) {
        this.charIntelligence = charIntelligence;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    
    // -- Andere Methoden -- //
    private void checkName(String name) {
    
    }
    
    
    public void levelUp() {
        //todo: implement better method of levelling up, make it more advancedd.
        //todo: add proper way of increasing the stats per level gained.
        this.charLevel++;
    }
    
    public void addExp(int amount) {
        this.exp += amount;
    }
    
    @Override
    public String toString() {
        return String.format("Character: %s%n-Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ",getCharName(), getHp(), getMaxHP(), getCharLevel(), getCharStrength(), getCharIntelligence());
    }
}
