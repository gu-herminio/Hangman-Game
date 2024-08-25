package BancoDados;

//Importação de bibliotecas principais para execução da tela de execução do jogo
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ConexaoBancoDados {
    private Connection conexao = null;
    
 
    public boolean conectar(){

        try {
            String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";
            this.conexao = DriverManager.getConnection(url);
            
            
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        
        System.out.println("Conectado.");
        
        return true;
    
    }
    
    public boolean desconectar(){
        
        try{
            if(this.conexao.isClosed() == false){
                this.conexao.close();
            }
            
        }catch(SQLException e){
           System.err.println(e.getMessage());
           return false;
        }
        
        System.out.println("Desconectado.");
        
        return true;
    
    }
    
  
    
    public Statement criarStatement(){
        try {
               return this.conexao.createStatement();
        } catch (SQLException e) {
                return null;
        
        }
    
    }
    
    
    public PreparedStatement criarPreparedStatement(String sql){
        try {
               return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
                return null;
        
        }
    
    }
        
    public Connection getConexao(){
        return this.conexao;
    
    }
    
   
}

    
    
        
        
    
    
    
    

