/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import model.Administrator;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anđela
 */
public class Communication {

    private static Communication instance;
    private Socket socket;
    private static final int PORT = 9000;
    private static final String HOST = "localhost";
    private Administrator ulogovani;

    private Communication() {
        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Klijent uspešno povezan");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Administrator ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Administrator getUlogovani() {
        return ulogovani;
    }
    
    public void closeSocket(){
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
