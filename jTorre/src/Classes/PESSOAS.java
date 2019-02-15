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
public class PESSOAS {
    
    private Integer codigo_pessoa;
    private String nome_pessoa;
    private String data_cadastro;
    private String status;
    private String login;
    private String observacao;
    private String tipo_pessoa;

    public Integer getCodigo_pessoa() {
        return codigo_pessoa;
    }

    public void setCodigo_pessoa(Integer codigo_pessoa) {
        this.codigo_pessoa = codigo_pessoa;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }
    
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO PESSOAS  "+
" 	(NOME_PESSOA,           "+
" 	DATA_CADASTRO,          "+
" 	STATUS,                 "+
" 	LOGIN,                  "+
" 	OBSERVACAO,             "+
" 	TIPO_PESSOA             "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setString(1, getNome_pessoa());
        stmt.setString(2, getData_cadastro());
        stmt.setString(3, getStatus());
        stmt.setString(4, getLogin());
        stmt.setString(5, getObservacao());
        stmt.setString(6, getTipo_pessoa());

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
            comando = "select * " +
                    "from PESSOAS "+
                    "where CODIGO_PESSOA = CODIGO_PESSOA ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa() != null){
               comando = comando + " AND CODIGO_PESSOA = ? ";
            }
           if (getNome_pessoa() != null) {
                comando = comando + "AND NOME_PESSOA like ?";
            }
           if (getLogin() != null) {
                comando = comando + "AND LOGIN like ?";
            }           

            comando = comando + " order by CODIGO_PESSOA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
            }
           if (getNome_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome_pessoa()+"%");
            }
           if (getLogin() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getLogin()+"%");
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    public ResultSet getConsultarUsuário(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {           
            String comando;
            comando = "select NOME_PESSOA " +
                    "from PESSOAS "+
                    "where CODIGO_PESSOA = CODIGO_PESSOA "+
                    "AND LOGIN = LOGIN ";
                   

            int quantParam = 0;


           if (getCodigo_pessoa() != null){
               comando = comando + " AND CODIGO_PESSOA = ? ";
            }
           if (getLogin() != null) {
                comando = comando + "AND LOGIN = ? ";
            }          

            comando = comando + " order by CODIGO_PESSOA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
            }
           if (getLogin() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getLogin());
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

        String comando = "UPDATE PESSOAS "+
" 	SET "+
" 	NOME_PESSOA = ?,        "+
" 	DATA_CADASTRO = ? ,      "+
" 	STATUS = ? ,             "+
" 	LOGIN = ? ,              "+
" 	OBSERVACAO = ? ,         "+
" 	TIPO_PESSOA = ?          "+
" 	WHERE "+
" 	CODIGO_PESSOA = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getNome_pessoa());
        stmt.setString(2,getData_cadastro());
        stmt.setString(3,getStatus());
        stmt.setString(4,getLogin());
        stmt.setString(5, getObservacao());
        stmt.setString(6, getTipo_pessoa());
        stmt.setInt(7, getCodigo_pessoa());

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

" DELETE FROM PESSOAS  "+
" 	WHERE "+
" 	CODIGO_PESSOA = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_pessoa());


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
    
    
    
    public ResultSet getConsultarPessoasTelefones(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {           
            String comando;
            comando = "select T.*, P.NOME_PESSOA, TP.TIPO_TELEFONE " +
                    "from TELEFONES T, PESSOAS P, TIPOS_TELEFONES TP "+
                    "where  T.CODIGO_PESSOAS = P.CODIGO_PESSOA "+
                    "AND T.CODIGO_TIPO_TELEFONE = T.CODIGO_TIPO_TELEFONE "+
                    "AND TP.CODIGO_TIPO_TELEFONE =  T.CODIGO_TIPO_TELEFONE "+
                    "AND P.TIPO_PESSOA = 'FÍSICA' "+
                    "AND TP.TIPO_TELEFONE = 'COMERCIAL' "+
                    "AND T.MOSTRAR = 'SIM' ";
                    
                    

            int quantParam = 0;

            if (getNome_pessoa() != null) {
                comando = comando + "AND NOME_PESSOA like ?";
            }
            

            comando = comando + " order by T.CODIGO_TELEFONE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getNome_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome_pessoa()+"%");
            }
            
            
        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

    
    
}// FIM DA CLASSE
