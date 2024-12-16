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
public class Klijent extends GenericDomainObject {

    private Long klijentID;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private String adresa;
    private String status;
    private Mesto mesto;

    @Override
    public String toString() {
        return ime + " " + prezime + " (Email: " + email + ", Status: " + status + ")";
    }

    public Klijent(Long klijentID, String ime, String prezime, String email, String telefon, String adresa, String status, Mesto mesto) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
        this.status = status;
        this.mesto = mesto;
    }

    public Klijent() {
    }

    @Override
    public String tableName() {
        return " Klijent ";
    }

    @Override
    public String alias() {
        return " k ";
    }

    @Override
    public String join() {
        return " JOIN MESTO M ON (M.MESTOID = K.MESTOID )";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        ArrayList<GenericDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Mesto m = new Mesto(rs.getInt("mestoID"),
                    rs.getString("m.naziv"));
            
            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Email"), rs.getString("Telefon"),
                    rs.getString("Adresa"), rs.getString("Status"), m);

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return " (Ime, Prezime, Email, Telefon, Adresa, Status, mestoID) ";
    }

    @Override
    public String valuesForInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + email + "', '" + telefon + "', '" + adresa + "', '" + status + "', "
                + mesto.getMestoID();
    }

    @Override
    public String valuesForUpdate() {
        return " email = '" + email + "', telefon = '" + telefon + "', "
                + "adresa = '" + adresa + "', status = '" + status + "', "
                + "mestoID = " + mesto.getMestoID();
    }

    @Override
    public String condition() {
        return " KlijentID = " + klijentID;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

}
