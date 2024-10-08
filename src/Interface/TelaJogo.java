
package Interface;


//Importação de bibliotecas principais para execução da tela de execução do jogo
import BancoDados.ConexaoBancoDados;
import BancoDados.InteracaoBancoDados;
import static Interface.TelaNiveis.nivel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import jogoforcaa3.AudioManager;



//Inicialização dos atributos necessários para os métodos pertencentes a classe TelaJogo
public class TelaJogo extends javax.swing.JFrame {
    private String palavraChave;
    private StringBuilder palavraAdivinhada;
    private String letrasUsadas;
    private int tentativasRestantes;
    ConexaoBancoDados conexaoSQLite = new ConexaoBancoDados();
    InteracaoBancoDados interacaoBanco = new InteracaoBancoDados(conexaoSQLite);
    int n = nivel;
    int numImg = 1;
    String statusGame;
    
    
    
    // Inicialização de tela de gameplay e verificação de qual nível foi selecionado através da tela anterior TelaNiveis
    public TelaJogo() {
        
        initComponents();
        setIcon();
        
        if (n == 2){
            iniciarJogo(2);

        }else{
            iniciarJogo();
        
        }
        
        inserirImagemJogo();
    }
   
    //Inicialização do método IniciarJogo que realiza consulta na base de dados do game para retornar palavra sorteada de acordo com o nível Fácil que 
    //foi selecionado na classe anterior TelaNiveis
   
    private void iniciarJogo() {
        palavraChave = interacaoBanco.consultaPalavra();
        palavraAdivinhada = new StringBuilder("-".repeat(palavraChave.length()));
        dicaPalavra2.setText(interacaoBanco.consultaDica());
        letrasUsadas = "";
        tentativasRestantes = 7;
        
        atualizarPalavraForca();
    }
    
    //Inicialização do método IniciarJogo que realiza consulta na base de dados do game para retornar palavra sorteada de acordo com o 
    //nível Difícil que foi selecionado na classe anterior TelaNiveis
     private void iniciarJogo(int nivel) {
        palavraChave = interacaoBanco.consultaPalavra(nivel);
        palavraAdivinhada = new StringBuilder("-".repeat(palavraChave.length()));
        dicaPalavra2.setText(interacaoBanco.consultaDica(nivel));
        letrasUsadas = "";
        tentativasRestantes = 5;
        
        atualizarPalavraForca();
    }
    
    //Atualização da palvra sorteada do jogo
    private void atualizarPalavraForca() {
        palavraForca.setText(palavraAdivinhada.toString());
        //palavraForca.setText("Letras Usadas: " + letrasUsadas);
        labelTentativa.setText("Tentativas Restantes: " + tentativasRestantes);
    }

    //Método para captura das letras selecionadas e verificação de entrada de dados usuário.
    private void registrarTentativa() {
    String texto = inputLetra.getText().toLowerCase();
    if (texto.length() == 1 && Character.isLetter(texto.charAt(0))) {
        char letra = texto.charAt(0);
        realizarTentativa(letra);
    } else {
        labelFeedback.setText("Por favor, digite apenas uma letra válida.");
    }
    inputLetra.setText(""); // Limpar o campo de entrada após a tentativa
}

    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        palavraForca = new javax.swing.JLabel();
        inputLetra = new javax.swing.JTextField();
        dicaPalavra = new javax.swing.JLabel();
        labelTentativa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        palavraForca1 = new javax.swing.JLabel();
        labelFeedback = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        dicaLabel = new javax.swing.JLabel();
        dicaPalavra2 = new javax.swing.JLabel();
        imagemJogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman by The Snakes INC");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(46, 51, 47));

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo hangman.jpg"))); // NOI18N
        logo2.setText("tese");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hangman_1.png"))); // NOI18N
        jLabel1.setToolTipText("");

        palavraForca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        palavraForca.setForeground(new java.awt.Color(204, 204, 204));
        palavraForca.setText("_");

        inputLetra.setBackground(new java.awt.Color(46, 51, 47));
        inputLetra.setDocument(new javax.swing.text.PlainDocument());
        inputLetra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        inputLetra.setForeground(new java.awt.Color(255, 255, 255));
        inputLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLetraActionPerformed(evt);
            }
        });

        dicaPalavra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dicaPalavra.setForeground(new java.awt.Color(204, 204, 204));

        labelTentativa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTentativa.setForeground(new java.awt.Color(204, 204, 204));
        labelTentativa.setText("Tentativas Restantes:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Digite uma letra:");

        jlabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jlabel6.setForeground(new java.awt.Color(204, 204, 204));
        jlabel6.setText("Retorno:");

        palavraForca1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        palavraForca1.setForeground(new java.awt.Color(204, 204, 204));
        palavraForca1.setText("Palavra:");

        labelFeedback.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelFeedback.setForeground(new java.awt.Color(204, 204, 204));

        botaoVoltar.setBackground(new java.awt.Color(45, 197, 85));
        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoVoltar.setForeground(new java.awt.Color(0, 0, 0));
        botaoVoltar.setText("VOLTAR");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        dicaLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dicaLabel.setForeground(new java.awt.Color(204, 204, 204));
        dicaLabel.setText("Dica:");

        dicaPalavra2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dicaPalavra2.setForeground(new java.awt.Color(204, 204, 204));
        dicaPalavra2.setText("teste");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTentativa)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dicaPalavra)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(palavraForca1)
                                .addGap(18, 18, 18)
                                .addComponent(palavraForca))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlabel6)
                                .addGap(18, 18, 18)
                                .addComponent(labelFeedback))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dicaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dicaPalavra2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagemJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(471, Short.MAX_VALUE)
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(445, 445, 445))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(palavraForca)
                            .addComponent(palavraForca1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel6)
                            .addComponent(labelFeedback))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dicaLabel)
                            .addComponent(dicaPalavra2)))
                    .addComponent(imagemJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dicaPalavra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelTentativa)
                        .addGap(107, 107, 107)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Ao pressionar o botão Enter após digitar uma letra, executa o método registrarTentativa()
    private void inputLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLetraActionPerformed
        // TODO add your handling code here:
                registrarTentativa();

    }//GEN-LAST:event_inputLetraActionPerformed

    // Retorna a tela principal (Classe TelaPrincipal)
    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    // Insere a primeira imagem do jogo para indicar a quantidade de tentativas restantes
    private void inserirImagemJogo() {
        ImageIcon imagem = new ImageIcon(getClass().getResource("/images/1.png"));
        imagem.setImage(imagem.getImage().getScaledInstance(imagemJogo.getWidth(), imagemJogo.getHeight(), 1));
        imagemJogo.setIcon(imagem);
        
        }
    
    // Atualiza a imagem do jogo para indicar a quantidade de tentativas restantes
    private void inserirImagemJogo(int numImg) {
        // Carregando a imagem da pasta resources ou qualquer outro diretório
        String url = "/images/"+numImg+".png";
        ImageIcon imagem = new ImageIcon(getClass().getResource(url));
        imagem.setImage(imagem.getImage().getScaledInstance(imagemJogo.getWidth(), imagemJogo.getHeight(), 1));
        imagemJogo.setIcon(imagem);
        
        }
    
    // Atualiza a imagem do jogo para de acordo com o final do jogo.
    private void inserirImagemJogo(String nomIMG){
        String url = "/images/"+nomIMG+".png";
        ImageIcon imagem = new ImageIcon(getClass().getResource(url));
        imagem.setImage(imagem.getImage().getScaledInstance(imagemJogo.getWidth(), imagemJogo.getHeight(), 1));
        imagemJogo.setIcon(imagem);
    }
    
    // Validação de palavras inseridas pelo usuário e confirmação final do jogo.
     private void realizarTentativa(char letraTentada) {
        if (letrasUsadas.contains(String.valueOf(letraTentada))) {
            labelFeedback.setText("Você já tentou a letra '" + letraTentada + "'. Digite outra letra.");
        } else {
            letrasUsadas += letraTentada;
            if (palavraChave.contains(String.valueOf(letraTentada))) {
                for (int i = 0; i < palavraChave.length(); i++) {
                    if (palavraChave.charAt(i) == letraTentada) {
                        palavraAdivinhada.setCharAt(i, letraTentada);
                    }
                }
                if (!palavraAdivinhada.toString().contains("-")) {
                    // Feedback de vencimento do jogo
                    labelFeedback.setText("Parabéns, Você acertou! A palavra é " + palavraChave + ".");
                    statusGame = "You win";
                    inserirImagemJogo(statusGame);
                    AudioManager.getInstance().pararAudio();
                    tocarAudio(statusGame);
                    inputLetra.setEnabled(false);

                    // Insere feedback de confirmação de acerto do usuário.
                } else {
                    labelFeedback.setText("Muito bom! A letra '" + letraTentada + "' existe na palavra.");
                }
            } else {
                tentativasRestantes--;
                if (tentativasRestantes == 0) {
                    // Feedback de perda do jogo
                    labelFeedback.setText("Você esgotou suas tentativas. A palavra era " + palavraChave + ".");
                    statusGame = "You lose";
                    inserirImagemJogo(statusGame);
                    AudioManager.getInstance().pararAudio();
                    tocarAudio(statusGame);
                    inputLetra.setEnabled(false);
                    // Insere feedback de erro de entrada de dados do usuário.
                } else {
                    labelFeedback.setText("A letra '" + letraTentada + "' não existe na palavra. Tente outra letra.");
                    
                    if (nivel == 2){
                    numImg+=2;
                    inserirImagemJogo(numImg);
                    }else{
                    numImg+=1;
                    inserirImagemJogo(numImg);
                    }
                    
                }
            }
        }
        atualizarPalavraForca();
    }
     
     // Executa áudio de feedback final do jogo
  public void tocarAudio(String audio) {
    try {
        String url = "/Sounds/"+audio+".wav";
        AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(getClass().getResourceAsStream(url));
        
        Clip clip = AudioSystem.getClip();
        
        clip.open(audioInputStream);
        
        clip.start();
        
       
       
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        e.printStackTrace();
    }
}

   
     
     

    
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel dicaLabel;
    private javax.swing.JLabel dicaPalavra;
    private javax.swing.JLabel dicaPalavra2;
    private javax.swing.JLabel imagemJogo;
    public static javax.swing.JTextField inputLetra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel labelFeedback;
    private javax.swing.JLabel labelTentativa;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel palavraForca;
    private javax.swing.JLabel palavraForca1;
    // End of variables declaration//GEN-END:variables

    // Método para inserção de logo no JFrame do jogo.

    private void setIcon() {
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo hangman.png")));
    }
    
    // Método Set para inserir a palavra sorteada pelo banco na classe InteracaoBancoDados
    public void setPalavraForca(String palavra) {
       palavraForca.setText(palavra);
    }

}

