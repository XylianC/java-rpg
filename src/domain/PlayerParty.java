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
    public PlayerCharacter getPlayerBySlot(int slot) {
        return players[slot];
    }
    
    // -- Setters -- //
    
    // -- Andere Methoden -- //
    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        
        strB.append("The party: \n");
        
        for (int i = 0; i < players.length; i++) {
            strB.append("Slot ").append(i + 1).append(": ");
            strB.append(players[i].toString());
            strB.append("\n");
            
        }
        
        return strB.toString();
    }
}
