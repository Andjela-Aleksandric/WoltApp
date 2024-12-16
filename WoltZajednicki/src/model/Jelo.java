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
public class Jelo extends GenericDomainObject {

    private Long jeloID;
    private String naziv;
    private String opis;
    private double cena;

    @Override
    public String toString() {
        return naziv;
    }

    public Jelo(Long jeloID, String naziv, String opis, double cena) {
        this.jeloID = jeloID;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public Jelo() {
    }

    @Override
    public String tableName() {
        return " Jelo ";
    }

    @Override
    public String alias() {
        return " j ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        ArrayList<GenericDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Jelo j = new Jelo(rs.getLong("jeloID"), rs.getString("naziv"),
                    rs.getString("opis"), rs.getDouble("cena"));

            lista.add(j);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return " (naziv, opis, cena) ";
    }

    @Override
    public String valuesForInsert() {
        return "'" + naziv + "', '" + opis + "', "
                + " " + cena + " ";
    }

    @Override
    public String valuesForUpdate() {
        return " naziv = '" + naziv + "', opis = '" + opis + "', "
                + "cena = '" + cena + "' ";
    }

    @Override
    public String condition() {
        return " jeloID = " + jeloID;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    public Long getJeloID() {
        return jeloID;
    }

    public void setJeloID(Long jeloID) {
        this.jeloID = jeloID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

}
