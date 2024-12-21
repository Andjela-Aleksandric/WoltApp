/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbina;

import db.DBBroker;
import model.GenericDomainObject;
import model.Narudzbina;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOGetAllNarudzbina extends GenericSO {

    private ArrayList<Narudzbina> lista;

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Narudzbina)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Narudžbina!");
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        ArrayList<GenericDomainObject> narudzbine = DBBroker.getInstance().select(gdo);
        lista = (ArrayList<Narudzbina>) (ArrayList<?>) narudzbine;
    }

    public ArrayList<Narudzbina> getLista() {
        return lista;
    }

}
