package domain;

import util.Elements;

public class Attack {
    /// ------      Attributes     ------  ///
    private final String attackCode;
    private final String attackName;
    private final Elements element;
    private final int baseDamage;
    private final int baseAccuracy;
    private final boolean isMagic;
    private final int cost;
    
    
    private static final boolean DEFAULT_NOMAGIC = false;
    private static final int DEFAULT_COST = 0;
    private static final Elements DEFAULT_ELEMENT = Elements.NORMAL;
    private static final int DEFAULT_BASE_DAMAGE = 1;
    private static final int DEFAULT_BASE_ACCURACY = 1;
    
    
    /// ------     Constructors     ------  ///
    public Attack(String attackCode, String attackName, Elements element, int baseDamage, int baseAccuracy, boolean isMagic, int cost) {
        checkStringInput(attackCode);
        this.attackCode = attackCode;

        checkStringInput(attackName);
        this.attackName = attackName;
        
        this.baseDamage = baseDamage;
        this.baseAccuracy = baseAccuracy;
        
        this.element = element;
        this.isMagic = isMagic;
        
        this.cost = cost;
    }
    
    public Attack(String attackCode, String attackName, int baseDamage, int baseAccuracy) {
        checkStringInput(attackCode);
        this.attackCode = attackCode;
        checkStringInput(attackName);
        this.attackName = attackName;
        
        this.baseDamage = baseDamage;
        this.baseAccuracy = baseAccuracy;
        
        this.element = DEFAULT_ELEMENT;
        this.isMagic = DEFAULT_NOMAGIC;
        this.cost = DEFAULT_COST;
    }
    
    public Attack(String attackCode, String attackName) {
        checkStringInput(attackCode);
        this.attackCode = attackCode;
        
        checkStringInput(attackName);
        this.attackName = attackName;
        
        this.baseDamage = DEFAULT_BASE_DAMAGE;
        this.baseAccuracy = DEFAULT_BASE_ACCURACY;
        
        this.element = DEFAULT_ELEMENT;
        this.isMagic = DEFAULT_NOMAGIC;
        this.cost = DEFAULT_COST;
    }
    
    /// ------      Getters     ------  ///
    public String getAttackCode() { return attackCode; }
    
    public String getAttackName() {
        return attackName;
    }
    
    public Elements getElement() {
        return element;
    }
    
    public boolean isMagic() {return isMagic;}
    
    public int getBaseDamage() {
        return baseDamage;
    }
    
    public int getBaseAccuracy() {
        return baseAccuracy;
    }
    
    public int getCost() { return cost;}
    /// ------      Setters     ------  ///
    
    /// ------   Class Methods   ------  ///
    private void checkStringInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input can not be null or empty!");
        }
    }
}
