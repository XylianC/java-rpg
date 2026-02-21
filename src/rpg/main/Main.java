package rpg.main;


import rpg.domain.PlayerCharacter;

public class Main {
    public static void main(String[] args) {
        PlayerCharacter playerTest = new PlayerCharacter("Xylian");
        System.out.println(playerTest.toString());
    }
}