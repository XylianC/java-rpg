package cui;

import domain.BattleManager;
import domain.Enemy;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleScene {
    private final BattleManager battleMan;
    private Scanner scanner = new Scanner(System.in);
    
    public BattleScene(BattleManager battleMan) {
        this.battleMan = battleMan;
    }
    
    public void drawFightScene() {
        while(battleMan.getBattleActive()) {
            doBattleCycle();
        }
        battleMan.finishBattle();
    }
    
    public void doBattleCycle() {
        playerTurn();
        enemyTurn();
        
    }
    
    public void playerTurn() {
        System.out.printf("Player turn%n----------%n");
        System.out.println("Currently: These enemies are in the fight:");
        
        ArrayList<Enemy> enemiesThisTurn = battleMan.getAliveEnemies();
        
        for (Enemy enemy : enemiesThisTurn) {
            System.out.println(enemy.toString());
            System.out.println();
        }
        
        System.out.printf("----------%nWhat would you like to do:%n");
        System.out.println("1: Attack");
        System.out.println("2: Magic");
        System.out.println("3: Defend");
        System.out.println("4: Flee");
        
        int input = scanner.nextInt();
        battleMan.doBattleTurn(input);
    }
    
    public void enemyTurn () {
        System.out.println("Does nothing yet");
    }
    
    
}

