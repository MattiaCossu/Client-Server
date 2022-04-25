package com.mycompany.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author artemide
 */
class Connected extends Thread
{
    private Socket client = null;
    BufferedReader in = null;
    PrintStream out = null;
    public Connected() {}
    
    public Connected(Socket clientSocket)
    {   
        client = clientSocket;
        try
        {
            //instanza dei buffer per i/o
            in = new BufferedReader(
            new InputStreamReader(client.getInputStream()));
            out = new PrintStream(client.getOutputStream(), true);
        }
        catch(IOException e1)
        {
            try 
            { 
                client.close(); 
            }
            catch(IOException e) 
            { 
                System.out.println(e.getMessage());
            }
            return;
        }
        //parta il thread (run())
        this.start();
    }
    
    @Override
    //faccio partire il thread
    public void run()
    {
        try
        {
            out.println("Ti sei Conesso");
            out.flush();
            // chiude gli stream e le connessioni
            out.close();
            in.close();
            client.close();
        }
        catch(IOException e) 
        {
        
        }
    }
}

