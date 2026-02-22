package domain;

public abstract class Combatant {
    // -- Attributen -- //
    // Combatant is shortened to CMT
    
    private final String name;
    
    private int level;
    
    private int strength;
    private int intelligence;
    
    private int hp;
    private int maxHP;
    
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SKILL_LEVEL = 1;
    
    
    // -- Constructors -- //
    public Combatant(String name, int lvl, int str, int intel, int hp, int maxhp) {
        checkName(name);
        this.name = name;
        
        setLevel(lvl);
        setStrength(str);
        setIntelligence(intel);
        
        setHp(hp);
        setMaxHP(maxhp);
    }
    
    public Combatant(String name, int lvl, int str, int intel) {
        checkName(name);
        this.name = name;
        
        setLevel(lvl);
        setStrength(str);
        setIntelligence(intel);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
    
    public Combatant(String name) {
        checkName(name);
        this.name = name;
        
        setLevel(DEFAULT_SKILL_LEVEL);
        setStrength(DEFAULT_SKILL_LEVEL);
        setIntelligence(DEFAULT_SKILL_LEVEL);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
    
    // -- Getters -- //
    public String getName() {
        return name;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getStrength() {
        return strength;
    }
    
    public int getIntelligence() {
        return intelligence;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getMaxHP() {
        return maxHP;
    }
    
    // ---- Setters ---- //
    
    public void setLevel(int lvl) {
        this.level = lvl;
    }
    
    public void setStrength(int str) {
        this.strength = str;
    }
    
    public void setIntelligence(int intel) {
        this.intelligence = intel;
    }
    
    public void setHp(int hp) {
        if(hp >= 0) {
            this.hp = hp;
        } else {
            throw new IllegalArgumentException("Character HP can not be below 0!");
        }
    }
    
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    
    // -- Class Specific Methods  -- //
    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Combatant name can not be empty or null");
        }
    }
}

