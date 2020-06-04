package com.company;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Menu {

    private ClientSideConnection csc;
    private int playerID;
    private int otherPlayer;
    int moznostint;
    boolean p1won;
    public Menu(){
        p1won = true;
    }

    public void connectToServer( int streng, int intel, int speed,int health){
        csc = new ClientSideConnection(streng,intel,speed,health);
    }

    String[] moznost = {"1. Objevuj","2. Bojuj","3. Nakupuj","4. O tobe","5. Konec"};
    public void menu(int strength, int intel, int speed, int health, int money,int xp,int lvl, String jmenoAvatara){
        boolean pokracovat = true;
        while(pokracovat==true) {

            Scanner ziskejMoznost = new Scanner(System.in);
            System.out.println("Vyber, co chceš dělat dál.");
            for (int i = 0; i < moznost.length; i++) {
                System.out.println(moznost[i]);
            }
            moznostint = ziskejMoznost.nextInt();

            switch (moznostint) {
                case 1:
                    Explore explore = new Explore();
                    explore.menuExplore();
                    explore.cesty(explore.cesta);
                    strength = explore.getStrength();
                    break;
                case 2:
                    Scanner in = new Scanner(System.in);
                    System.out.println("Pomalu se připravuj na souboj " + jmenoAvatara);
                    System.out.println("Ješte ti před soubojem dám jednu volbu. Realný hráč(nejdříve se musí spustit FightServer)/ Nerealný(jednoduchy) -> 1/2");
                    int volbaOO = in.nextInt();
                    switch (volbaOO){
                        case 1:
                            connectToServer( strength, intel, speed, health);
                            money += 20;
                            strength += 2;
                            speed += 2;
                            intel += 1;
                            break;
                        case 2:
                            FightServer fs = new FightServer();
                            Enemy en = new Enemy(15,15,20,1000,200,1,1,"Obr");
                            p1won = fs.fight(strength, intel, speed, health,en.strength,en.speed,en.intelect,en.health,this.p1won);
                            System.out.println("Souboj právě probíha....");
                            try {
                                Thread.sleep(2000);
                            }catch(Exception e){}
                            if(p1won){
                               System.out.println("Vyhrál jsi!\n Jako odměna pro tebe budou mince a spoustu dalšího. Vše si můžeš oveřít v části \"O tobě\"");
                                money += 20;
                                strength += 2;
                                speed += 2;
                                intel += 1;
                            }else{
                                System.out.println("Prohrál jsi!\nVe hře nemůžeš nadále pokračovat.\n Byl jsi dobrý hráč.\n Brzy přijď znovu");
                                System.exit(0);
                            }
                            break;
                        default:
                            System.out.println("Vidím, že jsi nevybral ani jednu možnost, proto jsem ti vybral ralného hrače.");
                            connectToServer( strength, intel, speed, health);
                    }
                    break;
                case 3:
                     Shop shop = new Shop();
                     shop.shopMenu(money);
                     System.out.println(shop.getSpent());
                     money -= shop.getSpent();
                     strength += shop.getStrength();
                     lvl += shop.getLevel();
                     intel +=shop.getIntelect();
                    break;
                case 4:
                    System.out.println( "Tvoje síla: " + strength + "\n" + "Tvůj intelekt: " + intel + "\n" + "Tvoje mince: " + money + "\nTvoje rychlost " + speed);
                    break;
                case 5:
                    System.out.println(jmenoAvatara + " hrál jsi dobře. \nUvidíme se příště.");
                    pokracovat = false;
                    break;
                default:

            }
        }
    }
    private class ClientSideConnection{
        private Socket socket;
        private DataOutputStream dataOut;
        private DataInputStream dataIn;
        private boolean p1won;
        public ClientSideConnection(int strength,int intel, int speed, int health){
            try{
                socket = new Socket("localhost", 5560);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                playerID = dataIn.readInt();
                dataOut.writeInt(strength);
                dataOut.writeInt(intel);
                dataOut.writeInt(speed);
                dataOut.writeInt(health);
                p1won = dataIn.readBoolean();
            }catch(IOException e){}
            System.out.println("Souboj prave probiha....");
            try {
                Thread.sleep(5000);
            }catch (Exception e){

            }
            if(playerID == 1 && p1won == true){
                System.out.println("Vyhrál jsi!");
            }else if(playerID == 2 && p1won == false){
                System.out.println("Vyhral jsi!");
            }else{
                System.out.println("Souboj jsi prohral\nVe hre nemuzes nadale pokracovat.\n Byl jsi dobry hrac.\n Brzi prijd znovu");
                System.exit(0);
            }
        }
    }

}
