/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavka_narudzbine;

import db.DBBroker;
import model.GenericDomainObject;
import model.StavkaNarudzbine;
import java.util.ArrayList;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOGetAllStavkaNarudzbine extends GenericSO {

    private ArrayList<StavkaNarudzbine> lista;

    @Override
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaNarudzbine)) {
            throw new Exception("Prosleđeni objekat nije instanca klase StavkaNarudzbine!");
        }
    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        ArrayList<GenericDomainObject> stavkeNarudzbine = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaNarudzbine>) (ArrayList<?>) stavkeNarudzbine;
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

}
