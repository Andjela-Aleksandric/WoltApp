/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Anđela
 */
public class StavkaNarudzbine extends GenericDomainObject {

    private Narudzbina narudzbina;
    private int rb;
    private int kolicina;
    private double cena;
    private String napomena;
    private Jelo jelo;

    public StavkaNarudzbine(Narudzbina narudzbina, int rb, int kolicina, double cena, String napomena, Jelo jelo) {
        this.narudzbina = narudzbina;
        this.rb = rb;
        this.kolicina = kolicina;
        this.cena = cena;
        this.napomena = napomena;
        this.jelo = jelo;
    }

    public StavkaNarudzbine() {
    }

    @Override
    public String tableName() {
        return " StavkaNarudzbine ";
    }

    @Override
    public String alias() {
        return " sn ";
    }

    @Override
    public String join() {
        return " JOIN NARUDZBINA N ON (N.NARUDZBINAID = SN.NARUDZBINAID)\n"
                + "JOIN JELO J ON (J.JELOID = SN.JELOID)\n"
                + "JOIN KLIJENT K ON (K.KLIJENTID = N.KLIJENTID)\n"
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = N.ADMINISTRATORID)\n"
                + "JOIN MESTO M ON (M.MESTOID = K.MESTOID)\n";
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

            Jelo j = new Jelo(rs.getLong("jeloID"), rs.getString("naziv"),
                    rs.getString("opis"), rs.getDouble("cena"));

            StavkaNarudzbine sn = new StavkaNarudzbine(n,
                    rs.getInt("rb"), rs.getInt("kolicina"),
                    rs.getDouble("cena"), rs.getString("napomena"), j);

            lista.add(sn);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return " (narudzbinaID, rb, kolicina, cena, napomena, jeloID) ";
    }

    @Override
    public String valuesForInsert() {
        return " " + narudzbina.getNarudzbinaID() + ", " + rb + ", "
                + " " + kolicina + ", " + cena + ", '" + napomena + "', "
                + jelo.getJeloID();
    }

    @Override
    public String valuesForUpdate() {
        return "";
    }

    @Override
    public String condition() {
        return " narudzbinaID = " + narudzbina.getNarudzbinaID();
    }

    @Override
    public String conditionForSelect() {
        if (narudzbina != null) {
            return " WHERE N.NARUDZBINAID = " + narudzbina.getNarudzbinaID();
        }
        return " WHERE J.JELOID = " + jelo.getJeloID();
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StavkaNarudzbine that = (StavkaNarudzbine) obj;
        return rb == that.rb
                && Double.compare(that.cena, cena) == 0
                && kolicina == that.kolicina
                && Objects.equals(napomena, that.napomena)
                && Objects.equals(jelo, that.jelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rb, kolicina, cena, napomena, jelo);
    }

    public String getPrimaryKey() {
        return "rb=" + rb + ", narudzbinaID=" + narudzbina.getNarudzbinaID();
    }

}
