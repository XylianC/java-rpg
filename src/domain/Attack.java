package domain;

public class Attack {
    /// ------      Attributes     ------  ///
    private final String attackCode;
    private final String attackName;
    private final String element;
    private final int baseDamage;
    private final int baseAccuracy;
    private final boolean isMagic;
    
    
    private static final boolean DEFAULT_NOMAGIC = false;
    private static final String DEFAULT_ELEMENT = "None";
    private static final int DEFAULT_BASE_DAMAGE = 1;
    private static final int DEFAULT_BASE_ACCURACY = 1;
    
    
    /// ------     Constructors     ------  ///
    public Attack(String attackCode, String attackName, String element, int baseDamage, int baseAccuracy, boolean isMagic) {
        checkStringInput(attackCode);
        this.attackCode = attackCode;

        checkStringInput(attackName);
        this.attackName = attackName;
        
        this.baseDamage = baseDamage;
        this.baseAccuracy = baseAccuracy;
        
        this.element = element;
        this.isMagic = isMagic;
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
    }
    
    /// ------      Getters     ------  ///
    public String getAttackName() {
        return attackName;
    }
    
    public String getElement() {
        return element;
    }
    
    public int getBaseDamage() {
        return baseDamage;
    }
    
    public int getBaseAccuracy() {
        return baseAccuracy;
    }
    /// ------      Setters     ------  ///
    
    /// ------   Class Methods   ------  ///
    private void checkStringInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input can not be null or empty!");
        }
    }
}
