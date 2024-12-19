/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormNarudzbina;

import FormKlijent.FormIzaberiKlijenta;
import FormKlijent.FormNoviKlijent;
import controller.ClientController;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import model.Jelo;
import model.Klijent;
import model.Narudzbina;
import model.StavkaNarudzbine;
import main_forms.MainForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import tableModels.TableModelStavkeNarudzbine;

/**
 *
 * @author Anđela
 */
public class FormDetaljiNarudzbine extends javax.swing.JDialog {

    private ResourceBundle messages;
    private JMenu languageMenu;
    private Narudzbina n;
    private double ukupanIznos;
    private Klijent izabraniKlijent;

    public FormDetaljiNarudzbine(JDialog parent, boolean modal, Narudzbina narudzbina) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Detalji narudžbine");
        this.n = narudzbina;
        txtCenaDostave.setEnabled(false);
        txtKonacanIznos.setEnabled(false);
        this.izabraniKlijent = n.getKlijent();
        txtIzabraniKlijent.setText(n.getKlijent().toString());
        txtIzabraniKlijent.setEnabled(false);
        errorKolicina.setText("");
        tblStavke.setModel(new TableModelStavkeNarudzbine());
        popuniJela();
        ukupanIznos = narudzbina.getKonacnaCena();
        txtKonacanIznos.setText(String.valueOf(ukupanIznos) + "din");
        cbIsporucena.setSelected(narudzbina.isIsporucena());
        tblStavke.setModel(new TableModelStavkeNarudzbine(narudzbina));
        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        createLanguageMenu();
        setRobotoFont();
        customizeOptionPane();
        if (narudzbina.isIsporucena()) {
            cmbJelo.setEnabled(false);
            btnDodajStavku.setEnabled(false);
            btnIzmeni.setEnabled(false);
            btnObrisi.setEnabled(false);
            btnObrisiStavku.setEnabled(false);
            txtKolicina.setEnabled(false);
            txtNapomena.setEnabled(false);
            cbIsporucena.setEnabled(false);
            JOptionPane.showMessageDialog(this, messages.getString("order_delivered"), messages.getString("war_title"), JOptionPane.WARNING_MESSAGE);
        }
        addDocumentListeners();
        customizeButtons();
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
                }

            } catch (NumberFormatException e) {
                txtKolicina.setBackground(Color.PINK);
            }
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
        lblCenaDostave = new javax.swing.JLabel();
        lblKonacanIznos = new javax.swing.JLabel();
        txtKonacanIznos = new javax.swing.JTextField();
        txtCenaDostave = new javax.swing.JTextField();
        btnZatvori = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        lblIsporucena = new javax.swing.JLabel();
        cbIsporucena = new javax.swing.JCheckBox();
        btnUnesiNovogKlijenta = new javax.swing.JButton();
        txtIzabraniKlijent = new javax.swing.JTextField();
        lblIzabranKlijent = new javax.swing.JLabel();
        btnIzaberiKlijenta = new javax.swing.JButton();
        lblKlijent = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelNarudzbina.setBorder(javax.swing.BorderFactory.createTitledBorder("Narudžbina"));

        jPanelStavkaNarudzbine.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke narudžbine"));

        lblJelo.setText("Jelo:");

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
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNapomena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtKolicina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                                .addComponent(errorKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbJelo, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                        .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                                .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelStavkaNarudzbineLayout.setVerticalGroup(
            jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJelo)
                    .addComponent(cmbJelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStavkaNarudzbineLayout.createSequentialGroup()
                        .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKolicina)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStavkaNarudzbineLayout.createSequentialGroup()
                        .addComponent(errorKolicina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNapomena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkaNarudzbineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku)
                    .addComponent(btnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblCenaDostave.setText("Cena dostave:");

        lblKonacanIznos.setText("Konačan iznos:");

        txtCenaDostave.setText("500.0din");

        btnZatvori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnZatvori.setText("Zatvori");
        btnZatvori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setText("Obriši narudžbinu");
        btnObrisi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeni.setText("Izmeni narudžbinu");
        btnIzmeni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        lblIsporucena.setText("Isporučena:");

        btnUnesiNovogKlijenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUnesiNovogKlijenta.setText("Unesi novog klijenta");
        btnUnesiNovogKlijenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUnesiNovogKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiNovogKlijentaActionPerformed(evt);
            }
        });

        lblIzabranKlijent.setText("Izabrani klijent:");

        btnIzaberiKlijenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzaberiKlijenta.setText("Izaberi klijenta");
        btnIzaberiKlijenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIzaberiKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiKlijentaActionPerformed(evt);
            }
        });

        lblKlijent.setText("Klijent:");

        javax.swing.GroupLayout jPanelNarudzbinaLayout = new javax.swing.GroupLayout(jPanelNarudzbina);
        jPanelNarudzbina.setLayout(jPanelNarudzbinaLayout);
        jPanelNarudzbinaLayout.setHorizontalGroup(
            jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelStavkaNarudzbine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNarudzbinaLayout.createSequentialGroup()
                        .addComponent(lblKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                        .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIzabranKlijent, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(lblCenaDostave, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKonacanIznos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIsporucena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)))
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbIsporucena)
                    .addComponent(txtIzabraniKlijent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                            .addComponent(btnIzaberiKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                            .addComponent(btnUnesiNovogKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtKonacanIznos))
                    .addComponent(txtCenaDostave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNarudzbinaLayout.setVerticalGroup(
            jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addComponent(jPanelStavkaNarudzbine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKlijent)
                    .addComponent(btnIzaberiKlijenta)
                    .addComponent(btnUnesiNovogKlijenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(10, 10, 10)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIsporucena)
                    .addComponent(cbIsporucena))
                .addGap(18, 18, 18)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZatvori)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNarudzbina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNarudzbina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        customizeOptionPane();
        int result = JOptionPane.showConfirmDialog(this, messages.getString("confirm_delete_order"), messages.getString("confirm_title"), JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteNarudzbina(n);
                FormPretragaNarudzbine fp = (FormPretragaNarudzbine) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, messages.getString("success_delete_order"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(FormDetaljiNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        customizeOptionPane();
        try {

            TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();

            n.setKonacnaCena(ukupanIznos);
            n.setStavkeNarudzbine(tm.getLista());
            n.setIsporucena(cbIsporucena.isSelected());
            n.setKlijent(izabraniKlijent);

            ClientController.getInstance().updateNarudzbina(n);
            FormPretragaNarudzbine fp = (FormPretragaNarudzbine) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, messages.getString("success_modify_order"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        customizeOptionPane();
        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, messages.getString("error_emptyQty"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
            return;
        }

        Jelo jelo = (Jelo) cmbJelo.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        String napomena = txtNapomena.getText();

        StavkaNarudzbine sn = new StavkaNarudzbine(n, -1, kolicina, jelo.getCena() * kolicina,
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

    private void btnIzaberiKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiKlijentaActionPerformed
        new FormIzaberiKlijenta(this, true).setVisible(true);
    }//GEN-LAST:event_btnIzaberiKlijentaActionPerformed

    private void btnUnesiNovogKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiNovogKlijentaActionPerformed
        new FormNoviKlijent(null, true).setVisible(true);
    }//GEN-LAST:event_btnUnesiNovogKlijentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzaberiKlijenta;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnUnesiNovogKlijenta;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JCheckBox cbIsporucena;
    private javax.swing.JComboBox cmbJelo;
    private javax.swing.JLabel errorKolicina;
    private javax.swing.JPanel jPanelNarudzbina;
    private javax.swing.JPanel jPanelStavkaNarudzbine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCenaDostave;
    private javax.swing.JLabel lblIsporucena;
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
        lblJelo.setText(messages.getString("lbl_jelo"));
        lblCenaDostave.setText(messages.getString("lbl_deliveryPrice"));
        lblKlijent.setText(messages.getString("lbl_client"));
        lblKolicina.setText(messages.getString("lbl_quantity"));
        lblIsporucena.setText(messages.getString("lbl_delivered"));
        lblKonacanIznos.setText(messages.getString("lbl_orderPrice"));
        lblIzabranKlijent.setText(messages.getString("lbl_izabranKl"));
        lblNapomena.setText(messages.getString("lbl_note"));
        TitledBorder border1 = (TitledBorder) jPanelNarudzbina.getBorder();
        border1.setTitle(messages.getString("jpanel_order"));
        TitledBorder border2 = (TitledBorder) jPanelStavkaNarudzbine.getBorder();
        border2.setTitle(messages.getString("jpanel_orderItem"));
        btnDodajStavku.setText(messages.getString("btn_addOI"));
        btnObrisiStavku.setText(messages.getString("btn_deleteOI"));
        btnIzaberiKlijenta.setText(messages.getString("btn_izaberiKl"));
        btnUnesiNovogKlijenta.setText(messages.getString("btn_addClient"));
        btnZatvori.setText(messages.getString("btn_close"));
        btnIzmeni.setText(messages.getString("btn_modifyOrder"));
        btnObrisi.setText(messages.getString("btn_removeOrder"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_login"));
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnDodajStavku, btnIzmeni, btnObrisi, btnObrisiStavku, btnZatvori, btnIzaberiKlijenta, btnUnesiNovogKlijenta};

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

}
