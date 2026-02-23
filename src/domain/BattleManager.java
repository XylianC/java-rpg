package domain;

import java.util.ArrayList;

public class BattleManager {
    // ------ Attributes ------ //
    private boolean isPlayerTurn;
    private boolean battleActive = true;
    private boolean playerFled;
    private int battleTurn = 1;
    
    private final PlayerParty playerParty;
    private final EnemyGroup enemyGroup;
    
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
    
    public boolean getBattleActive() {
        return battleActive;
    }
    
    public ArrayList<Enemy> getAliveEnemies() {
        return enemyGroup.getEnemiesAlive();
    }
    
    

    
    // ------ Class Methods ------ //
    public void doBattleTurn(int input) {
        doPlayerTurn(input);
        doEnemyTurn();
        battleTurn++;
        this.battleActive = areEnemiesAlive() && !this.playerFled;
    }
    
    
    ///  ---- General methods ---- ///
    
    
    public void finishBattle() {
        if(!this.playerFled) {
            System.out.println("Battle is over");
            System.out.println("This is the loot");
        } else {
            System.out.println("Battle is over, player fled, no loot");
        }
    }
    
    private boolean areEnemiesAlive() {
        return !enemyGroup.getEnemiesAlive().isEmpty();
    }
    
    
    ///  ----- Enemy Turn ------ ///
    private void doEnemyTurn() {
        
        
        isPlayerTurn = true;
    }
    
    ///  ----- Player Turn ------ ///
    
    public void doPlayerTurn(int input) {
        switch (input) {
            case 1 -> doPlayerAttack();
            case 2 -> doPlayerMagic();
            case 3 -> doPlayerDefend();
            case 4 -> doPlayerFlee();
        }
        isPlayerTurn = false;
    }
    
    private void doPlayerAttack() {
        System.out.println("You chose to attack");
    }
    
    private void doPlayerMagic() {
        System.out.println("You chose to use a spell");
    }
    
    private void doPlayerDefend() {
        System.out.println("You chose to defend");
    }
    
    private void doPlayerFlee() {
        playerFled = true;
        System.out.println("You chose to flee");
    }
    
    
    /*
    
    One complete turn of combat

    Player turn
    In one turn, the player selects the preferred action (Attack, Magic, Defend, Flee), for every member of the party;
    
    If the player chooses: attack    -> he needs to choose a target -> calculations are done -> attack
    If the player chooses: magic     -> same thing as the above basically, except he chooses a spell as well.
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

