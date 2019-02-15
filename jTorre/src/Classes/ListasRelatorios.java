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
public class ListasRelatorios {
    
    private Integer codigo_lista_relatorio;
    private Integer codigo_regional;
    private String data_inicial;
    private String datafinal;
    private String status;

    public Integer getCodigo_lista_relatorio() {
        return codigo_lista_relatorio;
    }

    public void setCodigo_lista_relatorio(Integer codigo_lista_relatorio) {
        this.codigo_lista_relatorio = codigo_lista_relatorio;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    public String getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public void setCadastrar(){
  try{
        String comando = "INSERT INTO LISTAS_RELATORIOS  "+ 
" 	(CODIGO_REGIONAL,           "+
" 	DATA_INICIAL,               "+
" 	DATA_FINAL,                 "+
" 	STATUS                      "+
" 	) "+
" 	VALUES "+
" 	(?,  "+
" 	?,  "+
" 	?,  "+
" 	?   "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCodigo_regional());
        stmt.setString(2, getData_inicial());
        stmt.setString(3, getDatafinal());
        stmt.setString(4, getStatus());

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
            comando = "select LR.* " +
                    "FROM LISTAS_RELATORIOS LR, REGIONAIS R "+
                    "WHERE LR.CODIGO_LISTA_RELATORIO = LR.CODIGO_LISTA_RELATORIO "+
                    "AND LR.CODIGO_REGIONAL = R.CODIGO_REGIONAL ";
//                    "AND LR.STATUS = 'ABERTA' ";
                    

            int quantParam = 0;



           if (getCodigo_regional() != null) {
                comando = comando + "AND LR.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_lista_relatorio() != null){
               comando = comando + " AND LR.CODIGO_LISTA_RELATORIO = ? ";
            }
           if (getStatus() != null) {
                comando = comando + "AND LR.STATUS = ?";
            }

            comando = comando + " order by LR.CODIGO_REGIONAL ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);



           if (getCodigo_regional() != 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_lista_relatorio() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_relatorio());
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
   
    
    
    public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE LISTAS_RELATORIOS "+
" 	SET "+
" 	CODIGO_REGIONAL = ?,    "+
" 	DATA_INICIAL = ? ,      "+
" 	DATA_FINAL = ? ,        "+
" 	STATUS = ?              "+
" 	WHERE "+
" 	CODIGO_LISTA_RELATORIO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_regional());
        stmt.setString(2,getData_inicial());
        stmt.setString(3,getDatafinal());
        stmt.setString(4,getStatus());
        stmt.setInt(5, getCodigo_lista_relatorio());

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

" DELETE FROM LISTAS_RELATORIOS  "+
" 	WHERE "+
" 	CODIGO_LISTA_RELATORIO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_lista_relatorio());


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
