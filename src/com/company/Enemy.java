package com.company;

public class Enemy extends Avatar {

    Enemy(int strength, int intel, int speed, int health, int money, int exp, int lvl, String name) {
        super(strength-1, intel-20, speed+3, health-20, money, exp, lvl, name);
    }
}
