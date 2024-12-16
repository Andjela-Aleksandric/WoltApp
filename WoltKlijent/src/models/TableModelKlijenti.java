/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import model.Klijent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anđela
 */
public class TableModelKlijenti extends AbstractTableModel implements Runnable {

    private ArrayList<Klijent> lista;
    private String[] kolone;
    private String parametar = "";
    private ResourceBundle messages;
    private JMenu languageMenu;

    public TableModelKlijenti() {
        try {
            Locale.setDefault(new Locale("sr", "LATN"));
            messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
            setLanguage(new Locale("sr", "LATN")); 
            lista = ClientController.getInstance().getAllKlijent();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLanguage(Locale locale) {
        messages = ResourceBundle.getBundle("resources.Messages", locale);
        kolone = new String[] {
            messages.getString("tbl_id"),
            messages.getString("tbl_ime"),
            messages.getString("tbl_prezime"),
            messages.getString("tbl_email"),
            messages.getString("tbl_telefon"),
            messages.getString("tbl_adresa"),
            messages.getString("tbl_status"),
            messages.getString("tbl_mesto")
        };
        fireTableStructureChanged();
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
        Klijent k = lista.get(row);

        switch (column) {
            case 0:
                return k.getKlijentID();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getEmail();
            case 4:
                return k.getTelefon();
            case 5:
                return k.getAdresa();
            case 6:
                return k.getStatus();
            case 7:
                return k.getMesto();

            default:
                return null;
        }
    }

    public Klijent getSelectedKlijent(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllKlijent();
            if (!parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || k.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
