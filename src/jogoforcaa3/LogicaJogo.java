
package jogoforcaa3;

import java.util.Scanner;


public class LogicaJogo {
      private String palavraChave;
      private String letrasUsadas = "";
      private String palavraAdivinhada = "";
      private int MAX_TENTATIVAS = 10;

    public LogicaJogo(String palavraChave) {
        this.palavraChave = palavraChave;
    }
      
      
    public void executaJogo(){
         for (int i = 0; i < palavraChave.length(); i++) {
            palavraAdivinhada += "_";
            
            for (int tentativas = 0; ; tentativas++) {
                if(tentativas == MAX_TENTATIVAS){
                    //System.out.printf("Foram 10 tentativas... A palavra era '%s'",palavraChave);
                    System.out.println("Foram 10 tentativas... A palavra era "+palavraChave);

                    System.exit(0);
                }
                
                //System.out.printf("Rodada %d. Ate agora advinhada: %s. Qual a sua proxima letra?%n",tentativas,palavraAdivinhada);
                System.out.println("Rodada "+ tentativas+" Ate agora adivinhado: "+palavraAdivinhada);
                
                char letraTentada = new Scanner(System.in).next().charAt(0);
                if (letrasUsadas.indexOf(letraTentada) >= 0){
                    //System.out.printf("Você ja tentou a letra %s.%n",letraTentada);
                    System.out.println("Você ja tentou a letra "+letraTentada+". Digite outra letra.");
                }else{
                    letrasUsadas += letraTentada;
                    if (palavraChave.indexOf(letraTentada) >= 0){
                        palavraAdivinhada = "";
                        
                        for (int j = 0; j < palavraChave.length(); j++) {
                            palavraAdivinhada += letrasUsadas.indexOf(palavraChave.charAt(j)) >= 0 ? palavraChave.charAt(j) : "_";
                            
                        }
                        
                        if (palavraAdivinhada.contains("_")){
                            //System.out.printf("Muito bom! %S existe na palavra. Ainda tem letras escondidas%n",letraTentada);
                            System.out.println("Muito bom! A letra '"+letraTentada+" existe na palavra. Continue para adivinhar as proximas letras.");
                        }else{
                            //System.out.printf("Parabens! A palavra adivinhada era '%s'",palavraAdivinhada);
                            System.out.println("Parabens! A palavra adivinhada era "+palavraAdivinhada);
                            System.exit(0);
                        }
                    }else{
                      //  System.out.printf("Infelizmente a letra %c não existe na palavra.", letraTentada);
                        System.out.println("Infelizmente a letra "+letraTentada+" não existe na palavra.");
                    }
                }
            }
            
        }
        
    }
      
      
      
    
    
}
