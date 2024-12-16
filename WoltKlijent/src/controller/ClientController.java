/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Administrator;
import model.Jelo;
import model.Klijent;
import model.Mesto;
import model.Narudzbina;
import model.Pozicija;
import model.StavkaNarudzbine;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import communication.Communication;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import transport.Request;
import transport.Response;
import transport.ResponseStatus;
import transport.Operation;

/**
 *
 * @author Anđela
 */
public class ClientController {

    private static ClientController instance;
    private Administrator adminForRegistration;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator getAdminForRegistration() {
        return adminForRegistration;
    }

    public void setAdminForRegistration(Administrator adminForRegistration) {
        this.adminForRegistration = adminForRegistration;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void logout(Administrator ulogovani) throws Exception {
        sendRequest(Operation.LOGOUT, ulogovani);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.ADD_KLIJENT, klijent);
    }

    public void addJelo(Jelo jelo) throws Exception {
        sendRequest(Operation.ADD_JELO, jelo);
    }

    public void addNarudzbina(Narudzbina narudzbina) throws Exception {
        sendRequest(Operation.ADD_NARUDZBINA, narudzbina);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.DELETE_KLIJENT, klijent);
    }

    public void deleteJelo(Jelo jelo) throws Exception {
        sendRequest(Operation.DELETE_JELO, jelo);
    }

    public void deleteNarudzbina(Narudzbina narudzbina) throws Exception {
        sendRequest(Operation.DELETE_NARUDZBINA, narudzbina);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.UPDATE_KLIJENT, klijent);
    }

    public void updateJelo(Jelo jelo) throws Exception {
        sendRequest(Operation.UPDATE_JELO, jelo);
    }

    public void updateNarudzbina(Narudzbina narudzbina) throws Exception {
        sendRequest(Operation.UPDATE_NARUDZBINA, narudzbina);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operation.GET_ALL_KLIJENT, null);
    }

    public ArrayList<Narudzbina> getAllNarudzbina(Klijent klijent) throws Exception {
        return (ArrayList<Narudzbina>) sendRequest(Operation.GET_ALL_NARUDZBINA, klijent);
    }

    public ArrayList<Jelo> getAllJelo() throws Exception {
        return (ArrayList<Jelo>) sendRequest(Operation.GET_ALL_JELO, null);
    }

    public ArrayList<Mesto> getAllMesto() throws Exception {
        return (ArrayList<Mesto>) sendRequest(Operation.GET_ALL_MESTO, null);
    }

    public ArrayList<Pozicija> getAllPozicija() throws Exception {
        return (ArrayList<Pozicija>) sendRequest(Operation.GET_ALL_POZICIJA, null);
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbine(Narudzbina narudzbina) throws Exception {
        return (ArrayList<StavkaNarudzbine>) sendRequest(Operation.GET_ALL_STAVKA_NARUDZBINE, narudzbina);
    }

    public void register(Administrator a) throws Exception {
        this.adminForRegistration = a;
    }

    public void sendRegisterRequest() throws Exception {
        if (adminForRegistration != null) {
            sendRequest(Operation.REGISTER, adminForRegistration);
        }
        adminForRegistration = null;
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        try {
            Request request = new Request(operation, data);

            ObjectOutputStream out = new ObjectOutputStream(Communication.getInstance().getSocket().getOutputStream());
            out.writeObject(request);
            out.flush();

            ObjectInputStream in = new ObjectInputStream(Communication.getInstance().getSocket().getInputStream());
            Response response = (Response) in.readObject();

            if (response.getResponseStatus().equals(ResponseStatus.Error)) {
                throw response.getException();
            } else {
                return response.getData();
            }
        } catch (SocketException ex) {
            System.out.println("Server je zatvorio vezu: " + ex.getMessage());
            closeConnection();
        } catch (EOFException ex) {
            System.out.println("Klijent je prekinuo komunikaciju");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbineJela(Jelo jelo) throws Exception {
        return (ArrayList<StavkaNarudzbine>) sendRequest(Operation.GET_ALL_STAVKA_NARUDZBINE, jelo);
    }

    private void closeConnection() {
        Communication.getInstance().closeSocket();
    }

}
