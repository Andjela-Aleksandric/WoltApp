/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import model.Jelo;
import model.Klijent;
import model.Narudzbina;
import model.StavkaNarudzbine;
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
public class TableModelNarudzbine extends AbstractTableModel implements Runnable {

    private ArrayList<Narudzbina> lista;
    private String[] kolone = {"ID", "Klijent", "Konačan iznos"};
    private String parametar = "";
    private ResourceBundle messages;
    private JMenu languageMenu;

    public TableModelNarudzbine() {
        try {
            Locale.setDefault(new Locale("sr", "LATN"));
            messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
            setLanguage(new Locale("sr", "LATN")); 
            lista = ClientController.getInstance().getAllNarudzbina(null);
        } catch (Exception ex) {
            Logger.getLogger(TableModelNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLanguage(Locale locale) {
        messages = ResourceBundle.getBundle("resources.Messages", locale);
        kolone = new String[] {
            messages.getString("tbl_id"),
            messages.getString("tbl_klijent"),
            messages.getString("tbl_iznos")
        };
        fireTableStructureChanged();
    }

    public TableModelNarudzbine(Klijent klijent) {
        try {
            lista = ClientController.getInstance().getAllNarudzbina(klijent);
        } catch (Exception ex) {
            Logger.getLogger(TableModelNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TableModelNarudzbine(Jelo jelo) {
        try {

            lista = new ArrayList<>();

            ArrayList<StavkaNarudzbine> stavkeNarudzbineJela
                    = ClientController.getInstance().getAllStavkaNarudzbineJela(jelo);

            for (StavkaNarudzbine stavkaNarudzbine : stavkeNarudzbineJela) {
                lista.add(stavkaNarudzbine.getNarudzbina());
            }

        } catch (Exception ex) {
            Logger.getLogger(TableModelNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
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
        Narudzbina n = lista.get(row);

        switch (column) {
            case 0:
                return n.getNarudzbinaID();
            case 1:
                return n.getKlijent().getIme() + " " + n.getKlijent().getPrezime();
            case 2:
                return n.getKonacnaCena() + "din";

            default:
                return null;
        }
    }

    public Narudzbina getSelectedNarudzbina(int row) {
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
            Logger.getLogger(TableModelNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllNarudzbina(null);
            if (!parametar.equals("")) {
                ArrayList<Narudzbina> novaLista = new ArrayList<>();
                for (Narudzbina n : lista) {
                    if (n.getKlijent().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || n.getKlijent().getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(n);
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
