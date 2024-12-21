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
public class SOGetAllKlijent extends GenericSO {

    private ArrayList<Klijent> lista;

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Klijent)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Klijent!");
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        ArrayList<GenericDomainObject> klijenti = DBBroker.getInstance().select(gdo);
        lista = (ArrayList<Klijent>) (ArrayList<?>) klijenti;
    }

    public ArrayList<Klijent> getLista() {
        return lista;
    }

}
