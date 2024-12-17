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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOInsertNarudzbina extends GenericSO {

    @Override
    protected void validate(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Narudzbina)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Narudžbina!");
        }

        Narudzbina narudzbina = (Narudzbina) ado;

        if (narudzbina.getStavkeNarudzbine().isEmpty()) {
            throw new Exception("Narudžbina mora da ima barem jednu stavku!");
        }

    }

    @Override
    protected void execute(GenericDomainObject ado) throws Exception {
        
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        Long narudzbinaID = keys.getLong(1);

        Narudzbina narudzbina = (Narudzbina) ado;
        narudzbina.setNarudzbinaID(narudzbinaID);

        for (StavkaNarudzbine stavkaNarudzbine : narudzbina.getStavkeNarudzbine()) {
            stavkaNarudzbine.setNarudzbina(narudzbina); 
            DBBroker.getInstance().insert(stavkaNarudzbine);
        }

    }

}
