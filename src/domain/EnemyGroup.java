package domain;

import java.util.ArrayList;

public class EnemyGroup {
    // ------ Attributes ------ //
    private ArrayList<Enemy> enemies = new ArrayList<>();
    
    // ------ Constructors ------ //
    public EnemyGroup(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
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
    
    public ArrayList<Enemy> getEnemiesAlive() {
        ArrayList<Enemy> enemiesAlive = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (enemy.getHp() > 0) {
                enemiesAlive.add(enemy);
            }
        }
        return enemiesAlive;
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
