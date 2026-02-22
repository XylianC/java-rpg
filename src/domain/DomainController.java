package domain;

import persistance.AttackRepository;

public class DomainController {
    public DomainController() {
    
    }
    
    PlayerCharacter[] players = createTemplatePlayers();
    Enemy[] enemies = createTemplateEnemies(3);
    
    ///  --- Debug --- ///
    private PlayerParty party  = new PlayerParty(players[0], players[1], players[2], players[3]);
    private EnemyGroup enemyGroup = new EnemyGroup(enemies);
    
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
    
    public Enemy[] createTemplateEnemies(int amount) {
        Enemy[] enemies = new Enemy[amount];
        
        enemies[0] = new Enemy("Green Slime", "Slimes", 8, 10, 2);
        enemies[1] = new Enemy("Red Slime", "Slimes");
        enemies[2] = new Enemy("Fire Dragon", "Lizardlikes");
        
        return enemies;
    }
}
