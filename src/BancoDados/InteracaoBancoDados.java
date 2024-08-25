
package BancoDados;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Random;



public class InteracaoBancoDados {
    
    
    private String palavraSorteada;
    
    private final ConexaoBancoDados conexaoBancoDados;
    
    public InteracaoBancoDados(ConexaoBancoDados pConexaoBancoDados){
        this.conexaoBancoDados = pConexaoBancoDados;
    }
    
    
    // Criação tabela 

    

  
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




  
  



