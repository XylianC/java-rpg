package persistence;

import overworld.Tile;
import util.TileType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapRepository {
    String mapName;
    
    public MapRepository(String mapName) {
        this.mapName = mapName;
    }
    
    public Tile[][] loadMap() throws IOException {
        InputStream file = getClass().getResourceAsStream("/maps/" + mapName + ".txt");
        InputStreamReader inputStreamReader = new InputStreamReader(file);
        BufferedReader reader = new BufferedReader(inputStreamReader);
    
        Tile[][] tiles = new Tile[16][32];
        
        String line; int row = 0;
        
        while ((line = reader.readLine()) != null && row < 16){
            String[] columns =line.split(",");
            for (int column = 0; column < columns.length; column++) {
                int type = Integer.parseInt(columns[column]);
                TileType tType = TileType.getTileTypeFromCode(type);
                tiles[row][column] = new Tile(tType);
            }
            row++;
        }
        
        return tiles;
    }
}
