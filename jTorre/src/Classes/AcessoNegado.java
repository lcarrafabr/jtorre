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
public class AcessoNegado {
    
    private Integer codigo_acesso_negado;
    private String login;
    private String data_acesso;
    private String hora_acesso;
    private String status;
    private String observacao;

    public Integer getCodigo_acesso_negado() {
        return codigo_acesso_negado;
    }

    public void setCodigo_acesso_negado(Integer codigo_acesso_negado) {
        this.codigo_acesso_negado = codigo_acesso_negado;
    }

    public String getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(String data_acesso) {
        this.data_acesso = data_acesso;
    }

    public String getHora_acesso() {
        return hora_acesso;
    }

    public void setHora_acesso(String hora_acesso) {
        this.hora_acesso = hora_acesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
    
    
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO TABELA_ACESSO_NEGADO  "+
" 	(LOGIN,          "+
" 	DATA_ACESSO,     "+
" 	HORA_ACESSO,     "+
" 	STATUS,          "+
" 	OBSERVACAO       "+
" 	) "+
" 	VALUES "+
" 	(?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        
//        String oDataCadastro = null;
//        if (getData_abertura() != null){
//          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
//          oDataCadastro = oDatOut.format(getData_abertura());
//        }

        stmt.setString(1, getLogin());
        stmt.setString(2, getData_acesso());
        stmt.setString(3, getHora_acesso());
        stmt.setString(4, getStatus());
        stmt.setString(5, getObservacao());

        stmt.execute();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
//        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

   

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException | HeadlessException e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
}
    
    public ResultSet getConsultar(ClassConecta conecta) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT * " +
                    "FROM TABELA_ACESSO_NEGADO "+
                    "WHERE CODIGO_ACESSO_NEGADO = CODIGO_ACESSO_NEGADO ";
//                    "AND STATUS = 'PENDENTE' ";
                    

            int quantParam = 0;


           if (getCodigo_acesso_negado() != null){
               comando = comando + " AND CODIGO_ACESSO_NEGADO = ? ";
            }
            if (getStatus() != null){
               comando = comando + " AND STATUS = ? ";
            }

           

            comando = comando + " order by CODIGO_ACESSO_NEGADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_acesso_negado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_acesso_negado());
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
    
//    public ResultSet getContaAcessosPendentes(ClassConecta conecta) throws SQLException
//    {
//        ResultSet resultSet = null;
//
//        try
//        {
//            String comando;
//            comando = "select COUNT(STATUS) as total "+
//                    "from TABELA_ACESSO_NEGADO "+
//                    " where STATUS = 'PENDENTE' ";
//           
//            comando = comando + " GROUP BY STATUS ";
//            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
//            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
//            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
//            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
//            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);
//
//        resultSet = stmtQuery.executeQuery();
//
//        }
//        catch (SQLException sqlex)
//        {
//             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);
//
//        }
//
//     return resultSet;
//     }
//    
    
    
    
    public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE TABELA_ACESSO_NEGADO "+
" 	SET "+
" 	LOGIN = ?,           "+
" 	DATA_ACESSO = ? ,    "+
" 	HORA_ACESSO = ? ,    "+
" 	STATUS = ? ,         "+
" 	OBSERVACAO = ?       "+
" 	WHERE "+
" 	CODIGO_ACESSO_NEGADO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getLogin());
        stmt.setString(2,getData_acesso());
        stmt.setString(3,getHora_acesso());
        stmt.setString(4,getStatus());
        stmt.setString(5, getObservacao());
        stmt.setInt(6, getCodigo_acesso_negado());

        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }


    }
    
    
    
    
    
}// fim da classe
