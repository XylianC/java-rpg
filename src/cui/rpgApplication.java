package cui;

import domain.*;

public class rpgApplication {
    BattleScene battleScene;
    
    public rpgApplication(DomainController dc){
        
        BattleManager battleMan = new BattleManager(dc.getParty(), dc.getEnemyGroup());
        battleScene = new BattleScene(battleMan);
        
        battleScene.drawFightScene();
    }
}
