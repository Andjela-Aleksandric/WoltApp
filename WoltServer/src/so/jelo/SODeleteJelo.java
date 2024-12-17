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
    protected void verify(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Jelo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Jelo!");
        }
    }

    @Override
    protected void operate(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
}
