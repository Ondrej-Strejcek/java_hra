package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        Random rndm = new Random();
        int volba_charakteru;
        String name;

        System.out.println("Vítejte!");
        System.out.println("Křižík RPG.");

        while (true) {
                System.out.println("Zadejte vaše jméno: ");
                    try {
                        Scanner ziskejJmeno = new Scanner(System.in);
                        name = ziskejJmeno.nextLine();
                        break;
                    }catch(Exception e) {
                        System.out.println("Něco se nepovedlo.... Zadejte vaše jméno znovu: ");
        }
        }
        System.out.println("Zvol si svého bojovníka\n1) Warrior\n2) Mage\n3) Hunter\n4)Priest");
        volba_charakteru = in.nextInt();


        switch(volba_charakteru){
            case 1:
                Warrior warrior = new Warrior(15,15,20,1000,200,1,1,name);
                menu.menu(warrior.strength,warrior.intelect, warrior.speed,warrior.health, (int) warrior.money,warrior.experience, warrior.level, warrior.name);
                break;
            case 2:
                Mage mage = new Mage(15,15,20,1000,200,1,1,name);
                menu.menu(mage.strength,mage.intelect, mage.speed,mage.health, (int) mage.money,mage.experience, mage.level, mage.name);
                break;
            case 3:
                Hunter hunter = new Hunter(15,15,20,1000,200,1,1,name);
                menu.menu(hunter.strength,hunter.intelect,hunter.speed,hunter.health, (int) hunter.money,hunter.experience, hunter.level, hunter.name);
                break;
            case 4:
                Priest priest = new Priest(15,15,20,1000,200,1,1,name);
                menu.menu(priest.strength,priest.intelect, priest.speed,priest.health, (int) priest.money,priest.experience,priest.level, priest.name);
                break;
            default:
                System.out.println("Vybral jste neplatnou možnost...\n Hra bude vypnuta");
                System.exit(0);
        }
    }
}

