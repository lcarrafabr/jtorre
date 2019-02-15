/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lcbenfic
 */
public class ControlesDiarios {
    
    private Integer codigo_controle_diario;
    private Integer codigo_pessoa_campo_credenciado;
    private Integer codigo_regional;
    private Integer codigo_lista_relatorio;
    private Integer canceladas;
    private Integer devolvidas;
    private Integer executadas;
    private Integer finalizadas;
    private Integer vencidas;
    private Integer reagendadas;
    private Date data;

    public Integer getCanceladas() {
        return canceladas;
    }

    public void setCanceladas(Integer canceladas) {
        this.canceladas = canceladas;
    }

    public Integer getCodigo_controle_diario() {
        return codigo_controle_diario;
    }

    public void setCodigo_controle_diario(Integer codigo_controle_diario) {
        this.codigo_controle_diario = codigo_controle_diario;
    }

    public Integer getCodigo_pessoa_campo_credenciado() {
        return codigo_pessoa_campo_credenciado;
    }

    public void setCodigo_pessoa_campo_credenciado(Integer codigo_pessoa_campo_credenciado) {
        this.codigo_pessoa_campo_credenciado = codigo_pessoa_campo_credenciado;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public Integer getCodigo_lista_relatorio() {
        return codigo_lista_relatorio;
    }

    public void setCodigo_lista_relatorio(Integer codigo_lista_relatorio) {
        this.codigo_lista_relatorio = codigo_lista_relatorio;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getDevolvidas() {
        return devolvidas;
    }

    public void setDevolvidas(Integer devolvidas) {
        this.devolvidas = devolvidas;
    }

    public Integer getExecutadas() {
        return executadas;
    }

    public void setExecutadas(Integer executadas) {
        this.executadas = executadas;
    }

    public Integer getFinalizadas() {
        return finalizadas;
    }

    public void setFinalizadas(Integer finalizadas) {
        this.finalizadas = finalizadas;
    }

    public Integer getReagendadas() {
        return reagendadas;
    }

    public void setReagendadas(Integer reagendadas) {
        this.reagendadas = reagendadas;
    }

    public Integer getVencidas() {
        return vencidas;
    }

    public void setVencidas(Integer vencidas) {
        this.vencidas = vencidas;
    }
    
    
    public void setCadastrar(){
  try{
        String comando = "INSERT INTO CONTROLES_DIARIOS  "+ 
" 	(CODIGO_PESSOA_CAMPO_CREDENCIADO,    "+
" 	CODIGO_REGIONAL,                    "+
" 	CODIGO_LISTA_RELATORIO,             "+
" 	CANCELADAS,                         "+
" 	DEVOLVIDAS,                         "+
" 	EXECUTADAS,                         "+
" 	FINALIZADAS,                        "+
" 	VENCIDAS,                           "+
" 	REAGENDADAS,                        "+
" 	DATA                                "+
" 	) "+
" 	VALUES "+
" 	(?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        
        String oDataCadastro = null;
        if (getData() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          oDataCadastro = oDatOut.format(getData());
        }

        stmt.setInt(1, getCodigo_pessoa_campo_credenciado());
        stmt.setInt(2, getCodigo_regional());
        stmt.setInt(3, getCodigo_lista_relatorio());
        stmt.setInt(4, getCanceladas());
        stmt.setInt(5, getDevolvidas());
        stmt.setInt(6, getExecutadas());
        stmt.setInt(7, getFinalizadas());
        stmt.setInt(8, getVencidas());
        stmt.setInt(9, getReagendadas());
        stmt.setString(10, oDataCadastro);

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
            comando = "SELECT CD.* " +
                    "FROM CONTROLES_DIARIOS CD, REGIONAIS R, LISTAS_RELATORIOS L "+
                    "WHERE CD.CODIGO_CONTROLE_DIARIO = CD.CODIGO_CONTROLE_DIARIO "+
                    "AND L.CODIGO_LISTA_RELATORIO = CD.CODIGO_LISTA_RELATORIO "+
                    "AND R.CODIGO_REGIONAL = CD.CODIGO_REGIONAL ";
                    

            int quantParam = 0;


           if (getCodigo_regional() != null) {
                comando = comando + "AND CD.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_lista_relatorio() != null) {
                comando = comando + "AND CD.CODIGO_LISTA_RELATORIO = ?";
            }
           if (getCodigo_controle_diario() != null){
               comando = comando + " AND CD.CODIGO_CONTROLE_DIARIO = ? ";
            }
           if (getCodigo_pessoa_campo_credenciado() != null){
               comando = comando + " AND CD.CODIGO_PESSOA_CAMPO_CREDENCIADO = ? ";
            }
           

            comando = comando + " order by CD.DATA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_lista_relatorio() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_relatorio());
            }
            if (getCodigo_controle_diario() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_controle_diario());
            }
            if (getCodigo_pessoa_campo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo_credenciado());
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    public ResultSet getConsultarTotalGeraldaSemana(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
         String comando;
         comando = "SELECT (suM(CD.CANCELADAS)) AS TOTAL_CANCELADAS, (SUM(CD.DEVOLVIDAS)) AS TOTAL_DEVOLVIDA, (SUM(CD.EXECUTADAS)) AS TOTAL_EXECUTADA, "
                 + "(SUM(CD.FINALIZADAS)) AS TOTAL_FINALIZADAS, (SUM(CD.VENCIDAS)) AS TOTAL_VENCIDA, (SUM(CD.REAGENDADAS)) AS TOTAL_REAGENDADAS, "
                 + "(SUM(CD.CANCELADAS + CD.DEVOLVIDAS + CD.EXECUTADAS + CD.FINALIZADAS)) AS TOTAL_GERAL " +
                   "FROM CONTROLES_DIARIOS CD, REGIONAIS R, LISTAS_RELATORIOS L "+
                   "WHERE CD.CODIGO_CONTROLE_DIARIO = CD.CODIGO_CONTROLE_DIARIO "+
                   "AND L.CODIGO_LISTA_RELATORIO = CD.CODIGO_LISTA_RELATORIO "+
                   "AND R.CODIGO_REGIONAL = CD.CODIGO_REGIONAL ";


            int quantParam = 0;


           if (getCodigo_regional() != null) {
                comando = comando + "AND CD.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_lista_relatorio() != null) {
                comando = comando + "AND CD.CODIGO_LISTA_RELATORIO = ?";
            }
           if (getCodigo_controle_diario() != null){
               comando = comando + " AND CD.CODIGO_CONTROLE_DIARIO = ? ";
            }
           if (getCodigo_pessoa_campo_credenciado() != null){
               comando = comando + " AND CD.CODIGO_PESSOA_CAMPO_CREDENCIADO = ? ";
            }
           

//            comando = comando + " order by CD.CODIGO_CONTROLE_DIARIO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_lista_relatorio() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_relatorio());
            }
            if (getCodigo_controle_diario() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_controle_diario());
            }
            if (getCodigo_pessoa_campo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo_credenciado());
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    /*  CODIGO PARA SOKAR O TOTAL DA SEMANA E USAR NO FUTURO NO RELATORIO
     
     
SELECT (suM(CD.CANCELADAS)) AS TOTAL_CANCELADAS, (SUM(CD.DEVOLVIDAS)) AS TOTAL_DEVOLVIDA, (SUM(CD.EXECUTADAS)) AS TOTAL_EXECUTADA,
(SUM(CD.FINALIZADAS)) AS TOTAL_FINALIZADAS, (SUM(CD.VENCIDAS)) AS TOTAL_VENCIDA, (SUM(CD.REAGENDADAS)) AS TOTAL_REAGENDADAS,
(SUM(CD.CANCELADAS + CD.DEVOLVIDAS + CD.EXECUTADAS + CD.FINALIZADAS + CD.VENCIDAS)) AS TOTAL_GERAL
FROM CONTROLES_DIARIOS CD, REGIONAIS R, LISTAS_RELATORIOS L
WHERE CD.CODIGO_CONTROLE_DIARIO = CD.CODIGO_CONTROLE_DIARIO
AND L.CODIGO_LISTA_RELATORIO = CD.CODIGO_LISTA_RELATORIO
AND R.CODIGO_REGIONAL = CD.CODIGO_REGIONAL
AND CD.CODIGO_REGIONAL = 10
AND CD.CODIGO_LISTA_RELATORIO = 3
AND CD.CODIGO_PESSOA_CAMPO_CREDENCIADO = 308
     
     */
    
    
    
    public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE CONTROLES_DIARIOS "+
" 	SET "+
" 	CODIGO_PESSOA_CAMPO_CREDENCIADO = ?,           "+
" 	CODIGO_REGIONAL = ? ,        "+
" 	CODIGO_LISTA_RELATORIO = ? , "+
" 	CANCELADAS = ? ,            "+
" 	DEVOLVIDAS = ?,             "+
" 	EXECUTADAS = ?,             "+
" 	FINALIZADAS = ?,            "+
" 	VENCIDAS = ?,               "+
" 	REAGENDADAS = ?,            "+
" 	DATA = ?                    "+
" 	WHERE "+
" 	CODIGO_CONTROLE_DIARIO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        String oDataCadastro = null;
        if (getData() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          oDataCadastro = oDatOut.format(getData());
        }

        stmt.setInt(1,getCodigo_pessoa_campo_credenciado());
        stmt.setInt(2,getCodigo_regional());
        stmt.setInt(3,getCodigo_lista_relatorio());
        stmt.setInt(4,getCanceladas());
        stmt.setInt(5, getDevolvidas());
        stmt.setInt(6, getExecutadas());
        stmt.setInt(7, getFinalizadas());
        stmt.setInt(8, getVencidas());
        stmt.setInt(9, getReagendadas());
        stmt.setString(10, oDataCadastro);
        stmt.setInt(11, getCodigo_controle_diario());

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

" DELETE FROM CONTROLES_DIARIOS  "+
" 	WHERE "+
" 	CODIGO_CONTROLE_DIARIO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_controle_diario());


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
