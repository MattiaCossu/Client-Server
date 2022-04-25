package com.mycompany.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class menagerServer {

    public static void main(String[] args) {

        System.out.println("***********************");
        System.out.println("Command Options: ");
        System.out.println("a: Start Server");
        System.out.println("b: Kill Server");
        System.out.println("q: Quit");
        System.out.println("***********************");

        String choice = null;
        Server server = null;
        choice = inputTXT();
        boolean status = false;
        
        do {
            switch (choice) {
                case "a" -> {
                    try {
                        System.out.print("SCEGLI LA PORTA : \n");
                        int porta = 0;
                        porta = inputINT();
                        server = new Server(porta);
                        break;
                    } catch (Exception ex) {
                        Logger.getLogger(menagerServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("SI POTRA CONTINUARE UNA VOLTA STABILITA LA CONESSIONE!!");
                }
                case "b" -> {
                    server.stop();
                }
                default -> {
                    status = true;    
                }
            }
        }while(status = true);
    }

    static String inputTXT() {
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INSERISCI : ");
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return s;
    }

    static int inputINT() {
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        int intero = Integer.parseInt(s);
        return intero;
    }
}
