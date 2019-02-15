/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcadastropendentes;

import Classes.*;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lcbenfic
 */
public class jFAcessoNegado extends javax.swing.JDialog {

    /**
     * Creates new form jFAcessoNegado
     */
    public jFAcessoNegado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        atualizaGradejButton = new javax.swing.JButton();
        sairjButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeAcessoNegadojTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginjTextField = new javax.swing.JTextField();
        dataAcessojFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        horaAcessojFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacaojTextArea = new javax.swing.JTextArea();
        statusjComboBox = new javax.swing.JComboBox();
        contaregiostrosjButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tipoAcessojLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalregistrosjLabel = new javax.swing.JLabel();
        alterarDadosjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        atualizaGradejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        atualizaGradejButton.setText("Atualiza");
        atualizaGradejButton.setFocusable(false);
        atualizaGradejButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizaGradejButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        atualizaGradejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaGradejButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(atualizaGradejButton);

        sairjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit.png"))); // NOI18N
        sairjButton.setText("Sair");
        sairjButton.setFocusable(false);
        sairjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sairjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(sairjButton);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        gradeAcessoNegadojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id#", "Login", "Data do acesso", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeAcessoNegadojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeAcessoNegadojTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeAcessoNegadojTable);
        gradeAcessoNegadojTable.getColumnModel().getColumn(0).setResizable(false);
        gradeAcessoNegadojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeAcessoNegadojTable.getColumnModel().getColumn(1).setResizable(false);
        gradeAcessoNegadojTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        gradeAcessoNegadojTable.getColumnModel().getColumn(2).setResizable(false);
        gradeAcessoNegadojTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        gradeAcessoNegadojTable.getColumnModel().getColumn(3).setResizable(false);
        gradeAcessoNegadojTable.getColumnModel().getColumn(3).setPreferredWidth(80);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Login");

        loginjTextField.setEditable(false);
        loginjTextField.setFocusable(false);

        dataAcessojFormattedTextField.setEditable(false);
        try {
            dataAcessojFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataAcessojFormattedTextField.setFocusable(false);

        jLabel2.setText("data do acesso");

        horaAcessojFormattedTextField.setEditable(false);
        try {
            horaAcessojFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        horaAcessojFormattedTextField.setFocusable(false);

        jLabel3.setText("Horario acesso");

        jLabel4.setText("Status");

        jLabel5.setText("Observação");

        observacaojTextArea.setColumns(20);
        observacaojTextArea.setRows(5);
        jScrollPane2.setViewportView(observacaojTextArea);

        statusjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDENTE", "RESOLVIDO", "EM ANDAMENTO" }));
        statusjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusjComboBoxActionPerformed(evt);
            }
        });

        contaregiostrosjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        contaregiostrosjButton.setContentAreaFilled(false);
        contaregiostrosjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contaregiostrosjButton.setFocusable(false);
        contaregiostrosjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        contaregiostrosjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        contaregiostrosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contaregiostrosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginjTextField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataAcessojFormattedTextField)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horaAcessojFormattedTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contaregiostrosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataAcessojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaAcessojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(contaregiostrosjButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tratativa", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Total de acessos:");

        jLabel7.setText(":");

        alterarDadosjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/concluido.png"))); // NOI18N
        alterarDadosjButton.setText("Alterar Dados");
        alterarDadosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarDadosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoAcessojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalregistrosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alterarDadosjButton)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alterarDadosjButton)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tipoAcessojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(totalregistrosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conecta = new ClassConecta();
    
    int codigo_click_acesso_negado;
    
    
    
    public void getGradePendentes() throws ParseException{
       //Consultar PENDENTES
        AcessoNegado oAcessoNegado = new AcessoNegado();


        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Id#", "Login", "Data do acesso", "Horário"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeAcessoNegadojTable.setModel(modeloTabela);
        gradeAcessoNegadojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeAcessoNegadojTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        gradeAcessoNegadojTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        gradeAcessoNegadojTable.getColumnModel().getColumn(3).setPreferredWidth(80);

try {
            oAcessoNegado.setStatus(statusjComboBox.getSelectedItem().toString());
            resultSet = oAcessoNegado.getConsultar(conecta);
            if (resultSet.getRow() == 1){
             resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("CODIGO_ACESSO_NEGADO")),
                    resultSet.getString("LOGIN"),
                    resultSet.getString("DATA_ACESSO"),
                    resultSet.getString("HORA_ACESSO")
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
        }

           }
    
    
    public void getFieldAcessoNegado(int codigo_click_acesso_negado) throws ParseException{
        //Buscar contato
        AcessoNegado oAcessoNegado = new AcessoNegado();
        ResultSet rs = null;
        oAcessoNegado.setCodigo_acesso_negado(codigo_click_acesso_negado);

        try {
            rs = oAcessoNegado.getConsultar(conecta);
            rs.next();

            //Pegar campos
            loginjTextField.setText(rs.getString("LOGIN"));
            statusjComboBox.setSelectedItem(rs.getString("STATUS"));
            dataAcessojFormattedTextField.setText(rs.getString("DATA_ACESSO"));
            horaAcessojFormattedTextField.setText(rs.getString("HORA_ACESSO"));
            observacaojTextArea.setText(rs.getString("OBSERVACAO"));

            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher os campos\n"+ex, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        alterarDadosjButton.setEnabled(false);
        try {
            ClassConecta.conectajTorre();
        } catch (Exception e) {
        }
        atualizaGradejButtonActionPerformed(null);
        
        observacaojTextArea.setLineWrap(true);
        observacaojTextArea.setWrapStyleWord(true);
        
    }//GEN-LAST:event_formWindowOpened

    private void atualizaGradejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaGradejButtonActionPerformed
        // TODO add your handling code here:
        try {
            getGradePendentes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar grade\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        contaregiostrosjButtonActionPerformed(null);
    }//GEN-LAST:event_atualizaGradejButtonActionPerformed

    private void contaregiostrosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contaregiostrosjButtonActionPerformed
        // TODO add your handling code here:
        int somaLinhas = gradeAcessoNegadojTable.getModel().getRowCount();     
        totalregistrosjLabel.setText(Integer.toString(somaLinhas));
        
        String status = statusjComboBox.getSelectedItem().toString();
        
        if(somaLinhas >= 1 && status.equals("PENDENTE")){
            totalregistrosjLabel.setForeground(Color.red);
            tipoAcessojLabel.setForeground(Color.red);
            tipoAcessojLabel.setText(statusjComboBox.getSelectedItem().toString());
        }else if(somaLinhas >= 1 && status.equals("RESOLVIDO")){
          totalregistrosjLabel.setForeground(Color.BLUE);
          tipoAcessojLabel.setForeground(Color.BLUE);
          tipoAcessojLabel.setText(statusjComboBox.getSelectedItem().toString());
        }else if (somaLinhas == 0){
            
            totalregistrosjLabel.setForeground(Color.black);
            tipoAcessojLabel.setText("");
            totalregistrosjLabel.setText("0");            
        }else{
            totalregistrosjLabel.setForeground(Color.black);
            tipoAcessojLabel.setForeground(Color.BLACK);
            tipoAcessojLabel.setText(statusjComboBox.getSelectedItem().toString());
            
        }
    }//GEN-LAST:event_contaregiostrosjButtonActionPerformed

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void statusjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusjComboBoxActionPerformed
        // TODO add your handling code here:
        
        try {
            getGradePendentes();
        } catch (Exception e) {
        }
        contaregiostrosjButtonActionPerformed(null);
    }//GEN-LAST:event_statusjComboBoxActionPerformed

    private void gradeAcessoNegadojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeAcessoNegadojTableMouseClicked
        // TODO add your handling code here:
        codigo_click_acesso_negado = Integer.parseInt(gradeAcessoNegadojTable.getValueAt(gradeAcessoNegadojTable.getSelectedRow(), 0).toString());       
        try {
            getFieldAcessoNegado(codigo_click_acesso_negado);
        } catch (ParseException ex) {
            Logger.getLogger(PESSOAS.class.getName()).log(Level.SEVERE, null, ex);
        }
        alterarDadosjButton.setEnabled(true);
    }//GEN-LAST:event_gradeAcessoNegadojTableMouseClicked

    private void alterarDadosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarDadosjButtonActionPerformed
        // TODO add your handling code here:
        AcessoNegado oAcessoNegado = new AcessoNegado();
        
        if(observacaojTextArea.getText().equals("")){
            
            JOptionPane.showMessageDialog(null, "O campo \"OBSERVAÇÃO\" é obrigatório", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
        }else{
            
            oAcessoNegado.setCodigo_acesso_negado(codigo_click_acesso_negado);
            
            oAcessoNegado.setLogin(loginjTextField.getText());
            oAcessoNegado.setData_acesso(dataAcessojFormattedTextField.getText().toString());
            oAcessoNegado.setHora_acesso(horaAcessojFormattedTextField.getText().toString());
            oAcessoNegado.setStatus(statusjComboBox.getSelectedItem().toString());
            oAcessoNegado.setObservacao(observacaojTextArea.getText());
            oAcessoNegado.setAlterar(conecta);
            
            contaregiostrosjButtonActionPerformed(null);
        alterarDadosjButton.setEnabled(false);
            
        }
        try {
            getGradePendentes();
        } catch (Exception e) {
        }
        contaregiostrosjButtonActionPerformed(null);
    }//GEN-LAST:event_alterarDadosjButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFAcessoNegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFAcessoNegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFAcessoNegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFAcessoNegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new jFAcessoNegado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarDadosjButton;
    private javax.swing.JButton atualizaGradejButton;
    private javax.swing.JButton contaregiostrosjButton;
    private javax.swing.JFormattedTextField dataAcessojFormattedTextField;
    private javax.swing.JTable gradeAcessoNegadojTable;
    private javax.swing.JFormattedTextField horaAcessojFormattedTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField loginjTextField;
    private javax.swing.JTextArea observacaojTextArea;
    private javax.swing.JButton sairjButton;
    private javax.swing.JComboBox statusjComboBox;
    private javax.swing.JLabel tipoAcessojLabel;
    private javax.swing.JLabel totalregistrosjLabel;
    // End of variables declaration//GEN-END:variables
}
