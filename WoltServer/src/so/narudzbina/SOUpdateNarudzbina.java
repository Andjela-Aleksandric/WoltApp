/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbina;

import db.DBBroker;
import model.GenericDomainObject;
import model.Narudzbina;
import model.StavkaNarudzbine;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOUpdateNarudzbina extends GenericSO {

    @Override
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Narudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Narudzbina!");
        }

        Narudzbina narudzbina = (Narudzbina) ado;

        if (narudzbina.getStavkeNarudzbine().isEmpty()) {
            throw new Exception("Narudzbina mora da ima barem jednu stavku!");
        }

    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        Narudzbina narudzbina = (Narudzbina) ado;
        DBBroker.getInstance().delete(narudzbina.getStavkeNarudzbine().get(0));
        for (StavkaNarudzbine stavkaNarudzbine : narudzbina.getStavkeNarudzbine()) {
            DBBroker.getInstance().insert(stavkaNarudzbine);
        }
    }

}
