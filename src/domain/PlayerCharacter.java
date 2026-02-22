package domain;

public class PlayerCharacter extends Combatant{
    // -- Attributen -- //
    private final String charClass;
    
    private int exp;
    private int expToNextLevel;
    
    private static final String DEFAULT_CLASS = "Mage";
    
    // -- Constructors -- //
    public PlayerCharacter(String name, String job, int lvl, int str, int intel, int hp, int maxhp) {
        super(name, lvl, str, intel, hp, maxhp);
        checkJob(job);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name, String job, int lvl, int str, int intel) {
        super(name, lvl, str, intel);
        checkJob(job);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name, String job) {
        super(name);
        checkJob(job);
        this.charClass = job;
    }
    
    public PlayerCharacter(String name) {
        super(name);
        this.charClass = DEFAULT_CLASS;

    }
    
    ///  Getters ////
    public String getCharClass() {
        return charClass;
    }
    
    
    ///  --- Class Specific Methods --- ////
    
    private void checkJob(String job) {
        if (job == null || job.isBlank()) {
            throw new IllegalArgumentException("Character job name can not be null!");
        }
    }
    
    public void levelUp() {
        //todo: implement better method of levelling up, make it more advancedd.
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
