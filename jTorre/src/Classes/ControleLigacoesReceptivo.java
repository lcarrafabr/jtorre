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
public class ControleLigacoesReceptivo {
    
    private Integer codigo_controle_ligacoes_rec;
    private Integer codigo_pessoa;
    private String solicitante;
    private String data_cadastro;
    private String hora_inicio;
    private String hora_fim;
    private String credenciado;
    private String regional;
    private String motivo;
    private String conseguiu_resolver;
    private String transferiu;
    private int MesRef;
    private int AnoRef;
    private Date dataFinal;
    private Date data_lancamento;

    public Integer getCodigo_controle_ligacoes_rec() {
        return codigo_controle_ligacoes_rec;
    }

    public void setCodigo_controle_ligacoes_rec(Integer codigo_controle_ligacoes_rec) {
        this.codigo_controle_ligacoes_rec = codigo_controle_ligacoes_rec;
    }

    public Integer getCodigo_pessoa() {
        return codigo_pessoa;
    }

    public void setCodigo_pessoa(Integer codigo_pessoa) {
        this.codigo_pessoa = codigo_pessoa;
    }

    public String getConseguiu_resolver() {
        return conseguiu_resolver;
    }

    public void setConseguiu_resolver(String conseguiu_resolver) {
        this.conseguiu_resolver = conseguiu_resolver;
    }

    public String getCredenciado() {
        return credenciado;
    }

    public void setCredenciado(String credenciado) {
        this.credenciado = credenciado;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTransferiu() {
        return transferiu;
    }

    public void setTransferiu(String transferiu) {
        this.transferiu = transferiu;
    }

    public int getAnoRef() {
        return AnoRef;
    }

    public void setAnoRef(int AnoRef) {
        this.AnoRef = AnoRef;
    }

    public int getMesRef() {
        return MesRef;
    }

    public void setMesRef(int MesRef) {
        this.MesRef = MesRef;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
    
    
    
    
    
    
    public void setCadastrar(){
  try{


        String comando = "INSERT INTO CONTROLE_LIGACOES_RECEPTIVO  "+
" 	(CODIGO_PESSOA,         "+
" 	SOLICITANTE,            "+
" 	DATA,                   "+
" 	HORA_INICIO,            "+
" 	HORA_FIM,               "+
" 	CREDENCIADO,            "+
" 	REGIONAL,               "+
" 	MOTIVO,                 "+
" 	CONSEGUIU_RESOLVER,     "+
" 	TRANSFERIU              "+
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
       
//        String oDataCadastro = null;
//        if (getData_cadastro() != null){
//          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//          oDataCadastro = oDatOut.format(getData_cadastro());
//        }
      
        stmt.setInt(1, getCodigo_pessoa());
        stmt.setString(2, getSolicitante());
        stmt.setString(3, getData_cadastro());
        stmt.setString(4, getHora_inicio());
        stmt.setString(5, getHora_fim());
        stmt.setString(6, getCredenciado());
        stmt.setString(7, getRegional());
        stmt.setString(8, getMotivo());
        stmt.setString(9, getConseguiu_resolver());
        stmt.setString(10, getTransferiu());

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
                   

            int quantParam = 0;
            
            
            if (getCodigo_controle_ligacoes_rec() != null){
               comando = comando + " AND C.CODIGO_CONTROLE_LIGACOES_REC = ? ";
            }
            if ( getData_cadastro() != null){
               comando = comando + " AND C.DATA = ? ";
               }
            
            

            comando = comando + " order by C.CODIGO_CONTROLE_LIGACOES_REC ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);
            
            
            if (getCodigo_controle_ligacoes_rec() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_controle_ligacoes_rec());
            }
            if ( getData_cadastro() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getData_cadastro() );
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

        String comando = "UPDATE CONTROLE_LIGACOES_RECEPTIVO "+
" 	SET "+
" 	CODIGO_PESSOA = ?,          "+
" 	SOLICITANTE = ? ,           "+
" 	DATA = ? ,                  "+
" 	HORA_INICIO = ? ,           "+
" 	HORA_FIM = ? ,              "+
" 	CREDENCIADO = ? ,           "+
" 	REGIONAL = ? ,              "+
" 	MOTIVO = ? ,                "+
" 	CONSEGUIU_RESOLVER = ? ,    "+
" 	TRANSFERIU = ?              "+
" 	WHERE "+
" 	CODIGO_CONTROLE_LIGACOES_REC = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        
//        String oDataCadastro = null;
//        if (getData_cadastro() != null){
//          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//          oDataCadastro = oDatOut.format(getData_cadastro());
//        }

        stmt.setInt(1,getCodigo_pessoa());
        stmt.setString(2,getSolicitante());
        stmt.setString(3,getData_cadastro());
        stmt.setString(4, getHora_inicio());
        stmt.setString(5, getHora_fim());
        stmt.setString(6, getCredenciado());
        stmt.setString(7, getRegional());
        stmt.setString(8, getMotivo());
        stmt.setString(9, getConseguiu_resolver());
        stmt.setString(10, getTransferiu());
        stmt.setInt(11, getCodigo_controle_ligacoes_rec());

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

" DELETE FROM CONTROLE_LIGACOES_RECEPTIVO  "+
" 	WHERE "+
" 	CODIGO_CONTROLE_LIGACOES_REC = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodigo_controle_ligacoes_rec());


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
    
    
    public ResultSet getConsultarRelatorioReceptivo2(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT P.NOME_PESSOA, COUNT(P.NOME_PESSOA) AS TOTAL "+
                      "from CONTROLE_LIGACOES_RECEPTIVO C, PESSOAS P "+
                      "where P.CODIGO_PESSOA = C.CODIGO_PESSOA "+
                      "GROUP BY P.NOME_PESSOA ";
                             

            comando = comando + "HAVING COUNT(*) >0 ";
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

            
            int quantParam = 0;

           
           if (getCodigo_pessoa() != null){
               comando = comando + " AND P.CODIGO_PESSOA = ? ";
            }
           if ( getData_cadastro() != null){
               comando = comando + " AND C.DATA = ? ";
               }
                   

            

            comando = comando + " ORDER by P.CODIGO_PESSOA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);
            
            if (getCodigo_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodigo_pessoa());
            }
            if ( getData_cadastro() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getData_cadastro() );
               }

            

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    
    
    
    
}// fim da classe
