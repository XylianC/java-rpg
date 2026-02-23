package persistance;

import domain.Enemy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class EnemyRepository {
    private HashMap<String, Enemy> enemies = new HashMap<>();
    
    public EnemyRepository() throws ParserConfigurationException, IOException, SAXException {
        loadEnemies();
    }
    
    public Enemy getEnemy(String enemy_code) {
        return enemies.get(enemy_code);
    }
    
    public void loadEnemies() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc = db.parse(getClass().getResourceAsStream("/enemies.xml"));
        
        NodeList enemyNodes = doc.getElementsByTagName("enemy");
        
        for (int i = 0; i < enemyNodes.getLength(); i++) {
            Element enemyElement = (Element) enemyNodes.item(i);
            NodeList possibleAttackNodes = enemyElement.getElementsByTagName("attacklist");
            
            ArrayList<String> possibleAttacks = new ArrayList<>();
            
            for (int j = 0; j < possibleAttackNodes.getLength(); j++) {
                Element attackElement = (Element) possibleAttackNodes.item(j);
                String possibleAttack = attackElement.getElementsByTagName("possibleAttack").item(0).getTextContent();
                
                possibleAttacks.add(possibleAttack);
            
            }
            
            String code = enemyElement.getElementsByTagName("code").item(0).getTextContent();
            String name = enemyElement.getElementsByTagName("name").item(0).getTextContent();
            String type = enemyElement.getElementsByTagName("type").item(0).getTextContent();
            int baseSTR = Integer.parseInt(enemyElement.getElementsByTagName("baseSTR").item(0).getTextContent());
            int baseINTEL = Integer.parseInt(enemyElement.getElementsByTagName("baseINTEL").item(0).getTextContent());
            int baseHP = Integer.parseInt(enemyElement.getElementsByTagName("baseHP").item(0).getTextContent());
            
            Enemy enemyToAdd = new Enemy(code, name, type, baseSTR, baseINTEL, baseHP, possibleAttacks);
            enemies.put(code, enemyToAdd);
        }
    }
}
