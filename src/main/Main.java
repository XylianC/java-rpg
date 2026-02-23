package main;

import domain.DomainController;
import cui.rpgApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DomainController dc = new DomainController();
        rpgApplication app = new rpgApplication(dc);
    }
}