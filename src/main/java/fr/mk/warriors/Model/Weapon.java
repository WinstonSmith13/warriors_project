package fr.mk.warriors.Model;

import fr.mk.warriors.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Weapon {

    SHORT_SWORD ("Short Sword", 10),
    BASTARD_SWORD ("Bastard Sword", 20),
    AXE_SWORD("Axe Sword", 15);

    public static final String WEAPON_EMOJI = Utils.unicodeToString(0x1F5E1);
    private final String name;
    private final int attackBonus;

    private Weapon(String name, int attackBonus){
        this.name = name;
        this.attackBonus = attackBonus;
    }

    /**
     * Select a random Weapon.
     */

    public static Weapon ofRandom(){
        List<Weapon> weapons = Arrays.asList(Weapon.values());
        int randomWeaponIndex = new Random().nextInt(weapons.size());

        return weapons.get(randomWeaponIndex);
    }

    @Override
    public String toString(){return WEAPON_EMOJI + name + "(+ " + attackBonus + "attack)";}

    public int getAttackBonus() {return attackBonus;}
}
