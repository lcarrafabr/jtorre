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
public class AderenciaAosProcedimentos {
    
    private Integer codigo_controle_acompanhamento;
    private Integer codigo_lista_semanal;
    private Integer codigo_regional;
    private Integer codigo_credenciado;
    private String pergunta1;
    private String pergunta2;
    private String pergunta3;
    private String pergunta4;
    private float valor;
    private String aderencia;
    private String data;

    public String getAderencia() {
        return aderencia;
    }

    public void setAderencia(String aderencia) {
        this.aderencia = aderencia;
    }

    public Integer getCodigo_controle_acompanhamento() {
        return codigo_controle_acompanhamento;
    }

    public void setCodigo_controle_acompanhamento(Integer codigo_controle_acompanhamento) {
        this.codigo_controle_acompanhamento = codigo_controle_acompanhamento;
    }

    public Integer getCodigo_credenciado() {
        return codigo_credenciado;
    }

    public void setCodigo_credenciado(Integer codigo_credenciado) {
        this.codigo_credenciado = codigo_credenciado;
    }

    public Integer getCodigo_lista_semanal() {
        return codigo_lista_semanal;
    }

    public void setCodigo_lista_semanal(Integer codigo_lista_semanal) {
        this.codigo_lista_semanal = codigo_lista_semanal;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPergunta1() {
        return pergunta1;
    }

    public void setPergunta1(String pergunta1) {
        this.pergunta1 = pergunta1;
    }

    public String getPergunta2() {
        return pergunta2;
    }

    public void setPergunta2(String pergunta2) {
        this.pergunta2 = pergunta2;
    }

    public String getPergunta3() {
        return pergunta3;
    }

    public void setPergunta3(String pergunta3) {
        this.pergunta3 = pergunta3;
    }

    public String getPergunta4() {
        return pergunta4;
    }

    public void setPergunta4(String pergunta4) {
        this.pergunta4 = pergunta4;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO ADERENCIA_AOS_PROCEDIMENTOS  "+
" 	(CODIGO_LISTA_SEMANAL,      "+
" 	CODIGO_REGIONAL,            "+
" 	CODIGO_CREDENCIADO,         "+
" 	PERGUNTA1,                  "+
" 	PERGUNTA2,                  "+
" 	PERGUNTA3,                  "+
" 	PERGUNTA4,                  "+
" 	VALOR,                      "+
" 	ADERENCIA,                  "+
" 	DATA                        "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");
        

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_lista_semanal());
        stmt.setInt(2, getCodigo_regional());
        stmt.setInt(3, getCodigo_credenciado());
        stmt.setString(4, getPergunta1());
        stmt.setString(5, getPergunta2());
        stmt.setString(6, getPergunta3());
        stmt.setString(7, getPergunta4());
        stmt.setFloat(8, getValor());
        stmt.setString(9, getAderencia());
        stmt.setString(10, getData());

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
            comando = "SELECT A.* " +
                    "FROM ADERENCIA_AOS_PROCEDIMENTOS A, LISTAS_SEMANAIS L, REGIONAIS R, CREDENCIADOS C "+
                    "WHERE  A.CODIGO_CONTROLE_ACOMPANHAMENTO = A.CODIGO_CONTROLE_ACOMPANHAMENTO "+
                    "AND A.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND A.CODIGO_CREDENCIADO = C.CODIGO_CREDENCIADO "+
                    "AND A.CODIGO_LISTA_SEMANAL = L.CODIGO_LISTA_SEMANAL ";
                    

            int quantParam = 0;

            
            if (getCodigo_controle_acompanhamento() != null) {
                comando = comando + "AND A.CODIGO_CONTROLE_ACOMPANHAMENTO = ?";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND A.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_credenciado() != null) {
                comando = comando + "AND A.CODIGO_CREDENCIADO = ?";
            }
           if (getCodigo_lista_semanal() != null) {
                comando = comando + "AND A.CODIGO_LISTA_SEMANAL = ?";
            }

            comando = comando + " order by A.DATA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            
            if (getCodigo_controle_acompanhamento() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_controle_acompanhamento());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
            if (getCodigo_lista_semanal() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_semanal());
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

        String comando = "UPDATE ADERENCIA_AOS_PROCEDIMENTOS "+
" 	SET "+
" 	CODIGO_LISTA_SEMANAL = ?,   "+
" 	CODIGO_REGIONAL = ? ,       "+
" 	CODIGO_CREDENCIADO = ? ,    "+
" 	PERGUNTA1 = ? ,             "+
" 	PERGUNTA2 = ? ,             "+
" 	PERGUNTA3 = ? ,             "+
" 	PERGUNTA4 = ? ,             "+
" 	VALOR = ? ,                 "+
" 	ADERENCIA = ? ,             "+
" 	DATA = ?                    "+
" 	WHERE "+
" 	CODIGO_CONTROLE_ACOMPANHAMENTO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_lista_semanal());
        stmt.setInt(2,getCodigo_regional());
        stmt.setInt(3,getCodigo_credenciado());
        stmt.setString(4,getPergunta1());
        stmt.setString(5,getPergunta2());
        stmt.setString(6,getPergunta3());
        stmt.setString(7,getPergunta4());
        stmt.setFloat(8,getValor());
        stmt.setString(9,getAderencia());
        stmt.setString(10,getData());
        stmt.setInt(11, getCodigo_controle_acompanhamento());

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

" DELETE FROM ADERENCIA_AOS_PROCEDIMENTOS  "+
" 	WHERE "+
" 	CODIGO_CONTROLE_ACOMPANHAMENTO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_controle_acompanhamento());


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
    
    
    
    
    
    
}//FIM DA CLASSE
