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
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Administrator!");
        }

        Administrator a = (Administrator) ado;

        ArrayList<Administrator> admini = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Administrator admin : admini) {
            if (admin.getUsername().equals(a.getUsername())) {
                throw new Exception("Klijent sa tom email adresom već postoji!");
            }
        }
    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        Administrator a = (Administrator) ado;
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
