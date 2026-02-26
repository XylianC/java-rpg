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
    private boolean isBossFight;
    
    private final PlayerParty playerParty;
    private final EnemyGroup enemyGroup;
    private final AttackRepository attacks;
    private BossMonster bossMonster = null;
    
    // ------ Constructors ------ //
    public BattleManager(PlayerParty players, EnemyGroup enemies, AttackRepository attacks, BossMonster bossMonster) throws ParserConfigurationException, IOException, SAXException {
        this.playerParty = players;
        this.enemyGroup = enemies;
        this.attacks = attacks;
        this.bossMonster = bossMonster;
        isBossFight = true;
    }
    
    public BattleManager(PlayerParty players, EnemyGroup enemies, AttackRepository attacks) throws ParserConfigurationException, IOException, SAXException {
        this.playerParty = players;
        this.enemyGroup = enemies;
        this.attacks = attacks;
        isBossFight = false;
    }
    
    // ------ Getters ------ //
    public boolean getBattleActive() {
        battleActive = areEnemiesAlive() && !playerFled && arePlayersAlive();
        
        return battleActive;
    }
    
    public Attack getSpecificAttack(String attackCode) {
        return attacks.getAttack(attackCode);
    }
    
    public ArrayList<PlayerCharacter> getPartyMembersAlive() {
        return playerParty.getPartyMembersAlive();
    }
    
    public int getPartySize() {
        return this.playerParty.getPartySize();
    }
    
    public PlayerCharacter getPartyMemberFromParty(int slot) {
        return this.playerParty.getPlayerBySlot(slot);
    }
    
    public ArrayList<Enemy> getAliveEnemies() {
        return enemyGroup.getEnemiesAlive();
    }
    
    public BossMonster getBossMonster() {return this.bossMonster;}
    
    public boolean isBossFight() { return this.isBossFight; }
    
    // ------ Class Methods ------ //
    
    ///  ---- General methods ---- ///
    public String finishBattle() {
        if(!this.playerFled) {
            return String.format("Battle is over%nThis is the loot: %n-TEST 1%n- TEST 2");
            
        } else {
            return String.format("Battle is over, player fled, no loot");
        }
    }

    ///  ------ Player Turn ------ ///
    public String doPlayerAttack(Combatant target, PlayerCharacter activeCharacter) {
        return activeCharacter.doAttack(target, attacks.getAttack("melee_attack"));
    }
    
    public String doPlayerMagic(Combatant target, Attack chosenSpell, PlayerCharacter activeCharacter) {
        return activeCharacter.doAttack(target, chosenSpell);
    }
    
    public String doPlayerDefend(PlayerCharacter activeCharacter) {
        return String.format("%s chose to defend. (DEBUG)", activeCharacter.getDisplayName());
    }
    
    public String doPlayerFlee(PlayerCharacter activeCharacter) {
        playerFled = true;
        return String.format("%s chose to flee.", activeCharacter.getDisplayName());
    }
    
    ///  ----- Enemy Turn ------ ///
    public String doEnemyTurn(Enemy activeEnemy) {
        ArrayList<PlayerCharacter> playersAlive = getPartyMembersAlive();
        
        int target = getRandom(playersAlive.size());
        PlayerCharacter playerTarget = playersAlive.get(target);
        
        ArrayList<String> possibleAttacks = activeEnemy.getPossibleAttacks();
        int randomAttack = getRandom(possibleAttacks.size());
        
        Attack attackToTry = attacks.getAttack(possibleAttacks.get(randomAttack));
        return activeEnemy.attemptAttack(playerTarget, attackToTry);
    }
    
    ///  --- Help methods --- ///
    public int getRandom(int max) {
        return (int)(Math.random() * max);
    }
    
    private boolean areEnemiesAlive() {
        return !enemyGroup.getEnemiesAlive().isEmpty();
    }
    
    private boolean arePlayersAlive() {
        return !playerParty.getPartyMembersAlive().isEmpty();
    }
}

