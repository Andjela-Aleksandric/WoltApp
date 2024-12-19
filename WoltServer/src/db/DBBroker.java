/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import model.GenericDomainObject;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anđela
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    private DBBroker() {
        connection = Conn.getInstance().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<GenericDomainObject> select(GenericDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.tableName() + " " + ado.alias()
                + " " + ado.join() + " " + ado.conditionForSelect();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.returnList(rs);
    }

    public PreparedStatement insert(GenericDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.tableName() + " "
                + ado.columnsForInsert() + " VALUES(" + ado.valuesForInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(GenericDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.tableName() + " SET "
                + ado.valuesForUpdate() + " WHERE " + ado.condition();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(GenericDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.tableName() + " WHERE " + ado.condition();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

}
