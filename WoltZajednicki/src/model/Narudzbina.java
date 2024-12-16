/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Anđela
 */
public class Narudzbina extends GenericDomainObject {

    private Long narudzbinaID;
    private Date datumVreme;
    private double cenaDostave;
    private double konacnaCena;
    private boolean isporucena;
    private Klijent klijent;
    private Administrator administrator;
    private ArrayList<StavkaNarudzbine> stavkeNarudzbine;

    public Narudzbina(Long narudzbinaID, Date datumVreme, double cenaDostave, double konacnaCena, boolean isporucena, Klijent klijent, Administrator administrator, ArrayList<StavkaNarudzbine> stavkeNarudzbine) {
        this.narudzbinaID = narudzbinaID;
        this.datumVreme = datumVreme;
        this.cenaDostave = cenaDostave;
        this.konacnaCena = konacnaCena;
        this.isporucena = isporucena;
        this.klijent = klijent;
        this.administrator = administrator;
        this.stavkeNarudzbine = stavkeNarudzbine;
    }

    public Narudzbina() {
    }

    @Override
    public String tableName() {
        return " Narudzbina ";
    }

    @Override
    public String alias() {
        return " n ";
    }

    @Override
    public String join() {
        return " JOIN KLIJENT K ON (K.KLIJENTID = N.KLIJENTID)\n"
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = N.ADMINISTRATORID)"
                + "JOIN MESTO M ON (M.MESTOID = K.MESTOID) ";
    }

    @Override
    public ArrayList<GenericDomainObject> returnList(ResultSet rs) throws SQLException {
        ArrayList<GenericDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("a.Ime"), rs.getString("a.Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Mesto m = new Mesto(rs.getInt("mestoID"),
                    rs.getString("m.naziv"));

            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("k.Ime"), rs.getString("k.Prezime"),
                    rs.getString("Email"), rs.getString("Telefon"),
                    rs.getString("Adresa"), rs.getString("Status"), m);

            Narudzbina n = new Narudzbina(rs.getLong("narudzbinaID"),
                    rs.getTimestamp("datumVreme"), rs.getDouble("cenaDostave"),
                    rs.getDouble("konacnaCena"), rs.getBoolean("isporucena"),
                    k, a, null);

            lista.add(n);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return " (datumVreme, cenaDostave, konacnaCena, isporucena, klijentID, administratorID) ";
    }

    @Override
    public String valuesForInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', " + cenaDostave + ", "
                + " " + konacnaCena + ", " + (isporucena ? 1 : 0) + ", "
                + klijent.getKlijentID() + ", " + administrator.getAdministratorID();
    }

    @Override
    public String valuesForUpdate() {
        return " konacnaCena = " + konacnaCena + ", isporucena = " + (isporucena ? 1 : 0) + " ";
    }

    @Override
    public String condition() {
        return " narudzbinaID = " + narudzbinaID;
    }

    @Override
    public String conditionForSelect() {
        if (klijent == null) {
            return "";
        }
        return " WHERE K.KLIJENTID = " + klijent.getKlijentID();
    }

    public Long getNarudzbinaID() {
        return narudzbinaID;
    }

    public void setNarudzbinaID(Long narudzbinaID) {
        this.narudzbinaID = narudzbinaID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getCenaDostave() {
        return cenaDostave;
    }

    public void setCenaDostave(double cenaDostave) {
        this.cenaDostave = cenaDostave;
    }

    public double getKonacnaCena() {
        return konacnaCena;
    }

    public void setKonacnaCena(double konacnaCena) {
        this.konacnaCena = konacnaCena;
    }

    public boolean isIsporucena() {
        return isporucena;
    }

    public void setIsporucena(boolean isporucena) {
        this.isporucena = isporucena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<StavkaNarudzbine> getStavkeNarudzbine() {
        return stavkeNarudzbine;
    }

    public void setStavkeNarudzbine(ArrayList<StavkaNarudzbine> stavkeNarudzbine) {
        this.stavkeNarudzbine = stavkeNarudzbine;
    }

}
