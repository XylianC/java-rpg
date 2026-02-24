package domain;

import org.xml.sax.SAXException;
import persistence.AttackRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class BattleManager {
    // ------ Attributes ------ //
    private boolean isPlayerTurn;
    private boolean battleActive = true;
    private boolean playerFled;
    private int battleTurn = 1;
    
    private final PlayerParty playerParty;
    private final EnemyGroup enemyGroup;
    private final AttackRepository attacks;
    
    // ------ Constructors ------ //
    public BattleManager(PlayerParty players, EnemyGroup enemies, AttackRepository attacks) throws ParserConfigurationException, IOException, SAXException {
        this.playerParty = players;
        this.enemyGroup = enemies;
        this.attacks = attacks;
    }
    
    // ------ Getters ------ //
    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }
    
    public int getBattleTurn() {
        return battleTurn;
    }
    
    public boolean getBattleActive() {
        battleActive = areEnemiesAlive() && !playerFled && arePlayersAlive();
        
        return battleActive;
    }
    
    public ArrayList<Enemy> getAliveEnemies() {
        return enemyGroup.getEnemiesAlive();
    }
    
    public ArrayList<PlayerCharacter> getPartyMembersAlive() {
        return playerParty.getPartyMembersAlive();
    }
    
    public PlayerCharacter getCharacterInfo(int slot) {
        return this.playerParty.getPlayerBySlot(slot);
    }
    
    public int getPartySize() {
        return this.playerParty.getPartySize();
    }

    
    // ------ Class Methods ------ //
    
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
    
    private boolean arePlayersAlive() {
        return !playerParty.getPartyMembersAlive().isEmpty();
    }
    
    ///  ----- Enemy Turn ------ ///
    public void doEnemyTurn() {
        System.out.println("THIS IS THE ENEMY TURN - DEBUG TEXT");
        
        ArrayList<PlayerCharacter> playersAlive = getPartyMembersAlive();
        
        int target = getRandom(playersAlive.size());
        PlayerCharacter playerTarget = playersAlive.get(target);
        
        System.out.printf("ENEMY ATTEMPTS TO ATTACK: %s%n", playerTarget.getName());
        
        isPlayerTurn = true;
    }
    
    ///  ----- Player Turn ------ ///
    
//    public void doPlayerTurn(int input) {
//        switch (input) {
//            //case 1 -> doPlayerAttack();
//            case 2 -> doPlayerMagic();
//            case 3 -> doPlayerDefend();
//            case 4 -> doPlayerFlee();
//        }
//        isPlayerTurn = false;
//    }
    
    public void doPlayerAttack(Combatant target, PlayerCharacter activeCharacter) {
        activeCharacter.doAttack(target, attacks.getAttack("melee_attack"));
    }
    
    public void doPlayerMagic() {
        System.out.println("You chose to use a spell");
    }
    
    public void doPlayerDefend() {
        System.out.println("You chose to defend");
    }
    
    public void doPlayerFlee() {
        playerFled = true;
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
    
    public int getRandom(int max) {
        return (int)(Math.random() * max);
    }
}

