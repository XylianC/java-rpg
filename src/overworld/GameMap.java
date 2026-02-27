package overworld;

import persistence.MapRepository;

import java.io.IOException;
import java.util.ArrayList;

public class GameMap {
    Tile[][] tiles = new Tile[16][32];
    
    MapRepository mapRepo;
    
    ArrayList<Entity> entities = new ArrayList<>();
    
    public GameMap(MapRepository mapRepo, ArrayList<Entity> entities) throws IOException {
        this.mapRepo = mapRepo;
        tiles = mapRepo.loadMap();
        this.entities = entities;
    }
    
    public Tile getTile(int row, int col) {
        if(row < 0 || col < 0 || row >= 16 || col >= 32) {
            return null;
        } else {
            return tiles[row][col];
        }
    }
    
    public boolean isWalkable(int row, int col) {
        if(row < 0 || col < 0 || row >= 16 || col >= 32) {
            return false;
        } else {
            if(tiles[row][col].isWalkable()) {
                for (int i = 0; i < entities.size(); i++) {
                    if (entities.get(i).getGridX() == col && entities.get(i).getGridY() == row) {
                        return false;
                    }
                }
            }
            return tiles[row][col].isWalkable();
        }
    }
    
    public void addEntity(Entity entityToAdd) {
        entities.add(entityToAdd);
    }
    
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    // has to read a map from text file.
}
