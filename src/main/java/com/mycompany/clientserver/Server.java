package com.mycompany.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artemide
 */
public class Server extends Thread
{
    private ServerSocket Server;
    private boolean status = false;
    
    Server(int porta) throws Exception
    {
        try {
            //istanzio oggetto Server
            Server = new ServerSocket(porta);
            System.out.println("Il Server è in attesa sulla porta selezionata.");           
            //this.start();
            //verifica conessione
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //derivante da RUNNABLE, riscrivo la funzione run che parte a ogni chiamata di start
    @Override
    public void run()
    {
        //loop di attesa
        while(!status)
        {
            try {               
                System.out.println("In attesa di Connessione.");
                //System.out.println(Server.accept());
                //accetta conessione
                Socket client = Server.accept();
                System.out.println("Connessione accettata da: "+
                client.getInetAddress());
                //instanza classe conessione per invio messaggi
                Connected c = new Connected(client);
            }
        catch(IOException e) {}
        }
    }
}
