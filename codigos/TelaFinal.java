import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.Color;
import greenfoot.Font;
import java.util.List;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * É o mundo que exibe o resultado final do jogo (vitória ou derrota).
 */
public class TelaFinal extends World
{
    // constante (variável imutável) que armazena o resultado final.
    private final boolean vitoria;

    /**
     * Construtor para objetos da classe TelaFinal.
     * @param pontuacaoTotal    A pontuação final do jogador.
     * @param resultadoVitoria  Indica se o jogador venceu (true) ou perdeu (false).
     */
    public TelaFinal(int pontuacaoTotal, boolean resultadoVitoria)
    {
        super(800, 560, 1); 
        this.vitoria = resultadoVitoria;
        
        prepararFundo();
        exibirMensagem();
        
        tocarSomResultado();
    }
    
    /**
     * Toca o som de vitória ou derrota baseado no resultado.
     */
    private void tocarSomResultado()
    {
        if (vitoria) {
            Greenfoot.playSound("won.wav");
        } else {
            Greenfoot.playSound("lost.wav");
        }
    }
    
    /**
     * Prepara a cor de fundo com base no resultado do jogo (verde em vitória, vermelho em derrota).
     */
    private void prepararFundo()
    {
        Color corFundo = vitoria 
                         ? new greenfoot.Color(100, 200, 100)  // vitória (verde claro)
                         : new greenfoot.Color(200, 100, 100); // derrota (vermelho claro)
        
        getBackground().setColor(corFundo);
        getBackground().fill();
    }
    
    /**
     * Desenha o título, a pontuação total, o tempo total, a tabela de resultados por fase e a instrução para reiniciar.
     */
    private void exibirMensagem()
    {
        String titulo = vitoria ? "VOCÊ VENCEU!" : "GAME OVER";
        String instrucao = "Pressione [ESPAÇO] para jogar novamente";
        
        int pontuacaoTotal = Placar.getPontuacaoTotal();
        int tempoTotal = Placar.getTempoTotalDeJogo();
        
        // exibe o texto com a cor preta
        getBackground().setColor(Color.BLACK); 
        
        // exibe o título
        getBackground().setFont(new Font(48));
        getBackground().drawString(titulo, getWidth()/2 - 140, 50);
        
        // exibe pontuação e tempo total
        getBackground().setFont(new Font(28));
        getBackground().drawString("Pontuação Total: " + pontuacaoTotal, 50, 100);
        getBackground().drawString("Tempo Total de Jogo: " + tempoTotal + "s", 450, 100);
        
        // exibe a tabela de resultados por fase
        int linhaY = 150;
        int colunaNome = 50;
        int colunaPontos = 300;
        int colunaTempo = 500;

        // cabeçalho
        getBackground().setFont(new Font(true, false, 24));
        getBackground().drawString("FASE", colunaNome, linhaY);
        getBackground().drawString("PONTOS", colunaPontos, linhaY);
        getBackground().drawString("TEMPO (s)", colunaTempo, linhaY);
        
        linhaY += 30;
        getBackground().setColor(Color.DARK_GRAY);
        getBackground().drawLine(colunaNome, linhaY, colunaTempo + 150, linhaY);
        getBackground().setColor(Color.BLACK);

        getBackground().setFont(new Font(false, false, 22));
        
        // percorre a lista de DadosFase armazenada no Placar
        for (DadosFase dados : Placar.getDadosDasFases()) {
            linhaY += 30;
            getBackground().drawString(dados.nomeFase, colunaNome, linhaY);
            getBackground().drawString(String.valueOf(dados.pontuacao), colunaPontos, linhaY);
            getBackground().drawString(String.valueOf(dados.tempoEmSegundos), colunaTempo, linhaY);
        }
        
        // exibe a instrução para reiniciar
        getBackground().setFont(new Font(24));
        getBackground().drawString(instrucao, getWidth()/2 - 235, 510);
    }

    /**
     * Recebe a entrada do teclado para reiniciar o jogo.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) {
            // reseta o placar
            Placar.resetarJogo();
            
            // volta para o mundo de jogo (primeira fase)
            Greenfoot.setWorld(new Fase1()); 
        }
    }
}