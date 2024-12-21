/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.jelo;

import db.DBBroker;
import model.GenericDomainObject;
import model.Jelo;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SODeleteJelo extends GenericSO {

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Jelo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Jelo!");
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        DBBroker.getInstance().delete(gdo);
    }
    
}
