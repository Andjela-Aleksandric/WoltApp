/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class SOInsertJelo extends GenericSO {

    @Override
    protected void verify(GenericDomainObject gdo) throws Exception {
        if (!(gdo instanceof Jelo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Jelo!");
        }

        Jelo novoJelo = (Jelo) gdo;
        
        if (novoJelo.getCena() < 100 || novoJelo.getCena() > 10000) {
            throw new Exception("Cena mora biti između 100din i 10000din!");
        }

        ArrayList<Jelo> jela = (ArrayList<Jelo>) (ArrayList<?>) DBBroker.getInstance().select(gdo);

        for (Jelo jelo : jela) {
            if (jelo.getNaziv().equals(novoJelo.getNaziv())) {
                throw new Exception("Jelo sa tim nazivom već postoji!");
            }
        }
    }

    @Override
    protected void operate(GenericDomainObject gdo) throws Exception {
        DBBroker.getInstance().insert(gdo);
    }
    
}
