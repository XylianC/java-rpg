package cui;

import domain.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class rpgApplication {
    BattleScene battleScene;
    
    public rpgApplication(DomainController dc) throws ParserConfigurationException, IOException, SAXException {
        boolean bossMonster = false;
        
        BattleManager battleMan;
        if(bossMonster) {
            battleMan = new BattleManager(dc.getParty(), dc.getEnemyGroup(), dc.getAttackRepo(), dc.getBossMonster());
        } else {
            battleMan = new BattleManager(dc.getParty(), dc.getEnemyGroup(), dc.getAttackRepo());
        }
        battleScene = new BattleScene(battleMan);
        
        battleScene.drawFightScene();
    }
}
