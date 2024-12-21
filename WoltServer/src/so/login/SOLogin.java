/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import controller.ServerController;
import db.DBBroker;
import java.security.MessageDigest;
import model.GenericDomainObject;
import model.Administrator;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOLogin extends GenericSO {

    Administrator ulogovani;

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Administrator)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Administrator!");
        }

        Administrator a = (Administrator) gdo;

        for (Administrator administrator : ServerController.getInstance().getUlogovaniAdministratori()) {
            if (administrator.getUsername().equals(a.getUsername())) {
                throw new Exception("Ovaj administrator je već ulogovan na sistem!");
            }
        }

    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {

        Administrator a = (Administrator) gdo;

        ArrayList<Administrator> administratori
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(gdo);

        for (Administrator administrator : administratori) {
            if (administrator.getUsername().equals(a.getUsername())) {
                String hashedPassword = hashPassword(a.getPassword());

                if (administrator.getPassword().equals(hashedPassword)) {
                    ulogovani = administrator;
                    ServerController.getInstance().getUlogovaniAdministratori().add(administrator);
                    return;
                }
            }
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");

    }

    public Administrator getUlogovani() {
        return ulogovani;
    }

    private String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));

        // Pretvaranje bajtova u heksadecimalni string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

}
