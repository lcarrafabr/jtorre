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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lcbenfic
 */
public class jFTelefonesCampo extends javax.swing.JDialog {

    /**
     * Creates new form jFTelefonesCampo
     */
    public jFTelefonesCampo() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/resources/radio-tower-32.png")).getImage()); 
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
        jSeparator3 = new javax.swing.JToolBar.Separator();
        salvarjButton = new javax.swing.JButton();
        salvarMaisjButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        alterarjButton = new javax.swing.JButton();
        excluirjButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        limparjButton = new javax.swing.JButton();
        sairjButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeTelefonesCampojTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dddjTextField = new javax.swing.JTextField();
        numeroTelefonejTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacaojTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tipoTelefonejComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
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
        jToolBar1.add(jSeparator3);

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

        salvarMaisjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/save_plus.png"))); // NOI18N
        salvarMaisjButton.setText("Salvar+");
        salvarMaisjButton.setFocusable(false);
        salvarMaisjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarMaisjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(salvarMaisjButton);
        jToolBar1.add(jSeparator2);

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
        jToolBar1.add(jSeparator1);

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

        gradeTelefonesCampojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id#", "Numero Telefone", "Tipo Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeTelefonesCampojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeTelefonesCampojTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeTelefonesCampojTable);
        gradeTelefonesCampojTable.getColumnModel().getColumn(0).setResizable(false);
        gradeTelefonesCampojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeTelefonesCampojTable.getColumnModel().getColumn(1).setResizable(false);
        gradeTelefonesCampojTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        gradeTelefonesCampojTable.getColumnModel().getColumn(2).setResizable(false);
        gradeTelefonesCampojTable.getColumnModel().getColumn(2).setPreferredWidth(100);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("DDD");

        numeroTelefonejTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel2.setText("Numero telefone");

        observacaojTextArea.setColumns(20);
        observacaojTextArea.setRows(5);
        jScrollPane2.setViewportView(observacaojTextArea);

        jLabel3.setText("Observação");

        tipoTelefonejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "CELULAR", "FIXO" }));

        jLabel4.setText("Tipo Telefone");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dddjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numeroTelefonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tipoTelefonejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dddjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroTelefonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoTelefonejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro Telefone", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conecta = new ClassConecta();
    
    String recebe_usuario_logado;
    
    String recebe_nivel_usuario;
    
    int recebe_codigo_pessoa;
    
    int codigo_click_telefone_campo;
    
    
    public void getGradeTelefonesCampo() throws ParseException{
       //Consultar Pessoas
        TelefonesCampo oTelefonesCampo = new TelefonesCampo();

        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Id#", "Numero Telefone", "Tipo telefone"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeTelefonesCampojTable.setModel(modeloTabela);
        gradeTelefonesCampojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeTelefonesCampojTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        gradeTelefonesCampojTable.getColumnModel().getColumn(2).setPreferredWidth(100);

try {
            oTelefonesCampo.setCodigo_pessoa_campo(recebe_codigo_pessoa);
            resultSet = oTelefonesCampo.getConsultar(conecta);
            if (resultSet.getRow() == 1){
             resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("CODIGO_TELEFONE_CAMPO")),
                    "(" + resultSet.getString("DDD") + ")" + " - " +resultSet.getString("NUMERO_TELEFONE"),
                    resultSet.getString("TIPO_TELEFONE")
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(Telefones.class.getName()).log(Level.SEVERE, null, ex);
        }

           }
    
    public void getFieldTelefoneCampo(int codigo_click_telefone_campo) throws ParseException{
        //Buscar contato
        TelefonesCampo oTelefonesCampo = new TelefonesCampo();
        ResultSet rs = null;
        oTelefonesCampo.setCodigo_telefone_campo(codigo_click_telefone_campo);

        try {
            rs = oTelefonesCampo.getConsultar(conecta);
            rs.next();

            //Pegar campos
            dddjTextField.setText(rs.getString("DDD"));
            numeroTelefonejTextField.setText(rs.getString("NUMERO_TELEFONE"));
            tipoTelefonejComboBox.setSelectedItem(rs.getString("TIPO_TELEFONE"));
            observacaojTextArea.setText(rs.getString("OBSERVACAO"));
            
        } catch (SQLException ex) {
            Logger.getLogger(TelefonesCampo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao preencher os campos\n"+ex, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        novojButton.setEnabled(true);
        editarjButton.setEnabled(false);
        salvarjButton.setEnabled(false);
        salvarMaisjButton.setEnabled(false);
        alterarjButton.setEnabled(false);
        excluirjButton.setEnabled(false);
        
        if ("SUPERVISOR".equals(recebe_nivel_usuario)){
            excluirjButton.setVisible(true);
            
        }else{
            excluirjButton.setVisible(false);
        }
        
        
        try {
            ClassConecta.getConectaContatosTorreDB();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        observacaojTextArea.setWrapStyleWord(true);
        observacaojTextArea.setLineWrap(true);
        
        buscarjButtonActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened

    private void novojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novojButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setEnabled(false);
        editarjButton.setEnabled(false);
        buscarjButton.setEnabled(true);
        salvarjButton.setEnabled(true);
        salvarMaisjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        dddjTextField.grabFocus();
        
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (Exception e) {
        }
        limparjButtonActionPerformed(null);
    }//GEN-LAST:event_novojButtonActionPerformed

    private void limparjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparjButtonActionPerformed
        // TODO add your handling code here:
        dddjTextField.setText("");
        numeroTelefonejTextField.setText("");
        tipoTelefonejComboBox.setSelectedItem("SELECIONE");
        observacaojTextArea.setText("");
    }//GEN-LAST:event_limparjButtonActionPerformed

    private void salvarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButtonActionPerformed
        // TODO add your handling code here:
        TelefonesCampo oTelefonesCampo = new TelefonesCampo();
        
        if(dddjTextField.getText().equals("") || numeroTelefonejTextField.getText().equals("") ||
           tipoTelefonejComboBox.getSelectedItem().equals("SELECIONE")){
          
            JOptionPane.showMessageDialog(null, "Atenção! Todos os campos são obrigatórios!", "mensagem do sistema", JOptionPane.WARNING_MESSAGE);  
        
        }else{
            
            try {
                
                salvarjButton.setEnabled(false);
                novojButton.setEnabled(true);
                editarjButton.setEnabled(true);
                salvarMaisjButton.setEnabled(false);
                excluirjButton.setEnabled(false);
                
                oTelefonesCampo.setCodigo_pessoa_campo(recebe_codigo_pessoa);
                
                oTelefonesCampo.setDdd(Integer.parseInt(dddjTextField.getText().trim()));
                oTelefonesCampo.setNumero_telefone(numeroTelefonejTextField.getText().trim());
                oTelefonesCampo.setTipo_telefone(tipoTelefonejComboBox.getSelectedItem().toString());
                oTelefonesCampo.setObservacao(observacaojTextArea.getText());
                oTelefonesCampo.setCadastrar();                
            } catch (NumberFormatException e ) {
          JOptionPane.showMessageDialog(null, "Erro!\nDigite apenas números no campo \"DDD\".\n"+e, "ATENÇÃO, MENSAGEM DO SISTEMA", JOptionPane.ERROR_MESSAGE);      
            novojButton.setEnabled(false);
            editarjButton.setEnabled(false);
            buscarjButton.setEnabled(true);
            salvarjButton.setEnabled(true);
            salvarMaisjButton.setEnabled(true);
            excluirjButton.setEnabled(false);      
            }
            try {
                getGradeTelefonesCampo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar grade!\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_salvarjButtonActionPerformed

    private void buscarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjButtonActionPerformed
        // TODO add your handling code here:
        try {
            getGradeTelefonesCampo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar grade!\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_buscarjButtonActionPerformed

    private void gradeTelefonesCampojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeTelefonesCampojTableMouseClicked
        // TODO add your handling code here:
        editarjButton.setEnabled(true);
        
        codigo_click_telefone_campo = Integer.parseInt(gradeTelefonesCampojTable.getValueAt(gradeTelefonesCampojTable.getSelectedRow(), 0).toString());
        try {
            getFieldTelefoneCampo(codigo_click_telefone_campo);
        } catch (ParseException ex) {
            Logger.getLogger(TelefonesCampo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gradeTelefonesCampojTableMouseClicked

    private void alterarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarjButtonActionPerformed
        // TODO add your handling code here:
        TelefonesCampo oTelefonesCampo = new TelefonesCampo();
        
        if(dddjTextField.getText().equals("") || numeroTelefonejTextField.getText().equals("") ||
           tipoTelefonejComboBox.getSelectedItem().equals("SELECIONE")){
          
            JOptionPane.showMessageDialog(null, "Atenção! Todos os campos são obrigatórios!", "mensagem do sistema", JOptionPane.WARNING_MESSAGE);  
        
        }else{
            
            try {
                alterarjButton.setEnabled(false);
                editarjButton.setEnabled(true);
                novojButton.setEnabled(true);
                excluirjButton.setEnabled(false);
                
                oTelefonesCampo.setCodigo_pessoa_campo(recebe_codigo_pessoa);
                oTelefonesCampo.setCodigo_telefone_campo(codigo_click_telefone_campo);
                
                oTelefonesCampo.setDdd(Integer.parseInt(dddjTextField.getText().trim()));
                oTelefonesCampo.setNumero_telefone(numeroTelefonejTextField.getText().trim());
                oTelefonesCampo.setTipo_telefone(tipoTelefonejComboBox.getSelectedItem().toString());
                oTelefonesCampo.setObservacao(observacaojTextArea.getText());
                oTelefonesCampo.setAlterar(conecta);                
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro!\nDigite apenas números no campo \"DDD\".\n"+e, "ATENÇÃO, MENSAGEM DO SISTEMA", JOptionPane.ERROR_MESSAGE);      
            novojButton.setEnabled(false);
            salvarjButton.setEnabled(false);
            editarjButton.setEnabled(false);
            alterarjButton.setEnabled(true);
            salvarMaisjButton.setEnabled(false);
            excluirjButton.setEnabled(true);
            }
            try {
                getGradeTelefonesCampo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar grade!\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
    }//GEN-LAST:event_alterarjButtonActionPerformed

    private void editarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setEnabled(false);
        salvarjButton.setEnabled(false);
        editarjButton.setEnabled(false);
        alterarjButton.setEnabled(true);
        salvarMaisjButton.setEnabled(false);
        excluirjButton.setEnabled(true);
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPendentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarjButtonActionPerformed

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
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);
        
        TelefonesCampo oTelefonesCampo = new TelefonesCampo();
        
        oTelefonesCampo.setCodigo_telefone_campo(codigo_click_telefone_campo);
        oTelefonesCampo.setExcluir(conecta);
        
        try {
            getGradeTelefonesCampo();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar grade!\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        limparjButtonActionPerformed(null);
    }//GEN-LAST:event_excluirjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(jFTelefonesCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFTelefonesCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFTelefonesCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFTelefonesCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jFTelefonesCampo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarjButton;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JTextField dddjTextField;
    private javax.swing.JButton editarjButton;
    private javax.swing.JButton excluirjButton;
    private javax.swing.JTable gradeTelefonesCampojTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton limparjButton;
    private javax.swing.JButton novojButton;
    private javax.swing.JTextField numeroTelefonejTextField;
    private javax.swing.JTextArea observacaojTextArea;
    private javax.swing.JButton sairjButton;
    private javax.swing.JButton salvarMaisjButton;
    private javax.swing.JButton salvarjButton;
    private javax.swing.JComboBox tipoTelefonejComboBox;
    // End of variables declaration//GEN-END:variables
}
