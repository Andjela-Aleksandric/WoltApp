/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package FormJelo;

import controller.ClientController;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import model.Jelo;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main_forms.LoginForm;
import models.TableModelNarudzbine;

/**
 *
 * @author Anđela
 */
public class FormDetaljiJela extends javax.swing.JDialog {

    private Jelo j;
    private ResourceBundle messages;
    private JMenu languageMenu;

    /**
     * Creates new form FormDetaljiJela
     */
    public FormDetaljiJela(JDialog parent, boolean modal, Jelo jelo) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Detalji jela");
        errorCena.setText("");
        errorNaziv.setText("");
        errorOpis.setText("");
        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        setRobotoFont();
        createLanguageMenu();
        this.j = jelo;
        txtNaziv.setText(jelo.getNaziv());
        txtOpis.setText(jelo.getOpis());
        txtCena.setText(String.valueOf(jelo.getCena()));
//        tblNarudzbine.setModel(new TableModelNarudzbine(jelo));
        addDocumentListeners();
        customizeButtons();
    }

    private void addDocumentListeners() {
        txtNaziv.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validateFieldNaziv(errorNaziv, messages.getString("error_name"));
            }

            public void removeUpdate(DocumentEvent e) {
                validateFieldNaziv(errorNaziv, messages.getString("error_name"));
            }

            public void changedUpdate(DocumentEvent e) {
                validateFieldNaziv(errorNaziv, messages.getString("error_name"));
            }

        });

        txtOpis.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validateFieldOpis(errorOpis, messages.getString("error_opis"));
            }

            public void removeUpdate(DocumentEvent e) {
                validateFieldOpis(errorOpis, messages.getString("error_opis"));
            }

            public void changedUpdate(DocumentEvent e) {
                validateFieldOpis(errorOpis, messages.getString("error_opis"));
            }
        });

        txtCena.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validateFieldCena(errorCena, messages.getString("error_cenaJela"));
            }

            public void removeUpdate(DocumentEvent e) {
                validateFieldCena(errorCena, messages.getString("error_cenaJela"));
            }

            public void changedUpdate(DocumentEvent e) {
                validateFieldCena(errorCena, messages.getString("error_cenaJela"));
            }
        });
    }

    private void validateFieldNaziv(javax.swing.JLabel errorLabel, String errorMessage) {
        if (txtNaziv.getText().length() <= 2 || txtNaziv.getText().length() >= 50 || txtNaziv.getText().isEmpty()) {
            txtNaziv.setBackground(Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        } else {
            txtNaziv.setBackground(Color.WHITE);
            errorLabel.setText("");
        }
    }

    private void validateFieldCena(javax.swing.JLabel errorLabel, String errorMessage) {

        try {
            double cena = Double.parseDouble(txtCena.getText());
            if (cena > 50 && cena < 10000) {
                txtCena.setBackground(Color.WHITE);
                errorLabel.setText("");
            } else {
                txtCena.setBackground(Color.PINK);
                errorLabel.setText(errorMessage);
                errorLabel.setForeground(Color.red);
            }
        } catch (NumberFormatException e) {
            txtCena.setBackground(Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        }
    }

    private void validateFieldOpis(javax.swing.JLabel errorLabel, String errorMessage) {
        if (txtOpis.getText().length() <= 2 || txtOpis.getText().isEmpty() || txtOpis.getText().length() >= 200) {
            txtOpis.setBackground(Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        } else {
            txtOpis.setBackground(Color.WHITE);
            errorLabel.setText("");
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

        txtOpis = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblOpis = new javax.swing.JLabel();
        lblCena = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        btnZatvori = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        errorNaziv = new javax.swing.JLabel();
        errorOpis = new javax.swing.JLabel();
        errorCena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaziv.setText("Naziv:");

        lblOpis.setText("Opis:");

        lblCena.setText("Cena:");

        btnZatvori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnZatvori.setText("Zatvori");
        btnZatvori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setText("Obriši jelo");
        btnObrisi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeni.setText("Izmeni jelo");
        btnIzmeni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        errorNaziv.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorNaziv.setText("jLabel1");

        errorOpis.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorOpis.setText("jLabel1");

        errorCena.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorCena.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(lblOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(txtOpis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(txtCena, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorCena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNaziv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorNaziv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOpis))
                .addGap(2, 2, 2)
                .addComponent(errorOpis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorCena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni)
                    .addComponent(btnZatvori))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        customizeOptionPane();
        int result = JOptionPane.showConfirmDialog(this, messages.getString("confirm_delete_dish"), messages.getString("confirm_title"), JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteJelo(j);
                FormPretragaJela fp = (FormPretragaJela) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, messages.getString("success_delete_dish"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, messages.getString("error_delete_dish"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        customizeOptionPane();
        try {
            if (txtNaziv.getText().isEmpty()
                    || txtOpis.getText().isEmpty()
                    || txtCena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, messages.getString("error_empty_loginField"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            String naziv = txtNaziv.getText();
            String opis = txtOpis.getText();
            String cena = txtCena.getText();

            j.setNaziv(naziv);
            j.setOpis(opis);
            j.setCena(Double.parseDouble(cena));

            ClientController.getInstance().updateJelo(j);
            FormPretragaJela fp = (FormPretragaJela) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, messages.getString("success_modify_dish"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed
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
        lblNaziv.setText(messages.getString("lbl_dishName"));
        lblOpis.setText(messages.getString("lbl_desc"));
        lblCena.setText(messages.getString("lbl_dishPrice"));
        btnIzmeni.setText(messages.getString("btn_modifyDish"));
        btnZatvori.setText(messages.getString("btn_close"));
        btnObrisi.setText(messages.getString("btn_removeDish"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_dishDetails"));
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnIzmeni, btnObrisi, btnZatvori};

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
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JLabel errorCena;
    private javax.swing.JLabel errorNaziv;
    private javax.swing.JLabel errorOpis;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOpis;
    // End of variables declaration//GEN-END:variables
}
