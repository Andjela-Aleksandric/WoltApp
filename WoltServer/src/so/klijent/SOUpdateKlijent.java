/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import model.GenericDomainObject;
import model.Klijent;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOUpdateKlijent extends GenericSO {

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Klijent)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Klijent!");
        }

        Klijent noviKlijent = (Klijent) gdo;

        if(noviKlijent.getIme().isEmpty() || noviKlijent.getIme().length() <=2 || noviKlijent.getIme().length() >= 30){
            throw new Exception("Ime mora imati više od 2 i manje od 30 karaktera!");
        }
        if(noviKlijent.getPrezime().isEmpty() || noviKlijent.getPrezime().length() <=2 || noviKlijent.getPrezime().length() >= 30){
            throw new Exception("Prezime mora imati više od 2 i manje od 30 karaktera!");
        }
        if(noviKlijent.getEmail().isEmpty() || !noviKlijent.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            throw new Exception("Email adresa mora biti popunjena u ispravnom formatu!");
        }
        if(noviKlijent.getTelefon().isEmpty() || !noviKlijent.getTelefon().matches("^(\\+381|0)[6-9]\\d{7}$") || !noviKlijent.getTelefon().matches("^\\+\\d{1,3}\\d{4,14}$")){
            throw new Exception("Telefon mora biti popunjen u ispravnom formatu!");
        }
        ArrayList<Klijent> klijenti = (ArrayList<Klijent>) (ArrayList<?>) DBBroker.getInstance().select(gdo);

        for (Klijent klijent : klijenti) {
            if (!klijent.getKlijentID().equals(noviKlijent.getKlijentID())) {
                if (klijent.getEmail().equals(noviKlijent.getEmail())) {
                    throw new Exception("Klijent sa tom email adresom već postoji!");
                }
                if (klijent.getTelefon().equals(noviKlijent.getTelefon())) {
                    throw new Exception("Klijent sa tim brojem telefona već postoji!");
                }
            }
        }

    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        DBBroker.getInstance().update(gdo);
    }

}
