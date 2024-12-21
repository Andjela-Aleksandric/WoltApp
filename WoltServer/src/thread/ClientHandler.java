/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import db.DBBroker;
import java.io.EOFException;
import model.Administrator;
import model.Jelo;
import model.Klijent;
import model.Narudzbina;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdP;
import model.StavkaNarudzbine;
import transport.Request;
import transport.Response;
import transport.ResponseStatus;
import transport.Operation;

/**
 *
 * @author Anđela
 */
public class ClientHandler extends Thread {

    private Socket socket;
    private int clientNumber;

    ClientHandler(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                Request request = receiveRequest();
                Response response = handleRequest(request);
                sendResponse(response);
            }
        } catch (Exception e) {
            System.out.println("Greška prilikom obrade zahteva: " + e.getMessage());
        } finally {
            closeSocket();
        }
    }

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("Greška pri zatvaranju soketa klijenta");
        }
        System.out.println("Nit za klijenta broj " + clientNumber + " je zaustavljena.");
    }

    public Request receiveRequest() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return (Request) ois.readObject();
        } catch (SocketException ex) {
            System.out.println("Klijent je prekinuo konekciju ili je server zatvoren:  " + ex.getMessage());
            closeSocket();
        } catch (EOFException ex) {
            System.out.println("Klijent je zatvorio vezu");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ClientHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        return null;
    }

    public void sendResponse(Response response) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(response);
            oos.flush();
        } catch (SocketException ex) {
            System.out.println("Klijent je prekinuo konekciju ili je server zatvoren:  " + ex.getMessage());
            closeSocket();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ClientHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) request.getData());
                    break;
                case Operation.ADD_ADP:
                    ServerController.getInstance().addAdP((AdP) request.getData());
                    break;
                case Operation.ADD_JELO:
                    ServerController.getInstance().addJelo((Jelo) request.getData());
                    break;
                case Operation.ADD_NARUDZBINA:
                    ServerController.getInstance().addNarudzbina((Narudzbina) request.getData());
                    break;
                case Operation.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) request.getData());
                    break;
                case Operation.DELETE_JELO:
                    ServerController.getInstance().deleteJelo((Jelo) request.getData());
                    break;
                case Operation.DELETE_NARUDZBINA:
                    ServerController.getInstance().deleteNarudzbina((Narudzbina) request.getData());
                    break;
                case Operation.UPDATE_KLIJENT:
                    ServerController.getInstance().updateKlijent((Klijent) request.getData());
                    break;
                case Operation.UPDATE_JELO:
                    ServerController.getInstance().updateJelo((Jelo) request.getData());
                    break;
                case Operation.UPDATE_NARUDZBINA:
                    ServerController.getInstance().updateNarudzbina((Narudzbina) request.getData());
                    break;
                case Operation.GET_ALL_JELO:
                    response.setData(ServerController.getInstance().getAllJelo());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    response.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_MESTO:
                    response.setData(ServerController.getInstance().getAllMesto());
                    break;
                case Operation.GET_ALL_NARUDZBINA:
                    response.setData(ServerController.getInstance().getAllNarudzbina((Klijent) request.getData()));
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_POZICIJA:
                    response.setData(ServerController.getInstance().getAllPozicija());
                    break;
                case Operation.GET_ALL_STAVKA_NARUDZBINE:
                    if (request.getData() instanceof Narudzbina) {
                        response.setData(ServerController.getInstance().getAllStavkaNarudzbine((Narudzbina) request.getData()));
                    } else {
                        response.setData(ServerController.getInstance().getAllStavkaNarudzbineJela((Jelo) request.getData()));
                    }
                    break;
                case Operation.REGISTER:
                    Administrator a = (Administrator) request.getData();
                    ServerController.getInstance().register(a);
                    break;
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) request.getData();
                    Administrator admin = ServerController.getInstance().login(administrator);
                    response.setData(admin);
                    break;
                case Operation.LOGOUT:
                    Administrator ulogovani = (Administrator) request.getData();
                    ServerController.getInstance().logout(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(ex);
        }
        return response;
    }

}
