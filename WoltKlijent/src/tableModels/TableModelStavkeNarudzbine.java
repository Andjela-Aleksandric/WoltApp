/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import controller.ClientController;
import model.Narudzbina;
import model.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anđela
 */
public class TableModelStavkeNarudzbine extends AbstractTableModel {

    private ArrayList<StavkaNarudzbine> lista;
    private String[] kolone = {"Rb", "Jelo", "Količina", "Cena"};
    private int rb;
    private ResourceBundle messages;
    private JMenu languageMenu;

    public TableModelStavkeNarudzbine() {
        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        setLanguage(new Locale("sr", "LATN"));
        lista = new ArrayList<>();
    }
    
    public void setLanguage(Locale locale) {
        messages = ResourceBundle.getBundle("resources.Messages", locale);
        kolone = new String[] {
            messages.getString("tbl_rb"),
            messages.getString("tbl_jelo"),
            messages.getString("tbl_kolicina"),
            messages.getString("tbl_cena")
        };
        fireTableStructureChanged();
    }

    public TableModelStavkeNarudzbine(Narudzbina narudzbina) {
        try {
            lista = ClientController.getInstance().getAllStavkaNarudzbine(narudzbina);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkeNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        StavkaNarudzbine sn = lista.get(row);

        switch (column) {
            case 0:
                return sn.getRb();
            case 1:
                return sn.getJelo();
            case 2:
                return sn.getKolicina();
            case 3:
                return sn.getCena() + "din";

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaNarudzbine sn) {

        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            if (stavkaNarudzbine.getJelo().getJeloID().equals(sn.getJelo().getJeloID())) {
                stavkaNarudzbine.setKolicina(stavkaNarudzbine.getKolicina() + sn.getKolicina());
                stavkaNarudzbine.setCena(stavkaNarudzbine.getCena() + sn.getCena());
                fireTableDataChanged();
                return;
            }
        }

        rb = lista.size();
        sn.setRb(++rb);
        lista.add(sn);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            stavkaNarudzbine.setRb(++rb);
        }

        fireTableDataChanged();
    }

    public double vratiUkupanIznos() {
        double ukupanIznos = 0;

        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            ukupanIznos += stavkaNarudzbine.getCena();
        }

        return ukupanIznos;
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

}
