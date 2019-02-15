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
public class CredenciadosAderenciaAosProcediementos {
    
    
    private Integer codigo_credenciado;
    private Integer codigo_regional;
    private String credenciado;
    private String status;

    public Integer getCodigo_credenciado() {
        return codigo_credenciado;
    }

    public void setCodigo_credenciado(Integer codigo_credenciado) {
        this.codigo_credenciado = codigo_credenciado;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getCredenciado() {
        return credenciado;
    }

    public void setCredenciado(String credenciado) {
        this.credenciado = credenciado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO CREDENCIADOS  "+
" 	(CODIGO_REGIONAL,     "+
" 	CREDENCIADO,          "+
" 	STATUS                "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");
        
        System.out.println("1");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        System.out.println("2");
        stmt.setInt(1, getCodigo_regional());
        System.out.println("3");
        stmt.setString(2, getCredenciado());
        System.out.println("4");
        stmt.setString(3, getStatus());
        System.out.println("5");

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
            comando = "select C.*, R.* " +
                    "from CREDENCIADOS C, REGIONAIS R "+
                    "where  C.CODIGO_CREDENCIADO = C.CODIGO_CREDENCIADO "+
                    "AND R.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND C.CODIGO_REGIONAL = R.CODIGO_REGIONAL ";
//                    "AND C.STATUS = 'ATIVO' ";
                    

            int quantParam = 0;


           if (getCodigo_regional() != null){
               comando = comando + " AND C.CODIGO_REGIONAL = ? ";
            }
           if (getStatus() != null) {
                comando = comando + "AND C.STATUS LIKE ?";
            }
           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
           if (getCredenciado() != null) {
                comando = comando + "AND C.CREDENCIADO LIKE ?";
            }

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getStatus() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getStatus()+"%");
            }
           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
           if (getCredenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getCredenciado()+"%");
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    public ResultSet getConsultarCredenciadoAtivo(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {           
            String comando;
            comando = "select C.*, R.* " +
                    "from CREDENCIADOS C, REGIONAIS R "+
                    "where  C.CODIGO_CREDENCIADO = C.CODIGO_CREDENCIADO "+
                    "AND R.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND C.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND C.STATUS = 'ATIVO' ";
                    

            int quantParam = 0;


           if (getCodigo_regional() != null){
               comando = comando + " AND C.CODIGO_REGIONAL = ? ";
            }
           if (getStatus() != null) {
                comando = comando + "AND C.STATUS LIKE ?";
            }
           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
           if (getCredenciado() != null) {
                comando = comando + "AND C.CREDENCIADO LIKE ?";
            }

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getStatus() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getStatus()+"%");
            }
           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
           if (getCredenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getCredenciado()+"%");
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

        String comando = "UPDATE CREDENCIADOS "+
" 	SET "+
" 	CODIGO_REGIONAL = ?,        "+
" 	CREDENCIADO = ? ,           "+
" 	STATUS = ?                  "+
" 	WHERE "+
" 	CODIGO_CREDENCIADO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_regional());
        stmt.setString(2,getCredenciado());
        stmt.setString(3,getStatus());
        stmt.setInt(4, getCodigo_credenciado());

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

" DELETE FROM CREDENCIADOS  "+
" 	WHERE "+
" 	CODIGO_CREDENCIADO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_credenciado());


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
