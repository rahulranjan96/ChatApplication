/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahulranjan96
 */
public class MessageTransmitter extends Thread {
     
    String message,hostname;
    int port;
    public MessageTransmitter()
    {
        
    }
    public MessageTransmitter(String message,String hostname,int port){
        this.message=message;
        this.hostname=hostname;
        this.port=port;
    }
    @Override
    public void run()
    {
        try {
            try (Socket s = new Socket(hostname,port)) {
                s.getOutputStream().write(message.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    
    }
    

