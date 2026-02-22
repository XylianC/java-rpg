package cui;

import domain.*;

public class rpgApplication {
    public rpgApplication(DomainController dc){
        PlayerCharacter[] players = dc.createTemplatePlayers();
        PlayerParty party  = new PlayerParty(players[0], players[1], players[2], players[3]);
        
        Enemy[] enemies = dc.createTemplateEnemies(3);
        EnemyGroup enemyGroup = new EnemyGroup(enemies);
        
        System.out.printf(party.toString());
        
        System.out.printf("%n%n");
        
        System.out.printf(enemyGroup.toString());
    }
}
