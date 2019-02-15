/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author lcbenfic
 */
public class Credenciadas {
    
    private Integer codigo_credenciado;
    private Integer codigo_pessoa_campo;
    private Integer codigo_sup_reg_op;
    private Integer codigo_gerente;
    private Integer codigo_sup_op;
    private Integer codigo_sup_vendas;
    private Integer codigo_monitor;
    private Integer codigo_consultor;
    private String pdv;
    private Integer numero_codigo;
    private String uf;
    private String micro_regiao;
    private String cnpj;
    private Integer codigo_regional; // usado apenas para consulta no getConsultarCredenciadas (FUNCIONANDO)
    private String nome_pessoa_campo; // usado apenas para consultar o nome da pessoa (FUNCIONANDO)
    
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getCodigo_consultor() {
        return codigo_consultor;
    }

    public void setCodigo_consultor(Integer codigo_consultor) {
        this.codigo_consultor = codigo_consultor;
    }

    public Integer getCodigo_credenciado() {
        return codigo_credenciado;
    }

    public void setCodigo_credenciado(Integer codigo_credenciado) {
        this.codigo_credenciado = codigo_credenciado;
    }

    public Integer getCodigo_gerente() {
        return codigo_gerente;
    }

    public void setCodigo_gerente(Integer codigo_gerente) {
        this.codigo_gerente = codigo_gerente;
    }

    public Integer getCodigo_monitor() {
        return codigo_monitor;
    }

    public void setCodigo_monitor(Integer codigo_monitor) {
        this.codigo_monitor = codigo_monitor;
    }

    public Integer getCodigo_pessoa_campo() {
        return codigo_pessoa_campo;
    }

    public void setCodigo_pessoa_campo(Integer codigo_pessoa_campo) {
        this.codigo_pessoa_campo = codigo_pessoa_campo;
    }

    public Integer getCodigo_sup_op() {
        return codigo_sup_op;
    }

    public void setCodigo_sup_op(Integer codigo_sup_op) {
        this.codigo_sup_op = codigo_sup_op;
    }

    public Integer getCodigo_sup_reg_op() {
        return codigo_sup_reg_op;
    }

    public void setCodigo_sup_reg_op(Integer codigo_sup_reg_op) {
        this.codigo_sup_reg_op = codigo_sup_reg_op;
    }

    public Integer getCodigo_sup_vendas() {
        return codigo_sup_vendas;
    }

    public void setCodigo_sup_vendas(Integer codigo_sup_vendas) {
        this.codigo_sup_vendas = codigo_sup_vendas;
    }

    public String getMicro_regiao() {
        return micro_regiao;
    }

    public void setMicro_regiao(String micro_regiao) {
        this.micro_regiao = micro_regiao;
    }

    public Integer getNumero_codigo() {
        return numero_codigo;
    }

    public void setNumero_codigo(Integer numero_codigo) {
        this.numero_codigo = numero_codigo;
    }

    public String getPdv() {
        return pdv;
    }

    public void setPdv(String pdv) {
        this.pdv = pdv;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCodigo_regional() {
        return codigo_regional;
    }

    public void setCodigo_regional(Integer codigo_regional) {
        this.codigo_regional = codigo_regional;
    }

    public String getNome_pessoa_campo() {
        return nome_pessoa_campo;
    }

    public void setNome_pessoa_campo(String nome_pessoa_campo) {
        this.nome_pessoa_campo = nome_pessoa_campo;
    }
    
    
    
    
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO CREDENCIADOS  "+
" 	(CODIGO_PESSOA_CAMPO,   "+
" 	CODIGO_SUP_REG_OP,      "+
" 	CODIGO_GERENTE,         "+
" 	CODIGO_SUP_OP,          "+
" 	CODIGO_SUP_VENDAS,      "+
" 	CODIGO_MONITOR,         "+
" 	CODIGO_CONSULTOR,       "+
" 	PDV,                    "+
" 	NUMERO_CODIGO,          "+
" 	UF,                     "+
" 	MICRO_REGIAO,           "+
" 	CNPJ                    "+
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
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
        stmt.setInt(1, getCodigo_pessoa_campo());
        stmt.setInt(2, getCodigo_sup_reg_op());
        stmt.setInt(3, getCodigo_gerente());
        stmt.setInt(4, getCodigo_sup_op());
        stmt.setInt(5, getCodigo_sup_vendas());
        stmt.setInt(6, getCodigo_monitor());
        stmt.setInt(7, getCodigo_consultor());
        stmt.setString(8, getPdv());
        stmt.setInt(9, getNumero_codigo());
        stmt.setString(10, getUf());
        stmt.setString(11, getMicro_regiao());
        stmt.setString(12, getCnpj());

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
            comando = "select C.*, P.PESSOA_CAMPO  " +
                    "from CREDENCIADOS C, PESSOAS_CAMPO P "+
                    "where C.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO ";
//                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND C.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
            

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
//******************************************************************************************************************************************    
    
    
    public ResultSet getConsultarCredenciado(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select C.*, P.PESSOA_CAMPO " +
                    "from CREDENCIADOS C, PESSOAS_CAMPO P, REGIONAIS R "+
                    "where C.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "AND C.CODIGO_CREDENCIADO = C.CODIGO_CREDENCIADO  "+
                    "AND P.CODIGO_REGIONAL = R.CODIGO_REGIONAL ";
                    

            int quantParam = 0;


           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND R.CODIGO_REGIONAL = ?";
            }
           if (getNome_pessoa_campo() != null) {
                comando = comando + "AND P.PESSOA_CAMPO like ? ";
            }
            

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getNome_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome_pessoa_campo()+"%");
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    //******************************************************************************************************************************************  
    //******************************************************************************************************************************************  
    //******************************************************************************************************************************************  
    
    
    
    //******************************************************************************************************************************************    
    
    
    public ResultSet getConsultarTelefoneCredenciado(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select T.*, P.PESSOA_CAMPO, C.* " +
                    "from TELEFONES_CAMPO T, PESSOAS_CAMPO P , CREDENCIADOS C "+
                    "where T.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO  "+
                    "AND T.CODIGO_TELEFONE_CAMPO = T.CODIGO_TELEFONE_CAMPO    "+
                    "AND C.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO ";
                    

            int quantParam = 0;


           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND R.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_pessoa_campo() != null) {
                comando = comando + "AND C.CODIGO_PESSOA_CAMPO = ?";
            }
            

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    //******************************************************************************************************************************************  
    //******************************************************************************************************************************************  
    //******************************************************************************************************************************************  
    
    
    
    
    
    
    
    
    
    public ResultSet getConsultarPessoaCredenciado(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select C.* " +
                    "from CREDENCIADOS C "+
                    "where C.CODIGO_CREDENCIADO = C.CODIGO_CREDENCIADO  ";
                    

            int quantParam = 0;


           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
           if (getCodigo_regional() != null) {
                comando = comando + "AND R.CODIGO_REGIONAL = ?";
            }
           if (getCodigo_pessoa_campo() != null) {
                comando = comando + "AND C.CODIGO_PESSOA_CAMPO = ?";
            }
            

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
            }
           if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    //******************************************************************************************************************************************  
    //******************************************************************************************************************************************  
    //******************************************************************************************************************************************  
    
    
    
    
    public ResultSet getConsultarRelatorioCredenciado(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select C.*, P.PESSOA_CAMPO, R.REGIONAL  " +
                    "from CREDENCIADOS C, PESSOAS_CAMPO P, REGIONAIS R "+
                    "where C.CODIGO_PESSOA_CAMPO = P.CODIGO_PESSOA_CAMPO "+
                    "and R.CODIGO_REGIONAL = P.CODIGO_REGIONAL ";
                    

            int quantParam = 0;


           if (getCodigo_pessoa_campo() != null){
               comando = comando + " AND C.CODIGO_PESSOA_CAMPO = ? ";
            }
           if (getCodigo_credenciado() != null) {
                comando = comando + "AND C.CODIGO_CREDENCIADO = ?";
            }
           if (getCodigo_regional() != null){
               comando = comando + " AND R.CODIGO_REGIONAL = ? ";
            }
            

            comando = comando + " order by C.CODIGO_CREDENCIADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCodigo_pessoa_campo() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa_campo());
            }
           if (getCodigo_credenciado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_credenciado());
            }
           if (getCodigo_regional() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_regional());
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

        String comando = "UPDATE CREDENCIADOS "+
" 	SET "+
" 	CODIGO_PESSOA_CAMPO = ?,     "+
" 	CODIGO_SUP_REG_OP = ?,       "+
" 	CODIGO_GERENTE = ?,          "+
" 	CODIGO_SUP_OP = ?,           "+
" 	CODIGO_SUP_VENDAS = ?,       "+
" 	CODIGO_MONITOR = ?,          "+
" 	CODIGO_CONSULTOR = ?,        "+
" 	PDV = ?,                     "+
" 	NUMERO_CODIGO = ?,           "+
" 	UF = ?,                      "+
" 	MICRO_REGIAO = ?,                      "+
" 	CNPJ = ?                     "+
" 	WHERE "+
" 	CODIGO_CREDENCIADO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodigo_pessoa_campo());
        stmt.setInt(2,getCodigo_sup_reg_op());
        stmt.setInt(3,getCodigo_gerente());
        stmt.setInt(4,getCodigo_sup_op());
        stmt.setInt(5, getCodigo_sup_vendas());
        stmt.setInt(6, getCodigo_monitor());
        stmt.setInt(7, getCodigo_consultor());
        stmt.setString(8, getPdv());
        stmt.setInt(9, getNumero_codigo());
        stmt.setString(10, getUf());
        stmt.setString(11, getMicro_regiao());
        stmt.setString(12, getCnpj());
        stmt.setInt(13, getCodigo_credenciado());
        

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

" DELETE FROM CREDENCIADOS  "+
" 	WHERE "+
" 	CODIGO_CREDENCIADO = ?  ";

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
