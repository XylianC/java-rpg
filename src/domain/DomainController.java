package domain;

import org.xml.sax.SAXException;
import persistence.AttackRepository;
import util.Classes;
import persistence.EnemyRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DomainController {
    private final EnemyRepository enemyRepo;
    private final AttackRepository attackRepo;
    private final PlayerParty party;
    private final EnemyGroup enemyGroup;

    
    public DomainController() throws ParserConfigurationException, IOException, SAXException {
        this.enemyRepo = new EnemyRepository();
        this.attackRepo = new AttackRepository();
        
        PlayerCharacter[] players = createTemplatePlayers();
        this.party  = new PlayerParty(players[0], players[1], players[2], players[3]);
        
        ArrayList<Enemy> enemies = createTemplateEnemies();
        this.enemyGroup = new EnemyGroup(enemies);
    }
    
    
    /// ---- Getters ---- ////
    public PlayerParty getParty() {
        return party;
    }
    
    public EnemyGroup getEnemyGroup() {
        return enemyGroup;
    }
    
    public AttackRepository getAttackRepo() {
        return attackRepo;
    }
    
    
    ///  ---- Debug Methods ---- ///
    public PlayerCharacter[] createTemplatePlayers() {
        PlayerCharacter[] players = new PlayerCharacter[4];
        
        players[0] = new PlayerCharacter("Xylian", Classes.WARRIOR);
        players[0].addAttack("melee_attack");
        players[0].addAttack("fire_bolt");
        players[1] = new PlayerCharacter("Millia", Classes.MAGE);
        players[1].addAttack("melee_attack");
        players[1].addAttack("ice_bolt");
        players[2] = new PlayerCharacter("Ruben", Classes.MONK);
        players[2].addAttack("melee_attack");
        players[2].addAttack("fire_bolt");
        players[3] = new PlayerCharacter("Mattis", Classes.SCHOLAR);
        players[3].addAttack("melee_attack");
        players[3].addAttack("lightning_bolt");
        
        return players;
    }
    
    public ArrayList<Enemy> createTemplateEnemies() {
        assert enemyRepo != null;
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemyRepo.spawnEnemy("slime_normal", 1));
        enemies.add(enemyRepo.spawnEnemy("slime_fire", 1));
        enemies.add(enemyRepo.spawnEnemy("dragon_fire", 3));
        enemies.add(enemyRepo.spawnEnemy("dragon_electric", 3));
        
        return enemies;
    }
}
