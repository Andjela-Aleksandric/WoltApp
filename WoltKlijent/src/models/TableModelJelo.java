/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import model.Jelo;
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
public class TableModelJelo extends AbstractTableModel implements Runnable {

    private ArrayList<Jelo> lista;
    private ResourceBundle messages;
    private JMenu languageMenu;
    private String[] kolone;
    private String parametar = "";

    public TableModelJelo() {
        try {
            Locale.setDefault(new Locale("sr", "LATN"));
            messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
            setLanguage(new Locale("sr", "LATN")); 
            lista = ClientController.getInstance().getAllJelo();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void setLanguage(Locale locale) {
        messages = ResourceBundle.getBundle("resources.Messages", locale);
        kolone = new String[] {
            messages.getString("tbl_id"),
            messages.getString("tbl_naziv"),
            messages.getString("tbl_opis"),
            messages.getString("tbl_cena")
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jelo j = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return j.getJeloID();
            case 1:
                return j.getNaziv();
            case 2:
                return j.getOpis();
            case 3:
                return j.getCena();
            default:
                return null;
        }
    }

    public Jelo getSelectedJelo(int row) {
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
            lista = ClientController.getInstance().getAllJelo();
            if (!parametar.equals("")) {
                ArrayList<Jelo> novaLista = new ArrayList<>();
                for (Jelo j : lista) {
                    if (j.getNaziv().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(j);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
