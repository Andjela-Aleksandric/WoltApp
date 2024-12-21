/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import model.GenericDomainObject;
import model.Klijent;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SODeleteKlijent extends GenericSO {

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Klijent)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Klijent!");
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        DBBroker.getInstance().delete(gdo);
    }

}
