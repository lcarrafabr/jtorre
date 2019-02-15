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
public class EmailsCampo {
    
    private Integer codigo_email_campo;
    private Integer codigo_pessoa;
    private String email;

    public Integer getCodigo_email_campo() {
        return codigo_email_campo;
    }

    public void setCodigo_email_campo(Integer codigo_email_campo) {
        this.codigo_email_campo = codigo_email_campo;
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
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO EMAILS_CAMPO  "+
" 	(CODIGO_PESSOA_CAMPO,           "+
" 	EMAIL          "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_pessoa());
        stmt.setString(2, getEmail());

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
            comando = "select E.*, P.PESSOA_CAMPO " +
                    "from EMAILS_CAMPO E, PESSOAS_CAMPO P "+
                    "where  E.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND E.CODIGO_EMAIL_CAMPO = E.CODIGO_EMAIL_CAMPO ";
                    

            int quantParam = 0;


           if (getCodigo_email_campo() != null){
               comando = comando + " AND E.CODIGO_EMAIL_CAMPO = ? ";
            }
           if (getCodigo_pessoa() != null) {
                comando = comando + "AND E.CODIGO_PESSOA_CAMPO = ?";
            }       

            comando = comando + " order by E.CODIGO_EMAIL_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_email_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_email_campo());
            }
           if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
            }
//           if (getCodigo_tipo_telefone() != null){
//               quantParam = quantParam +1;
//               stmtQuery.setInt(quantParam, getCodigo_tipo_telefone());
//            }

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

        String comando = "UPDATE EMAILS_CAMPO "+
" 	SET "+
" 	CODIGO_PESSOA_CAMPO = ?,  "+
" 	EMAIL = ?                 "+
" 	WHERE "+
" 	CODIGO_EMAIL_CAMPO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_pessoa());
        stmt.setString(2,getEmail());
        stmt.setInt(3, getCodigo_email_campo());

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

" DELETE FROM EMAILS_CAMPO  "+
" 	WHERE "+
" 	CODIGO_EMAIL_CAMPO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_email_campo());


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
