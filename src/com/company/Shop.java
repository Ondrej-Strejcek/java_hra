package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop {
    ArrayList<String> menu = new ArrayList<String>();
    boolean stay;
    int spent, gainStrength, gainedIntelect, addedLevel;
    int moznost;
    Shop(){
        menu.add("1)+ 2  síla");
        menu.add("2)+ 1 intelekt");
        menu.add("3)+ 1 lvl");
        stay = true;
        spent = 0;
        gainStrength = 0;
        gainedIntelect = 0;
        addedLevel = 0;
    }

    public void shopMenu(int money) {
        if(money<20){
            stay=false;
        }
        while (stay) {
            if(spent< money ) {
                System.out.println("Every item has the same price. 20 coins.");
                for (String i : menu) {
                    System.out.println(i);
                }
                System.out.println("Zadejte číslo možnosti, kterou si chcete koupit");
                System.out.println("Pokud nechcete žádnou zadejte číslo 0.");
                Scanner in = new Scanner(System.in);
                moznost = in.nextInt();
                switch (moznost) {
                    case 0:
                        stay = false;
                        break;
                    case 1:
                        spent += 20;
                        gainStrength += 2;
                        break;
                    case 2:
                        spent += 20;
                        gainedIntelect += 1;
                        break;
                    case 3:
                        spent += 20;
                        addedLevel += 1;
                        break;
                    default:
                        System.out.println("Předmět, který jsi zvolil nemáme. \n Zkusit to můžeš příště!");
                        break;
                }
            }else{
                stay = false;
            }
        }
    }

    public int getSpent(){
        return spent;
    }
    public int getStrength(){
        return gainStrength;
    }
    public int getLevel(){return addedLevel;}
    public int getIntelect(){return gainedIntelect;}


}
