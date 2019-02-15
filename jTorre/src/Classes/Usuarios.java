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
public class Usuarios {
    
    private Integer codigo_pessoa_usuario;
    private String login;
    private String nivel_usuario;
    private String observacao;

    public Integer getCodigo_pessoa_usuario() {
        return codigo_pessoa_usuario;
    }

    public void setCodigo_pessoa_usuario(Integer codigo_pessoa_usuario) {
        this.codigo_pessoa_usuario = codigo_pessoa_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNivel_usuario() {
        return nivel_usuario;
    }

    public void setNivel_usuario(String nivel_usuario) {
        this.nivel_usuario = nivel_usuario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO PESSOAS_USUARIOS  "+
" 	(CODIGO_PESSOA_USUARIO,           "+
" 	LOGIN,              "+
" 	NIVEL_USUARIO,      "+
" 	OBSERVACAO          "+
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
        
        stmt.setInt(1, getCodigo_pessoa_usuario());
        stmt.setString(2, getLogin());
        stmt.setString(3, getNivel_usuario());
        stmt.setString(4, getObservacao());

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
            comando = "select U.*, P.NOME_PESSOA " +
                    "from PESSOAS_USUARIOS U, PESSOAS P "+
                    "where U.CODIGO_PESSOA_USUARIO = P.CODIGO_PESSOA ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_usuario() != null){
               comando = comando + " AND CODIGO_PESSOA_USUARIO = ? ";
            }           

            comando = comando + " order by U.CODIGO_PESSOA_USUARIO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_usuario() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_usuario());
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

        String comando = "UPDATE PESSOAS_USUARIOS "+
" 	SET "+
" 	LOGIN = ?,          "+
" 	NIVEL_USUARIO = ? ,             "+
" 	OBSERVACAO = ?          "+
" 	WHERE "+
" 	CODIGO_PESSOA_USUARIO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getLogin());
        stmt.setString(2,getNivel_usuario());
        stmt.setString(3, getObservacao());
        stmt.setInt(4, getCodigo_pessoa_usuario());

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

" DELETE FROM PESSOAS_USUARIOS  "+
" 	WHERE "+
" 	CODIGO_PESSOA_USUARIO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_pessoa_usuario());


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
    
    
    
    
}// fim da classe
