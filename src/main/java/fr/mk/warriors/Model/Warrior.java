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

public void attack (Warrior opponent){
    int attackBonus = weapon == null ? 0 : weapon.getAttackBonus();
    int cumulatedAttack = attack + attackBonus;

    String msgDetails = "+" + attack + ATTACK_EMOJI;
    msgDetails += " +" + attackBonus + Weapon.WEAPON_EMOJI;
    String msg = name + " : I attack " + opponent.name + " with " + cumulatedAttack + " (" + msgDetails + ")" + " points";
    System.out.println(msg);

    opponent.defend(this, cumulatedAttack);
}

    private void defend(Warrior opponent, int attack) {
        int shieldDefenseBonus = shield == null ? 0 : shield.getDefenseBonus();
        int cumulatedDefense = defense + shieldDefenseBonus;

        int damage = Math.max(0, attack - cumulatedDefense);
        health = Math.max(0, health - damage);

        String msgDetails = "+" + defense + DEFENSE_EMOJI;
        msgDetails += " +" + shieldDefenseBonus + Shield.SHIELD_EMOJI;
        String msg = name + " : I defend against " + opponent.name + " with " + cumulatedDefense + " (" + msgDetails + ") points : " + damage + " damage points -> health = " + health + HEALTH_EMOJI;
        System.out.println(msg);

        // Drop eventually Shield when damage is too high (it breaks !)
        if (shield != null && attack > shieldDefenseBonus) {
            dropShield();
        }
    }

    private void dropShield() {
    System.out.println(name + " : Je dois déposé mon bouclier (il est cassé) ! : " + this.shield);
    shield = null;
}


}
