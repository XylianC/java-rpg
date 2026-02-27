package cgui;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import overworld.GameMap;
import overworld.OverworldPlayer;
import util.TileType;


public class OverworldScene {
    private GameMap map;
    private OverworldPlayer player;
    private Canvas canvas;
    private GraphicsContext gc;
    
    public OverworldScene(GameMap theMap, OverworldPlayer thePlayer) {
        this.map = theMap;
        this.player = thePlayer;
        canvas = new Canvas(512,256);
        gc = canvas.getGraphicsContext2D();
    }
    
    public void render() {
        gc.clearRect(0, 0, 512, 256);
        drawMap();
        drawPlayer();
    }
    
    public void drawMap() {
        for (int row = 0; row < 16; row++) {
            for (int column = 0; column < 32; column++) {
                TileType tileType = map.getTile(row, column).getTileType();
                
                switch (tileType) {
                    case GRASS -> gc.setFill(Paint.valueOf("green"));
                    case DIRT -> gc.setFill(Paint.valueOf("brown"));
                    case SAND -> gc.setFill(Paint.valueOf("yellow"));
                    case WATER -> gc.setFill(Paint.valueOf("blue"));
                    case TOWN -> gc.setFill(Paint.valueOf("red"));
                    case CHEST -> gc.setFill(Paint.valueOf("orange"));
                    default -> gc.setFill(Paint.valueOf("black"));
                }
                gc.fillRect(column * 16, row * 16, 16, 16);
            
            }
        }
    }
    
    public void drawPlayer() {
        gc.setFill(Paint.valueOf("white"));
        gc.fillRect(player.getPixelX(), player.getPixelY(), 16,16);
    }
    
    public Canvas getCanvas() {
        return canvas;
    }
}
