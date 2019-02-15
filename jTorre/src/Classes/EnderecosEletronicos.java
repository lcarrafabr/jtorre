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
public class EnderecosEletronicos {
    
    private Integer codigo_endereco_eletronico;
    private Integer codigo_pessoa;
    private String email;
    private String site;
    private String observacao;

    public Integer getCodigo_endereco_eletronico() {
        return codigo_endereco_eletronico;
    }

    public void setCodigo_endereco_eletronico(Integer codigo_endereco_eletronico) {
        this.codigo_endereco_eletronico = codigo_endereco_eletronico;
    }

    public Integer getCodigo_pessoa() {
        return codigo_pessoa;
    }

    public void setCodigo_pessoa(Integer codigo_pessoa) {
        this.codigo_pessoa = codigo_pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    
     public void setCadastrar(){
  try{


        String comando = "INSERT INTO ENDERECOS_ELETRONICOS  "+
" 	(CODIGO_PESSOA,         "+
" 	EMAIL,                  "+
" 	SITE,                   "+
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
        stmt.setString(2, getEmail());
        stmt.setString(3, getSite());
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
            comando = "select E.*, P.NOME_PESSOA " +
                    "from ENDERECOS_ELETRONICOS E, PESSOAS P "+
                    "where E.CODIGO_PESSOA = P.CODIGO_PESSOA "+
                    "AND E.CODIGO_ENDERECO_ELETRONICO = E.CODIGO_ENDERECO_ELETRONICO ";
                   

            int quantParam = 0;


           if (getCodigo_endereco_eletronico() != null){
               comando = comando + " AND E.CODIGO_ENDERECO_ELETRONICO = ? ";
            }
           if (getCodigo_pessoa() != null) {
                comando = comando + "AND E.CODIGO_PESSOA = ? ";
            }          

            comando = comando + " order by E.CODIGO_ENDERECO_ELETRONICO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_endereco_eletronico() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_endereco_eletronico());
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

        String comando = "UPDATE ENDERECOS_ELETRONICOS "+
" 	SET "+
" 	CODIGO_PESSOA = ?,                "+
" 	EMAIL = ? ,                     "+
" 	SITE = ? ,                    "+
" 	OBSERVACAO = ?                 "+
" 	WHERE "+
" 	CODIGO_ENDERECO_ELETRONICO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_pessoa());
        stmt.setString(2,getEmail());
        stmt.setString(3,getSite());
        stmt.setString(4, getObservacao());
        stmt.setInt(5, getCodigo_endereco_eletronico());

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

" DELETE FROM ENDERECOS_ELETRONICOS  "+
" 	WHERE "+
" 	CODIGO_ENDERECO_ELETRONICO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_endereco_eletronico());


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
