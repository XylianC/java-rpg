package domain;

import java.util.ArrayList;

public abstract class Combatant {
    // -- Attributen -- //
    // Combatant is shortened to CMT
    
    private final String name;
    
    private int level;
    
    private final int baseSTR;
    private final int baseINTEL;
    
    private final int baseHp;
    private final int baseMp;
    
    private int strength;
    private int intelligence;
    
    private int mp;
    private int maxMp;
    
    private int hp;
    private int maxHP;
    
    private boolean isAlive = true;
    
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_MP = 10;
    private static final int DEFAULT_SKILL_LEVEL = 1;
    
    private static final int MINIMUM_ACC_FOR_SUCCES = 100;
    
    
    // -- Constructors -- //
    public Combatant(String name, int str, int intel, int hp, int mp, int lvl) {
        checkName(name);
        this.name = name;
        
        setLevel(lvl);
        this.baseSTR = str;
        this.baseINTEL = intel;
        this.baseHp = hp;
        this.baseMp = mp;
        
        setStrength(calculateStats(baseSTR));
        setIntelligence(calculateStats(baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
    }
    
    public Combatant(String name, int str, int intel, int hp, int mp) {
        checkName(name);
        this.name = name;
        
        setLevel(DEFAULT_SKILL_LEVEL);
        this.baseSTR = str;
        this.baseINTEL = intel;
        this.baseHp = hp;
        this.baseMp = mp;
        
        setStrength(calculateStats(baseSTR));
        setIntelligence(calculateStats(baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
    }
    
    public Combatant(String name, int lvl, int str, int intel) {
        checkName(name);
        this.name = name;
        
        setLevel(lvl);
        this.baseSTR = str;
        this.baseINTEL = intel;
        this.baseHp = DEFAULT_HP;
        this.baseMp = DEFAULT_MP;
        
        setStrength(calculateStats(baseSTR));
        setIntelligence(calculateStats(baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
    }
    
    
    public Combatant(String name) {
        checkName(name);
        this.name = name;
        
        setLevel(DEFAULT_SKILL_LEVEL);
        this.baseSTR = DEFAULT_SKILL_LEVEL;
        this.baseINTEL = DEFAULT_SKILL_LEVEL;
        this.baseHp = DEFAULT_HP;
        this.baseMp = DEFAULT_MP;
        
        setStrength(calculateStats(baseSTR));
        setIntelligence(calculateStats(baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
    }
    
    public Combatant(Combatant original, int level) {
        this.name = original.getName();
        
        this.setLevel(level);
        this.baseSTR = original.baseSTR;
        this.baseINTEL = original.baseINTEL;
        this.baseHp = original.baseHp;
        this.baseMp = original.baseMp;
        
        
        setStrength(calculateStats(this.baseSTR));
        setIntelligence(calculateStats(this.baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
    }
    
    public Combatant(Combatant original) {
        this.name = original.getName();
        
        this.level = original.getLevel();
        this.baseSTR = original.baseSTR;
        this.baseINTEL = original.baseINTEL;
        this.baseHp = original.baseHp;
        this.baseMp = original.baseMp;
        
        
        setStrength(calculateStats(this.baseSTR));
        setIntelligence(calculateStats(this.baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
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
    
    public int getMp() {return mp;}
    
    public int getMaxMp() {return maxMp;}
    
    public boolean isAlive() {return isAlive;}
    
    
    // ---- Setters ---- //
    public void resetStats() {
        setStrength(calculateStats(baseSTR));
        setIntelligence(calculateStats(baseINTEL));
        
        setMaxMP(calculateMagic());
        setMp(getMaxMp());
        
        setMaxHP(calculateHealth());
        setHp(getMaxHP());
    }
    
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
    
    public void setMp(int mp) {
        if (mp >= 0) {
            this.mp = mp;
        } else {
            throw new IllegalArgumentException("Character MP can not be below 0");
        }
    }
    
    public void setMaxMP(int maxMp) {
        this.maxMp = maxMp;
    }
    
    // -- Class Specific Methods  -- //
    public boolean attemptAttack(Combatant target, Attack attemptedAttack) {
        //todo: attack logic comes here
        boolean succes = false;
        
        if ((attemptedAttack.getBaseAccuracy() * level) >= MINIMUM_ACC_FOR_SUCCES) {
            doAttack(target, attemptedAttack);
            succes = true;
        }
        
        return succes;
    }
    
    public void doAttack(Combatant target, Attack attackToDo) {
        //todo: attack logic comes here
        int damage = attackToDo.getBaseDamage() * strength;
        target.takeDamage(damage);
        
        if(attackToDo.isMagic()) {
            System.out.printf("%n%s casts %s on %s for %d damage%n", this.getName(),attackToDo.getAttackName(), target.getName(), damage);
        } else {
            System.out.printf("%n%s hits %s for %d damage%n", this.getName(), target.getName(), damage);
        }
        
    }
    
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            this.isAlive = false;
        }
    }
    
    
    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Combatant name can not be empty or null");
        }
    }
    
    public int calculateStats(int baseAmount) {
        int statAmount = baseAmount + level;
        return statAmount;
    }
    
    private int calculateHealth() {
        int statAmount = baseHp + (level * 15);
        return statAmount;
    }
    
    private int calculateMagic() {
        int amount = baseMp + (level * intelligence);
        return amount;
    }
}

