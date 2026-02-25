package persistence;

import domain.Attack;
import domain.BossMonster;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.Elements;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class BossesRepository {
    private HashMap<String, BossMonster> bosses = new HashMap<>();
    
    public BossesRepository() throws ParserConfigurationException, IOException, SAXException {
        loadBosses();
    }
    
    public BossMonster getBoss(String bossName) {
        return bosses.get(bossName);
    }
    
    public void loadBosses() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc = db.parse(getClass().getResourceAsStream("/bosses.xml"));
        
        NodeList bossNodes = doc.getElementsByTagName("boss");
        
        for (int i = 0; i < bossNodes.getLength(); i++) {
            Element bossElement = (Element) bossNodes.item(i);
            
            String name = bossElement.getElementsByTagName("name").item(0).getTextContent();
            int LVL = Integer.parseInt(bossElement.getElementsByTagName("level").item(0).getTextContent());
            int STR = Integer.parseInt(bossElement.getElementsByTagName("baseSTR").item(0).getTextContent());
            int INTEL = Integer.parseInt(bossElement.getElementsByTagName("baseINTEL").item(0).getTextContent());
            int HP = Integer.parseInt(bossElement.getElementsByTagName("baseHP").item(0).getTextContent());
            int MP = Integer.parseInt(bossElement.getElementsByTagName("baseMP").item(0).getTextContent());
            
            
            BossMonster bossToAdd = new BossMonster(name, LVL, STR, INTEL, HP, MP);
            bosses.put(name, bossToAdd);
        }
    }
}
