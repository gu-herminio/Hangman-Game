package jogoforcaa3;

import BancoDados.ConexaoBancoDados;
import BancoDados.InteracaoBancoDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import org.sqlite.SQLiteException;

public class JogoForcaA3 {

  
    public static void main(String[] args) {
        ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
        InteracaoBancoDados interacaoBanco = new InteracaoBancoDados(conexaoSQLite);
        interacaoBanco.criarTabelaPalavras();
        interacaoBanco.inserirRegistrosTabela();
        

       
                
                
                

        
        //LogicaJogo jogo = new LogicaJogo("arroz");
        //jogo.executaJogo();
        
    
}
    
}
