/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.mesto;

import db.DBBroker;
import model.GenericDomainObject;
import model.Mesto;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOGetAllMesto extends GenericSO {

    private ArrayList<Mesto> lista;

    @Override
    protected void verify(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Mesto)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Mesto!");
        }
    }

    @Override
    protected void operate(GenericDomainObject ado) throws Exception {
        ArrayList<GenericDomainObject> mesta = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Mesto>) (ArrayList<?>) mesta;
    }

    public ArrayList<Mesto> getLista() {
        return lista;
    }

}
