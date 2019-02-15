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
public class TiposTelefones {
    
    private Integer codigo_tipo_telefone;
    private String tipo_telefone;

    public Integer getCodigo_tipo_telefone() {
        return codigo_tipo_telefone;
    }

    public void setCodigo_tipo_telefone(Integer codigo_tipo_telefone) {
        this.codigo_tipo_telefone = codigo_tipo_telefone;
    }

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
    }

    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO TIPOS_TELEFONES  "+
" 	(TIPO_TELEFONE           "+
" 	) "+
" 	VALUES  "+
" 	(?     "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setString(1, getTipo_telefone());

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
                    "from TIPOS_TELEFONES "+
                    "where CODIGO_TIPO_TELEFONE = CODIGO_TIPO_TELEFONE ";
                    

            int quantParam = 0;


           if (getCodigo_tipo_telefone() != null){
               comando = comando + " AND CODIGO_TIPO_TELEFONE = ? ";
            }
           if (getTipo_telefone() != null) {
                comando = comando + "AND TIPO_TELEFONE like ?";
            }      

            comando = comando + " order by CODIGO_TIPO_TELEFONE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_tipo_telefone() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_tipo_telefone());
            }
           if (getTipo_telefone() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getTipo_telefone()+"%");
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

        String comando = "UPDATE TIPOS_TELEFONES "+
" 	SET "+
" 	TIPO_TELEFONE = ?                "+
" 	WHERE "+
" 	CODIGO_TIPO_TELEFONE = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getTipo_telefone());
        stmt.setInt(2, getCodigo_tipo_telefone());

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

" DELETE FROM TIPOS_TELEFONES  "+
" 	WHERE "+
" 	CODIGO_TIPO_TELEFONE = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_tipo_telefone());


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
    
    
}// FIM DA CLASSE
