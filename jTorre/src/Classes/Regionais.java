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
public class Regionais {
    
    private Integer codigo_regional;
    private String regional;

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO REGIONAIS  "+
" 	(REGIONAL           "+
" 	) "+
" 	VALUES "+
" 	(?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        
//        String oDataCadastro = null;
//        if (getData_abertura() != null){
//          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
//          oDataCadastro = oDatOut.format(getData_abertura());
//        }

        stmt.setString(1, getRegional());

        stmt.execute();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

   

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
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
                    "from REGIONAIS "+
                    "where CODIGO_REGIONAL = CODIGO_REGIONAL ";
                    

            int quantParam = 0;


           if (getRegional() != null){
               comando = comando + " AND REGIONAL = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND CODIGO_REGIONAL = ?";
            }
//           if (getNome_clientes() != null) {
//                comando = comando + "AND NOME_CLIENTE like ?";
//            }
//           if (getProtocolo() != null) {
//                comando = comando + "AND PROTOCOLO_ABERTURA like ?";
//            }
           

            comando = comando + " order by CODIGO_REGIONAL ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getRegional() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getRegional());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
//           if (getNome_clientes() != null){
//               quantParam = quantParam +1;
//               stmtQuery.setString(quantParam, getNome_clientes()+"%");
//            }
//           if (getProtocolo() != null){
//               quantParam = quantParam +1;
//               stmtQuery.setString(quantParam, getProtocolo()+"%");
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

        String comando = "UPDATE REGIONAIS "+
" 	SET "+
" 	REGIONAL = ?               "+
" 	WHERE "+
" 	CODIGO_REGIONAL = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getRegional());
        stmt.setInt(2, getCodigo_regional());

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

" DELETE FROM REGIONAIS  "+
" 	WHERE "+
" 	CODIGO_REGIONAL = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_regional());


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
