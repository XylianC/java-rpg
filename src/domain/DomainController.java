package domain;

public class DomainController {
    public DomainController() {
    
    }
    
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
