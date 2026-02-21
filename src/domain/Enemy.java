package domain;

public class Enemy {
        private final String enemyName;
        private final String enemyType;
        
        private int enemyLevel;
        
        private int enemyStrength;
        private int enemyIntelligence;
        
        private int hp;
        private int maxHP;
        
        private static final String DEFAULT_CLASS = "Monster";
        private static final int DEFAULT_HP = 30;
        private static final int DEFAULT_SKILL_LEVEL = 1;
        
        
        // -- Constructors -- //
        
        public Enemy(String enemyName, String enemyType, int lvl, int str, int intel) {
            checkName(enemyName);
            this.enemyName = enemyName;
            this.enemyType = enemyType;
            
            setEnemyLevel(lvl);
            setEnemyStrength(str);
            setEnemyIntelligence(intel);
            
            setHp(DEFAULT_HP);
            setMaxHP(DEFAULT_HP);
        }
    
    public Enemy(String enemyName, String enemyType) {
        checkName(enemyName);
        this.enemyName = enemyName;
        checkType(enemyType);
        this.enemyType = enemyType;
        
        setEnemyLevel(DEFAULT_SKILL_LEVEL);
        setEnemyStrength(DEFAULT_SKILL_LEVEL);
        setEnemyIntelligence(DEFAULT_SKILL_LEVEL);
        
        setHp(DEFAULT_HP);
        setMaxHP(DEFAULT_HP);
    }
        
        public Enemy(String enemyName) {
            checkName(enemyName);
            this.enemyName = enemyName;
            this.enemyType = DEFAULT_CLASS;
            
            setEnemyLevel(DEFAULT_SKILL_LEVEL);
            setEnemyStrength(DEFAULT_SKILL_LEVEL);
            setEnemyIntelligence(DEFAULT_SKILL_LEVEL);
            
            setHp(DEFAULT_HP);
            setMaxHP(DEFAULT_HP);
        }
        
        
        // -- Getters -- //
        public String getEnemyName() {
            return enemyName;
        }
        
        public String getEnemyType() {
            return enemyType;
        }
        
        public int getEnemyLevel() {
            return enemyLevel;
        }
        
        
        public int getEnemyStrength() {
            return enemyStrength;
        }
        
        public int getEnemyIntelligence() {
            return enemyIntelligence;
        }
        
        public int getHp() {
            return hp;
        }
        
        public int getMaxHP() {
            return maxHP;
        }
        
        // -- Setters -- //
        public void setEnemyLevel(int enemyLevel) {
            this.enemyLevel = enemyLevel;
        }
        
        public void setEnemyStrength(int enemyStrength) {
            this.enemyStrength = enemyStrength;
        }
        
        public void setEnemyIntelligence(int enemyIntelligence) {
            this.enemyIntelligence = enemyIntelligence;
        }
        
        public void setHp(int hp) {
            if(hp >= 0) {
                this.hp = hp;
            } else {
                throw new IllegalArgumentException("Character HP can not be below 0!");
            }
        }
        
        public void setMaxHP(int maxHP) {
            this.maxHP = maxHP;
        }
        
        // -- Andere Methoden -- //
        private void checkName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Enemy type can not be empty or null");
            }
        }
        
        private void checkType(String type) {
            if(type == null || type.isBlank()) {
                throw new IllegalArgumentException("Enemy type can not be empty or null");
            }
    }
        
        
        @Override
        public String toString() {
            return String.format("Enemy: %s Type: %s %n- Health: %d / %d %n- Stats: LVL: %d, STR: %d, INT: %d ", getEnemyName(), getEnemyType(), getHp(), getMaxHP(), getEnemyLevel(), getEnemyStrength(), getEnemyIntelligence());
        }
    }
