/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Anđela
 */
public class AdP extends GenericDomainObject {
    
    private Pozicija pozicija;
    private Administrator administrator;
    private Date datumOd;
    private Date datumDo;

    public AdP(Pozicija pozicija, Administrator administrator, Date datumOd, Date datumDo) {
        this.pozicija = pozicija;
        this.administrator = administrator;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public AdP() {
    }
    
    @Override
    public String tableName() {
        return " AdP ";
    }

    @Override
    public String alias() {
        return " adp ";
    }

    @Override
    public String join() {
        return " JOIN POZICIJA P ON (P.POZICIJAID = ADP.POZICIJAID)\n"
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = ADP.ADMINISTRATORID)";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        ArrayList<GenericDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Pozicija p = new Pozicija(rs.getLong("pozicijaID"),
                    rs.getString("p.naziv"));
            
            AdP adp = new AdP(p, a, rs.getDate("datumOd"), rs.getDate("datumDo"));

            lista.add(adp);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return " (pozicijaID, AdministratorID, datumOd, datumDo) ";
    }

    @Override
    public String valuesForInsert() {
        return "" + pozicija.getPozicijaID() + ", "
                + " " + administrator.getAdministratorID() + ", "
                + "'" + new java.sql.Date(datumOd.getTime()) + "', "
                + "'" + new java.sql.Date(datumDo.getTime()) + "' ";
    }
    
    @Override
    public String valuesForUpdate() {
        return "";
    }
    
    @Override
    public String condition() {
        return " AdministratorID = " + administrator.getAdministratorID();
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }
    
}
