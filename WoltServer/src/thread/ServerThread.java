/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anđela
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private final int PORT = 9000;
    private boolean end = false;
    private int clientNumber = 0;

    public ServerThread() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server osluškuje na portu " + PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            try {
                while (!serverSocket.isClosed() && !end) {
                    Socket socket = serverSocket.accept();
                    clientNumber++;
                    System.out.println("Klijent " + clientNumber + " se povezao!");
                    ClientHandler ch = new ClientHandler(socket,clientNumber);
                    ServerController.getInstance().getClients().add(ch);
                    ch.start();
                }
            } catch (SocketException e) {
                System.out.println("Server je zatvoren ili je prekinuta veza: " + e.getMessage());
            }
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            shutDown();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    private void shutDown() {
        end = true;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            for (ClientHandler client : ServerController.getInstance().getClients()) {
                    client.closeSocket();
                }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, "Greška pri zatvaranju servera", ex);
        }
    }

}
