package me.gaptixa;

import java.util.Scanner;

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

public class LatihanMethod1 {

    public static void main(String[] args) {

        boolean masih = true;
        boolean created = false;
        Scanner scan = new Scanner(System.in);
        Player player = null;
        Weapon senjata = null;
        Armor armor = null;

        while (masih){
            System.out.print("Masukkan perintah: ");
            String cmd = scan.nextLine();

            switch (cmd) {
                case "playercreate":
                        created = true;
                        System.err.print("Masukkan nama player: ");
                        String name = scan.nextLine();
                        System.err.print("Masukkan ID player: ");
                        int id = scan.nextInt();
                        player = createPlayer(name, id);
                        System.out.println("Player berhasil dibuat!");
                    break;
                case "showstats":
                        if(!(player == null)){
                            showStats(player);
                        } else {
                            System.out.println("Player belum ada");
                        }
                    break;
                case "exit":
                        masih = false;
                    break;
                case "createweapon":
                        if((senjata == null)){
                            System.err.print("Masukkan nama senjata: ");
                            String namaSenjata = scan.nextLine();
                            System.err.print("Masukkan Damage senjata: ");
                            int damageSenjata = scan.nextInt();
                            senjata = createWeapon(namaSenjata, damageSenjata);
                            System.out.println("Senjata berhasil dibuat");
                        } else {
                            System.out.println("Senjata sudah ada");
                        }
                    break;
                case "createarmor":
                        if((armor == null)){
                            System.err.print("Masukkan nama senjata: ");
                            String namaArmor = scan.nextLine();
                            System.err.print("Masukkan defense armor: ");
                            int defenseArmor = scan.nextInt();
                            armor = createArmor(namaArmor, defenseArmor);
                            System.out.println("Armor berhasil dibuat");
                        } else {
                            System.out.println("Armor sudah ada");
                        }
                    break;
                case "addarmor":
                    if(!(armor == null)){
                        if(!(armor == null)){
                            addArmor(player, armor);
                            System.out.println("berhasil menambahkan armor ke player");
                        }
                    } else {
                        System.out.println("Armor belum ada");
                    }
                    break;
                case "addweapon":
                    if(!(senjata == null)){
                        if(!(senjata == null)){
                            addWeapon(player, senjata);
                            System.out.println("berhasil menambahkan senjata ke player");
                        }
                    } else {
                        System.out.println("Senjata belum ada");
                    }
                    break;
            }
        }

    }

    public static Player createPlayer(String name, int id){
        return new Player(name, id);
    }

    public static Armor createArmor(String name, int defense){
        return new Armor(name, defense);
    }

    public static Weapon createWeapon(String name, int damage){
        return new Weapon(name, damage);
    }

    public static void showStats(Player player){
        player.showStats();
    }

    public static void addArmor(Player player, Armor armor){
        player.equipArmor(armor);
    }

    public static void addWeapon(Player player, Weapon weapon){
        player.equipWeapon(weapon);
    }

}
