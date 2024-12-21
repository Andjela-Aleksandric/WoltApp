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
public class SOInsertKlijent extends GenericSO {

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Klijent)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Klijent!");
        }

        Klijent noviKlijent = (Klijent) gdo;

        ArrayList<Klijent> klijenti = (ArrayList<Klijent>) (ArrayList<?>) DBBroker.getInstance().select(gdo);

        for (Klijent klijent : klijenti) {
            if (klijent.getEmail().equals(noviKlijent.getEmail())) {
                throw new Exception("Klijent sa tom email adresom već postoji!");
            }
            if (klijent.getTelefon().equals(noviKlijent.getTelefon())) {
                throw new Exception("Klijent sa tim brojem telefona već postoji!");
            }
        }

    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        DBBroker.getInstance().insert(gdo);
    }

}
