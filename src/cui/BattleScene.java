package cui;

import domain.BattleManager;
import domain.Enemy;
import domain.PlayerCharacter;
import domain.PlayerParty;

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
        doPlayerTurn();
        enemyTurn();
    }
    
    public void doPlayerTurn() {
        System.out.printf("Player turn%n----------%n");
        
        printEnemiesAlive();
        
        for (int i = 0; i < battleMan.getPartySize(); i++) {
            PlayerCharacter activeCharacter = battleMan.getCharacterInfo(i);
            
            System.out.printf("----------%nWhat would %s like to do:%n", activeCharacter.getName());
            System.out.println("1: Attack");
            System.out.println("2: Magic");
            System.out.println("3: Defend");
            System.out.println("4: Flee");
            
            int input = scanner.nextInt();
            characterTurn(input, activeCharacter);
        }
        
        
    }
    
    public void characterTurn(int choice, PlayerCharacter activeChar) {
           switch(choice) {
               case 1 -> {
                   System.out.printf("%s chose to attack%n", activeChar.getName());
                   System.out.println("Which target would you like to attack?");
                   printEnemiesAlive();
                   int input = scanner.nextInt();
                   
                   Enemy target = battleMan.getAliveEnemies().get(input - 1);
                   battleMan.doPlayerAttack(target, activeChar);
                   
               }
               case 2 -> {
                   System.out.println("You chose to do magic");
               }
               case 3 -> {
                   System.out.println("You chose to defend");
               }
               case 4 -> {
                   System.out.println("You chose to flee");
                   
               }
           }
    }
    
    public void enemyTurn () {
        System.out.println("Does nothing yet");
    }
    
    public void printEnemiesAlive() {
        System.out.println("Currently: These enemies are in the fight:");
        
        ArrayList<Enemy> enemiesThisTurn = battleMan.getAliveEnemies();
        
        for (Enemy enemy : enemiesThisTurn) {
            System.out.println(enemy.toString());
            System.out.println();
        }
        
    }
    
}

