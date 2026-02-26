package main;

import domain.DomainController;
import cui.rpgApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new StackPane(), 512, 256);
        stage.setScene(scene);
        stage.setTitle("CLI & GUI Adventures");
        stage.show();
        
        
        
        DomainController dc = new DomainController();
        //rpgApplication app = new rpgApplication(dc);
    }
}