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
    protected void verify(GenericDomainObject gdo) throws Exception {
        if(!(gdo instanceof AdP)){
            throw new Exception("Prosleđeni objekat nije instanca klase AdP!");
        }
        
        AdP adp = (AdP) gdo;
        if(adp.getDatumOd() == null || adp.getDatumDo() == null){
            throw new Exception("Datum od i datum do moraju biti popunjeni!");
        }else{
            if(adp.getDatumDo().before(adp.getDatumOd())){
                throw new Exception("Datum od mora biti pre datuma do!");
            }
        }
        ArrayList<AdP> adps = (ArrayList<AdP>) (ArrayList<?>) DBBroker.getInstance().select(gdo);

        for (AdP a : adps) {
            if (adp.getAdministrator().getAdministratorID().equals(a.getAdministrator().getAdministratorID())) {
               if (adp.getPozicija().getPozicijaID() == a.getPozicija().getPozicijaID()) {
                    throw new Exception("Ovakav administrator već postoji u sistemu!");
                }
            }
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        DBBroker.getInstance().insert(gdo);
    }
    
}
