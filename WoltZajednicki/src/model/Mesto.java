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
public class Mesto extends GenericDomainObject {

    private Long mestoID;
    private String naziv;

    @Override
    public String toString() {
        return naziv;
    }

    public Mesto(Long mestoID, String naziv) {
        this.mestoID = mestoID;
        this.naziv = naziv;
    }

    public Mesto() {
    }

    @Override
    public String tableName() {
        return " mesto ";
    }

    @Override
    public String alias() {
        return " m ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        ArrayList<GenericDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Mesto m = new Mesto(rs.getLong("mestoID"),
                    rs.getString("m.naziv"));

            lista.add(m);
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
        return " mestoID = " + mestoID;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    public Long getMestoID() {
        return mestoID;
    }

    public void setMestoID(Long mestoID) {
        this.mestoID = mestoID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
