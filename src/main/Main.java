package main;

import cgui.OverworldScene;
import domain.DomainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import overworld.GameMap;
import overworld.OverworldPlayer;
import persistence.MapRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        MapRepository mapRepo = new MapRepository("overworld");
        GameMap map = new GameMap(mapRepo);
        
        OverworldPlayer player = new OverworldPlayer(5, 5);
        OverworldScene worldScene = new OverworldScene(map, player);
        
        StackPane root = new StackPane(worldScene.getCanvas());
        int scale = 3;
        Scene scene = new Scene(root, 512 * worldScene.getSCALE(), 256 * worldScene.getSCALE());
        
        scene.setOnKeyPressed(keyEvent -> {
            int direction = 0;
            KeyCode code = keyEvent.getCode();
            switch (code) {
                case UP -> direction = 1;
                case DOWN -> direction = 2;
                case LEFT -> direction = 3;
                case RIGHT -> direction = 4;
                case Z -> direction = 1;
                case S -> direction = 2;
                case Q -> direction = 3;
                case D -> direction = 4;
            }
            player.move(direction, map);
            worldScene.render();
        });
        
        stage.setScene(scene);
        stage.setTitle("CLI & GUI Adventures");
        stage.show();
        
        worldScene.render();
        
        
        DomainController dc = new DomainController();
        //rpgApplication app = new rpgApplication(dc);
    }
}