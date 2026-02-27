package cgui;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import overworld.Entity;
import overworld.GameMap;
import overworld.OverworldPlayer;
import util.TileType;


public class OverworldScene {
    private GameMap map;
    private OverworldPlayer player;
    private Canvas canvas;
    private GraphicsContext gc;
    
    private static final int SCALE = 3;
    
    
    public OverworldScene(GameMap theMap, OverworldPlayer thePlayer) {
        this.map = theMap;
        this.player = thePlayer;
        canvas = new Canvas(512 * SCALE,256 * SCALE);
        gc = canvas.getGraphicsContext2D();
        gc.setImageSmoothing(false);
    }
    
    public void render() {
        gc.clearRect(0, 0, 512 * SCALE, 256 * SCALE);
        drawMap();
        drawEntities();
        drawPlayer();
    }
    
    public void drawMap() {
        for (int row = 0; row < 16; row++) {
            for (int column = 0; column < 32; column++) {
                TileType tileType = map.getTile(row, column).getTileType();
                
                gc.drawImage(map.getTile(row, column).getSprite(), column * 16 * SCALE, row * 16 * SCALE, 16 * SCALE, 16 * SCALE);
            }
        }
    }
    
    public void drawEntities() {
        for (int i = 0; i < map.getEntities().size(); i++) {
            Entity entityToDraw = map.getEntities().get(i);
            gc.drawImage(entityToDraw.getSprite(), entityToDraw.getPixelX() * SCALE, entityToDraw.getPixelY() * SCALE, 16 * SCALE, 16 * SCALE);
        
        }
    }
    
    public void drawPlayer() {
        gc.drawImage(player.getSprite(), player.getPixelX() * SCALE, player.getPixelY() * SCALE, 16 * SCALE,16 * SCALE);
    }
    
    public Canvas getCanvas() {
        return canvas;
    }
    
    public int getSCALE() {
        return SCALE;
    }
}
