/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package FormNarudzbina;

import FormKlijent.FormIzaberiKlijenta;
import FormKlijent.FormNoviKlijent;
import communication.Communication;
import controller.ClientController;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main_forms.LoginForm;
import main_forms.MainForm;
import model.Administrator;
import model.Jelo;
import model.Klijent;
import model.Narudzbina;
import model.StavkaNarudzbine;
import tableModels.TableModelStavkeNarudzbine;

/**
 *
 * @author Anđela
 */
public class FormNovaNarudzbina extends javax.swing.JDialog {

    private ResourceBundle messages;
    private Administrator ulogovani;
    private double ukupanIznos;
    private JMenu languageMenu;
    private Klijent izabraniKlijent;

    /**
     * Creates new form FormNovaNarudzbina
     */
    public FormNovaNarudzbina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        customizeOptionPane();
        setLocationRelativeTo(null);
        errorKolicina.setText("");
        this.ulogovani = Communication.getInstance().getUlogovani();
        popuniJela();
        tblStavke.setModel(new TableModelStavkeNarudzbine());
        setTitle("Unos narudžbine");
        getContentPane().setBackground(new Color(1, 195, 233));
        txtCenaDostave.setEnabled(false);
        txtKonacanIznos.setEnabled(false);
        txtIzabraniKlijent.setEnabled(false);

        setRobotoFont();
        setForeground(Color.WHITE);

        Image woltIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/wolt-logo.png"));
        setIconImage(woltIcon);

        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        createLanguageMenu();

        addDocumentListeners();
        customizeButtons();

    }

    private void addDocumentListeners() {
        txtKolicina.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateKolicina(errorKolicina, messages.getString("error_qty"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateKolicina(errorKolicina, messages.getString("error_qty"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateKolicina(errorKolicina, messages.getString("error_qty"));
            }
        });
    }

    private void validateKolicina(javax.swing.JLabel errorLabel, String errorMessage) {
        String kolicinaText = txtKolicina.getText().trim();

        if (kolicinaText.isEmpty()) {
            txtKolicina.setBackground(Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.RED);
        } else {
            try {
                int kolicina = Integer.parseInt(kolicinaText);
                if (kolicina > 0) {
                    errorLabel.setText("");
                    txtKolicina.setBackground(Color.WHITE);
                } else {
                    errorLabel.setText(errorMessage);
                    errorLabel.setForeground(Color.RED);
                    txtKolicina.setBackground(Color.PINK);
                }
            } catch (NumberFormatException e) {
                txtKolicina.setBackground(Color.PINK);
            }
        }
    }

    
    private void popuniJela() {
        try {
            ArrayList<Jelo> jela = ClientController.getInstance().getAllJelo();

            cmbJelo.removeAllItems();

            for (Jelo jelo : jela) {
                cmbJelo.addItem(jelo);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNarudzbina = new javax.swing.JPanel();
        jPanelStavkaNarudzbine = new javax.swing.JPanel();
        lblJelo = new javax.swing.JLabel();
        lblKolicina = new javax.swing.JLabel();
        cmbJelo = new javax.swing.JComboBox();
        txtKolicina = new javax.swing.JTextField();
        btnDodajStavku = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        lblNapomena = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        errorKolicina = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        lblKlijent = new javax.swing.JLabel();
        lblCenaDostave = new javax.swing.JLabel();
        lblKonacanIznos = new javax.swing.JLabel();
        txtKonacanIznos = new javax.swing.JTextField();
        txtCenaDostave = new javax.swing.JTextField();
        btnIzaberiKlijenta = new javax.swing.JButton();
        btnUnesiNovogKlijenta = new javax.swing.JButton();
        lblIzabranKlijent = new javax.swing.JLabel();
        txtIzabraniKlijent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelNarudzbina.setBorder(javax.swing.BorderFactory.createTitledBorder("Narudžbina"));

        jPanelStavkaNarudzbine.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke narudžbine"));

        lblJelo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJelo.setText("Jelo:");

        lblKolicina.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKolicina.setText("Količina:");

        cmbJelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtKolicina.setText("5");

        btnDodajStavku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnObrisiStavku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisiStavku.setText("Obriši stavku");
        btnObrisiStavku.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        lblNapomena.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNapomena.setText("Napomena:");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        txtNapomena.setText("Neka napomena.");
        jScrollPane2.setViewportView(txtNapomena);

        errorKolicina.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorKolicina.setText("jLabel1");

        javax.swing.GroupLayout jPanelStavkaNarudzbineLayout = new javax.swing.GroupLayout(jPanelStavkaNarudzbine);
        jPanelStavkaNarudzbine.setLayout(jPanelStavkaNarudzbineLayout);
        jPanelStavkaNarudzbineLayout.setHorizontalGroup(
            jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNapomena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbJelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                        .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(errorKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(txtKolicina)))
            .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelStavkaNarudzbineLayout.setVerticalGroup(
            jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJelo)
                    .addComponent(cmbJelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKolicina)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(errorKolicina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNapomena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku)
                    .addComponent(btnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSacuvaj.setText("Sačuvaj narudžbinu");
        btnSacuvaj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblKlijent.setText("Klijent:");

        lblCenaDostave.setText("Cena dostave:");

        lblKonacanIznos.setText("Konačan iznos:");

        txtCenaDostave.setText("500.0din");

        btnIzaberiKlijenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzaberiKlijenta.setText("Izaberi klijenta");
        btnIzaberiKlijenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIzaberiKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiKlijentaActionPerformed(evt);
            }
        });

        btnUnesiNovogKlijenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUnesiNovogKlijenta.setText("Unesi novog klijenta");
        btnUnesiNovogKlijenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUnesiNovogKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiNovogKlijentaActionPerformed(evt);
            }
        });

        lblIzabranKlijent.setText("Izabrani klijent:");

        javax.swing.GroupLayout jPanelNarudzbinaLayout = new javax.swing.GroupLayout(jPanelNarudzbina);
        jPanelNarudzbina.setLayout(jPanelNarudzbinaLayout);
        jPanelNarudzbinaLayout.setHorizontalGroup(
            jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelStavkaNarudzbine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIzabranKlijent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKlijent, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(lblCenaDostave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKonacanIznos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCenaDostave)
                            .addComponent(txtKonacanIznos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                                .addComponent(btnIzaberiKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUnesiNovogKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIzabraniKlijent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNarudzbinaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanelNarudzbinaLayout.setVerticalGroup(
            jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelStavkaNarudzbine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKlijent)
                    .addComponent(btnIzaberiKlijenta)
                    .addComponent(btnUnesiNovogKlijenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIzabraniKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIzabranKlijent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCenaDostave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCenaDostave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKonacanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKonacanIznos))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelNarudzbina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelNarudzbina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        customizeOptionPane();
        if (txtKolicina.getText().isEmpty() || txtKolicina.getBackground().equals(Color.PINK)) {
            JOptionPane.showMessageDialog(this, messages.getString("error_emptyQty"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
            return;
        }

        Jelo jelo = (Jelo) cmbJelo.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        String napomena = txtNapomena.getText();

        StavkaNarudzbine sn = new StavkaNarudzbine(null, -1, kolicina, jelo.getCena() * kolicina,
                napomena, jelo);
        TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();
        tm.dodajStavku(sn);

        ukupanIznos = tm.vratiUkupanIznos();
        txtKonacanIznos.setText(String.valueOf(ukupanIznos + 500) + "din");
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed

        int row = tblStavke.getSelectedRow();

        if (row >= 0) {
            TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();
            tm.obrisiStavku(row);

            ukupanIznos = tm.vratiUkupanIznos();
            txtKonacanIznos.setText(String.valueOf(ukupanIznos + 500) + "din");
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        customizeOptionPane();
        try {

            double cenaDostave;

            if (izabraniKlijent.getStatus().equals("FREE")) {
                cenaDostave = 500;
            } else {
                cenaDostave = 0;
            }

            TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();
            if (tm.getLista().size() == 0) {
                JOptionPane.showMessageDialog(this, messages.getString("sn_zero"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tm.getLista().size() == 0) {
                JOptionPane.showMessageDialog(this, messages.getString("sn_zero"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            Narudzbina narudzbina = new Narudzbina(null, new Date(), cenaDostave,
                    ukupanIznos, false, izabraniKlijent, ulogovani, tm.getLista());

            ClientController.getInstance().addNarudzbina(narudzbina);
            txtKonacanIznos.setText("");
            txtCenaDostave.setText("");
            txtIzabraniKlijent.setText("");
            tm.getLista().clear();
            tm.fireTableDataChanged();
            JOptionPane.showMessageDialog(this, messages.getString("success_save_order"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed
    private void btnUnesiNovogKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiNovogKlijentaActionPerformed
        new FormNoviKlijent(null, true).setVisible(true);
    }//GEN-LAST:event_btnUnesiNovogKlijentaActionPerformed

    private void btnIzaberiKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiKlijentaActionPerformed
        new FormIzaberiKlijenta(this, true).setVisible(true);
    }//GEN-LAST:event_btnIzaberiKlijentaActionPerformed

    private void setRobotoFont() {
        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("resources/Roboto-Regular.ttf");
            if (fontStream != null) {
                Font robotoFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(12f);
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.put("Label.font", robotoFont);
                UIManager.put("Button.font", robotoFont);
                UIManager.put("TextField.font", robotoFont);
                UIManager.put("TextArea.font", robotoFont);
                UIManager.put("ComboBox.font", robotoFont);
                UIManager.put("Table.font", robotoFont);
                UIManager.put("Menu.font", robotoFont);
                UIManager.put("MenuItem.font", robotoFont);
                SwingUtilities.updateComponentTreeUI(this);
            } else {
                System.out.println("Font fajl nije pronađen.");
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void createLanguageMenu() {
        JMenuBar menuBar = new JMenuBar();

        languageMenu = new JMenu("Jezik");

        JMenuItem latinicaItem = new JMenuItem("SRB Latinica");
        latinicaItem.addActionListener(e -> setLanguage("sr", "Latn"));
        JMenuItem cirilicaItem = new JMenuItem("SRB Ćirilica");
        cirilicaItem.addActionListener(e -> setLanguage("sr", "Cyrl"));
        JMenuItem englishItem = new JMenuItem("ENG");
        englishItem.addActionListener(e -> setLanguage("en", "US"));

        languageMenu.add(latinicaItem);
        languageMenu.add(cirilicaItem);
        languageMenu.add(englishItem);

        menuBar.add(languageMenu);
        setJMenuBar(menuBar);
    }

    private void setLanguage(String language, String country) {
        Locale locale = new Locale(language, country);
        messages = ResourceBundle.getBundle("resources.messages", locale);
        TitledBorder border1 = (TitledBorder) jPanelNarudzbina.getBorder();
        border1.setTitle(messages.getString("jpanel_order"));
        TitledBorder border2 = (TitledBorder) jPanelStavkaNarudzbine.getBorder();
        border2.setTitle(messages.getString("jpanel_orderItem"));
        lblJelo.setText(messages.getString("lbl_jelo"));
        lblIzabranKlijent.setText(messages.getString("lbl_izabranKl"));
        lblKlijent.setText(messages.getString("lbl_client"));
        lblKolicina.setText(messages.getString("lbl_quantity"));
        lblCenaDostave.setText(messages.getString("lbl_deliveryPrice"));
        lblKonacanIznos.setText(messages.getString("lbl_orderPrice"));
        lblNapomena.setText(messages.getString("lbl_note"));
        btnDodajStavku.setText(messages.getString("btn_addOI"));
        btnObrisiStavku.setText(messages.getString("btn_deleteOI"));
        btnSacuvaj.setText(messages.getString("btn_save"));
        btnIzaberiKlijenta.setText(messages.getString("btn_izaberiKl"));
        btnUnesiNovogKlijenta.setText(messages.getString("btn_addClient"));
        TableModelStavkeNarudzbine tmsn2 = (TableModelStavkeNarudzbine) tblStavke.getModel();
        tmsn2.setLanguage(locale);
        txtNapomena.setText(messages.getString("note"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_addOrder"));
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void customizeOptionPane() {
        UIManager.put("OptionPane.background", new Color(1, 195, 233));
        UIManager.put("Panel.background", new Color(1, 195, 233));

        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("resources/Roboto-Regular.ttf");
            if (fontStream != null) {
                Font robotoFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(14f);
                UIManager.put("OptionPane.messageFont", robotoFont);
                UIManager.put("OptionPane.buttonFont", robotoFont);
            } else {
                System.out.println("Font fajl nije pronađen.");
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public Klijent getIzabraniKlijent() {
        return izabraniKlijent;
    }

    public void setIzabraniKlijent(Klijent izabraniKlijent) {
        this.izabraniKlijent = izabraniKlijent;
        txtIzabraniKlijent.setText(izabraniKlijent.toString());
        if (izabraniKlijent.getStatus().equals("WOLT+")) {
            txtCenaDostave.setText("Besplatno");
            TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();
            ukupanIznos = tm.vratiUkupanIznos();
            txtKonacanIznos.setText(String.valueOf(ukupanIznos) + "din");

        } else {
            txtCenaDostave.setText("500.00din");
            txtKonacanIznos.setText(String.valueOf(ukupanIznos + 500) + "din");
        }
    }

    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnDodajStavku, btnObrisiStavku, btnSacuvaj, btnIzaberiKlijenta, btnUnesiNovogKlijenta};

        for (JButton button : buttons) {
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(hoverColor);
                    button.setForeground(new Color(1, 195, 233));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(UIManager.getColor("control"));
                    button.setForeground(Color.BLACK);
                }
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzaberiKlijenta;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUnesiNovogKlijenta;
    private javax.swing.JComboBox cmbJelo;
    private javax.swing.JLabel errorKolicina;
    private javax.swing.JPanel jPanelNarudzbina;
    private javax.swing.JPanel jPanelStavkaNarudzbine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCenaDostave;
    private javax.swing.JLabel lblIzabranKlijent;
    private javax.swing.JLabel lblJelo;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblKonacanIznos;
    private javax.swing.JLabel lblNapomena;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCenaDostave;
    private javax.swing.JTextField txtIzabraniKlijent;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtKonacanIznos;
    private javax.swing.JTextArea txtNapomena;
    // End of variables declaration//GEN-END:variables
}
