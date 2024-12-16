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
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Klijent)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Klijent!");
        }
    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        ArrayList<GenericDomainObject> klijenti = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Klijent>) (ArrayList<?>) klijenti;
    }

    public ArrayList<Klijent> getLista() {
        return lista;
    }

}
