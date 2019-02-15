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
public class Cargos {
    
    private Integer codigo_cargo;
    private Integer codigo_pessoa;
    private String cargo;
    private String status;
    private String observacao;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCodigo_cargo() {
        return codigo_cargo;
    }

    public void setCodigo_cargo(Integer codigo_cargo) {
        this.codigo_cargo = codigo_cargo;
    }

    public Integer getCodigo_pessoa() {
        return codigo_pessoa;
    }

    public void setCodigo_pessoa(Integer codigo_pessoa) {
        this.codigo_pessoa = codigo_pessoa;
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
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO CARGOS  "+
" 	(CODIGO_PESSOA,         "+
" 	CARGO,                  "+
" 	STATUS,                 "+
" 	OBSERVACAO              "+
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
        
        stmt.setInt(1, getCodigo_pessoa());
        stmt.setString(2, getCargo());
        stmt.setString(3, getStatus());
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
            comando = "select C.*, P.NOME_PESSOA " +
                    "from CARGOS C, PESSOAS P "+
                    "where C.CODIGO_PESSOA = P.CODIGO_PESSOA "+
                    "AND C.CODIGO_CARGO = C.CODIGO_CARGO ";
                   

            int quantParam = 0;


           if (getCodigo_cargo() != null){
               comando = comando + " AND C.CODIGO_CARGO = ? ";
            }
           if (getCodigo_pessoa() != null) {
                comando = comando + "AND C.CODIGO_PESSOA = ? ";
            }          

            comando = comando + " order by C.CODIGO_CARGO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_cargo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_cargo());
            }
           if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
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

        String comando = "UPDATE CARGOS "+
" 	SET "+
" 	CODIGO_PESSOA = ?,              "+
" 	CARGO = ? ,                     "+
" 	STATUS = ? ,                    "+
" 	OBSERVACAO = ?                  "+
" 	WHERE "+
" 	CODIGO_CARGO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_pessoa());
        stmt.setString(2,getCargo());
        stmt.setString(3,getStatus());
        stmt.setString(4, getObservacao());
        stmt.setInt(5, getCodigo_cargo());

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

" DELETE FROM CARGOS  "+
" 	WHERE "+
" 	CODIGO_CARGO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_cargo());


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
    
    public ResultSet getConsultarPessoaCargo(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {           
            String comando;
            comando = "select C.*, P.NOME_PESSOA " +
                    "from CARGOS C, PESSOAS P "+
                    "where C.CODIGO_PESSOA = P.CODIGO_PESSOA "+
                    "AND C.CODIGO_CARGO = C.CODIGO_CARGO "+
                    "AND C.CARGO = 'RECEPTIVO' ";
                   

            int quantParam = 0;


           if (getCodigo_cargo() != null){
               comando = comando + " AND C.CODIGO_CARGO = ? ";
            }
           if (getCodigo_pessoa() != null) {
                comando = comando + "AND C.CODIGO_PESSOA = ? ";
            }          

            comando = comando + " order by C.CODIGO_CARGO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_cargo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_cargo());
            }
           if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }
        return resultSet;
     }

        
    
    
}// fim da classe
