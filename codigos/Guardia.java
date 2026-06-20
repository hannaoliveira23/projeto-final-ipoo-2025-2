import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa o jogador, e é controlada pelo teclado.
 */
public class Guardia extends Entidade
{
    private int velocidade = 3;

    private int cooldownTiro = 0;
    private boolean disparoTravado = false; // garante um tiro por clique de espaço

    // atributos para controlar o tempo do efeito da teia de aranha
    private static final int TEMPO_LENTIDAO_CICLOS = 3 * 60;
    private static final int VELOCIDADE_NORMAL = 3;
    private static final int VELOCIDADE_LENTA = 1;
    private int contadorLentidao = 0;
    private boolean efeitoLentidaoAtivo = false;

    /**
     * Construtor da classe Guardia.
     */
    public Guardia()
    {
        // carrega e configura animações
        GreenfootImage[] idle = carregarAnimacao("Idle", 16, 60, 70);
        GreenfootImage[] run  = carregarAnimacao("Run", 20, 60, 70);
        configurarAnimacoes(idle, run);

        // a vida interna da Guardia é 1, pois qualquer dano resulta em remoção.
        definirVidaInicial(1);
    }

    /**
     * Altera o comportamento de sofrerDano da Entidade.
     * @param dano Quantidade de dano (sempre 1, já que a vida interna é 1).
     */
    @Override
    public void sofrerDano(int dano)
    {
        int vidaAtual = getVida();
        setVida(vidaAtual - dano);

        if (getVida() <= 0) {
            MundoJogo mundo = (MundoJogo) getWorld();
            if (mundo != null) {
                mundo.perderVida();
                if (getWorld() != null) {
                    getWorld().removeObject(this); 
                }
            }
        }
    }

    /**
     * Permite que um item colecionável aumente a vida global da guardiã.
     */
    public void aumentarVidaGlobal()
    {
        MundoJogo mundo = (MundoJogo) getWorld();
        if (mundo != null) {
            mundo.ganharVida();
        }
    }

    /**
     * Aplica o efeito de lentidão. Chamado ao tocar na TeiaAranha.
     */
    public void aplicarLentidao()
    {
        this.contadorLentidao = TEMPO_LENTIDAO_CICLOS;
        this.velocidade = VELOCIDADE_LENTA;
        this.efeitoLentidaoAtivo = true;
        Greenfoot.playSound("som-teia.wav");
    }

    /**
     * Cuida da movimentação da guardiã.
     */
    private void mover()
    {
        if (contadorLentidao > 0) {
            contadorLentidao--;
        }

        if (contadorLentidao == 0 && this.efeitoLentidaoAtivo) {
            this.efeitoLentidaoAtivo = false;
            this.velocidade = VELOCIDADE_NORMAL; 
        }

        if (isTouching(TeiaAranha.class) && !efeitoLentidaoAtivo) {
            aplicarLentidao();
        }

        boolean seMovendo = false;
        int deltaX = 0;
        int deltaY = 0;

        if (Greenfoot.isKeyDown("left")) {
            deltaX -= velocidade;
            definirDirecao(false);
            seMovendo = true;
        }
        if (Greenfoot.isKeyDown("right")) {
            deltaX += velocidade;
            definirDirecao(true);
            seMovendo = true;
        }
        if (Greenfoot.isKeyDown("up")) {
            deltaY -= velocidade;
            seMovendo = true;
        }
        if (Greenfoot.isKeyDown("down")) {
            deltaY += velocidade;
            seMovendo = true;
        }

        if (seMovendo) {
            tentarMover(deltaX, deltaY);
            definirAcao("Correndo");
        } else {
            definirAcao("Parada");
        }
    }

    /**
     * Gerencia a colisão da guardiã com objetos Barreira. Tenta mover em X, e depois em Y.
     */
    private void tentarMover(int deltaX, int deltaY)
    {
        int antigoX = getX();
        int antigoY = getY();

        if (deltaX != 0) {
            setLocation(getX() + deltaX, getY());
            if (getOneIntersectingObject(Barreira.class) != null) {
                setLocation(antigoX, getY());
            }
        }

        if (deltaY != 0) {
            setLocation(getX(), getY() + deltaY);
            if (getOneIntersectingObject(Barreira.class) != null) {
                setLocation(getX(), antigoY);
            }
        }
    }

    /**
     * Lógica principal de ação da Guardia.
     */
    @Override
    public void act()
    {
        mover();
        animar();
        atirar();
    }

    /**
     * Lógica de tiro dos fragmentos. Utilizado apenas na fase 3.
     */
    private void atirar()
    {
        if (!(getWorld() instanceof Fase3)) {
            return;
        }

        if (cooldownTiro > 0) {
            cooldownTiro--;
        }

        boolean espacoPressionado = Greenfoot.isKeyDown("space");

        if (espacoPressionado && Placar.getFragmentosColetados() > 0 && cooldownTiro == 0 && !disparoTravado) {
            Placar.gastarMunicao();
            cooldownTiro = 10;
            disparoTravado = true;

            getWorld().addObject(new TiroFragmento(), getX(), getY());
        }

        // destrava o disparo assim que o botão "space" é solto
        if (!espacoPressionado) {
            disparoTravado = false;
        }
    }
}