package com.company;

public class Mage extends Avatar{
    Mage(int strength, int intel, int speed, int health, int money, int exp, int lvl, String name) {
        super(strength, intel+5, speed, health+10, money, lvl, exp, name);
        System.out.println("Vitej "+ name);
    }
}
