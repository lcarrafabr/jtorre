/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcadastropendentes;

import Classes.*;
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
public class jFCredenciados extends javax.swing.JDialog {

    /**
     * Creates new form jFCredenciados
     */
    public jFCredenciados() {
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
        buscarjButton = new javax.swing.JButton();
        novojButton = new javax.swing.JButton();
        editarjButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        salvarjButton = new javax.swing.JButton();
        alterarjButton = new javax.swing.JButton();
        excluirjButton = new javax.swing.JButton();
        cancelarjButton = new javax.swing.JButton();
        limparjButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        sairjButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeCredenciadojTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        credenciadojTextField = new javax.swing.JTextField();
        statusjComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        buscarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buscar.png"))); // NOI18N
        buscarjButton.setText("Buscar");
        buscarjButton.setFocusable(false);
        buscarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(buscarjButton);

        novojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new2.png"))); // NOI18N
        novojButton.setText("Novo");
        novojButton.setFocusable(false);
        novojButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novojButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        novojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novojButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(novojButton);

        editarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        editarjButton.setText("Editar");
        editarjButton.setFocusable(false);
        editarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editarjButton);
        jToolBar1.add(jSeparator4);

        salvarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/save.png"))); // NOI18N
        salvarjButton.setText("Salvar");
        salvarjButton.setFocusable(false);
        salvarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salvarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(salvarjButton);

        alterarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/save2.png"))); // NOI18N
        alterarjButton.setText("Alterar");
        alterarjButton.setFocusable(false);
        alterarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alterarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alterarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(alterarjButton);

        excluirjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N
        excluirjButton.setText("Excluir");
        excluirjButton.setFocusable(false);
        excluirjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(excluirjButton);

        cancelarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Cancel.png"))); // NOI18N
        cancelarjButton.setText("Cancelar");
        cancelarjButton.setFocusable(false);
        cancelarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelarjButton);

        limparjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clear.png"))); // NOI18N
        limparjButton.setText("Limpar");
        limparjButton.setFocusable(false);
        limparjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limparjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limparjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(limparjButton);
        jToolBar1.add(jSeparator1);

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

        gradeCredenciadojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id#", "Credenciado", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeCredenciadojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeCredenciadojTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeCredenciadojTable);
        gradeCredenciadojTable.getColumnModel().getColumn(0).setResizable(false);
        gradeCredenciadojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeCredenciadojTable.getColumnModel().getColumn(1).setResizable(false);
        gradeCredenciadojTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        gradeCredenciadojTable.getColumnModel().getColumn(2).setResizable(false);
        gradeCredenciadojTable.getColumnModel().getColumn(2).setPreferredWidth(20);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Nome credenciada");

        credenciadojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                credenciadojTextFieldKeyReleased(evt);
            }
        });

        statusjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));
        statusjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusjComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(credenciadojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(credenciadojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro de credenciados", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conecta = new ClassConecta();
    
    int recebe_codigo_regional = 0;
    String status = null;
    
    int codigo_click_credenciado;
    
    
    
    public void getGradeCredenciados() throws ParseException{
       //Consultar Pessoas
        CredenciadosAderenciaAosProcediementos oCredAosProcediementos = new CredenciadosAderenciaAosProcediementos();
        
        if ( credenciadojTextField.getText().length() > 0 ){
            oCredAosProcediementos.setCredenciado(credenciadojTextField.getText() +"%");
        }

        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Id#", "Credenciado", "Status"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeCredenciadojTable.setModel(modeloTabela);
        gradeCredenciadojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeCredenciadojTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        gradeCredenciadojTable.getColumnModel().getColumn(2).setPreferredWidth(20);

try {
            oCredAosProcediementos.setStatus(status);
            oCredAosProcediementos.setCodigo_regional(recebe_codigo_regional);
            resultSet = oCredAosProcediementos.getConsultar(conecta);
            if (resultSet.getRow() == 1){
             resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("CODIGO_CREDENCIADO")),
                    resultSet.getString("CREDENCIADO"),
                    resultSet.getString("STATUS")
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(Telefones.class.getName()).log(Level.SEVERE, null, ex);
        }

           }
    
    
    
    public void getFieldCredenciado(int codigo_click_credenciado) throws ParseException{
        //Buscar contato
        CredenciadosAderenciaAosProcediementos oCredaAosProcediementos = new CredenciadosAderenciaAosProcediementos();
        ResultSet rs;
        oCredaAosProcediementos.setCodigo_credenciado(codigo_click_credenciado);
        oCredaAosProcediementos.setCodigo_regional(recebe_codigo_regional);
        try {
            rs = oCredaAosProcediementos.getConsultar(conecta);
            rs.next();

            //Pegar campos            
            credenciadojTextField.setText(rs.getString("CREDENCIADO"));
            statusjComboBox.setSelectedItem(rs.getString("STATUS"));
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher os campos\n"+ex, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        novojButton.setVisible(true);
        editarjButton.setVisible(false);
        salvarjButton.setVisible(false);
        alterarjButton.setVisible(false);
        excluirjButton.setVisible(false);
        cancelarjButton.setVisible(false);
        try {
            ClassConecta.conectaAderenciaAosprocedimentos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        buscarjButtonActionPerformed(null);
        
        System.out.println(recebe_codigo_regional);
    }//GEN-LAST:event_formWindowOpened

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void novojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novojButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setVisible(false);
        editarjButton.setVisible(false);
        buscarjButton.setVisible(true);
        salvarjButton.setVisible(true);
        excluirjButton.setVisible(false);
        cancelarjButton.setVisible(true);
        credenciadojTextField.grabFocus();
        
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (Exception e) {
        }
        limparjButtonActionPerformed(evt);
    }//GEN-LAST:event_novojButtonActionPerformed

    private void salvarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButtonActionPerformed
        // TODO add your handling code here:
        CredenciadosAderenciaAosProcediementos oCredAosProcediementos = new CredenciadosAderenciaAosProcediementos();
        
        if(credenciadojTextField.getText().isEmpty()){
            
         JOptionPane.showMessageDialog(null, "O campo \"Credenciado\" é obrigatório", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
        }else if(statusjComboBox.getSelectedItem().equals("SELECIONE")){
         JOptionPane.showMessageDialog(null, "Escolha um status", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE); 
        }else{
            
            try {
                
                salvarjButton.setVisible(false);
                novojButton.setVisible(true);
                editarjButton.setVisible(true);
                excluirjButton.setVisible(false);
                cancelarjButton.setVisible(false);
                
                oCredAosProcediementos.setCodigo_regional(recebe_codigo_regional);
                
                oCredAosProcediementos.setCredenciado(credenciadojTextField.getText().trim().toUpperCase());
                oCredAosProcediementos.setStatus(statusjComboBox.getSelectedItem().toString());
                oCredAosProcediementos.setCadastrar();             
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }
            try {
            getGradeCredenciados();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao atualizar a grade\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
            
        }
        
    }//GEN-LAST:event_salvarjButtonActionPerformed

    private void buscarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjButtonActionPerformed
        // TODO add your handling code here:
        try {
            getGradeCredenciados();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao atualizar a grade\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarjButtonActionPerformed

    private void statusjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusjComboBoxActionPerformed
        // TODO add your handling code here:
        status = statusjComboBox.getSelectedItem().toString();
        
        if(status.equals("SELECIONE")){
            status = "ATIVO";
        }
        try {
            getGradeCredenciados();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao atualizar a grade\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_statusjComboBoxActionPerformed

    private void alterarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarjButtonActionPerformed
        // TODO add your handling code here:
        CredenciadosAderenciaAosProcediementos oCredaAosProcediementos = new CredenciadosAderenciaAosProcediementos();
        
        if(credenciadojTextField.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "O campo \"Credenciado\" é obrigatório", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
            
        }else if(statusjComboBox.getSelectedItem().equals("SELECIONE")){
        JOptionPane.showMessageDialog(null, "Escolha um status", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);     
            
        }else{
            
            try {
                
                alterarjButton.setVisible(false);
                editarjButton.setVisible(true);
                novojButton.setVisible(true);
                excluirjButton.setVisible(false);
                cancelarjButton.setVisible(false);
                
                oCredaAosProcediementos.setCodigo_credenciado(codigo_click_credenciado);
                oCredaAosProcediementos.setCodigo_regional(recebe_codigo_regional);
                
                oCredaAosProcediementos.setCredenciado(credenciadojTextField.getText().trim().toUpperCase());
                oCredaAosProcediementos.setStatus(statusjComboBox.getSelectedItem().toString());
                oCredaAosProcediementos.setAlterar(conecta);              
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao alterar registro\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);   
            }
            try {
            getGradeCredenciados();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao atualizar a grade\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }   
        }
        
    }//GEN-LAST:event_alterarjButtonActionPerformed

    private void gradeCredenciadojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeCredenciadojTableMouseClicked
        // TODO add your handling code here:
        editarjButton.setVisible(true);
        
        codigo_click_credenciado = Integer.parseInt(gradeCredenciadojTable.getValueAt(gradeCredenciadojTable.getSelectedRow(), 0).toString());
        try {
            getFieldCredenciado(codigo_click_credenciado);
        } catch (ParseException ex) {
            Logger.getLogger(Telefones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gradeCredenciadojTableMouseClicked

    private void editarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setVisible(false);
        salvarjButton.setVisible(false);
        editarjButton.setVisible(false);
        alterarjButton.setVisible(true);
        excluirjButton.setVisible(true);
        cancelarjButton.setVisible(true);
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarjButtonActionPerformed

    private void credenciadojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_credenciadojTextFieldKeyReleased
        // TODO add your handling code here:
        if (!alterarjButton.isVisible()){
            try {
                CredenciadosAderenciaAosProcediementos oCredaAosProcediementos = new CredenciadosAderenciaAosProcediementos();
                oCredaAosProcediementos.setCredenciado(credenciadojTextField.getText());
                ResultSet rs = null;
                rs = oCredaAosProcediementos.getConsultar(conecta);
                getGradeCredenciados();
            } catch (    ParseException | SQLException ex) {
                Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }//GEN-LAST:event_credenciadojTextFieldKeyReleased

    private void limparjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparjButtonActionPerformed
        // TODO add your handling code here:
        credenciadojTextField.setText("");
        statusjComboBox.setSelectedItem("ATIVO");
    }//GEN-LAST:event_limparjButtonActionPerformed

    private void excluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjButtonActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Sim", "Não"};
        int sd =
                JOptionPane.showOptionDialog(
                null,
                "Deseja realmente EXCLUIR esse registro?",
                "Confirmação!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (sd != 0) {
            return;
        }
        CredenciadosAderenciaAosProcediementos oCredaAosProcediementos = new CredenciadosAderenciaAosProcediementos();
        
        try {
            oCredaAosProcediementos.setCodigo_credenciado(codigo_click_credenciado);
            oCredaAosProcediementos.setExcluir(conecta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        try {
            getGradeCredenciados();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao atualizar a grade\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        cancelarjButtonActionPerformed(evt);
        limparjButtonActionPerformed(evt);
    }//GEN-LAST:event_excluirjButtonActionPerformed

    private void cancelarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarjButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setVisible(true);
        editarjButton.setVisible(false);
        salvarjButton.setVisible(false);
        alterarjButton.setVisible(false);
        excluirjButton.setVisible(false);
        cancelarjButton.setVisible(false);
    }//GEN-LAST:event_cancelarjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(jFCredenciados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFCredenciados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFCredenciados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFCredenciados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jFCredenciados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarjButton;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JButton cancelarjButton;
    private javax.swing.JTextField credenciadojTextField;
    private javax.swing.JButton editarjButton;
    private javax.swing.JButton excluirjButton;
    private javax.swing.JTable gradeCredenciadojTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton limparjButton;
    private javax.swing.JButton novojButton;
    private javax.swing.JButton sairjButton;
    private javax.swing.JButton salvarjButton;
    private javax.swing.JComboBox statusjComboBox;
    // End of variables declaration//GEN-END:variables
}
