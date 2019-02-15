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
public class PessoasCampo {
    
    private Integer codigo_pessoa_campo;
    private Integer codigo_regional;
    private String pessoa_campo;
    private String tipo_pessoa;
    private String status;
    private String hierarquia;
    private String ofensor;

    public Integer getCodigo_pessoa_campo() {
        return codigo_pessoa_campo;
    }

    public void setCodigo_pessoa_campo(Integer codigo_pessoa_campo) {
        this.codigo_pessoa_campo = codigo_pessoa_campo;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(String hierarquia) {
        this.hierarquia = hierarquia;
    }

    public String getPessoa_campo() {
        return pessoa_campo;
    }

    public void setPessoa_campo(String pessoa_campo) {
        this.pessoa_campo = pessoa_campo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public String getOfensor() {
        return ofensor;
    }

    public void setOfensor(String ofensor) {
        this.ofensor = ofensor;
    }
    
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO PESSOAS_CAMPO  "+
" 	(CODIGO_REGIONAL,   "+
" 	PESSOA_CAMPO,       "+
" 	TIPO_PESSOA,        "+
" 	STATUS,             "+
" 	HIERARQUIA,         "+
" 	OFENSOR             "+
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
        
        stmt.setInt(1, getCodigo_regional());
        stmt.setString(2, getPessoa_campo());
        stmt.setString(3, getTipo_pessoa());
        stmt.setString(4, getStatus());
        stmt.setString(5, getHierarquia());
        stmt.setString(6, getOfensor());

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
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ? ";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ? ";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    
    public ResultSet getConsultarSupRegOp(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'SUPERV. REGIONAL OPERAÇÕES' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    public ResultSet getConsultarGerente(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'GERENTE' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    
    
    public ResultSet getConsultarSupervOperacoes(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'SUPERV. DE OPERAÇÕES' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    
    
    public ResultSet getConsultarSupervVendas(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'SUPERV. DE VENDAS' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    public ResultSet getConsultarMonitorCampo(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'MONITOR DE CAMPO' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
 
    
    
    public ResultSet getConsultarConsultor(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'CONSULTOR' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    public ResultSet getConsultarCredenciado(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'CREDENCIADO' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    public ResultSet getConsultarCredenciadoAtivo(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select P.*, R.REGIONAL " +
                    "from PESSOAS_CAMPO P, REGIONAIS R "+
                    "where P.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL "+
                    "AND P.HIERARQUIA = 'CREDENCIADO' "+
                    "AND STATUS = 'ATIVO' "+
                    "AND OFENSOR = 'SIM' ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND P.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND P.CODIGO_REGIONAL = ?";
            }
           if (getPessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ?";
            }
           

            comando = comando + " order by P.CODIGO_PESSOA_CAMPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getPessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa_campo()+"%");
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

        String comando = "UPDATE PESSOAS_CAMPO "+
" 	SET "+
" 	CODIGO_REGIONAL = ?,           "+
" 	PESSOA_CAMPO = ? ,             "+
" 	TIPO_PESSOA = ? ,              "+
" 	STATUS = ? ,                   "+
" 	HIERARQUIA = ?,                "+
" 	OFENSOR = ?                    "+
" 	WHERE "+
" 	CODIGO_PESSOA_CAMPO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_regional());
        stmt.setString(2,getPessoa_campo());
        stmt.setString(3,getTipo_pessoa());
        stmt.setString(4,getStatus());
        stmt.setString(5, getHierarquia());
        stmt.setString(6, getOfensor());
        stmt.setInt(7, getCodigo_pessoa_campo());

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

" DELETE FROM PESSOAS_CAMPO  "+
" 	WHERE "+
" 	CODIGO_PESSOA_CAMPO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_pessoa_campo());


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
