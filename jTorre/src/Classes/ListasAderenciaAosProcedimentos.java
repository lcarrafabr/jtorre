/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lcbenfic
 */
public class ListasAderenciaAosProcedimentos {
    
    private Integer codigo_lista_semanal;
    private Integer codigo_regional;
    private String data_inicial;
    private String data_final;
    private String status;

    public Integer getCodigo_lista_semanal() {
        return codigo_lista_semanal;
    }

    public void setCodigo_lista_semanal(Integer codigo_lista_semanal) {
        this.codigo_lista_semanal = codigo_lista_semanal;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO LISTAS_SEMANAIS  "+
" 	(CODIGO_REGIONAL,      "+
" 	DATA_INICIAL,          "+
" 	DATA_FINAL,            "+
" 	STATUS                 "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");
        

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_regional());
        stmt.setString(2, getData_inicial());
        stmt.setString(3, getData_final());
        stmt.setString(4, getStatus());

        stmt.execute();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
}
    
    
    public ResultSet getConsultar(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {           
            String comando;
            comando = "select L.*, R.* " +
                    "from LISTAS_SEMANAIS L, REGIONAIS R "+
                    "where  L.CODIGO_LISTA_SEMANAL = L.CODIGO_LISTA_SEMANAL "+
                    "AND R.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND L.CODIGO_REGIONAL = R.CODIGO_REGIONAL ";
//                    "AND L.STATUS = 'ABERTA' ";
                    

            int quantParam = 0;


            if (getCodigo_lista_semanal() != null){
               comando = comando + " AND L.CODIGO_LISTA_SEMANAL = ? ";
            }
            if (getCodigo_regional() != 0) {
                comando = comando + "AND L.CODIGO_REGIONAL = ?";
            }
           if (getStatus() != null) {
                comando = comando + "AND L.STATUS = ?";
            }

            comando = comando + " order by L.CODIGO_LISTA_SEMANAL ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_lista_semanal() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_semanal());
            }
           if (getCodigo_regional() != 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
          if (getStatus() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getStatus());
            } 

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    public ResultSet getConsultarListaFechada(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {           
            String comando;
            comando = "select L.*, R.* " +
                    "from LISTAS_SEMANAIS L, REGIONAIS R "+
                    "where  L.CODIGO_LISTA_SEMANAL = L.CODIGO_LISTA_SEMANAL "+
                    "AND R.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND L.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND L.STATUS = 'FECHADO' ";
                    

            int quantParam = 0;


           if (getCodigo_lista_semanal() != null){
               comando = comando + " AND L.CODIGO_LISTA_SEMANAL = ? ";
            }
           if (getCodigo_regional() != 0) {
                comando = comando + "AND L.CODIGO_REGIONAL = ?";
            }
           
            comando = comando + " order by L.CODIGO_LISTA_SEMANAL ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_lista_semanal() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_semanal());
            }
            if (getCodigo_regional() != 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE LISTAS_SEMANAIS "+
" 	SET "+
" 	CODIGO_REGIONAL = ?,        "+
" 	DATA_INICIAL = ? ,          "+
" 	DATA_FINAL = ? ,            "+
" 	STATUS = ?                  "+
" 	WHERE "+
" 	CODIGO_LISTA_SEMANAL = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_regional());
        stmt.setString(2,getData_inicial());
        stmt.setString(3,getData_final());
        stmt.setString(4,getStatus());
        stmt.setInt(5, getCodigo_lista_semanal());

        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    public void setExcluir(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM LISTAS_SEMANAIS  "+
" 	WHERE "+
" 	CODIGO_LISTA_SEMANAL = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_lista_semanal());


        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}
    
    
    
    
}//fim da classe
