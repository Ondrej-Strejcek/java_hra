package com.company;

public class Warrior extends Avatar{
    public Warrior(int strength, int intel, int speed,int health,int money, int exp, int lvl, String name){
        super(strength+3,intel-2,speed,health+12,money,exp,lvl,name);
        System.out.println("Vitej "+ name);

    }

}
