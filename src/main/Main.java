package main;

import cgui.OverworldScene;
import domain.DomainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import overworld.Entity;
import overworld.GameMap;
import overworld.OverworldPlayer;
import overworld.Tile;
import persistence.DialogueRepository;
import persistence.MapRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    ArrayList<Entity> entitiesToSpawnDEBUG = new ArrayList<>();
    
    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        MapRepository mapRepo = new MapRepository("overworld");
        DialogueRepository dialogueRepo = new DialogueRepository();
        createTemplateEntities();
        GameMap map = new GameMap(mapRepo, entitiesToSpawnDEBUG);
        
        OverworldPlayer player = new OverworldPlayer(5, 5);
        OverworldScene worldScene = new OverworldScene(map, player, dialogueRepo);
        
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
                case E -> {
                    if(worldScene.isDialogueActive()){
                        worldScene.advanceDialogue();
                    } else {
                        Entity nearbyEntity = player.getNearbyEntity(map);
                        if(nearbyEntity != null) {
                            worldScene.startDialogue(nearbyEntity.getEntityName());
                        }
                        Tile nearbyTile = player.getNearbyInteractable(map);
                        if (nearbyTile != null) {
                            // trigger tile interaction
                        }
                    }
                    
                }
                case SPACE -> {
                    if(worldScene.isDialogueActive()){
                        worldScene.advanceDialogue();
                    } else {
                        Entity nearbyEntity = player.getNearbyEntity(map);
                        if(nearbyEntity != null) {
                            worldScene.startDialogue(nearbyEntity.getEntityName());
                        }
                        Tile nearbyTile = player.getNearbyInteractable(map);
                        if (nearbyTile != null) {
                            // trigger tile interaction
                        }
                    }
                }
            }
            if(!worldScene.isDialogueActive()) {
                player.move(direction, map);
            }
            worldScene.render();
        });
        
        stage.setScene(scene);
        stage.setTitle("CLI & GUI Adventures");
        stage.show();
        
        worldScene.render();
        
        // DomainController dc = new DomainController();
        // rpgApplication app = new rpgApplication(dc);
    }
    
    public void createTemplateEntities() {
        Entity entityToSpawn = new Entity(6, 4, "Mage", "monk");
        entitiesToSpawnDEBUG.add(entityToSpawn);
    }
    
}