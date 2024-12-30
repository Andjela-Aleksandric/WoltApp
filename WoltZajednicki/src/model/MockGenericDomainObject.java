/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anđela
 */
public class MockGenericDomainObject extends GenericDomainObject {
     @Override
    public String tableName() {
        return "mock_table";
    }

    @Override
    public String alias() {
        return "mt";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public String columnsForInsert() {
        return "mock_column";
    }

    @Override
    public String valuesForInsert() {
        return "'mock_value'";
    }

    @Override
    public String valuesForUpdate() {
        return "mock_column = 'mock_value'";
    }

    @Override
    public String condition() {
        return "1=1";
    }

    @Override
    public String conditionForSelect() {
        return "1=1";
    }
}
