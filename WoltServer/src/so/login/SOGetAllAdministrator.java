/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import db.DBBroker;
import java.util.ArrayList;
import model.Administrator;
import model.GenericDomainObject;
import model.Klijent;
import so.GenericSO;

/**
 *
 * @author Anđela
 */
public class SOGetAllAdministrator extends GenericSO {

    private ArrayList<Administrator> lista;

    @Override
    protected void verify(GenericDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Administrator!");
        }
    }

    @Override
    protected void operate(GenericDomainObject ado) throws Exception {
        ArrayList<GenericDomainObject> admini = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Administrator>) (ArrayList<?>) admini;
    }

    public ArrayList<Administrator> getLista() {
        return lista;
    }
    
}
