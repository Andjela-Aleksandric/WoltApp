/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anđela
 */
public class Pozicija extends GenericDomainObject {

    private Long pozicijaID;
    private String naziv;

    @Override
    public String toString() {
        return naziv;
    }

    public Pozicija(Long pozicijaID, String naziv) {
        this.pozicijaID = pozicijaID;
        this.naziv = naziv;
    }

    public Pozicija() {
    }

    @Override
    public String tableName() {
        return " pozicija ";
    }

    @Override
    public String alias() {
        return " p ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        ArrayList<GenericDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Pozicija p = new Pozicija(rs.getLong("pozicijaID"),
                    rs.getString("p.naziv"));

            lista.add(p);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return " (naziv) ";
    }

    @Override
    public String valuesForInsert() {
        return " '" + naziv + "' ";
    }

    @Override
    public String valuesForUpdate() {
        return " naziv = '" + naziv + "' ";
    }

    @Override
    public String condition() {
        return " pozicijaID = " + pozicijaID;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    public Long getPozicijaID() {
        return pozicijaID;
    }

    public void setPozicijaID(Long pozicijaID) {
        this.pozicijaID = pozicijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
