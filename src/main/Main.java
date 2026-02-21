package main;


import domain.Enemy;
import domain.PlayerCharacter;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        
        PlayerCharacter playerTest = new PlayerCharacter("Xylian", "Warrior");
        System.out.println(playerTest.toString());
        
        PlayerCharacter player2Test = new PlayerCharacter("Millia");
        System.out.println(player2Test.toString());
        
        PlayerCharacter player3Test = new PlayerCharacter("Ruben", "Monk");
        System.out.println(player3Test.toString());
        
        PlayerCharacter player4Test = new PlayerCharacter("Mattis", "Scholar");
        System.out.println(player4Test.toString());
        
        System.out.printf("%n%n%n");
        
        Enemy enemyTest1 = new Enemy("Green Slime", "Slimes", 8, 10, 2);
        System.out.println(enemyTest1.toString());
        
        Enemy enemyTest2 = new Enemy("Red Slime", "Slimes");
        System.out.println(enemyTest2.toString());
        
        Enemy enemyTest3 = new Enemy("Fire Dragon", "Lizardlikes");
        System.out.println(enemyTest3.toString());
        
        
        
    }
}