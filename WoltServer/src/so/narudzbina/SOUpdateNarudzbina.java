/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbina;

import controller.ServerController;
import db.DBBroker;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    protected void verify(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Narudzbina)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Narudžbina!");
        }

        Narudzbina narudzbina = (Narudzbina) ado;

        if (narudzbina.getStavkeNarudzbine().isEmpty()) {
            throw new Exception("Narudžbina mora da ima barem jednu stavku!");
        }

    }

    @Override
    protected void operate(GenericDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        Narudzbina narudzbina = (Narudzbina) ado;
        // Postojeće stavke narudžbine u bazi
        List<StavkaNarudzbine> trenutneStavke = ServerController.getInstance().getAllStavkaNarudzbine(narudzbina);

        // Novi skup stavki iz klijenta
        List<StavkaNarudzbine> noveStavke = narudzbina.getStavkeNarudzbine();

        // Mape za brže poređenje
        Map<Integer, StavkaNarudzbine> trenutneStavkeMap = trenutneStavke.stream()
                .collect(Collectors.toMap(StavkaNarudzbine::getRb, stavka -> stavka));
        Map<Integer, StavkaNarudzbine> noveStavkeMap = noveStavke.stream()
                .collect(Collectors.toMap(StavkaNarudzbine::getRb, stavka -> stavka));

        // Pronalaženje stavke za dodavanje i ažuriranje
        for (StavkaNarudzbine novaStavka : noveStavke) {
            StavkaNarudzbine trenutnaStavka = trenutneStavkeMap.get(novaStavka.getRb()); 

            if (trenutnaStavka == null) {
                // Nova stavka - Dodaj u bazu
                DBBroker.getInstance().insert(novaStavka);
            } else if (!novaStavka.equals(trenutnaStavka)) {
                // Postojeća stavka je promenjena - Ažuriraj u bazi
                DBBroker.getInstance().update(novaStavka);
            }
        }

        // Pronađi stavke za brisanje
        for (StavkaNarudzbine trenutnaStavka : trenutneStavke) {
            if (!noveStavkeMap.containsKey(trenutnaStavka.getRb())) {
                // Stavka više ne postoji u novim podacima - Obriši iz baze
                DBBroker.getInstance().delete(trenutnaStavka);
            }
        }
    }

}
