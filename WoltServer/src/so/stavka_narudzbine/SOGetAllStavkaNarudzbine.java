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
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof StavkaNarudzbine)) {
            throw new Exception("Prosleđeni objekat nije instanca klase StavkaNarudzbine!");
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        ArrayList<GenericDomainObject> stavkeNarudzbine = DBBroker.getInstance().select(gdo);
        lista = (ArrayList<StavkaNarudzbine>) (ArrayList<?>) stavkeNarudzbine;
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

}
