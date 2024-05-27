
package BancoDados;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogoforcaa3.Palavras;
import java.sql.ResultSet;
import java.util.Random;



public class InteracaoBancoDados {
    
    
    private String palavraSorteada;
    
    private final ConexaoBancoDados conexaoBancoDados;
    
    public InteracaoBancoDados(ConexaoBancoDados pConexaoBancoDados){
        this.conexaoBancoDados = pConexaoBancoDados;
    }
    
    
    // Criação tabela 
    public void criarTabelaPalavras(){
        ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
        InteracaoBancoDados criaTabela = new InteracaoBancoDados(conexaoSQLite);
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_palavras"
                + "("
                + "id integer PRIMARY KEY,"
                + "palavra text NOT NULL"
                + ");"; 
    
        
        boolean conectou = false;
        
        try {
           conectou = this.conexaoBancoDados.conectar();
           
           Statement stmt = this.conexaoBancoDados.criarStatement();
           
           stmt.execute(sql);
           System.out.println("Tabela Criada!");
           
        } catch (SQLException e) {            
          
        }finally{
            if(conectou){
                this.conexaoBancoDados.desconectar();
            }
        }
        
    }
    // Insert de registros SQL
    public void inserirRegistrosTabela(){
        ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
        Palavras palavra1 = new Palavras();
        palavra1.setId(1);
        palavra1.setPalavra("Baleia");
        
        conexaoSQLite.conectar();
        
        String sqlInsert = "INSERT INTO tbl_Palavras ("
                + "id,"
                + "palavra"
                + ") VALUES (?,?)"
                + ";";
        
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        
        try {
            preparedStatement.setInt(1, palavra1.getId());
            preparedStatement.setString(2, palavra1.getPalavra());
            
            int resultado = preparedStatement.executeUpdate();
            
            if(resultado ==1){
                System.out.println("Palavra inserida!");
            }else{
                System.out.println("Palavra não inserida!");
            }
            
        } catch (SQLException e) {
                System.out.println("Palavra não inserida!");
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InteracaoBancoDados.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
            
            conexaoSQLite.desconectar();
                    
          
        }
    }
    
  public void consultaRegistrosTabela(){
    ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
    
    ResultSet resultSet = null;
    Statement statement = null;
    
    conexaoSQLite.conectar();
    
    String query = "SELECT * FROM tbl_palavras;";
    
    statement = conexaoSQLite.criarStatement();
    
    try {
        resultSet = statement.executeQuery(query);
            System.out.println("LISTA DE PALAVRAS");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("palavra"));
            System.out.println("------------------");
        }
        
    } catch (SQLException e) {
        System.out.println("Erro");
    } finally {
        try {
            if(resultSet != null)
                resultSet.close();
            if(statement != null)
                statement.close();
            conexaoSQLite.desconectar();
        } catch (SQLException ex) {
            System.out.println("Erro de fechamento.");
        }
    }
  }
  
public String consultaPalavra(){
    ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
    conexaoSQLite.conectar();
    
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String palavra ="";
    
    String sql = "SELECT * " +  
                 "FROM tbl_palavras " + 
                 "WHERE id = ?";
  
    try {
          
        Random random = new Random();
        int idPalavra = random.nextInt(20) + 1;
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
        preparedStatement.setInt(1, idPalavra);
        
        resultSet = preparedStatement.executeQuery(); // Atribuir o resultado da consulta ao resultSet
        palavra = resultSet.getString("palavra");

        
        
    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        try {
            if(resultSet != null)
                resultSet.close();
            if(preparedStatement != null)
                preparedStatement.close();
            conexaoSQLite.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    palavraSorteada = palavra;
    return palavra;
}

public String consultaPalavra(int nivel){
    ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
    conexaoSQLite.conectar();
    
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String palavra ="";
    
    String sql = "SELECT * " +  
                 "FROM tbl_palavras_dificil " + 
                 "WHERE id = ?";
  
    try {
          
        Random random = new Random();
        int idPalavra = random.nextInt(10) + 1;
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
        preparedStatement.setInt(1, idPalavra);
        
        resultSet = preparedStatement.executeQuery(); // Atribuir o resultado da consulta ao resultSet
        palavra = resultSet.getString("palavra");

        
    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        try {
            if(resultSet != null)
                resultSet.close();
            if(preparedStatement != null)
                preparedStatement.close();
            conexaoSQLite.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        palavraSorteada = palavra;
        return palavra;
}


public String consultaDica(){
    
    ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
    conexaoSQLite.conectar();
    
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String palavra = palavraSorteada;
    String tema = "";
    
    String sql = "SELECT * " +  
                 "FROM tbl_palavras " + 
                 "WHERE palavra = '"+palavra+"'";
  
    try {
          
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sql);        
        resultSet = preparedStatement.executeQuery(); // Atribuir o resultado da consulta ao resultSet
        tema = resultSet.getString("tema");

        
    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        try {
            if(resultSet != null)
                resultSet.close();
            if(preparedStatement != null)
                preparedStatement.close();
            conexaoSQLite.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        return tema;


}

public String consultaDica(int nivel){
    
    ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
    conexaoSQLite.conectar();
    
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String palavra = palavraSorteada;
    String tema = "";
    
    String sql = "SELECT * " +  
                 "FROM tbl_palavras_dificil " + 
                 "WHERE palavra = '"+palavra+"'";
  
    try {
          
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sql);        
        resultSet = preparedStatement.executeQuery(); // Atribuir o resultado da consulta ao resultSet
        tema = resultSet.getString("tema");

        
    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        try {
            if(resultSet != null)
                resultSet.close();
            if(preparedStatement != null)
                preparedStatement.close();
            conexaoSQLite.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        return tema;


}


}




  
  



