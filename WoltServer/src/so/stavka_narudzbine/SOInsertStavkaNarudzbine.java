/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavka_narudzbine;

import db.DBBroker;
import model.GenericDomainObject;
import model.Klijent;
import model.StavkaNarudzbine;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOInsertStavkaNarudzbine extends GenericSO {

    @Override
    protected void verify(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaNarudzbine)) {
            throw new Exception("Prosleđeni objekat nije instanca klase StavkaNarudžbine!");
        }
    }

    @Override
    protected void operate(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
