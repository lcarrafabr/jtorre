/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/*   
 NOMES DOS BANCOS DE DADOS
 * 
 * CADASTRO_PEND_NOHSBD
 * JTORREDB
 * CONTATOSTORREDB
 * ADERENCIA_AOS_PROCEDIMENTOS
 
 */


/**
 *
 * @author lcbenfic
 */
public class ClassConecta {
    

  public static Connection con = null;
 
 
     public static java.sql.Connection getConnection() throws SQLException {
        String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
        
        String url = "jdbc:ucanaccess://\\\\spws-vm-fs02/sky/sky/siebel/note/1 - AGENTES - TORRE NACIONAL/1 - ATIVIDADES DIARIAS/BASE DE DADOS/CADASTRO_PEND_NOHSBD.accdb";
        
        String username = ""; //leave blank if none
        String password = ""; //leave blank if none    
        
        
        
        try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
      con.setAutoCommit(false);
      System.out.println("Conectado!");
      
     } catch (ClassNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
        try {
      return DriverManager.getConnection(url, username, password);
     } catch (SQLException e) {
      // TODO Auto-generated catch block
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
     return con;
    }
     
     
     
     
     //**************************************************************************************************************************************
     
     public static java.sql.Connection conectajTorre() throws SQLException {
        String driver = "net.ucanaccess.jdbc.UcanaccessDriver";    
        
        String url = "jdbc:ucanaccess://\\\\spws-vm-fs02/sky/sky/siebel/note/1 - AGENTES - TORRE NACIONAL/1 - ATIVIDADES DIARIAS/BASE DE DADOS/JTORREDB.accdb";
        
        String username = ""; //leave blank if none
        String password = ""; //leave blank if none    

        try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
      con.setAutoCommit(false);
      System.out.println("Conectado!");
      
     } catch (ClassNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
        try {
      return DriverManager.getConnection(url, username, password);
     } catch (SQLException e) {
      // TODO Auto-generated catch block
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
     return con;
    }
     
     
      //**************************************************************************************************************************************
     
     public static java.sql.Connection getConectaContatosTorreDB() throws SQLException {
        String driver = "net.ucanaccess.jdbc.UcanaccessDriver";    
        
        String url = "jdbc:ucanaccess://\\\\spws-vm-fs02/sky/sky/siebel/note/1 - AGENTES - TORRE NACIONAL/1 - ATIVIDADES DIARIAS/BASE DE DADOS/CONTATOSTORREDB.accdb";
        
        String username = ""; //leave blank if none
        String password = ""; //leave blank if none    

        try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
      con.setAutoCommit(false);
      System.out.println("Conectado!");
      
     } catch (ClassNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
        try {
      return DriverManager.getConnection(url, username, password);
     } catch (SQLException e) {
      // TODO Auto-generated catch block
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
     return con;
    }
     
     
     
     
     /**************************************************** APENAS PARA CONECAR AO BANCO DE DADOS DE TESTE******************************* */
     
     
     public static java.sql.Connection getConectaBancoTeste() throws SQLException {
        String driver = "net.ucanaccess.jdbc.UcanaccessDriver";    
        
        String url = "jdbc:ucanaccess://\\\\spws-vm-fs02/sky/sky/siebel/note/1 - AGENTES - TORRE NACIONAL/1 - ATIVIDADES DIARIAS/BASE DE DADOS/TESTE.accdb";
        
        String username = ""; //leave blank if none
        String password = ""; //leave blank if none    

        try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
      con.setAutoCommit(false);
      System.out.println("Conectado!");
      
     } catch (ClassNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
        try {
      return DriverManager.getConnection(url, username, password);
     } catch (SQLException e) {
      // TODO Auto-generated catch block
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
     return con;
    }
     
     
     
     
     //**************************************************************************************************************************************
     
     public static java.sql.Connection conectaAderenciaAosprocedimentos() throws SQLException {
        String driver = "net.ucanaccess.jdbc.UcanaccessDriver";    
        
        String url = "jdbc:ucanaccess://\\\\spws-vm-fs02/sky/sky/siebel/note/1 - AGENTES - TORRE NACIONAL/1 - ATIVIDADES DIARIAS/BASE DE DADOS/ADERENCIA_AOS_PROCEDIMENTOS.accdb";
        
        String username = ""; //leave blank if none
        String password = ""; //leave blank if none    

        try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
      con.setAutoCommit(false);
      System.out.println("Conectado!");
      
     } catch (ClassNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
        try {
      return DriverManager.getConnection(url, username, password);
     } catch (SQLException e) {
      // TODO Auto-generated catch block
         JOptionPane.showMessageDialog(null, "Erro na conexão\n"+e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
         System.out.println(e);
     }
     return con;
    }
     
     
   
     
     
     
     
    
}
 
  
     


 