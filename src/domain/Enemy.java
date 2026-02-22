package domain;

import java.util.ArrayList;

public class Enemy extends Combatant{
    private final String enemyType;
        
    private static final String DEFAULT_CLASS = "Monster";
    
    private final ArrayList<String> attackList = new ArrayList<>();
        
        
    // -- Constructors -- //
    public Enemy(String enemyName, String enemyType, int enemyLvl, int enemyStr, int enemyIntel, int enemyHp, int enemyMaxHp) {
        super(enemyName, enemyLvl, enemyStr, enemyIntel, enemyHp, enemyMaxHp);
        checkType(enemyType);
        this.enemyType = enemyType;
    }
    
    public Enemy(String enemyName, String enemyType, int enemyLvl, int enemyStr, int enemyIntel) {
        super(enemyName, enemyLvl, enemyStr, enemyIntel);
        checkType(enemyType);
        this.enemyType = enemyType;
    }
    
    public Enemy(String enemyName, String enemyType) {
        super(enemyName);
        checkType(enemyType);
        this.enemyType = enemyType;
    }
    
    // -- Getters -- //
    public String getEnemyType() {
        return enemyType;
    }
        
    // -- Andere Methoden -- //
    private void checkType(String type) {
        if(type == null || type.isBlank()) {
            throw new IllegalArgumentException("Enemy type can not be empty or null");
        }
    }
    
        
    @Override
    public String toString() {
        return String.format("Enemy: %s Type: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ", getName(), getEnemyType(), getHp(), getMaxHP(), getLevel(), getStrength(), getIntelligence());
    }
}
