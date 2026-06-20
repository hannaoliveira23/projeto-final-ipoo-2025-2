import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Sua responsabilidade é armazenar e gerenciar os valores numéricos de progresso do jogador (pontuação e fragmentos).
 */
public class Placar
{
    // variáveis estáticas que armazenam o estado "global" do jogo
    private static int pontuacaoTotal = 0;
    private static int fragmentosColetados = 0;
    private static final int PONTOS_POR_FRAGMENTO = 50; // além de estática, é constante, pois os pontos por fragmento não devem mudar

    private static List<DadosFase> dadosDasFases = new ArrayList<>(); // lista para armazenar objetos DadosFase
    private static int tempoTotalDeJogo = 0;

    /**
     * Adiciona uma quantidade de pontos arbitrária a pontuação total.
     * @param pontos O valor inteiro a ser adicionado.
     */
    public static void adicionarPontos(int pontos)
    {
        pontuacaoTotal += pontos;
    }

    /**
     * Incrementa a contagem de fragmentos e adiciona a pontuação correspondente.
     */
    public static void coletarFragmento()
    {
        fragmentosColetados++;
        pontuacaoTotal += PONTOS_POR_FRAGMENTO;
    }

    /**
     * Decrementa a contagem de fragmentos, usado para o disparo da guardiã (munição).
     * Inclui validação para evitar placar negativo.
     */
    public static void gastarMunicao()
    {
        if (fragmentosColetados > 0) {
            fragmentosColetados--;
        }
    }

    /**
     * @return Pontuação acumulada do jogador.
     */
    public static int getPontuacaoTotal()
    {
        return pontuacaoTotal;
    }

    /**
     * @return Número de fragmentos coletados.
     */
    public static int getFragmentosColetados()
    {
        return fragmentosColetados;
    }

    /**
     * Reseta todos os dados para um novo jogo.
     */
    public static void resetarJogo()
    {
        pontuacaoTotal = 0;
        fragmentosColetados = 0;

        dadosDasFases.clear();
        tempoTotalDeJogo = 0;
    }

    /**
     * Dobra a pontuação total do jogador.
     */
    public static void dobrarPontuacao()
    {
        pontuacaoTotal *= 2;
    }

    /**
     * Registra a pontuação e o tempo ao finalizar uma fase.
     */
    public static void registrarFase(String nome, int pontosFase, int tempoFase)
    {
        dadosDasFases.add(new DadosFase(nome, pontosFase, tempoFase));
        tempoTotalDeJogo += tempoFase;
    }

    /**
     * @return Os dados detalhados de todas as fases.
     */
    public static List<DadosFase> getDadosDasFases()
    {
        return dadosDasFases;
    }

    /**
     * @return O tempo total de jogo.
     */
    public static int getTempoTotalDeJogo()
    {
        return tempoTotalDeJogo;
    }
}