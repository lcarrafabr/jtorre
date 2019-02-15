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
public class AderenciaAMeta {
    
    private Integer codigo_aderencia_aos_processos;
    private Integer codigo_pessoa_campo_credenciado;
    private Integer codigo_regional;
    private Date data;
    private String pergunta1;
    private String pergunta2;
    private String pergunta3;
    private String pergunta4;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private float valor;
    private String aderencia;
    private Integer codigo_lista_relatorio;

    public String getAderencia() {
        return aderencia;
    }

    public void setAderencia(String aderencia) {
        this.aderencia = aderencia;
    }

    public Integer getCodigo_aderencia_aos_processos() {
        return codigo_aderencia_aos_processos;
    }

    public void setCodigo_aderencia_aos_processos(Integer codigo_aderencia_aos_processos) {
        this.codigo_aderencia_aos_processos = codigo_aderencia_aos_processos;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getItem1() {
        return item1;
    }

    public void setItem1(Integer item1) {
        this.item1 = item1;
    }

    public Integer getItem2() {
        return item2;
    }

    public void setItem2(Integer item2) {
        this.item2 = item2;
    }

    public Integer getItem3() {
        return item3;
    }

    public void setItem3(Integer item3) {
        this.item3 = item3;
    }

    public Integer getItem4() {
        return item4;
    }

    public void setItem4(Integer item4) {
        this.item4 = item4;
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

    public Integer getCodigo_lista_relatorio() {
        return codigo_lista_relatorio;
    }

    public void setCodigo_lista_relatorio(Integer codigo_lista_relatorio) {
        this.codigo_lista_relatorio = codigo_lista_relatorio;
    }
    
    
    
    
    public void setCadastrar(){
  try{
        String comando = "INSERT INTO ADERENCIA_AOS_PROCEDIMENTOS  "+ 
" 	(CODIGO_PESSOA_CAMPO_CREDENCIADO,    "+
" 	CODIGO_REGIONAL,                 "+
" 	DATA,                            "+
" 	PERGUNTA1,                       "+
" 	PERGUNTA2,                       "+
" 	PERGUNTA3,                       "+
" 	PERGUNTA4,                       "+
" 	VALOR,                           "+
" 	ADERENCIA,                        "+
" 	CODIGO_LISTA_RELATORIO           "+
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
        stmt.setString(3, oDataCadastro);
        stmt.setString(4, getPergunta1());
        stmt.setString(5, getPergunta2());
        stmt.setString(6, getPergunta3());
        stmt.setString(7, getPergunta4());
        stmt.setFloat(8, getValor());
        stmt.setString(9, getAderencia());
        stmt.setInt(10, getCodigo_lista_relatorio());

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
                    "FROM ADERENCIA_AOS_PROCEDIMENTOS A, PESSOAS_CAMPO P, REGIONAIS R, LISTAS_RELATORIOS L "+
                    "WHERE A.CODIGO_ADERENCIA_AOS_PROCEDIMENTOS = A.CODIGO_ADERENCIA_AOS_PROCEDIMENTOS "+
                    "AND R.CODIGO_REGIONAL = A.CODIGO_REGIONAL "+
                    "AND P.CODIGO_PESSOA_CAMPO = A.CODIGO_PESSOA_CAMPO_CREDENCIADO "+
                    "AND L.CODIGO_LISTA_RELATORIO = A.CODIGO_LISTA_RELATORIO ";
                    

            int quantParam = 0;


           if (getCodigo_regional() != null) {
                comando = comando + "AND A.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_pessoa_campo_credenciado() != null) {
                comando = comando + "AND A.CODIGO_PESSOA_CAMPO_CREDENCIADO = ?";
            }
           if (getCodigo_aderencia_aos_processos() != null){
               comando = comando + "AND A.CODIGO_ADERENCIA_AOS_PROCEDIMENTOS = ? ";
            }
           if (getCodigo_lista_relatorio() != null) {
                comando = comando + "AND A.CODIGO_LISTA_RELATORIO = ?";
            }

            comando = comando + " order by A.DATA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_pessoa_campo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo_credenciado());
            }
            if (getCodigo_aderencia_aos_processos() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_aderencia_aos_processos());
            }
            if (getCodigo_lista_relatorio() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_lista_relatorio());
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
" 	CODIGO_PESSOA_CAMPO_CREDENCIADO = ?,           "+
" 	CODIGO_REGIONAL = ? ,    "+
" 	DATA = ? ,               "+
" 	PERGUNTA1 = ? ,          "+
" 	PERGUNTA2 = ?,           "+
" 	PERGUNTA3 = ?,           "+
" 	PERGUNTA4 = ?,           "+
" 	VALOR = ?,               "+
" 	ADERENCIA = ?            "+
" 	WHERE "+
" 	CODIGO_ADERENCIA_AOS_PROCEDIMENTOS = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        String oDataCadastro = null;
        if (getData() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          oDataCadastro = oDatOut.format(getData());
        }

        stmt.setInt(1,getCodigo_pessoa_campo_credenciado());
        stmt.setInt(2,getCodigo_regional());
        stmt.setString(3,oDataCadastro);
        stmt.setString(4,getPergunta1());
        stmt.setString(5, getPergunta2());
        stmt.setString(6, getPergunta3());
        stmt.setString(7, getPergunta4());
        stmt.setFloat(8, getValor());
        stmt.setString(9, getAderencia());
        stmt.setInt(10, getCodigo_aderencia_aos_processos());

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
" 	CODIGO_ADERENCIA_AOS_PROCEDIMENTOS = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_aderencia_aos_processos());


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