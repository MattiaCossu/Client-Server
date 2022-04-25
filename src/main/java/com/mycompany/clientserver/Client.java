package com.mycompany.clientserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.io.*;
import java.net.*;
 
public class Client
{
    public static void main(String argv[])
    {
        BufferedReader in = null;
        PrintStream out = null;
        Socket socket = null;
        String message;
        InetAddress indirizzo = null;
        
        try
        {
            indirizzo = InetAddress.getLocalHost();
            // open a socket connection
            socket = new Socket(indirizzo, 5656);
            // Apre i canali I/O
            in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);
            // Legge dal server
            message = in.readLine();
            System.out.print("Messaggio Ricevuto : " + message);
            out.close();
            in.close();
        }
        catch(IOException e) 
        { 
            System.out.println("errore di eccezione");}
        } 
    }

