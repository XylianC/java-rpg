package domain;

import org.xml.sax.SAXException;
import persistence.AttackRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class BattleManager {
    // ------ Attributes ------ //
    private boolean battleActive = true;
    private boolean playerFled;
    
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
    public boolean getBattleActive() {
        battleActive = areEnemiesAlive() && !playerFled && arePlayersAlive();
        
        return battleActive;
    }
    
    public Attack getSpecificAttack(String attackCode) {
        return attacks.getAttack(attackCode);
    }
    
    public ArrayList<Enemy> getAliveEnemies() {
        return enemyGroup.getEnemiesAlive();
    }
    
    public ArrayList<PlayerCharacter> getPartyMembersAlive() {
        return playerParty.getPartyMembersAlive();
    }
    
    public int getPartySize() {
        return this.playerParty.getPartySize();
    }
    
    public PlayerCharacter getCharacterInfo(int slot) {
        return this.playerParty.getPlayerBySlot(slot);
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
    public String doEnemyTurn(Enemy activeEnemy) {
        ArrayList<PlayerCharacter> playersAlive = getPartyMembersAlive();
        
        int target = getRandom(playersAlive.size());
        PlayerCharacter playerTarget = playersAlive.get(target);
        
        ArrayList<String> possibleAttacks = activeEnemy.getAttackList();
        int randomAttack = getRandom(possibleAttacks.size());
        
        Attack attackToTry = attacks.getAttack(possibleAttacks.get(randomAttack));
        return activeEnemy.attemptAttack(playerTarget, attackToTry);
    }
    
    ///  ------ Player Turn ------ ///
    public String doPlayerAttack(Combatant target, PlayerCharacter activeCharacter) {
        return activeCharacter.doAttack(target, attacks.getAttack("melee_attack"));
    }
    
    public String doPlayerMagic(Combatant target, Attack chosenSpell, PlayerCharacter activeCharacter) {
        return activeCharacter.doAttack(target, chosenSpell);
    }
    
    public String doPlayerDefend() {
        return String.format("");
    }
    
    public void doPlayerFlee() {
        playerFled = true;
    }
    
    ///  --- Help methods --- ///
    public int getRandom(int max) {
        return (int)(Math.random() * max);
    }
}

