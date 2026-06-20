/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela armazena o resultado (pontuação e tempo) de uma única fase.
 */
public class DadosFase
{
    public int pontuacao;
    public int tempoEmSegundos;
    public String nomeFase;

    /**
     * Construtor que recebe o nome, os pontos e o tempo da fase.
     */
    public DadosFase(String nomeFase, int pontos, int tempo)
    {
        this.nomeFase = nomeFase;
        this.pontuacao = pontos;
        this.tempoEmSegundos = tempo;
    }
}