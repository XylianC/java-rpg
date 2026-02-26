package domain;

import util.Classes;

public class PlayerCharacter extends Combatant{
    // -- Attributen -- //
    private final Classes charClass;
    
    private int exp;
    private int expToNextLevel;
    
    // -- Constructors -- //
    public PlayerCharacter(String name, Classes job, int lvl, int str, int intel, int hp, int mp) {
        super(name, lvl, str, intel, hp, mp);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name, Classes job, int lvl) {
        super(name, lvl, job.getBaseStr(), job.getBaseIntel(), job.getBaseHP(), job.getBaseMP());
        this.charClass = job;
    }
    
    
    ///  Getters ////
    public String getCharClass() {
        return charClass.getDisplayName();
    }
    
    
    ///  --- Class Specific Methods --- ////
    public void levelUp() {
        recalculateStats();
        //todo: implement better method of levelling up, make it more advanced.
        //todo: add proper way of increasing the stats per level gained.
    }
    
    public void addExp(int amount) {
        this.exp += amount;
    }
    
    @Override
    public String toString() {
        return String.format("Character: %s Class: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ",getName(), getCharClass(), getHp(), getMaxHP(), getLevel(), getStrength(), getIntelligence());
    }
}
