package domain;

import util.Elements;

import java.util.ArrayList;

public class Enemy extends Combatant{
    private final String enemyCode;
    private final String enemyRace;
    private final Elements enemyElement;
    
    // -- Constructors -- //
    
    
    public Enemy(String enemyCode, String enemyRace, Elements enemyElement, int enemyStr, int enemyIntel, int enemyHp, int enemyMp, ArrayList<String> attacks) {
        super(enemyRace, enemyStr, enemyIntel, enemyHp, enemyMp, attacks);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyRace);
        this.enemyRace = enemyRace;
        
        this.enemyElement = enemyElement;
    }
    
    public Enemy(Enemy original, int level){
        super(original, level);
        this.enemyCode = original.enemyCode;
        this.enemyRace = original.getEnemyRace();
        this.enemyElement = original.getEnemyElement();
    }
    
    
    // -- Getters -- //
    public String getEnemyRace() {
        return this.enemyRace;
    }
    
    public Elements getEnemyElement() {
        return this.enemyElement;
    }
    
    @Override
    public String getDisplayName() {
        String output = getEnemyElement().getDisplayName() + " " + getEnemyRace();
        return output;
     }
    
    // -- Andere Methoden -- //
    private void checkString(String type) {
        if(type == null || type.isBlank()) {
            throw new IllegalArgumentException("Enemy type can not be empty or null");
        }
    }
    
    @Override
    public String toString() {
        return String.format("Enemy: %s%nType: %s %n- Health: %d / %d %n- Magic: %d/%d%n- Stats: LVL: %d, STR: %d, INT: %d ", getDisplayName(), getEnemyElement().getDisplayName(), getHp(), getMaxHP(), getMp(), getMaxMp(), getLevel(), getStrength(), getIntelligence());
    }
    
    public String getShortString() {
        return String.format("%s%n- HP:%d/%d%n- MP:%d/%d%n", getDisplayName(),getHp(), getMaxHP(), getMp(), getMaxMp());
    }
}
