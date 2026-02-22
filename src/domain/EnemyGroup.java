package domain;

import java.util.ArrayList;

public class EnemyGroup {
    // ------ Attributes ------ //
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    
    // ------ Constructors ------ //
    public EnemyGroup(Enemy[] enemies) {
        for (Enemy enemy : enemies) {
            addEnemy(enemy);
        }
    }
    
    // ------ Getters ------ //
    
    // ------ Setters ------ //
    
    // ------ Class Methods ------ //
    private void addEnemy(Enemy newEnemy) {
        enemies.add(newEnemy);
    }
    
    public void removeEnemy(int slot) {
        enemies.remove(slot);
    }
    
    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        
        strB.append("Enemy Group: \n");
        
        for (Enemy enemy : enemies) {
            strB.append(enemy.toString());
            strB.append("\n");
        }
        
        return strB.toString();
    }
    
}
