/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_forms;

import FormKlijent.FormNoviKlijent;
import FormKlijent.FormPretragaKlijenta;
import FormJelo.FormNovoJelo;
import FormJelo.FormPretragaJela;
import FormNarudzbina.FormPretragaNarudzbine;
import controller.ClientController;
import model.Administrator;
import model.Jelo;
import model.Klijent;
import model.Narudzbina;
import model.StavkaNarudzbine;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tableModels.TableModelStavkeNarudzbine;
import communication.Communication;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Anđela
 */
public class MainForm extends javax.swing.JFrame {

    private ResourceBundle messages;
    private Administrator ulogovani;
    private double ukupanIznos;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        customizeOptionPane();
        setLocationRelativeTo(null);
        errorKolicina.setText("");
        this.ulogovani = Communication.getInstance().getUlogovani();
        popuniJela();
        popuniKlijente();
        tblStavke.setModel(new TableModelStavkeNarudzbine());
        lblUlogovani.setText("Ulogovani administrator: " + ulogovani);
        setTitle("Klijentska forma");
        getContentPane().setBackground(new Color(1, 195, 233));
        txtCenaDostave.setEnabled(false);
        txtKonacanIznos.setEnabled(false);

        setRobotoFont();
        setForeground(Color.WHITE);

        Image woltIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/wolt-logo.png"));
        setIconImage(woltIcon);

        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        createLanguageMenu();

        addDocumentListeners();

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        null,
                        messages.getString("confirm_question"),
                        messages.getString("confirm_title"),
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    try {
                        ClientController.getInstance().logout(ulogovani);
                        System.exit(0);
                    } catch (Exception ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
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
                Integer.parseInt(kolicinaText);
                errorLabel.setText("");
                txtKolicina.setBackground(Color.WHITE);
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

        lblUlogovani = new javax.swing.JLabel();
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
        cmbKlijent = new javax.swing.JComboBox();
        txtKonacanIznos = new javax.swing.JTextField();
        txtCenaDostave = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuKlijent = new javax.swing.JMenu();
        miNoviKlijent = new javax.swing.JMenuItem();
        miPretragaKlijenta = new javax.swing.JMenuItem();
        jMenuJelo = new javax.swing.JMenu();
        miNovoJelo = new javax.swing.JMenuItem();
        miPretragaJela = new javax.swing.JMenuItem();
        jMenuNarudzbina = new javax.swing.JMenu();
        miPretragaNarudzbine = new javax.swing.JMenuItem();
        jMenuOdjava = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();
        languageMenu = new javax.swing.JMenu();
        latinicaItem = new javax.swing.JMenuItem();
        cirilicaItem = new javax.swing.JMenuItem();
        englishItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
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

        cmbKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKlijent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKlijentItemStateChanged(evt);
            }
        });

        txtCenaDostave.setText("500.0din");

        javax.swing.GroupLayout jPanelNarudzbinaLayout = new javax.swing.GroupLayout(jPanelNarudzbina);
        jPanelNarudzbina.setLayout(jPanelNarudzbinaLayout);
        jPanelNarudzbinaLayout.setHorizontalGroup(
            jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKonacanIznos, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(lblCenaDostave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKlijent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCenaDostave)
                            .addComponent(txtKonacanIznos, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelStavkaNarudzbine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelNarudzbinaLayout.setVerticalGroup(
            jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNarudzbinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelStavkaNarudzbine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKlijent)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCenaDostave)
                    .addComponent(txtCenaDostave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNarudzbinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKonacanIznos)
                    .addComponent(txtKonacanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuKlijent.setText("Klijent");

        miNoviKlijent.setText("Novi klijent");
        miNoviKlijent.setPreferredSize(new java.awt.Dimension(629, 22));
        miNoviKlijent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviKlijentActionPerformed(evt);
            }
        });
        jMenuKlijent.add(miNoviKlijent);

        miPretragaKlijenta.setText("Pretraga klijenta");
        miPretragaKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaKlijentaActionPerformed(evt);
            }
        });
        jMenuKlijent.add(miPretragaKlijenta);

        jMenuBar1.add(jMenuKlijent);

        jMenuJelo.setText("Jelo");

        miNovoJelo.setText("Novo jelo");
        miNovoJelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovoJeloActionPerformed(evt);
            }
        });
        jMenuJelo.add(miNovoJelo);

        miPretragaJela.setText("Pretraga jela");
        miPretragaJela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaJelaActionPerformed(evt);
            }
        });
        jMenuJelo.add(miPretragaJela);

        jMenuBar1.add(jMenuJelo);

        jMenuNarudzbina.setText("Narudžbina");

        miPretragaNarudzbine.setText("Pretraga narudžbine");
        miPretragaNarudzbine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaNarudzbineActionPerformed(evt);
            }
        });
        jMenuNarudzbina.add(miPretragaNarudzbine);

        jMenuBar1.add(jMenuNarudzbina);

        jMenuOdjava.setText("Odjava");

        miOdjava.setText("Odjavi se");
        miOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenuOdjava.add(miOdjava);

        jMenuBar1.add(jMenuOdjava);

        languageMenu.setText("Jezik");

        latinicaItem.setText("SRB Latinica");
        languageMenu.add(latinicaItem);

        cirilicaItem.setText("SRB Ćirilica");
        languageMenu.add(cirilicaItem);

        englishItem.setText("ENG");
        languageMenu.add(englishItem);

        jMenuBar1.add(languageMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNarudzbina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNarudzbina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviKlijentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviKlijentActionPerformed
        new FormNoviKlijent(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviKlijentActionPerformed

    private void miPretragaKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKlijentaActionPerformed
        new FormPretragaKlijenta(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKlijentaActionPerformed

    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOdjavaActionPerformed
        customizeOptionPane();
        int result = JOptionPane.showConfirmDialog(
                null,
                messages.getString("confirm_question"),
                messages.getString("confirm_title"),
                JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                System.out.println("Klijent uspešno odjavljen");
                ClientController.getInstance().logout(ulogovani);
                new LoginForm().setVisible(true);
                Communication.getInstance().setUlogovani(null);
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_miOdjavaActionPerformed

    private void miNovoJeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovoJeloActionPerformed
        new FormNovoJelo(this, true).setVisible(true);
    }//GEN-LAST:event_miNovoJeloActionPerformed

    private void miPretragaJelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaJelaActionPerformed
        new FormPretragaJela(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaJelaActionPerformed

    private void miPretragaNarudzbineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaNarudzbineActionPerformed
        new FormPretragaNarudzbine(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaNarudzbineActionPerformed

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
            Klijent klijent = (Klijent) cmbKlijent.getSelectedItem();
            double cenaDostave;

            if (klijent.getStatus().equals("FREE")) {
                cenaDostave = 500;
            } else {
                cenaDostave = 0;
            }

            TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();
            if (tm.getLista().size() == 0) {
                JOptionPane.showMessageDialog(this, messages.getString("sn_zero"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            Narudzbina narudzbina = new Narudzbina(null, new Date(), cenaDostave,
                    ukupanIznos, false, klijent, ulogovani, tm.getLista());

            ClientController.getInstance().addNarudzbina(narudzbina);
            txtKonacanIznos.setText("");
            tm.getLista().clear();
            tm.fireTableDataChanged();
            JOptionPane.showMessageDialog(this, messages.getString("success_save_order"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void cmbKlijentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKlijentItemStateChanged

        if (cmbKlijent.getSelectedItem() != null) {
            Klijent klijent = (Klijent) cmbKlijent.getSelectedItem();

            if (klijent.getStatus().equals("WOLT+")) {
                txtCenaDostave.setText("Besplatno");
                TableModelStavkeNarudzbine tm = (TableModelStavkeNarudzbine) tblStavke.getModel();

                ukupanIznos = tm.vratiUkupanIznos();
                txtKonacanIznos.setText(String.valueOf(ukupanIznos) + "din");

            } else {
                txtCenaDostave.setText("500.00din");
                txtKonacanIznos.setText(String.valueOf(ukupanIznos + 500) + "din");
            }

        }
    }//GEN-LAST:event_cmbKlijentItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JMenuItem cirilicaItem;
    private javax.swing.JComboBox cmbJelo;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JMenuItem englishItem;
    private javax.swing.JLabel errorKolicina;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuJelo;
    private javax.swing.JMenu jMenuKlijent;
    private javax.swing.JMenu jMenuNarudzbina;
    private javax.swing.JMenu jMenuOdjava;
    private javax.swing.JPanel jPanelNarudzbina;
    private javax.swing.JPanel jPanelStavkaNarudzbine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JMenuItem latinicaItem;
    private javax.swing.JLabel lblCenaDostave;
    private javax.swing.JLabel lblJelo;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblKonacanIznos;
    private javax.swing.JLabel lblNapomena;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNoviKlijent;
    private javax.swing.JMenuItem miNovoJelo;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPretragaJela;
    private javax.swing.JMenuItem miPretragaKlijenta;
    private javax.swing.JMenuItem miPretragaNarudzbine;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCenaDostave;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtKonacanIznos;
    private javax.swing.JTextArea txtNapomena;
    // End of variables declaration//GEN-END:variables

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
        latinicaItem.addActionListener(e -> setLanguage("sr", "Latn"));
        cirilicaItem.addActionListener(e -> setLanguage("sr", "Cyrl"));
        englishItem.addActionListener(e -> setLanguage("en", "US"));
    }

    private void setLanguage(String language, String country) {
        Locale locale = new Locale(language, country);
        messages = ResourceBundle.getBundle("resources.messages", locale);
        lblUlogovani.setText(messages.getString("lbl_ulogovani"));
        jMenuJelo.setText(messages.getString("jmenu_jelo"));
        jMenuKlijent.setText(messages.getString("jmenu_client"));
        jMenuOdjava.setText(messages.getString("jmenu_logout"));
        jMenuNarudzbina.setText(messages.getString("jmenu_order"));
        miNoviKlijent.setText(messages.getString("mi_newC"));
        miPretragaKlijenta.setText(messages.getString("mi_findC"));
        miNovoJelo.setText(messages.getString("mi_newD"));
        miPretragaJela.setText(messages.getString("mi_findD"));
        miPretragaNarudzbine.setText(messages.getString("mi_findO"));
        miOdjava.setText(messages.getString("mi_logout"));
        TitledBorder border1 = (TitledBorder) jPanelNarudzbina.getBorder();
        border1.setTitle(messages.getString("jpanel_order"));
        TitledBorder border2 = (TitledBorder) jPanelStavkaNarudzbine.getBorder();
        border2.setTitle(messages.getString("jpanel_orderItem"));
        lblJelo.setText(messages.getString("lbl_jelo"));
        lblKlijent.setText(messages.getString("lbl_client"));
        lblKolicina.setText(messages.getString("lbl_quantity"));
        lblCenaDostave.setText(messages.getString("lbl_deliveryPrice"));
        lblKonacanIznos.setText(messages.getString("lbl_orderPrice"));
        lblNapomena.setText(messages.getString("lbl_note"));
        btnDodajStavku.setText(messages.getString("btn_addOI"));
        btnObrisiStavku.setText(messages.getString("btn_deleteOI"));
        btnSacuvaj.setText(messages.getString("btn_save"));
        TableModelStavkeNarudzbine tmsn2 = (TableModelStavkeNarudzbine) tblStavke.getModel();
        tmsn2.setLanguage(locale);
        txtNapomena.setText(messages.getString("note"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_main"));
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

    private void popuniKlijente() {
        try {
            ArrayList<Klijent> klijenti = ClientController.getInstance().getAllKlijent();

            cmbKlijent.removeAllItems();

            for (Klijent klijent : klijenti) {
                cmbKlijent.addItem(klijent);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnDodajStavku, btnObrisiStavku, btnSacuvaj};

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
}
