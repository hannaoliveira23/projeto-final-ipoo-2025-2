import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootSound;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * É a superclasse que reúne os métodos comuns para qualquer fase do jogo.
 */
public class MundoJogo extends World
{ 
    // o gerenciamento de vidas da guardiã é feito no mundo
    private int vidasGlobais = 3; 

    // objeto que controla o som de fundo
    private GreenfootSound musicaFundo;

    // controla se a chave já foi colocada
    private boolean chaveSpawnada = false;

    // posições dos 4 pontos onde os fragmentos serão spawnados (onde eles nascem)
    private List<int[]> spawnPointsFragmentos = new ArrayList<>();

    // configurações de tempo
    private static final int FPS = 60;
    private int timerCiclos = 0; 

    // pontuação total antes da fase, para calcular o ganho
    private int pontuacaoTotalAntesDaFase = 0;

    /**
     * Construtor para o mundo do jogo.
     */
    public MundoJogo()
    { 
        super(1000, 600, 1);

        prepararFundo();
        configurarSpawnPoints(); 
        adicionarFragmentos();
        criarGuardia();
        criarInimigos();
        prepararCenario();

        // cria o objeto de som
        musicaFundo = new GreenfootSound("fundo.wav");
        musicaFundo.setVolume(62); // ajusta o volume
        musicaFundo.playLoop(); // começa a tocar a música

        pontuacaoTotalAntesDaFase = Placar.getPontuacaoTotal();
    }

    /**
     * Retorna a vida da guardiã.
     */
    public int getVidas()
    {
        return vidasGlobais;
    }

    /**
     * Implementa a perda de vida da guardiã.
     */
    public void perderVida()
    {
        if (vidasGlobais > 0) {
            this.vidasGlobais--;

            Guardia g = getGuardia();
            if (g != null) {
                removeObject(g); 
            }
        }
    }

    /**
     * Adiciona uma vida à guardiã, se ela já não tiver atingido seu limite.
     */
    public void ganharVida()
    {
        if (vidasGlobais < 3) {
            this.vidasGlobais++;
        }
    }

    /**
     * Ciclo do mundo do jogo.
     */
    public void act()
    {
        timerCiclos++;

        desenharHUD();
        checarColetaCompleta();
        checarTrocaDeFase();

        checarEstadoGuardia();
    }

    /**
     * Gerencia o respawn (se a guardiã foi removida mas ainda possui vidas) e o game over (se ela foi removida e não possui vidas).
     */
    private void checarEstadoGuardia()
    {
        Guardia g = getGuardia();
        if (g == null) {
            if (vidasGlobais > 0) {
                criarGuardia();
            } else {
                checarGameOver();
            }
        }
    }

    /**
     * Checa se as vidas da guardiã foram zeradas e registra o resultado da fase atual (derrota).
     */
    private void checarGameOver()
    {
        if (vidasGlobais <= 0) {
            registrarResultadoFase(" (Derrota)"); 

            musicaFundo.stop();
            Greenfoot.setWorld(new TelaFinal(Placar.getPontuacaoTotal(), false));
        }
    }

    /**
     * Pausa a música ao clicar em "Pause".
     */
    @Override
    public void stopped()
    {
        musicaFundo.pause();
    }

    /**
     * Toca a música.
     */
    @Override
    public void started()
    {
        musicaFundo.playLoop();
    }

    /**
     * Desenha o heads-up display.
     */
    public void desenharHUD()
    {
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect(0, 0, getWidth(), 60);

        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font("Arial", true, false, 22));

        // pontos e vidas
        getBackground().drawString("Pontos: " + Placar.getPontuacaoTotal(), 20, 40);
        getBackground().drawString("Vidas: " + getVidas(), 850, 40); 

        // fragmentos e tempo
        int totalFragmentosDaFase = spawnPointsFragmentos.size();
        int fragmentosColetadosNestaFase = totalFragmentosDaFase - getObjects(FragmentoMagico.class).size();
        int segundosPassados = timerCiclos / FPS;

        getBackground().drawString("Fragmentos: " + fragmentosColetadosNestaFase + "/" + totalFragmentosDaFase, 350, 40);
        getBackground().drawString("Tempo: " + segundosPassados + "s", 600, 40);
    }

    /**
     * Prepara o fundo do mundo do jogo.
     */
    private void prepararFundo()
    {
        GreenfootImage fundo = new GreenfootImage("fundo_menu.png");
        fundo.scale(getWidth(), getHeight());
        setBackground(fundo);
    }

    /**
     * Adiciona os fragmentos nos pontos da lista.
     */
    private void adicionarFragmentos()
    {
        for (int[] p : spawnPointsFragmentos) {
            addObject(new FragmentoMagico(), p[0], p[1]);
        }
    }

    /**
     * Adiciona um ponto de spawn na lista.
     */
    protected void adicionarSpawnPoint(int x, int y)
    {
        spawnPointsFragmentos.add(new int[]{x, y});
    }

    /**
     * Tenta encontrar a guardiã no mundo.
     * @return null, se ela não está; objeto Guardia, caso contrário.
     */
    protected Guardia getGuardia()
    {
        List<Guardia> lista = getObjects(Guardia.class);
        return lista.isEmpty() ? null : lista.get(0);
    }

    /**
     * Define os pontos de spawn dos fragmentos. Está vazio por padrão.
     */
    public void configurarSpawnPoints() { }

    /**
     * Cria a guardiã. A fase define onde.
     */
    public void criarGuardia() { }

    /**
     * Adiciona os inimigos. A fase decide quantos e onde.
     */
    public void criarInimigos() { }

    /**
     * Define a próxima fase. Deve ser sobrescrito por cada fase.
     * @return null, por padrão.
     */
    public World proximaFase()
    {
        return null;
    }

    /**
     * Retorna a posição (X,Y) onde a chave deve ser spawnada. Pode ser sobrescrito pelas subclasses.
     * @return um array de int com {X,Y}.
     */
    protected int[] getPosicaoSpawnChave()
    {
        return new int[]{getWidth() / 2, getHeight() / 2}; 
    }

    /**
     * Checa a coleta de todos os fragmentos antes de spawnar a chave.
     */
    protected void checarColetaCompleta()
    {
        if (!chaveSpawnada && getObjects(FragmentoMagico.class).isEmpty()) {
            int[] posChave = getPosicaoSpawnChave();
            addObject(new Chave(), posChave[0], posChave[1]);
            chaveSpawnada = true;
        }
    }

    /**
     * Checa se a chave já foi spawnada E coletada, para o avanço de fase.
     */
    private void checarTrocaDeFase()
    {
        if (chaveSpawnada && getObjects(Chave.class).isEmpty()) {
            World prox = proximaFase();
            if (prox != null) {
                registrarResultadoFase(""); // sem sufixo, pois é uma transição normal

                musicaFundo.stop();
                Greenfoot.setWorld(prox);
            }
        }
    }

    /**
     * Método auxiliar para calcular, registrar e retornar a pontuação e tempo da fase.
     * @param sufixo Nome adicional a ser anexado ao nome da fase (ex: " (Derrota)").
     */
    protected void registrarResultadoFase(String sufixo)
    {
        int pontosGanhosNestaFase = Placar.getPontuacaoTotal() - pontuacaoTotalAntesDaFase;
        int tempoGasto = timerCiclos / FPS;

        String nomeFase = this.getClass().getSimpleName() + sufixo;
        Placar.registrarFase(nomeFase, pontosGanhosNestaFase, tempoGasto);
    }

    /**
     * Implementa o cenário. Deve ser sobrescrito pelas fases.
     */
    public void prepararCenario() { }

    /**
     * Permite que subclasses acessem a pontuação antes do início da fase.
     */
    protected int getPontuacaoTotalAntesDaFase()
    {
        return pontuacaoTotalAntesDaFase;
    }

    /**
     * Permite que subclasses acessem o contador de ciclos (tempo).
     */
    protected int getTimerCiclos()
    {
        return timerCiclos;
    }

    /**
     * Permite que subclasses acessem o FPS (usado para cálculo de tempo).
     */
    protected int getFPS()
    {
        return FPS;
    }

    /**
     * Permite que subclasses acessem o objeto de som.
     */
    protected GreenfootSound getMusicaFundo()
    {
        return musicaFundo;
    }
}