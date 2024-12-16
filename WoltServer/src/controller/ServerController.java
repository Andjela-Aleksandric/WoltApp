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
import java.util.ArrayList;
import java.util.List;
import so.jelo.SOInsertJelo;
import so.jelo.SODeleteJelo;
import so.jelo.SOGetAllJelo;
import so.jelo.SOUpdateJelo;
import so.klijent.SOInsertKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOGetAllKlijent;
import so.klijent.SOUpdateKlijent;
import so.login.SOLogin;
import so.login.SORegister;
import so.mesto.SOGetAllMesto;
import so.narudzbina.SOInsertNarudzbina;
import so.narudzbina.SODeleteNarudzbina;
import so.narudzbina.SOGetAllNarudzbina;
import so.narudzbina.SOUpdateNarudzbina;
import so.pozicija.SOGetAllPozicija;
import so.stavka_narudzbine.SOGetAllStavkaNarudzbine;
import thread.ClientHandler;

/**
 *
 * @author Anđela
 */
public class ServerController {

    private static ServerController instance;
    private ArrayList<Administrator> ulogovaniAdministratori = new ArrayList<>();
    private List<ClientHandler> clients = new ArrayList<>();

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public ArrayList<Administrator> getUlogovaniAdministratori() {
        return ulogovaniAdministratori;
    }

    public void setUlogovaniAdministratori(ArrayList<Administrator> ulogovaniAdministratori) {
        this.ulogovaniAdministratori = ulogovaniAdministratori;
    }
    
    public void register(Administrator administrator) throws Exception {
        SORegister so = new SORegister();
        so.templateExecute(administrator);
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public void addKlijent(Klijent klijent) throws Exception {
        (new SOInsertKlijent()).templateExecute(klijent);
    }

    public void addNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOInsertNarudzbina()).templateExecute(narudzbina);
    }

    public void addJelo(Jelo jelo) throws Exception {
        (new SOInsertJelo()).templateExecute(jelo);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        (new SODeleteKlijent()).templateExecute(klijent);
    }

    public void deleteNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SODeleteNarudzbina()).templateExecute(narudzbina);
    }

    public void deleteJelo(Jelo jelo) throws Exception {
        (new SODeleteJelo()).templateExecute(jelo);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        (new SOUpdateKlijent()).templateExecute(klijent);
    }

    public void updateNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOUpdateNarudzbina()).templateExecute(narudzbina);
    }

    public void updateJelo(Jelo jelo) throws Exception {
        (new SOUpdateJelo()).templateExecute(jelo);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Narudzbina> getAllNarudzbina(Klijent klijent) throws Exception {
        SOGetAllNarudzbina so = new SOGetAllNarudzbina();
        
        Narudzbina n = new Narudzbina();
        n.setKlijent(klijent);
        
        so.templateExecute(n);
        return so.getLista();
    }

    public ArrayList<Jelo> getAllJelo() throws Exception {
        SOGetAllJelo so = new SOGetAllJelo();
        so.templateExecute(new Jelo());
        return so.getLista();
    }

    public ArrayList<Mesto> getAllMesto() throws Exception {
        SOGetAllMesto so = new SOGetAllMesto();
        so.templateExecute(new Mesto());
        return so.getLista();
    }

    public ArrayList<Pozicija> getAllPozicija() throws Exception {
        SOGetAllPozicija so = new SOGetAllPozicija();
        so.templateExecute(new Pozicija());
        return so.getLista();
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbine(Narudzbina narudzbina) throws Exception {
        SOGetAllStavkaNarudzbine so = new SOGetAllStavkaNarudzbine();

        StavkaNarudzbine sn = new StavkaNarudzbine();
        sn.setNarudzbina(narudzbina);

        so.templateExecute(sn);
        return so.getLista();
    }

    public void logout(Administrator ulogovani) {
        ulogovaniAdministratori.remove(ulogovani);
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbineJela(Jelo jelo) throws Exception {
        SOGetAllStavkaNarudzbine so = new SOGetAllStavkaNarudzbine();

        StavkaNarudzbine sn = new StavkaNarudzbine();
        sn.setJelo(jelo);

        so.templateExecute(sn);
        return so.getLista();
    }

    public List<ClientHandler> getClients() {
        return clients;
    }

    public void setClients(List<ClientHandler> clients) {
        this.clients = clients;
    }
    
    public void addClient(ClientHandler ch){
        clients.add(ch);
    }

}
