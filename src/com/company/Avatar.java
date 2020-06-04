package com.company;

public class Avatar {
    float money;
    String name;
    int health,strength,intelect,speed,experience,level;

    Avatar(int strength, int intel, int speed,int health,int money,int exp, int lvl,String name){
        this.health = health;
        this.strength = strength;
        this.intelect= intel;
        this.speed = speed;
        this.money = money;
        this.name = name;
        this.level = lvl;
        this.experience = exp;
    }
    public void setHealth(int hlt){
        this.health = hlt;
    }
    public void setStrength(int str){
        this.strength = str;
    }
    public void setMoney(int mon){
        this.money = mon;
    }
    public void setIntelect(int intelect){
        this.intelect = intelect;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }
    public int getHealth(){
        return this.health;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getMoney(){
        return (int) this.money;
    }
    public int getIntelect(){
        return this.intelect;
    }
    public int getSpeed(){
        return this.speed;
    }
    public String getName(){
        return this.name;
    }
    public int getExperience(){
        return experience;
    }

}
