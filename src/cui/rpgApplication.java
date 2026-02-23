package cui;

import domain.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class rpgApplication {
    BattleScene battleScene;
    
    public rpgApplication(DomainController dc) throws ParserConfigurationException, IOException, SAXException {
        
        BattleManager battleMan = new BattleManager(dc.getParty(), dc.getEnemyGroup());
        battleScene = new BattleScene(battleMan);
        
        battleScene.drawFightScene();
    }
}
