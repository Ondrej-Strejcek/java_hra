package com.company;

public class Priest extends Avatar{
    Priest(int strength, int intel, int speed,int health,int money, int exp, int lvl, String name){
        super(strength,intel+5,speed+3,health,money+20,exp,lvl,name);
        System.out.println("Vitej"+ name);
    }


}
