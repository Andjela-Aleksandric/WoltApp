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
        if (novoJelo.getNaziv().isEmpty()  || novoJelo.getNaziv().length()<=2 || novoJelo.getNaziv().length() >= 50){
            throw new Exception("Naziv jela mora sadržati više od 2 i manje od 50 karaktera!");
        }
        if (novoJelo.getCena() <= 50 || novoJelo.getCena() >= 10000) {
            throw new Exception("Cena mora biti veća od 50din i manja od 10000din!");
        }
        if (novoJelo.getOpis().isEmpty()  || novoJelo.getOpis().length()<=2 || novoJelo.getOpis().length() >= 200){
            throw new Exception("Opis jela mora sadržati više od 2 i manje od 200 karaktera!");
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
