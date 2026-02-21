package domain;

public class PlayerCharacter {
    // -- Attributen -- //
    private final String charName;
    private final String charClass;
    
    private int charLevel;
    private int exp;
    private int expToNextLevel;
    
    private int charStrength;
    private int charIntelligence;
    
    private int hp;
    private int maxHP;
    
    private static final String DEFAULT_CLASS = "Mage";
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SKILL_LEVEL = 1;
    
    
    // -- Constructors -- //
    
    public PlayerCharacter(String name, String job, int lvl, int str, int intel) {
        checkName(name);
        this.charName = name;
        this.charClass = job;
        
        setCharLevel(lvl);
        setCharStrength(str);
        setCharIntelligence(intel);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
    
    public PlayerCharacter(String name, String job) {
        checkName(name);
        this.charName = name;
        checkJob(job);
        this.charClass = job;
        
        setCharLevel(DEFAULT_SKILL_LEVEL);
        setCharStrength(DEFAULT_SKILL_LEVEL);
        setCharIntelligence(DEFAULT_SKILL_LEVEL);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
    
    public PlayerCharacter(String name) {
        checkName(name);
        this.charName = name;
        this.charClass = DEFAULT_CLASS;
        
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
    
    public String getCharClass() {
        return charClass;
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
        if(hp >= 0) {
            this.hp = hp;
        } else {
            throw new IllegalArgumentException("Character HP can not be below 0!");
        }
    }
    
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    
    // -- Andere Methoden -- //
    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Character name can not be null!");
        }
    }
    
    private void checkJob(String job) {
        if (job == null || job.isBlank()) {
            throw new IllegalArgumentException("Character job name can not be null!");
        }
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
        return String.format("Character: %s Class: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ",getCharName(), getCharClass(), getHp(), getMaxHP(), getCharLevel(), getCharStrength(), getCharIntelligence());
    }
}
