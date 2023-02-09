package fr.mk.warriors.Model;

import fr.mk.warriors.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Shield {

    WOOD_SHIELD("Wood Shield", 10),
    IRON_SHIELD("Iron Shield", 20),
    GOLD_SHIELD("Gold Shield", 40),
    DEVIL_SHIELD("Devil Shield", 100);


    public static final String SHIELD_EMOJI = Utils.unicodeToString(0x1F6E1);
    private final String name;
    private final int defenseBonus;

    private Shield(String name, int defenseBonus){
        this.name = name;
        this.defenseBonus = defenseBonus;
    }

    /**
     * Select a random Shield.
     */

    public static Shield ofRandom(){
        List<Shield> shields = Arrays.asList(Shield.values());
        int randomShieldIndex = new Random().nextInt(shields.size());

        return shields.get(randomShieldIndex);
    }

    @Override
    public String toString() {return SHIELD_EMOJI + name + "(+ " + defenseBonus + "defense)";}

    public int getDefenseBonus() {
        return defenseBonus;
    }
}
