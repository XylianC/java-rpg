package persistance;

import domain.Attack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.HashMap;

public class AttackRepository {
    private HashMap<String, Attack> attacks = new HashMap<>();
    
    public AttackRepository() throws ParserConfigurationException, IOException, SAXException {
        loadAttacks();
    }
    
    public Attack getAttack(String attackcode) {
        return attacks.get(attackcode);
    }
    
    public void loadAttacks() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
    
        Document doc = db.parse(getClass().getResourceAsStream("/attacks.xml"));
        
        NodeList attackNodes = doc.getElementsByTagName("attack");
        
        for (int i = 0; i < attackNodes.getLength(); i++) {
            Element attackElement = (Element) attackNodes.item(i);
            String code = attackElement.getElementsByTagName("code").item(0).getTextContent();
            String name = attackElement.getElementsByTagName("name").item(0).getTextContent();
            String element = attackElement.getElementsByTagName("element").item(0).getTextContent();
            int baseDMG = Integer.parseInt(attackElement.getElementsByTagName("baseDMG").item(0).getTextContent());
            int baseACC = Integer.parseInt(attackElement.getElementsByTagName("baseACC").item(0).getTextContent());
            boolean isMagic = Boolean.parseBoolean(attackElement.getElementsByTagName("isMagic").item(0).getTextContent());
        
            Attack atkToAdd = new Attack(code, name, element, baseDMG, baseACC, isMagic);
            attacks.put(code, atkToAdd);
        }
    }
}

