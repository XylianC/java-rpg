package domain;

public class BattleManager {
    // ------ Attributes ------ //
    private boolean isPlayerTurn;
    private int battleTurn = 1;
    
    private PlayerParty playerParty;
    private EnemyGroup enemyGroup;
    
    // ------ Constructors ------ //
    public BattleManager(PlayerParty players, EnemyGroup enemies) {
        this.playerParty = players;
        this.enemyGroup = enemies;
    }
    
    
    // ------ Getters ------ //
    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }
    
    public int getBattleTurn() {
        return battleTurn;
    }
    
    // ------ Setters ------ //
    
    // ------ Class Methods ------ //
    private void playerTurn() {
    
    }
    
    private void enemyTurn() {
    
    }
    
    
    /*
    
    One complete turn of combat

    Player turn
    In one turn, the player selects the preferred action (Attack, Magic, Defend, Flee), for every member of the party;
    
    If the player chooses: attack    -> he needs to choose a target -> calculations are done -> attack
    If the player chooses: magic     -> same thing as the above basically
    If the player chooses: defend    -> no targets needs to be chosen -> damage is smaller
    If the player chooses: flee      -> some calculations are done to see if they can flee
    
    Enemy turn
    In one turn, every enemies goes through this list of commands
    1) The enemy chooses a random party member, and chooses an attack out of his attack list
    2) The game calculates if the attack hits, and how much damage it does
    3) The playerCharacter takes eventual damage
    
    Repeat
     */
}

