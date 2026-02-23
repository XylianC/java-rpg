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
    public Enemy(String enemyCode, String enemyRace, Elements enemyElement, int enemyStr, int enemyIntel, int enemyHp, ArrayList<String> attacks, int enemyLvl) {
        super(enemyRace, enemyStr, enemyIntel, enemyHp, enemyLvl);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyRace);
        this.enemyRace = enemyRace;
        
        this.enemyElement = enemyElement;
        
        this.attackList = attacks;
    }
    
    public Enemy(String enemyCode, String enemyRace, Elements enemyElement, int enemyStr, int enemyIntel, int enemyHp, ArrayList<String> attacks) {
        super(enemyRace, enemyStr, enemyIntel, enemyHp);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyRace);
        this.enemyRace = enemyRace;
        
        this.enemyElement = enemyElement;
        
        this.attackList = attacks;
    }
    
    
    public Enemy(String enemyCode, String enemyName, String enemyType, int enemyLvl, int enemyStr, int enemyIntel, int enemyHp) {
        super(enemyName, enemyLvl, enemyStr, enemyIntel, enemyHp);
       
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyRace = enemyType;
    }
    
    public Enemy(String enemyCode,String enemyName, String enemyType, int enemyLvl, int enemyStr, int enemyIntel) {
        super(enemyName, enemyLvl, enemyStr, enemyIntel);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyRace = enemyType;
    }
    
    public Enemy(String enemyCode, String enemyName, String enemyType) {
        super(enemyName);
        
        checkString(enemyCode);
        this.enemyCode = enemyCode;
        
        checkString(enemyType);
        this.enemyRace = enemyType;
    }
    
    // -- Getters -- //
    public String getEnemyRace() {
        return enemyRace;
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
        return String.format("Enemy: %s%nType: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ", getName(), getEnemyRace(), getHp(), getMaxHP(), getLevel(), getStrength(), getIntelligence());
    }
}
