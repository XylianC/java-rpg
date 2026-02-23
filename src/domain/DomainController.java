package domain;

import org.xml.sax.SAXException;
import persistance.AttackRepository;
import persistance.EnemyRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomainController {
    private final EnemyRepository enemyRepo;
    private final PlayerParty party;
    private final EnemyGroup enemyGroup;

    
    public DomainController() throws ParserConfigurationException, IOException, SAXException {
        this.enemyRepo = new EnemyRepository();
        
        PlayerCharacter[] players = createTemplatePlayers();
        this.party  = new PlayerParty(players[0], players[1], players[2], players[3]);
        
        Enemy[] enemies = createTemplateEnemies();
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
    
    public Enemy[] createTemplateEnemies() {
        assert enemyRepo != null;
        Enemy[] enemies = new Enemy[3];
        enemies[0] = enemyRepo.getEnemy("slime_green");
        enemies[1] = enemyRepo.getEnemy("slime_red");
        enemies[2] = enemyRepo.getEnemy("dragon_fire");
        
        return enemies;
    }
}
