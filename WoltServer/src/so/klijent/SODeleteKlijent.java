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
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Klijent)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Klijent!");
        }
    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
