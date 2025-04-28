package me.gaptixa;

class Player {

    String nama;
    int id;
    Weapon senjata;
    Armor armor;
    int damage;
    int defense;

    Player (String nama, int id) {
        this.nama = nama;
        this.id = id;
    }

    void showStats () {
        System.out.println("=====================");
        System.out.println("Nama: " + this.nama);
        System.out.println("ID: " + this.id);
        System.out.println("Senjata: " + ((this.senjata == null) ? "Belum ada senjata" : this.senjata.getName()));
        System.out.println("Armor: " + ((this.armor == null) ? "Belum ada armor" : this.armor.getName()));
        System.out.println("Damage: " + ((this.senjata == null) ? 0 : this.senjata.getDamage()));
        System.out.println("Armor: " + ((this.armor == null) ? 0 : this.armor.getDefense()));
    }

    void equipArmor(Armor armor){
        this.armor = armor;
    }

    void unequipArmor(){
        this.armor = null;
    }

    void equipWeapon(Weapon weapon){
        this.senjata = weapon;
    }

    void unequipWeapon(){
        this.senjata = null;
    }

}

class Weapon {
    String name;
    int damage;

    Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }

    String getName(){
        return this.name;
    }

    int getDamage(){
        return this.damage;
    }

}

class Armor {
    String name;
    int defense;

    Armor (String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    String getName(){
        return this.name;
    }

    int getDefense() {
        return this.defense;
    }
}

public class Main {

    public static void main(String[] args) {

        // PLAYEr
        Player player = new Player("Gaptixa", 10010);
        Player player2 = new Player("Cheviazt", 0);
        player.showStats();
        player2.showStats();
        

        //SENJATA
        Weapon pistol = new Weapon("pistol", 99);
        Weapon pisau = new Weapon("50", 60);

        // ARMOR
        Armor zirahBesi = new Armor("Zirah Besi", 1000);
        Armor zirahBerlian = new Armor("Zirah Berlian", 999999);

        // PLAYER MANAGE
        player.equipArmor(zirahBerlian);
        player.showStats();
        player.equipWeapon(pisau);
        player.showStats();

        player2.equipArmor(zirahBesi);
        player2.showStats();
        player2.equipWeapon(pistol);
        player2.showStats();
    }

}