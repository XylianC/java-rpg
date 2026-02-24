package domain;

import org.xml.sax.SAXException;
import persistance.AttackRepository;
import persistance.EnemyRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DomainController {
    private final EnemyRepository enemyRepo;
    private final PlayerParty party;
    private final EnemyGroup enemyGroup;

    
    public DomainController() throws ParserConfigurationException, IOException, SAXException {
        this.enemyRepo = new EnemyRepository();
        
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
    
    
    
    ///  ---- Debug Methods ---- ///
    public PlayerCharacter[] createTemplatePlayers() {
        PlayerCharacter[] players = new PlayerCharacter[4];
        
        players[0] = new PlayerCharacter("Xylian", "Warrior");
        players[1] = new PlayerCharacter("Millia");
        players[2] = new PlayerCharacter("Ruben", "Monk");
        players[3] = new PlayerCharacter("Mattis", "Scholar");
        
        return players;
    }
    
    public ArrayList<Enemy> createTemplateEnemies() {
        assert enemyRepo != null;
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemyRepo.getEnemy("slime_normal"));
        enemies.add(enemyRepo.getEnemy("slime_fire"));
        enemies.add(enemyRepo.getEnemy("dragon_fire"));
        enemies.add(enemyRepo.getEnemy("dragon_electric"));
        
        return enemies;
    }
}
