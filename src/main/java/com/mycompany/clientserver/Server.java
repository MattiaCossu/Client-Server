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
    boolean status = false;
    
    Server(int porta) throws Exception
    {
        try {
            //istanzio oggetto Server
            Server = new ServerSocket(porta);
            System.out.println("Il Server è in attesa sulla porta selezionata.");           
            this.start();
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
        while(status != true)
        {
            System.out.println(this.isStatus());
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

    public boolean isStatus() {
        return status;
    }
    
    public void stopServer(){
        boolean stop = false;
        setStatus(stop);
    }
    
    public void restartServer(){
        boolean start = true;
        setStatus(start);
    }
    
    public void killServer(){
        this.interrupt();
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
}
