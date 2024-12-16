/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbina;

import db.DBBroker;
import model.GenericDomainObject;
import model.Narudzbina;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SODeleteNarudzbina extends GenericSO {

    @Override
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Narudzbina)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Narudžbina!");
        }
    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
