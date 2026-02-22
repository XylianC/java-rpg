package domain;

public class PlayerParty {
    // -- Attributen -- //
    private final PlayerCharacter[] players = new PlayerCharacter[4];
    
    // -- Constructors -- //
    public PlayerParty(PlayerCharacter player1, PlayerCharacter player2, PlayerCharacter player3, PlayerCharacter player4){
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
    }
    
    // -- Getters -- //
    
    // -- Setters -- //
    
    // -- Andere Methoden -- //
    @Override
    public String toString() {
        return String.format("The Party: %n" +
                "Slot 1: " + players[0].toString() + "%n" +
                "Slot 2: " + players[1].toString() + "%n" +
                "Slot 3: " + players[2].toString() + "%n" +
                "Slot 4: " + players[3].toString() + "%n"
                );
    }
}
