package fr.mk.warriors.Model;

import fr.mk.warriors.Utils;

public class Warrior {
    public static final String HEALTH_EMOJI = Utils.unicodeToString(0x1F496);
    public static final String DEFENSE_EMOJI = Utils.unicodeToString(0x1F44C);
    public static final String ATTACK_EMOJI = Utils.unicodeToString(0x1F4AA);

    private String name;
    private int health;
    private int defense;
    private int attack;

private Shield shield;

private Weapon weapon;

private Warrior(){
}

public Warrior (String name, int health, int defense, int attack){
    this();
    this.name = name;
    this.health = health;
    this.defense = defense;
    this.attack = attack;
}

@Override
    public String toString(){
    return name + "(health = " + health + HEALTH_EMOJI + ", defense =" + defense + DEFENSE_EMOJI + ", attack = " + attack + ATTACK_EMOJI + ", shield = " + shield + ", weapon = " + weapon + ")";
}



}
