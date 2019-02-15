/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lcbenfic
 */
public class CadastroPendentes {
    
    private int cod_cadastro;
    private Integer customer;
    private String nome_clientes;
    private String protocolo;
    private String data_abertura;
    private String regional;
    private String vencido;
    private String descricao;

    public int getCod_cadastro() {
        return cod_cadastro;
    }

    public void setCod_cadastro(int cod_cadastro) {
        this.cod_cadastro = cod_cadastro;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome_clientes() {
        return nome_clientes;
    }

    public void setNome_clientes(String nome_clientes) {
        this.nome_clientes = nome_clientes;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getVencido() {
        return vencido;
    }

    public void setVencido(String vencido) {
        this.vencido = vencido;
    }
    
    
    
    public void setCadastrar(){
  try{
        String comando = "INSERT INTO CADASTRO_PENDENTE1  "+
//" 	(COD_CADASTROS,     "+ 
" 	(CUSTOMER,           "+
" 	NOME_CLIENTE,       "+
" 	PROTOCOLO_ABERTURA, "+
" 	DATA_ABERTURA,      "+
" 	REGIONAL,           "+
" 	VENCIDO,            "+
" 	PROBLEMA            "+
" 	) "+
" 	VALUES "+
//" 	(16,  "+
" 	(?,  "+
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
        
        
//        String oDataCadastro = null;
//        if (getData_abertura() != null){
//          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
//          oDataCadastro = oDatOut.format(getData_abertura());
//        }

        stmt.setInt(1, getCustomer());
        stmt.setString(2, getNome_clientes());
        stmt.setString(3, getProtocolo());
        stmt.setString(4, getData_abertura());
        stmt.setString(5, getRegional());
        stmt.setString(6, getVencido());
        stmt.setString(7, getDescricao());

        stmt.execute();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

   

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
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
                    "from CADASTRO_PENDENTE1 "+
                    "where COD_CADASTROS = COD_CADASTROS ";
                    

            int quantParam = 0;


           if (getCod_cadastro() != 0){
               comando = comando + " AND COD_CADASTROS = ? ";
            }
           if (getCustomer() != null) {
                comando = comando + "AND CUSTOMER like ?";
            }
           if (getNome_clientes() != null) {
                comando = comando + "AND NOME_CLIENTE like ?";
            }
           if (getProtocolo() != null) {
                comando = comando + "AND PROTOCOLO_ABERTURA like ?";
            }
           

            comando = comando + " order by COD_CADASTROS ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_cadastro() != 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_cadastro());
            }
           if (getCustomer() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getCustomer()+"%");
            }
           if (getNome_clientes() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome_clientes()+"%");
            }
           if (getProtocolo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getProtocolo()+"%");
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

        String comando = "UPDATE CADASTRO_PENDENTE1 "+
" 	SET "+
" 	CUSTOMER = ?,               "+
" 	NOME_CLIENTE = ? ,          "+
" 	PROTOCOLO_ABERTURA = ? ,    "+
" 	DATA_ABERTURA = ? ,         "+
" 	REGIONAL = ? ,              "+
" 	VENCIDO = ? ,               "+
" 	PROBLEMA = ?                "+
" 	WHERE "+
" 	COD_CADASTROS = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCustomer());
        stmt.setString(2,getNome_clientes());
        stmt.setString(3,getProtocolo());
        stmt.setString(4,getData_abertura());
        stmt.setString(5, getRegional());
        stmt.setString(6, getVencido());
        stmt.setString(7, getDescricao());
        stmt.setInt(8, getCod_cadastro());

        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);
        
        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }


    }
    
    public ResultSet getContaregistros(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select COUNT(COD_CADASTROS) " +
                    "from CADASTRO_PENDENTE1 ";

//            comando = comando + " order by COD_CADASTROS ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    public ResultSet getContaregistrosVencidos(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select COUNT(VENCIDO) " +
                    "from CADASTRO_PENDENTE1 "+
                    " where VENCIDO = 'SIM' ";
           
            comando = comando + " GROUP by VENCIDO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

        resultSet = stmtQuery.executeQuery();

        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    public ResultSet getContaregistrosNoPrazo(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select COUNT(VENCIDO) " +
                    "from CADASTRO_PENDENTE1 "+
                    " where VENCIDO = 'NÃO' ";
           
            comando = comando + " GROUP by VENCIDO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

        resultSet = stmtQuery.executeQuery();

        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    public void setExcluir(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM CADASTRO_PENDENTE1  ";


       PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

//        stmt.setInt(1,getCod_cadastro());


        stmt.executeUpdate();
        
        ClassConecta.con.commit();
        ClassConecta.con.setAutoCommit(true);

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "Todos os registros do banco de dados\n foram excluídos com sucesso!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    
    
} // fim da classe
