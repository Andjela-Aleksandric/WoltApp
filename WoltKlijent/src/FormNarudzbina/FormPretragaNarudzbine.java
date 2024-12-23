/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormNarudzbina;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main_forms.LoginForm;
import model.Narudzbina;
import tableModels.TableModelNarudzbine;
import tableModels.TableModelStavkeNarudzbine;

/**
 *
 * @author Anđela
 */
public class FormPretragaNarudzbine extends javax.swing.JDialog {

    private ResourceBundle messages;
    private JMenu languageMenu;

    public FormPretragaNarudzbine(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pretraga narudžbine");
        Locale.setDefault(new Locale("sr", "LATN"));
        messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
        createLanguageMenu();
        setRobotoFont();
        TableModelNarudzbine model = new TableModelNarudzbine();
        Thread thread = new Thread(model);
        thread.start();
        tblNarudzbine.setModel(model);
        customizeButtons();

        txtPretraga.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }

            private void performSearch() {
                String param = txtPretraga.getText();
                TableModelNarudzbine tm = (TableModelNarudzbine) tblNarudzbine.getModel();
                tm.setParametar(param);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImePrezimeKl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNarudzbine = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblImePrezimeKl.setText("Pretraga (ime i prezime klijenta):");

        tblNarudzbine.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNarudzbine);

        btnDetalji.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDetalji.setText("Detalji narudžbine");
        btnDetalji.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblImePrezimeKl, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(637, 637, 637))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImePrezimeKl))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalji)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed

        int row = tblNarudzbine.getSelectedRow();

        if (row >= 0) {
            Narudzbina n = ((TableModelNarudzbine) tblNarudzbine.getModel()).getSelectedNarudzbina(row);
            new FormDetaljiNarudzbine(this, true, n).setVisible(true);
        }

    }//GEN-LAST:event_btnDetaljiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImePrezimeKl;
    private javax.swing.JTable tblNarudzbine;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    void refreshTable() {
        TableModelNarudzbine tm = (TableModelNarudzbine) tblNarudzbine.getModel();
        tm.refreshTable();
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
        lblImePrezimeKl.setText(messages.getString("client_nameSearch"));
        btnDetalji.setText(messages.getString("btn_orderDetails"));
        TableModelNarudzbine tmn2 = (TableModelNarudzbine) tblNarudzbine.getModel();
        tmn2.setLanguage(locale);
        languageMenu.setText(messages.getString("jmenu"));
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void customizeButtons() {
        Color hoverColor = new Color(0, 165, 200);
        JButton[] buttons = {btnDetalji};

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
