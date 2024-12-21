/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import model.GenericDomainObject;
import java.sql.SQLException;

/**
 *
 * @author Anđela
 */
public abstract class GenericSO {
    
    protected abstract void verify(GenericDomainObject gdo) throws Exception;
    protected abstract void operate(GenericDomainObject gdo) throws Exception;

    public void genericOperate(GenericDomainObject gdo) throws Exception {
        try {
            verify(gdo);
            operate(gdo);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
