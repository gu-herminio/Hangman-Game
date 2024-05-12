
package BancoDados;

import BancoDados.ConexaoBancoDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogoforcaa3.Palavras;


public class InteracaoBancoDados {
    
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
}
    

