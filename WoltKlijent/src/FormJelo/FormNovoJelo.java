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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.Jelo;
import model.Klijent;
import model.Mesto;
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
public class FormNovoJelo extends javax.swing.JDialog {

    private ResourceBundle messages;
    private JMenu languageMenu;

    /**
     * Creates new form FormNovoJelo
     */
    public FormNovoJelo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        errorCena.setText("");
        errorNaziv.setText("");
        errorOpis.setText("");
        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        setRobotoFont();
        createLanguageMenu();
        setTitle("Unos jela");
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
        if (txtOpis.getText() == null || txtOpis.getText().isEmpty() || txtOpis.getText().length() <= 2 || txtOpis.getText().length() >= 200) {
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

        lblNaziv = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        lblCena = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtOpis = new javax.swing.JTextField();
        txtCena = new javax.swing.JTextField();
        btnZatvori = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        errorNaziv = new javax.swing.JLabel();
        errorOpis = new javax.swing.JLabel();
        errorCena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaziv.setText("Naziv");

        lblOpis.setText("Opis");

        lblCena.setText("Cena");

        btnZatvori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnZatvori.setText("Zatvori");
        btnZatvori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setText("Dodaj jelo");
        btnDodaj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
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
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(lblOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOpis, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(txtNaziv)
                            .addComponent(txtCena, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorOpis, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(errorCena, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNaziv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorNaziv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOpis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorOpis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorCena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnZatvori))
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
            if (txtCena.getText().isEmpty() || txtNaziv.getText().isEmpty()
                    || txtOpis.getText().isEmpty() || txtOpis.getBackground().equals(Color.PINK)
                    || txtCena.getBackground().equals(Color.PINK) || txtNaziv.getBackground().equals(Color.PINK)) {
                JOptionPane.showMessageDialog(this, messages.getString("error_empty_loginField"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            String naziv = txtNaziv.getText();
            String opis = txtOpis.getText();
            String c = txtCena.getText();
            if (!c.matches("^[0-9]+(\\.[0-9]+)?$")) {
                JOptionPane.showMessageDialog(this, messages.getString("number"), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
                return;
            }
            double cena = Double.parseDouble(c);
            Jelo jelo = new Jelo(null, naziv, opis, cena);
            ClientController.getInstance().addJelo(jelo);
            JOptionPane.showMessageDialog(this, messages.getString("success_add_dish"), messages.getString("success_title"), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), messages.getString("error_title"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

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

    private void setLanguage(String language, String country) {
        Locale locale = new Locale(language, country);
        messages = ResourceBundle.getBundle("resources.messages", locale);
        lblNaziv.setText(messages.getString("lbl_dishName"));
        lblOpis.setText(messages.getString("lbl_desc"));
        lblCena.setText(messages.getString("lbl_dishPrice"));
        btnDodaj.setText(messages.getString("btn_addDish"));
        btnZatvori.setText(messages.getString("btn_close"));
        languageMenu.setText(messages.getString("jmenu"));
        setTitle(messages.getString("title_newDish"));
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
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
