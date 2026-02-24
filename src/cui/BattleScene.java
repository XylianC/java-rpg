package cui;

import domain.*;

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
        
        printPlayerCharactersAlive();
        
        printEnemiesAlive();
        
        for (int i = 0; i < battleMan.getPartySize(); i++) {
            if(battleMan.getBattleActive()) {
                PlayerCharacter activeCharacter = battleMan.getCharacterInfo(i);
                
                System.out.printf("----------%nWhat would %s like to do:%n", activeCharacter.getName());
                System.out.println("1: Attack");
                System.out.println("2: Magic");
                System.out.println("3: Defend");
                System.out.println("4: Flee");
                
                int input = scanner.nextInt();
                characterTurn(input, activeCharacter);
            } else {
                battleMan.finishBattle();
                return;
            }
        }
        
        
    }
    
    public void characterTurn(int choice, PlayerCharacter activeChar) {
           switch(choice) {
               case 1 -> {
                   System.out.printf("%s chose to attack%n", activeChar.getName());
                   
                   Enemy target = chooseTarget();
                   battleMan.doPlayerAttack(target, activeChar);
               }
               case 2 -> {
                   System.out.printf("%s chose to use a spell:%n", activeChar.getName());
                   System.out.printf("What spell do you want to use? %n");
                   
                   for (int i = 0; i < activeChar.getPossibleAttacks().size(); i++) {
                       System.out.print(i + ": ");
                       System.out.println(activeChar.getPossibleAttacks().get(i));
                   }
                   
                   System.out.print("Choose an attack: ");
                   int input = scanner.nextInt();
                   Attack chosenAttack = battleMan.getSpecificAttack(activeChar.getPossibleAttacks().get(input));
                   
                   
                   Enemy target = chooseTarget();
                   battleMan.doPlayerMagic(target, chosenAttack, activeChar);
               }
               case 3 -> {
                   System.out.printf("%s chose to defend%n", activeChar.getName());
                   battleMan.doPlayerDefend();
               }
               case 4 -> {
                   System.out.printf("%s chose to flee%n", activeChar.getName());
                   battleMan.doPlayerFlee();
                   
               }
           }
    }
    
    public void enemyTurn () {
        battleMan.doEnemyTurn();
    }
    
    public void printEnemiesAlive() {
        System.out.println("Currently: These enemies are in the fight:");
        
        ArrayList<Enemy> enemiesThisTurn = battleMan.getAliveEnemies();
        
        for (Enemy enemy : enemiesThisTurn) {
            System.out.println(enemy.toString());
            System.out.println();
        }
        
    }
    
    public void printEnemiesAliveShort() {
        System.out.println("Possible Targets:");
        
        ArrayList<Enemy> enemiesThisTurn = battleMan.getAliveEnemies();
        
        for (int i = 0; i < enemiesThisTurn.size(); i++) {
            System.out.print("Slot " + (i + 1) + ": ");
            System.out.println(enemiesThisTurn.get(i).getShortString());
        }
        
    }
    
    public void printPlayerCharactersAlive() {
        System.out.println("Currently, these players are in the fight");
        
        ArrayList<PlayerCharacter> playersThisTurn = battleMan.getPartyMembersAlive();
        
        for (PlayerCharacter player : playersThisTurn) {
            System.out.println(player.toString());
            System.out.println();
        }
    }
    
    public Enemy chooseTarget() {
        System.out.println("Which target would you like to attack?");
        printEnemiesAliveShort();
        int input = scanner.nextInt();
        
        return battleMan.getAliveEnemies().get(input - 1);
    }
    
}

