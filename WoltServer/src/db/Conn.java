/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
/**
 *
 * @author Anđela
 */
public class Conn {
    private static Conn instance;
    private Connection connection;
    
    private Conn(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Conn getInstance() {
        if(instance == null){
            instance = new Conn();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
}
