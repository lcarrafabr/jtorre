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
public class Telefones {
    
    private Integer codigo_telefone;
    private Integer codigo_pessoa;
    private Integer codigo_tipo_telefone;
    private String numero_telefone;
    private String ramal;
    private String observacao;
    private String mostrar_receptivo;

    public Integer getCodigo_pessoa() {
        return codigo_pessoa;
    }

    public void setCodigo_pessoa(Integer codigo_pessoa) {
        this.codigo_pessoa = codigo_pessoa;
    }

    public Integer getCodigo_telefone() {
        return codigo_telefone;
    }

    public void setCodigo_telefone(Integer codigo_telefone) {
        this.codigo_telefone = codigo_telefone;
    }

    public Integer getCodigo_tipo_telefone() {
        return codigo_tipo_telefone;
    }

    public void setCodigo_tipo_telefone(Integer codigo_tipo_telefone) {
        this.codigo_tipo_telefone = codigo_tipo_telefone;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getMostrar_receptivo() {
        return mostrar_receptivo;
    }

    public void setMostrar_receptivo(String mostrar_receptivo) {
        this.mostrar_receptivo = mostrar_receptivo;
    }
    
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO TELEFONES  "+
" 	(CODIGO_PESSOAS,           "+
" 	CODIGO_TIPO_TELEFONE,          "+
" 	NUMERO,                 "+
" 	RAMAL,                  "+
" 	OBSERVACAO,             "+
" 	MOSTRAR                 "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_pessoa());
        stmt.setInt(2, getCodigo_tipo_telefone());
        stmt.setString(3, getNumero_telefone());
        stmt.setString(4, getRamal());
        stmt.setString(5, getObservacao());
        stmt.setString(6, getMostrar_receptivo());

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
            comando = "select T.*, P.NOME_PESSOA, TP.TIPO_TELEFONE " +
                    "from TELEFONES T, PESSOAS P, TIPOS_TELEFONES TP "+
                    "where  T.CODIGO_PESSOAS = P.CODIGO_PESSOA "+
                    "AND T.CODIGO_TIPO_TELEFONE = T.CODIGO_TIPO_TELEFONE "+
                    "AND TP.CODIGO_TIPO_TELEFONE =  T.CODIGO_TIPO_TELEFONE ";
                    

            int quantParam = 0;


           if (getCodigo_telefone() != null){
               comando = comando + " AND T.CODIGO_TELEFONE = ? ";
            }
           if (getCodigo_pessoa() != null) {
                comando = comando + "AND T.CODIGO_PESSOAS = ?";
            }
//           if (getCodigo_tipo_telefone() != null) {
//                comando = comando + "AND T.CODIGO_TIPO_TELEFONE = ?";
//            }           

            comando = comando + " order by T.CODIGO_TELEFONE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_telefone() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_telefone());
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

        String comando = "UPDATE TELEFONES "+
" 	SET "+
" 	CODIGO_PESSOAS = ?,             "+
" 	CODIGO_TIPO_TELEFONE = ? ,      "+
" 	NUMERO = ? ,                    "+
" 	RAMAL = ? ,                     "+
" 	OBSERVACAO = ? ,                "+
" 	MOSTRAR = ?                     "+
" 	WHERE "+
" 	CODIGO_TELEFONE = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_pessoa());
        stmt.setInt(2,getCodigo_tipo_telefone());
        stmt.setString(3,getNumero_telefone());
        stmt.setString(4,getRamal());
        stmt.setString(5, getObservacao());
        stmt.setString(6, getMostrar_receptivo());
        stmt.setInt(7, getCodigo_telefone());

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

" DELETE FROM TELEFONES  "+
" 	WHERE "+
" 	CODIGO_TELEFONE = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_telefone());


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

