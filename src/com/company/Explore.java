package com.company;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ondrej.strejcek
 */
public class Explore {
    Random rndm = new Random();
    int cesta, strengthAdd;
    String[] msgChest = new String[2];
    String[] msg = new String[5];

    Explore(){
        msgChest[0] = "Našel jsi truhlu. Chceš ji otevřít? Pokud ano zmáčkni 'f' !";
        msgChest[1] = "Jdeš a před tebou truhla. Chceč ji otevřít? Pokud ano zmáčkni 'f' !";
    }
    public void cesty(int vyberCesty){
        switch(vyberCesty){
            case 1:
                System.out.println("Vybral jsi si první cestu. Ušel jsi "+ rndm.nextInt(500)+"m a najednou se před tebou objevil skřet. Radši jsi se otočil a šel zpět.");
                break;
            case 2:
                System.out.println(msgChest[rndm.nextInt(1)]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(InterruptedException ex){}
                for(int i = 0; i <10; i++){
                    System.out.println("...");
                }
                System.out.println("Jejda nestihl jsi to :( ");
                break;
            case 3:
                System.out.println("Vybral jsi si treti cestu. \n Nejdrive vypada trochu nebezpecne. \n Po chvili uz vypada jako kazda jina. \n Najednou se pred tebou objevi lektvar. \n Chces ho vypit? a/n");
                Scanner vypitLektvar = new Scanner(System.in);
                String pokracovatDal = vypitLektvar.nextLine();
                if (pokracovatDal == "a"){
                    System.out.println("Vypil jsi ho.....\n +1 sila");
                    strengthAdd += 1;
                }


                break;
            case 4:
                Scanner pokracovat = new Scanner(System.in);
                System.out.println("Vybral jsi si cestu, na ktere lezi zbran. Zvedl jsi ji a jdes dal.\n Najednou vidis neco divneho nevis co to je...\nChces to vzit? 1/0");
                int volbaVzit = pokracovat.nextInt();
                if(volbaVzit == 1){
                    switch(rndm.nextInt(7)){
                        case 3:
                            strengthAdd += 20;
                            break;
                        default:
                            System.out.println("Jejda zabilo te to...");
                            System.exit(0);
                    }
                }
                strengthAdd += 10;
                break;

            default:
                System.out.println("Vybral/a jsi si cestu, která není na mape.\nJdeš dál.\nPAST!!!\nUMŘEL JSI!");
                System.exit(0);
                break;
        }
    }
    public void menuExplore(){
        System.out.println("Právě jsi začal hru a před sebou vidíš les.\nRozhodl jsi se popojít o "+ rndm.nextInt(1000) + "m.\nPřed sebou vidíš dům. Vedle domu je 4 cesty");
        System.out.println("Kterou půjdeš? Cesty jsou cislovany 1-4...");
        Scanner in = new Scanner(System.in);
        cesta = in.nextInt();
    }
    public int getStrength(){
        return strengthAdd;
    }
}
