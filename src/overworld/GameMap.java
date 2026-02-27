package overworld;

import persistence.MapRepository;

import java.io.IOException;

public class GameMap {
    Tile[][] tiles = new Tile[16][32];
    
    MapRepository mapRepo;
    
    public GameMap(MapRepository mapRepo) throws IOException {
        this.mapRepo = mapRepo;
        tiles = mapRepo.loadMap();
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
            return tiles[row][col].isWalkable();
        }
    }
    // has to read a map from text file.
}
