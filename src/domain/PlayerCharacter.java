package domain;

import util.Classes;

import java.util.ArrayList;

public class PlayerCharacter extends Combatant{
    // -- Attributen -- //
    private final Classes charClass;
    
    private int exp;
    private int expToNextLevel;
    
    ArrayList<String> possibleAttacks = new ArrayList<>();
    
    private static final Classes DEFAULT_CLASS = Classes.WARRIOR;
    
    // -- Constructors -- //
    public PlayerCharacter(String name, Classes job, int lvl, int str, int intel, int hp, int mp) {
        super(name, lvl, str, intel, hp);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name, Classes job, int lvl, int str, int intel) {
        super(name, lvl, str, intel);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name, Classes job) {
        super(name);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name) {
        super(name);
        this.charClass = DEFAULT_CLASS;

    }
    
    ///  Getters ////
    public String getCharClass() {
        return charClass.getDisplayName();
    }
    
    public ArrayList<String> getPossibleAttacks () {
        return possibleAttacks;
    }
    
    
    ///  --- Class Specific Methods --- ////
    public void levelUp() {
        //todo: implement better method of levelling up, make it more advanced.
        //todo: add proper way of increasing the stats per level gained.
    }
    
    public void addAttack(String attackCode) {
        possibleAttacks.add(attackCode);
    }
    
    public void addExp(int amount) {
        this.exp += amount;
    }
    
    @Override
    public String toString() {
        return String.format("Character: %s Class: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ",getName(), getCharClass(), getHp(), getMaxHP(), getLevel(), getStrength(), getIntelligence());
    }
}
