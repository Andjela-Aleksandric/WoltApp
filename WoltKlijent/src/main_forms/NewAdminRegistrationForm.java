/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package main_forms;

import communication.Communication;
import controller.ClientController;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.*;

/**
 *
 * @author Anđela
 */
public class NewAdminRegistrationForm extends javax.swing.JDialog {

    private ResourceBundle messages;
    private JMenu languageMenu;

    public NewAdminRegistrationForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registracija administratora");

        getContentPane().setBackground(new Color(1, 195, 233));

        setRobotoFont();
        setForeground(Color.WHITE);

        Image woltIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/wolt-logo.png"));
        setIconImage(woltIcon);

        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        createLanguageMenu();

        errorPassword.setText("");
        errorUsername.setText("");
        errorPrezime.setText("");
        errorIme.setText("");
        errorPotvrdiPassword.setText("");

        addActionListeners();
        customizeButtons();

    }

    private void addActionListeners() {
        txtUsername.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField(txtUsername, errorUsername, messages.getString("error_user"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField(txtUsername, errorUsername, messages.getString("error_user"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField(txtUsername, errorUsername, messages.getString("error_user"));
            }
        });

        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField(txtPassword, errorPassword, messages.getString("error_pass"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField(txtPassword, errorPassword, messages.getString("error_pass"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField(txtPassword, errorPassword, messages.getString("error_pass"));
            }
        });

        txtIme.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField(txtIme, errorIme, messages.getString("error_name"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField(txtIme, errorIme, messages.getString("error_name"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField(txtIme, errorIme, messages.getString("error_name"));
            }
        });

        txtIPrezime.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField(txtIPrezime, errorPrezime, messages.getString("error_surname"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField(txtIPrezime, errorPrezime, messages.getString("error_surname"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField(txtIPrezime, errorPrezime, messages.getString("error_surname"));
            }
        });

        txtPotvrdiPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateFieldConfirm(txtPotvrdiPassword, errorPotvrdiPassword, messages.getString("error_confirmPass"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateFieldConfirm(txtPotvrdiPassword, errorPotvrdiPassword, messages.getString("error_confirmPass"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateFieldConfirm(txtPotvrdiPassword, errorPotvrdiPassword, messages.getString("error_confirmPass"));
            }
        });

    }

    private void validateField(javax.swing.JTextField field, javax.swing.JLabel errorLabel, String errorMessage) {
        if (field.getText().isEmpty() || field.getText().length() <= 2 || field.getText().length() >= 50) {
            field.setBackground(Color.pink);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        } else {
            field.setBackground(Color.white);
            errorLabel.setText("");
        }
    }

    private void validateField(javax.swing.JPasswordField field, javax.swing.JLabel errorLabel, String errorMessage) {
        if (String.valueOf(field.getPassword()).isEmpty() || String.valueOf(field.getPassword()).length() <= 5 || String.valueOf(field.getPassword()).length() >= 64) {
            field.setBackground(Color.pink);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        } else {
            field.setBackground(Color.white);
            errorLabel.setText("");
        }
    }

    private void validateFieldConfirm(javax.swing.JPasswordField field, javax.swing.JLabel errorLabel, String errorMessage) {
        if (String.valueOf(field.getPassword()).isEmpty() || !String.valueOf(field.getPassword()).equals(String.valueOf(txtPassword.getPassword()))) {
            field.setBackground(Color.pink);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        } else {
            field.setBackground(Color.white);
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

        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblPrezime = new javax.swing.JLabel();
        txtIPrezime = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblPass = new javax.swing.JLabel();
        btnRegistruj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        errorIme = new javax.swing.JLabel();
        errorPrezime = new javax.swing.JLabel();
        errorUsername = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        lblPotvrdiPass = new javax.swing.JLabel();
        txtPotvrdiPassword = new javax.swing.JPasswordField();
        errorPotvrdiPassword = new javax.swing.JLabel();
        cmbPozicija = new javax.swing.JComboBox<>();
        lblPozicija = new javax.swing.JLabel();
        jDateDatumDo = new com.toedter.calendar.JDateChooser();
        jDateDatumOd = new com.toedter.calendar.JDateChooser();
        lblDatumOd = new javax.swing.JLabel();
        lblDatumDo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        lblUsername.setText("Korisničko ime:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        lblPass.setText("Lozinka:");

        btnRegistruj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistruj.setText("Registruj");
        btnRegistruj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrujActionPerformed(evt);
            }
        });

        btnOtkazi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOtkazi.setText("Otkaži");
        btnOtkazi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        errorIme.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorIme.setText("jLabel1");

        errorPrezime.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorPrezime.setText("jLabel1");

        errorUsername.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorUsername.setText("jLabel1");

        errorPassword.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorPassword.setText("jLabel1");

        lblPotvrdiPass.setText("Potvrdi lozinku:");

        txtPotvrdiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPotvrdiPasswordActionPerformed(evt);
            }
        });

        errorPotvrdiPassword.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorPotvrdiPassword.setText("jLabel1");

        cmbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistem administrator", "Tehnička podrška aplikacije", "Menadžer podrške" }));

        lblPozicija.setText("Pozicija:");

        lblDatumOd.setText("Datum od:");

        lblDatumDo.setText("Datum do:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPotvrdiPass, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(lblPrezime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPozicija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDatumOd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDatumDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(errorUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtIme)
                            .addComponent(txtIPrezime)
                            .addComponent(errorIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorPotvrdiPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPotvrdiPassword)
                            .addComponent(cmbPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateDatumOd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateDatumDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistruj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorIme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrezime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorPrezime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(errorUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass))
                .addGap(5, 5, 5)
                .addComponent(errorPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPotvrdiPass)
                    .addComponent(txtPotvrdiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorPotvrdiPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPozicija))
                        .addGap(26, 26, 26)
                        .addComponent(jDateDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDatumOd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatumDo)
                    .addComponent(jDateDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnRegistruj))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnRegistrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrujActionPerformed
        customizeOptionPane();
        try {

            if (jDateDatumOd.getDate() == null) {
                JOptionPane.showMessageDialog(this, messages.getString("error_date"),
                        messages.getString("error_title"),
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (jDateDatumDo.getDate() == null) {
                JOptionPane.showMessageDialog(this, messages.getString("error_dateDo"),
                        messages.getString("error_title"),
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                if (jDateDatumDo.getDate().before(jDateDatumOd.getDate())) {
                    JOptionPane.showMessageDialog(this, messages.getString("error_date"),
                            messages.getString("error_title"),
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }

            if (txtUsername.getText() == null || txtUsername.getText().isEmpty() || txtPassword.getPassword() == null || String.valueOf(txtPassword.getPassword()).isEmpty()
                    || txtIme.getText() == null || txtIme.getText().isEmpty() || txtIPrezime.getText() == null || txtIPrezime.getText().isEmpty()
                    || txtIme.getBackground().equals(Color.PINK) || txtIPrezime.getBackground().equals(Color.PINK) || txtPassword.getBackground().equals(Color.PINK)
                    || txtUsername.getBackground().equals(Color.PINK) || txtPotvrdiPassword.getPassword() == null || txtPotvrdiPassword.getBackground().equals(Color.PINK)
                    || jDateDatumOd.getDate() == null || jDateDatumDo.getDate() == null) {
                JOptionPane.showMessageDialog(this, messages.getString("error_empty_loginField"),
                        messages.getString("error_title"),
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Administrator a = new Administrator(null, txtIme.getText(), txtIPrezime.getText(), txtUsername.getText(), new String(txtPassword.getPassword()));
            try {
                String pozicija = (String) cmbPozicija.getSelectedItem();
                Date datumOd = jDateDatumOd.getDate();
                Date datumDoo = jDateDatumDo.getDate();
                ClientController.getInstance().register(a, pozicija, datumOd, datumDoo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        messages.getString("error_title"),
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, messages.getString("success_register"), messages.getString("success_title"),
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrujActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPotvrdiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPotvrdiPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPotvrdiPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnRegistruj;
    private javax.swing.JComboBox<String> cmbPozicija;
    private javax.swing.JLabel errorIme;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorPotvrdiPassword;
    private javax.swing.JLabel errorPrezime;
    private javax.swing.JLabel errorUsername;
    private com.toedter.calendar.JDateChooser jDateDatumDo;
    private com.toedter.calendar.JDateChooser jDateDatumOd;
    private javax.swing.JLabel lblDatumDo;
    private javax.swing.JLabel lblDatumOd;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPotvrdiPass;
    private javax.swing.JLabel lblPozicija;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtIPrezime;
    private javax.swing.JTextField txtIme;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPotvrdiPassword;
    private javax.swing.JTextField txtUsername;
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
        jDateDatumDo.setLocale(locale);
        jDateDatumOd.setLocale(locale);
        lblIme.setText(messages.getString("lbl_name"));
        lblPrezime.setText(messages.getString("lbl_surname"));
        lblUsername.setText(messages.getString("username"));
        lblPass.setText(messages.getString("password"));
        lblPotvrdiPass.setText(messages.getString("potvrdi_pass"));
        lblPozicija.setText(messages.getString("cmb_pozicija"));
        lblDatumDo.setText(messages.getString("datum_do"));
        lblDatumOd.setText(messages.getString("datum_od"));
        btnOtkazi.setText(messages.getString("btn_cancel"));
        btnRegistruj.setText(messages.getString("btn_register"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_register"));
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnOtkazi, btnRegistruj};

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
