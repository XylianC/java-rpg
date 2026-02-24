package domain;

import persistance.Elements;

import java.util.ArrayList;

public class Enemy extends Combatant{
    private final String enemyCode;
    private final String enemyRace;
    private final Elements enemyElement;
        
    private static final String DEFAULT_CLASS = "Monster";
    
    private ArrayList<String> attackList = new ArrayList<>();
    
    // -- Constructors -- //
    public Enemy(String enemyCode, String enemyRace, Elements enemyElement, int enemyStr, int enemyIntel, int enemyHp, int enemyMp, ArrayList<String> attacks, int enemyLvl) {
        super(enemyRace, enemyStr, enemyIntel, enemyHp, enemyMp, enemyLvl);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyRace);
        this.enemyRace = enemyRace;
        
        this.enemyElement = enemyElement;
        
        this.attackList = attacks;
    }
    
    public Enemy(String enemyCode, String enemyRace, Elements enemyElement, int enemyStr, int enemyIntel, int enemyHp, int enemyMp, ArrayList<String> attacks) {
        super(enemyRace, enemyStr, enemyIntel, enemyHp, enemyMp);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyRace);
        this.enemyRace = enemyRace;
        
        this.enemyElement = enemyElement;
        
        this.attackList = attacks;
    }
    
    
    
    // -- Getters -- //
    public String getEnemyRace() {
        return this.enemyRace;
    }
    
    public Elements getEnemyElement() {return this.enemyElement;}
    
    public String getEnemyDisplayName() {
        String output = getEnemyElement().getDisplayName() + " " + getEnemyRace();
        return output;
     }
    
    // -- Andere Methoden -- //
    private void checkString(String type) {
        if(type == null || type.isBlank()) {
            throw new IllegalArgumentException("Enemy type can not be empty or null");
        }
    }
    
    public void addAttack(String attackCode) {
        attackList.add(attackCode);
    }
    
    @Override
    public String toString() {
        return String.format("Enemy: %s%nType: %s %n- Health: %d / %d %nMP: %d/%d%n- Stats: LVL: %d, STR: %d, INT: %d ", getEnemyDisplayName(), getEnemyElement().getDisplayName(), getHp(), getMaxHP(), getMp(), getMaxMp(), getLevel(), getStrength(), getIntelligence());
    }
}
