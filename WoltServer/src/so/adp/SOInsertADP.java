/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.adp;

import db.DBBroker;
import java.util.ArrayList;
import model.AdP;
import model.GenericDomainObject;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOInsertADP extends GenericSO{

    @Override
    protected void verify(GenericDomainObject ado) throws Exception {
        if(!(ado instanceof AdP)){
            throw new Exception("Prosleđeni objekat nije instanca klase AdP!");
        }
        
        AdP adp = (AdP) ado;
        ArrayList<AdP> adps = (ArrayList<AdP>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (AdP a : adps) {
            if (adp.getAdministrator().getAdministratorID().equals(a.getAdministrator().getAdministratorID())) {
               if (adp.getPozicija().getPozicijaID() == a.getPozicija().getPozicijaID()) {
                    throw new Exception("Ovakav administrator već postoji u sistemu!");
                }
            }
        }
    }

    @Override
    protected void operate(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
