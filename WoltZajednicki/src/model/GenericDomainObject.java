/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anđela
 */
public abstract class GenericDomainObject implements Serializable {

    public abstract String tableName();
    public abstract String alias();
    public abstract String join();
    public abstract ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException;
    public abstract String columnsForInsert();
    public abstract String valuesForInsert();
    public abstract String valuesForUpdate();
    public abstract String condition();
    public abstract String conditionForSelect();
    
}
