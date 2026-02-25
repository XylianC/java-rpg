package domain;

import util.Elements;
import java.util.ArrayList;

public class BossMonster extends Combatant {
    public BossMonster(String bossName, int level, int bossStr, int bossIntel, int bossHp, int bossMp) {
        super(bossName, level, bossStr, bossIntel, bossHp, bossMp);
    }
    
    @Override
    public String toString() {
        return String.format("Boss Monster: %s%n-Level: %d%n- Health: %d/%d%n- Magic: %d/%d%n", getName(), getLevel(), getHp(), getMaxHP(), getMp(), getMaxMp());
    }
}
