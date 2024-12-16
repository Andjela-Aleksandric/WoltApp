/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pozicija;

import db.DBBroker;
import model.GenericDomainObject;
import model.Pozicija;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela

 */
public class SOGetAllPozicija extends GenericSO {

    private ArrayList<Pozicija> lista;

    @Override
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Pozicija)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pozicija!");
        }
    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        ArrayList<GenericDomainObject> pozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pozicija>) (ArrayList<?>) pozicije;
    }

    public ArrayList<Pozicija> getLista() {
        return lista;
    }

}
