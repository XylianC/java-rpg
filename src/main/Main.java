package main;

import domain.Enemy;
import domain.EnemyGroup;
import domain.PlayerCharacter;
import domain.PlayerParty;

public class Main {
    public static void main(String[] args) {
        PlayerCharacter[] players = createTemplatePlayers();
        PlayerParty party  = new PlayerParty(players[0], players[1], players[2], players[3]);
        
        Enemy[] enemies = createTemplateEnemies(3);
        EnemyGroup enemyGroup = new EnemyGroup(enemies);
        
        System.out.printf(party.toString());
        
        System.out.printf("%n%n");
        
        System.out.printf(enemyGroup.toString());
    }
    
    private static PlayerCharacter[] createTemplatePlayers() {
        PlayerCharacter[] players = new PlayerCharacter[4];
        
        players[0] = new PlayerCharacter("Xylian", "Warrior");
        players[1] = new PlayerCharacter("Millia");
        players[2] = new PlayerCharacter("Ruben", "Monk");
        players[3] = new PlayerCharacter("Mattis", "Scholar");
        
        return players;
    }
    
    private static Enemy[] createTemplateEnemies(int amount) {
        Enemy[] enemies = new Enemy[amount];
        
        enemies[0] = new Enemy("Green Slime", "Slimes", 8, 10, 2);
        enemies[1] = new Enemy("Red Slime", "Slimes");
        enemies[2] = new Enemy("Fire Dragon", "Lizardlikes");
        
        return enemies;
    }
}