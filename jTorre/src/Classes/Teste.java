/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lcbenfic
 */
public class Teste {
    
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
    
    public ResultSet getConsultar2(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;
        String datIni = null;
        String datFin = null;
System.out.println("inicio");
        try
        {           
            String comando;
            comando = "select C.*, P.NOME_PESSOA " +
                    "from CONTROLE_LIGACOES_RECEPTIVO C, PESSOAS P "+
                    "where C.CODIGO_PESSOA = P.CODIGO_PESSOA "+
                    "AND C.CODIGO_CONTROLE_LIGACOES_REC = C.CODIGO_CONTROLE_LIGACOES_REC ";
                   

            

            comando = comando + " group by P.NOME_PESSOA ";
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
    
    
    
    
    
    
}
