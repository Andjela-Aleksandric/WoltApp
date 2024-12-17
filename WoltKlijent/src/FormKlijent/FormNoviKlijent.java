/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormKlijent;

import controller.ClientController;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import model.Klijent;
import model.Mesto;
import java.util.ArrayList;
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
import main_forms.LoginForm;

/**
 *
 * @author Anđela
 */
public class FormNoviKlijent extends javax.swing.JDialog {

    private ResourceBundle messages;
    private JMenu languageMenu;

    public FormNoviKlijent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        errorAdresa.setText("");
        errorIme.setText("");
        errorPrezime.setText("");
        errorEmail.setText("");
        errorTelefon.setText("");
        setTitle("Unos klijenta");
        popuniMesta();
        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        createLanguageMenu();
        setRobotoFont();
        addDocumentListeners();
        customizeButtons();
    }

    private void addDocumentListeners() {
        txtEmail.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEmail(errorEmail, messages.getString("error_email"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEmail(errorEmail, messages.getString("error_email"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEmail(errorEmail, messages.getString("error_email"));
            }
        });

        txtTelefon.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateTelefon(errorTelefon, messages.getString("error_telefon"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateTelefon(errorTelefon, messages.getString("error_telefon"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateTelefon(errorTelefon, messages.getString("error_telefon"));
            }
        });

        txtIme.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateText(txtIme, errorIme, messages.getString("error_ime"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateText(txtIme, errorIme, messages.getString("error_ime"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateText(txtIme, errorIme, messages.getString("error_ime"));
            }
        });

        txtPrezime.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateText(txtPrezime, errorPrezime, messages.getString("error_prezime"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateText(txtPrezime, errorPrezime, messages.getString("error_prezime"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateText(txtPrezime, errorPrezime, messages.getString("error_prezime"));
            }
        });

        txtAdresa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateText(txtAdresa, errorAdresa, messages.getString("error_adresa"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateText(txtAdresa, errorAdresa, messages.getString("error_adresa"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateText(txtAdresa, errorAdresa, messages.getString("error_adresa"));
            }
        });
    }

    private void validateText(javax.swing.JTextField field, javax.swing.JLabel errorLabel, String errorMessage) {
        if (field.getText().isEmpty() || field.getText().length() <= 2 || field.getText().length() >= 30) {
            field.setBackground(java.awt.Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        } else {
            field.setBackground(java.awt.Color.WHITE);
            errorLabel.setText("");
        }
    }

    private void validateEmail(javax.swing.JLabel errorLabel, String errorMessage) {
        String email = txtEmail.getText();
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email.matches(regex)) {
            txtEmail.setBackground(java.awt.Color.WHITE);
            errorLabel.setText("");
        } else {
            txtEmail.setBackground(java.awt.Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
        }
    }

    private void validateTelefon(javax.swing.JLabel errorLabel, String errorMessage) {
        String telefon = txtTelefon.getText();
        String regexSrpski = "^(\\+381|0)[6-9]\\d{7}$";
        String regexStrani = "^\\+\\d{1,3}\\d{4,14}$";

        if (telefon.matches(regexSrpski) || telefon.matches(regexStrani)) {
            txtTelefon.setBackground(java.awt.Color.WHITE);
            errorLabel.setText("");
        } else {
            txtTelefon.setBackground(java.awt.Color.PINK);
            errorLabel.setText(errorMessage);
            errorLabel.setForeground(Color.red);
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
        txtPrezime = new javax.swing.JTextField();
        btnZatvori = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblAdresa = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblMesto = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        txtAdresa = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        cmbMesto = new javax.swing.JComboBox();
        errorIme = new javax.swing.JLabel();
        errorEmail = new javax.swing.JLabel();
        errorPrezime = new javax.swing.JLabel();
        errorTelefon = new javax.swing.JLabel();
        errorAdresa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIme.setText("Ime:");

        txtIme.setText("Andrija");

        lblPrezime.setText("Prezime:");

        txtPrezime.setText("Aleksandrić");
        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        btnZatvori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnZatvori.setText("Zatvori");
        btnZatvori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setText("Dodaj klijenta");
        btnDodaj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        lblEmail.setText("Email:");

        lblTelefon.setText("Telefon:");

        txtEmail.setText("andrija@gmail.com");

        lblAdresa.setText("Adresa:");

        lblStatus.setText("Status:");

        lblMesto.setText("Mesto:");

        txtTelefon.setText("062372128");

        txtAdresa.setText("Masarikova 12");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FREE", "WOLT+" }));

        cmbMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        errorIme.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorIme.setText("jLabel1");

        errorEmail.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorEmail.setText("jLabel1");

        errorPrezime.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorPrezime.setText("jLabel1");

        errorTelefon.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorTelefon.setText("jLabel1");

        errorAdresa.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorAdresa.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(lblTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIme, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                                .addComponent(txtTelefon, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAdresa, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbMesto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(errorTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIme))
                .addGap(3, 3, 3)
                .addComponent(errorIme)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorPrezime)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorTelefon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdresa))
                .addGap(1, 1, 1)
                .addComponent(errorAdresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMesto))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZatvori)
                    .addComponent(btnDodaj))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        customizeOptionPane();
        try {
            if (txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty()
                    || txtEmail.getText().isEmpty()
                    || txtAdresa.getText().isEmpty()
                    || txtTelefon.getText().isEmpty()
                    || txtAdresa.getBackground().equals(Color.PINK)
                    || txtEmail.getBackground().equals(Color.PINK)
                    || txtTelefon.getBackground().equals(Color.PINK)
                    || txtIme.getBackground().equals(Color.PINK)
                    || txtPrezime.getBackground().equals(Color.PINK)) {
                JOptionPane.showMessageDialog(this, messages.getString("error_empty_loginField"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            String email = txtEmail.getText();
            String telefon = txtTelefon.getText();
            String adresa = txtAdresa.getText();
            String status = (String) cmbStatus.getSelectedItem();
            Mesto mesto = (Mesto) cmbMesto.getSelectedItem();

            Klijent k = new Klijent(null, ime, prezime, email, telefon, adresa, status, mesto);

            for (Klijent klijent : ClientController.getInstance().getAllKlijent()) {
                if (k.getEmail().equals(klijent.getEmail())) {
                    JOptionPane.showMessageDialog(this, messages.getString("same_email"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (k.getTelefon().equals(klijent.getTelefon())) {
                    JOptionPane.showMessageDialog(this, messages.getString("same_phone"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            ClientController.getInstance().addKlijent(k);
            JOptionPane.showMessageDialog(this, messages.getString("success_add_user"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JComboBox cmbMesto;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel errorAdresa;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorIme;
    private javax.swing.JLabel errorPrezime;
    private javax.swing.JLabel errorTelefon;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblMesto;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

    private void popuniMesta() {
        try {
            ArrayList<Mesto> mesta = ClientController.getInstance().getAllMesto();

            cmbMesto.removeAllItems();

            for (Mesto mesto : mesta) {
                cmbMesto.addItem(mesto);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNoviKlijent.class.getName()).log(Level.SEVERE, null, ex);
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
        lblIme.setText(messages.getString("lbl_name"));
        lblPrezime.setText(messages.getString("lbl_surname"));
        lblEmail.setText(messages.getString("lbl_email"));
        lblStatus.setText(messages.getString("lbl_status"));
        lblTelefon.setText(messages.getString("lbl_phone"));
        lblAdresa.setText(messages.getString("lbl_address"));
        lblMesto.setText(messages.getString("lbl_place"));
        btnZatvori.setText(messages.getString("btn_close"));
        btnDodaj.setText(messages.getString("btn_addClient"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_newClient"));
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnDodaj, btnZatvori};

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
