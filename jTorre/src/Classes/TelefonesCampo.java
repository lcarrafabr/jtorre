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
public class TelefonesCampo {
    
    private Integer codigo_telefone_campo;
    private Integer codigo_pessoa_campo;
    private Integer ddd;
    private String numero_telefone;
    private String tipo_telefone;
    private String observacao;

    public Integer getCodigo_pessoa_campo() {
        return codigo_pessoa_campo;
    }

    public void setCodigo_pessoa_campo(Integer codigo_pessoa_campo) {
        this.codigo_pessoa_campo = codigo_pessoa_campo;
    }

    public Integer getCodigo_telefone_campo() {
        return codigo_telefone_campo;
    }

    public void setCodigo_telefone_campo(Integer codigo_telefone_campo) {
        this.codigo_telefone_campo = codigo_telefone_campo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
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

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
    }
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO TELEFONES_CAMPO  "+
" 	(CODIGO_PESSOA_CAMPO,    "+
" 	DDD,                     "+
" 	NUMERO_TELEFONE,         "+
" 	TIPO_TELEFONE,           "+
" 	OBSERVACAO               "+
" 	) "+
" 	VALUES  "+
" 	(?,     "+
" 	?,      "+
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_pessoa_campo());
        stmt.setInt(2, getDdd());
        stmt.setString(3, getNumero_telefone());
        stmt.setString(4, getTipo_telefone());
        stmt.setString(5, getObservacao());

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
            comando = "select T.*, P.PESSOA_CAMPO " +
                    "from TELEFONES_CAMPO T, PESSOAS_CAMPO P "+
                    "where  T.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND T.CODIGO_TELEFONE_CAMPO = T.CODIGO_TELEFONE_CAMPO ";
                    

            int quantParam = 0;


           if (getCodigo_telefone_campo() != null){
               comando = comando + " AND T.CODIGO_TELEFONE_CAMPO = ? ";
            }
           if (getCodigo_pessoa_campo() != null) {
                comando = comando + "AND T.CODIGO_PESSOA_CAMPO = ?";
            }
//           if (getCodigo_tipo_telefone() != null) {
//                comando = comando + "AND T.CODIGO_TIPO_TELEFONE = ?";
//            }           

            comando = comando + " order by T.CODIGO_TELEFONE_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_telefone_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_telefone_campo());
            }
           if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
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

        String comando = "UPDATE TELEFONES_CAMPO "+
" 	SET "+
" 	CODIGO_PESSOA_CAMPO = ?,    "+
" 	DDD = ? ,                   "+
" 	NUMERO_TELEFONE = ? ,       "+
" 	TIPO_TELEFONE = ? ,         "+
" 	OBSERVACAO = ?              "+
" 	WHERE "+
" 	CODIGO_TELEFONE_CAMPO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_pessoa_campo());
        stmt.setInt(2,getDdd());
        stmt.setString(3,getNumero_telefone());
        stmt.setString(4,getTipo_telefone());
        stmt.setString(5, getObservacao());
        stmt.setInt(6, getCodigo_telefone_campo());

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

" DELETE FROM TELEFONES_CAMPO  "+
" 	WHERE "+
" 	CODIGO_TELEFONE_CAMPO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_telefone_campo());


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
