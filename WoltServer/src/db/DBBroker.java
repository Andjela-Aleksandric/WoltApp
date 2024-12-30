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

    public static void setInstance(DBBroker instance) {
        DBBroker.instance = instance;
    }
    
    public ArrayList<GenericDomainObject> select(GenericDomainObject gdo) throws SQLException {
        String upit = "SELECT * FROM " + gdo.tableName() + " " + gdo.alias()
                + " " + gdo.join() + " " + gdo.conditionForSelect();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return gdo.returnList(rs);
    }

    public PreparedStatement insert(GenericDomainObject gdo) throws SQLException {
        String upit = "INSERT INTO " + gdo.tableName() + " "
                + gdo.columnsForInsert() + " VALUES(" + gdo.valuesForInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(GenericDomainObject gdo) throws SQLException {
        String upit = "UPDATE " + gdo.tableName() + " SET "
                + gdo.valuesForUpdate() + " WHERE " + gdo.condition();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(GenericDomainObject gdo) throws SQLException {
        String upit = "DELETE FROM " + gdo.tableName() + " WHERE " + gdo.condition();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

}
