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
public class TorresGat {
    
    private Integer codigo_torre_gat;
    private Integer codigo_credenciado;
    private String nome_torre_gat;
    private String observacao;

    public Integer getCodigo_credenciado() {
        return codigo_credenciado;
    }

    public void setCodigo_credenciado(Integer codigo_credenciado) {
        this.codigo_credenciado = codigo_credenciado;
    }

    public Integer getCodigo_torre_gat() {
        return codigo_torre_gat;
    }

    public void setCodigo_torre_gat(Integer codigo_torre_gat) {
        this.codigo_torre_gat = codigo_torre_gat;
    }

    public String getNome_torre_gat() {
        return nome_torre_gat;
    }

    public void setNome_torre_gat(String nome_torre_gat) {
        this.nome_torre_gat = nome_torre_gat;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO TORRES_GAT  "+
" 	(CODIGO_CREDENCIADO,  "+
" 	NOME_TORRE_GAT,       "+
" 	OBSERVACAO            "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_credenciado());
        stmt.setString(2, getNome_torre_gat());
        stmt.setString(3, getObservacao());

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
            comando = "select T.* " +
                    "from TORRES_GAT T, CREDENCIADOS C "+
                    "where T.CODIGO_CREDENCIADO = C.CODIGO_CREDENCIADO "+
                    "AND T.CODIGO_TORRE_GAT = T.CODIGO_TORRE_GAT ";
                    

            int quantParam = 0;


           if (getCodigo_torre_gat() != null){
               comando = comando + " AND T.CODIGO_TORRE_GAT = ? ";
            }
           if (getCodigo_credenciado() != null) {
                comando = comando + "AND T.CODIGO_CREDENCIADO = ?";
            }
           

            comando = comando + " order by T.CODIGO_TORRE_GAT ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_torre_gat() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_torre_gat());
            }
           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
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

        String comando = "UPDATE TORRES_GAT "+
" 	SET "+
" 	CODIGO_CREDENCIADO = ? ,          "+
" 	NOME_TORRE_GAT = ? ,              "+
" 	OBSERVACAO = ?                    "+
" 	WHERE "+
" 	CODIGO_TORRE_GAT = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_credenciado());
        stmt.setString(2,getNome_torre_gat());
        stmt.setString(3,getObservacao());
        stmt.setInt(4, getCodigo_torre_gat());

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

" DELETE FROM TORRES_GAT  "+
" 	WHERE "+
" 	CODIGO_TORRE_GAT = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_torre_gat());


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
