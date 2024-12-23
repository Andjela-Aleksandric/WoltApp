/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.jelo;

import db.DBBroker;
import model.GenericDomainObject;
import model.Jelo;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOGetAllJelo extends GenericSO {

    private ArrayList<Jelo> lista;

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Jelo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Jelo!");
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        ArrayList<GenericDomainObject> jela = DBBroker.getInstance().select(gdo);
        lista = (ArrayList<Jelo>) (ArrayList<?>) jela;
    }

    public ArrayList<Jelo> getLista() {
        return lista;
    }

}
