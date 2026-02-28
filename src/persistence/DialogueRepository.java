package persistence;

import domain.Attack;
import domain.Enemy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.Elements;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DialogueRepository {
    private HashMap<String, ArrayList<String>> dialogues = new HashMap<>();
    
    
    public DialogueRepository() throws ParserConfigurationException, IOException, SAXException {
        loadDialogues();
    }
    
    public void loadDialogues() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc = db.parse(getClass().getResourceAsStream("/dialogues.xml"));
        
        NodeList npcNodes = doc.getElementsByTagName("NPC");
        
        for (int i = 0; i < npcNodes.getLength(); i++) {
            Element npcElement = (Element) npcNodes.item(i);
            
            NodeList possibleAttackNodes = npcElement.getElementsByTagName("dialogue");
            ArrayList<String> dialogueLines = new ArrayList<>();
            
            for (int j = 0; j < possibleAttackNodes.getLength(); j++) {
                Element attackElement = (Element) possibleAttackNodes.item(j);
                NodeList attackCodes = attackElement.getElementsByTagName("line");
                
                for (int k = 0; k < attackCodes.getLength(); k++) {
                    String possibleAttack = attackElement.getElementsByTagName("line").item(k).getTextContent();
                    dialogueLines.add(possibleAttack);
                }
            }
            
            String npcName = npcElement.getElementsByTagName("npcName").item(0).getTextContent();
            dialogues.put(npcName, dialogueLines);
            
        }
    }
    
    public ArrayList<String> getDialogue(String npcName) {
        return dialogues.get(npcName);
    }
}
