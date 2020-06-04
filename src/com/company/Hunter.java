package com.company;

public class Hunter extends Avatar{

    Hunter(int strength, int intel, int speed,int health,int money, int exp, int lvl, String name){
        super(strength+5,intel-1,speed+3,health,money,exp,lvl,name);
        System.out.println("Vítej "+ name);
    }
}
