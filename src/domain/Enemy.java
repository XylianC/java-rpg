package domain;

import java.util.ArrayList;

public class Enemy extends Combatant{
    private final String enemyCode;
    private final String enemyType;
        
    private static final String DEFAULT_CLASS = "Monster";
    
    private ArrayList<String> attackList = new ArrayList<>();
        
        
    // -- Constructors -- //
    public Enemy(String enemyCode, String enemyName, String enemyType, int enemyStr, int enemyIntel, int enemyHp, ArrayList<String> attacks, int enemyLvl) {
        super(enemyName, enemyStr, enemyIntel, enemyHp, enemyLvl);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyType = enemyType;
        
        this.attackList = attacks;
    }
    
    public Enemy(String enemyCode, String enemyName, String enemyType, int enemyStr, int enemyIntel, int enemyHp, ArrayList<String> attacks) {
        super(enemyName, enemyStr, enemyIntel, enemyHp);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyType = enemyType;
    
        this.attackList = attacks;
    }
    
    
    public Enemy(String enemyCode, String enemyName, String enemyType, int enemyLvl, int enemyStr, int enemyIntel, int enemyHp) {
        super(enemyName, enemyLvl, enemyStr, enemyIntel, enemyHp);
       
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyType = enemyType;
    }
    
    public Enemy(String enemyCode,String enemyName, String enemyType, int enemyLvl, int enemyStr, int enemyIntel) {
        super(enemyName, enemyLvl, enemyStr, enemyIntel);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyType = enemyType;
    }
    
    public Enemy(String enemyCode, String enemyName, String enemyType) {
        super(enemyName);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyType = enemyType;
    }
    
    // -- Getters -- //
    public String getEnemyType() {
        return enemyType;
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
        return String.format("Enemy: %s%nType: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ", getName(), getEnemyType(), getHp(), getMaxHP(), getLevel(), getStrength(), getIntelligence());
    }
}
