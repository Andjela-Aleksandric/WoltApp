/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import controller.ServerController;
import db.DBBroker;
import java.security.MessageDigest;
import java.util.ArrayList;
import model.GenericDomainObject;
import model.Administrator;
import model.Klijent;
import org.w3c.dom.views.AbstractView;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SORegister extends GenericSO {

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Administrator)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Administrator!");
        }

        Administrator a = (Administrator) gdo;

        ArrayList<Administrator> admini = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(gdo);

        for (Administrator admin : admini) {
            if (admin.getUsername().equals(a.getUsername())) {
                throw new Exception("Administrator sa tom email adresom već postoji!");
            }
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        Administrator a = (Administrator) gdo;
        String hashedPassword = hashPassword(a.getPassword());
        a.setPassword(hashedPassword);
        DBBroker.getInstance().insert(a);
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
