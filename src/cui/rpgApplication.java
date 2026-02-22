package cui;

import domain.*;

public class rpgApplication {
    public rpgApplication(DomainController dc){
        System.out.printf(dc.getParty().toString());
        System.out.printf("%n%n");
        System.out.printf(dc.getEnemyGroup().toString());
    }
}
