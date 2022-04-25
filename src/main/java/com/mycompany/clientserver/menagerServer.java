package com.mycompany.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class menagerServer {

    public static void main(String[] args) {

        String choice = null;
        Server server = null;
        boolean status = false;
        stampaMenu();
        do {
            
            System.out.println("INSERISCI DAL MENU: ");
            choice = inputTXT();
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
                }
                case "b" -> {
                    //utilizzo una "fleag" (status) annulla o conferma il ciclo di loop
                    server.stopServer();
                    System.out.println("SERVER IN PAUSA");
                }
                case "c" -> {
                    server.restartServer();
                    System.out.println("SERVER RIPARTITO");
                }
                case "d" -> {
                    //usando interrupt() uccido il THREAD
                    server.killServer();
                    System.out.println("SERVER SPENTO");
                }
                default -> {
                    status = true;
                }
            }
        } while (status = true);
    }

    static String inputTXT() {
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    static void stampaMenu() {
        System.out.println("***********************");
        System.out.println("Command Options: ");
        System.out.println("a: Start Server");
        System.out.println("b: Pause Server");
        System.out.println("c: Restart Server");
        System.out.println("d: Kill Server");
        System.out.println("q: Quit");
        System.out.println("***********************");
    }
}
