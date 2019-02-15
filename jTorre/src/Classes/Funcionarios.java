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
public class Funcionarios {
    
    private Integer codigo_pessoa_funcionario;
    private Integer matricula;
    private String login;
    private Integer id_login;
    private String ccms;
    private String data_admissao;
    private String data_ultima_ferias;
    private String data_demissao;
    private String observacao;

    public String getCcms() {
        return ccms;
    }

    public void setCcms(String ccms) {
        this.ccms = ccms;
    }

    public Integer getCodigo_pessoa_funcionario() {
        return codigo_pessoa_funcionario;
    }

    public void setCodigo_pessoa_funcionario(Integer codigo_pessoa_funcionario) {
        this.codigo_pessoa_funcionario = codigo_pessoa_funcionario;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(String data_demissao) {
        this.data_demissao = data_demissao;
    }

    public String getData_ultima_ferias() {
        return data_ultima_ferias;
    }

    public void setData_ultima_ferias(String data_ultima_ferias) {
        this.data_ultima_ferias = data_ultima_ferias;
    }

    public Integer getId_login() {
        return id_login;
    }

    public void setId_login(Integer id_login) {
        this.id_login = id_login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO FUNCIONARIOS  "+
" 	(CODIGO_PESSOA_FUNCIONARIO,           "+
" 	MATRICULA,          "+
" 	LOGIN,              "+
" 	ID_LOGIN,           "+
" 	CCMS,               "+
" 	DATA_ADMISSAO,      "+
" 	DATA_ULTIMA_FERIAS, "+
" 	DATA_DEMISSAO,      "+
" 	OBSERVACAO          "+
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
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_pessoa_funcionario());
        stmt.setInt(2, getMatricula());
        stmt.setString(3, getLogin());
        stmt.setInt(4, getId_login());
        stmt.setString(5, getCcms());
        stmt.setString(6, getData_admissao());
        stmt.setString(7, getData_ultima_ferias());
        stmt.setString(8, getData_demissao());
        stmt.setString(9, getObservacao());

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
            comando = "select F.*, P.NOME_PESSOA " +
                    "from FUNCIONARIOS F, PESSOAS P "+
                    "where F.CODIGO_PESSOA_FUNCIONARIO = P.CODIGO_PESSOA ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_funcionario() != null){
               comando = comando + " AND CODIGO_PESSOA_FUNCIONARIO = ? ";
            }           

            comando = comando + " order by CODIGO_PESSOA_FUNCIONARIO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_funcionario() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_funcionario());
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

        String comando = "UPDATE FUNCIONARIOS "+
" 	SET "+
" 	MATRICULA = ?,          "+
" 	LOGIN = ? ,             "+
" 	ID_LOGIN = ? ,          "+
" 	CCMS = ? ,              "+
" 	DATA_ADMISSAO = ? ,     "+
" 	DATA_ULTIMA_FERIAS = ? , "+
" 	DATA_DEMISSAO = ? ,     "+
" 	OBSERVACAO = ?          "+
" 	WHERE "+
" 	CODIGO_PESSOA_FUNCIONARIO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getMatricula());
        stmt.setString(2,getLogin());
        stmt.setInt(3,getId_login());
        stmt.setString(4,getCcms());
        stmt.setString(5, getData_admissao());
        stmt.setString(6, getData_ultima_ferias());
        stmt.setString(7, getData_ultima_ferias());
        stmt.setString(8, getObservacao());
        stmt.setInt(9, getCodigo_pessoa_funcionario());

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

" DELETE FROM FUNCIONARIOS  "+
" 	WHERE "+
" 	CODIGO_PESSOA_FUNCIONARIO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_pessoa_funcionario());


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
