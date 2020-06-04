package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.net.*;
public class FightServer {
    private ServerSocket ss;
    private int numPlayers;
    private ServerSideConnection player1;
    private ServerSideConnection player2;
    private ArrayList<Integer> player1stats;
    private ArrayList<Integer> player2stats;
    private int done;
    private boolean won; 

    public FightServer(){
        player1stats = new ArrayList<Integer>();
        player2stats = new ArrayList<Integer>();
        numPlayers =0;
        won = true;
        try{
            ss = new ServerSocket(5560);
        }catch (IOException e){

        }
    }

    public void acceptConnections(){
        try {
            System.out.println("Waiting for connections...");
            while (numPlayers<2){
                Socket s = ss.accept();
                numPlayers++;
                System.out.println("Player has conected");
                ServerSideConnection ssc = new ServerSideConnection(s, numPlayers);
                if(numPlayers == 1){
                    player1 = ssc;
                }else{
                    player2 = ssc;
                }
                Thread t = new Thread(ssc);
                t.start();
            }
            System.out.println("No longer accepting connections");
        }catch(IOException e){

        }
    }


    private class ServerSideConnection implements Runnable {

            private Socket socket;
            private DataInputStream dataIn;
            private DataOutputStream dataOut;
            private int playerID;
            public boolean p1won;

            public ServerSideConnection(Socket s, int id){
                p1won = true;
                socket = s;
                playerID = id;
                try{
                    dataIn = new DataInputStream(socket.getInputStream());
                    dataOut = new DataOutputStream(socket.getOutputStream());
                }catch(IOException e){

                }
            }

            public void run(){
                try{
                    dataOut.writeInt(playerID);
                    dataOut.flush();
                    if (playerID == 1){
                            player1stats.add(dataIn.readInt());
                            player1stats.add(dataIn.readInt());
                            player1stats.add(dataIn.readInt());
                            player1stats.add(dataIn.readInt());
                            System.out.println(player1stats.get(0));

                        }else{
                            player2stats.add(dataIn.readInt());
                            player2stats.add(dataIn.readInt());
                            player2stats.add(dataIn.readInt());
                            player2stats.add(dataIn.readInt());
                            System.out.println(player2stats.get(0));
                            
                        }

                    while(player2stats.size()<4){
                        try{
                            Thread.sleep(1000);
                        }catch(Exception e){}
                        System.out.println("Cekam na protihrace...");
                    }
                    won = fight(player1stats.get(0),player1stats.get(1),player1stats.get(2),player1stats.get(3),player2stats.get(0),player2stats.get(1),player2stats.get(2),player2stats.get(3), p1won);
                        dataOut.writeBoolean(won);
                            dataOut.flush();
                            
                    
                }catch(IOException e){
                System.out.println("Tady je problém");

                }            }


}

    public boolean fight(int strength, int speed, int intel, int health,int p2strength, int p2speed, int p2intel, int p2health,boolean p1won){
        Random rndm = new Random();
        boolean alive = true;
        while(alive) {
            switch (rndm.nextInt(6)) {
                case 1:
                    p2health -= 1.5 * strength * speed * intel;
                    break;
                case 2:
                    p2health -= 30*strength * speed * intel;
                    break;
                case 3:
                    p2health -= 0.2*strength * speed * intel;
                    break;
                case 4:
                    p2health -= 0.7*strength * speed * intel;
                    break;
                case 5:
                    p2health -= 0.1*strength * speed * intel;
                    break;
                case 6:
                    p2health -= 0*strength * speed * intel;
                    break;
            }
            if(p2health<1){
                p1won = true;
                return p1won;
            }
            switch (rndm.nextInt(6)) {
                case 1:
                    health -= 1.5 * p2strength * p2speed * p2intel;
                    break;
                case 2:
                    health -= 30*p2strength * p2speed * p2intel;
                    break;
                case 3:
                    health -= 0.2*p2strength * p2speed * p2intel;
                    break;
                case 4:
                    health -= 0.7*p2strength * p2speed * p2intel;
                    break;
                case 5:
                    health -= 0.1*p2strength * p2speed * p2intel;
                    break;
                case 6:
                    health -= 0*p2strength * p2speed * p2intel;
                    break;
            }
            if(health<1){
                p1won = false;
                return p1won;
            }
        }
        return p1won;
    }

    public static void main(String[] args){
        FightServer fs = new FightServer();
        fs.acceptConnections();
    }

}
