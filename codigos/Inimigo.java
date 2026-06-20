import greenfoot.Greenfoot;
import greenfoot.Actor;
import java.util.List;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela é a superclasse para todos os inimigos (zumbis). Define a regra de ataque,
 * lógica de dano ao jogador e definição do ciclo de vida comum.
 */
public class Inimigo extends Entidade
{
    private int cooldownAtaque = 0;
    private static final int VIDA_PADRAO = 50;
    private static final int TEMPO_ENTRE_ATAQUES = 60; // 1 segundo (60 ciclos de act()) de cooldown.
    private static final int DANO_BASE = 1;

    /**
     * Construtor do Inimigo. Configura a vida padrão e animações (não implementadas aqui).
     */
    public Inimigo()
    {
        super();
        definirVidaInicial(VIDA_PADRAO);
    }

    protected int getDanoBase()
    {
        return DANO_BASE;
    }

    /**
     * Define o som do ataque. Pode ser sobrescrito pelas subclasses.
     */
    protected void tocarSomAtaque()
    {
        Greenfoot.playSound("som-ataque.wav");
    }

    /**
     * Tenta encontrar a guardiã no mundo.
     * @return O objeto Guardia ou null se nao estiver presente.
     */
    public Guardia localizarGuardia()
    {
        List<Guardia> guardias = getWorld().getObjects(Guardia.class);
        return guardias.isEmpty() ? null : guardias.get(0);
    }

    /**
     * Gerencia a lógica de ataque com um período de recarga (cooldown).
     */
    public void atacarGuardia()
    {
        if (cooldownAtaque > 0) {
            cooldownAtaque--; // conta sempre, encostando ou não
        }

        Guardia jogador = localizarGuardia();
        if (jogador == null) {
            return;
        }

        if (isTouching(Guardia.class) && cooldownAtaque == 0) {
            jogador.sofrerDano(DANO_BASE);
            tocarSomAtaque();
            cooldownAtaque = TEMPO_ENTRE_ATAQUES; // arma 1s de cooldown
        }
    }

    /**
     * Comportamento de movimento padrão. Deve ser sobrescrito pelas subclasses, uma vez que cada inimigo tem um movimento diferente.
     */
    protected void mover() { }

    /**
     * O ciclo de vida do Inimigo. Garante que ataque, movimento e animação ocorram, nessa ordem.
     */
    @Override
    public void act()
    {
        atacarGuardia();
        mover();
        animar();
    }

    /**
     * Calcula a distância Euclidiana entre um inimigo e um alvo (o qual pode ser o jogador, um objeto coletável, etc.).
     * @param alvo O ator até o qual a distância deve ser calculada.
     * @return     A distância em pixels.
     */
    public double calcularDistanciaAte(Actor alvo)
    {
        if (alvo == null) return Double.MAX_VALUE; // retorna um valor alto se o alvo não existir.

        // calcula a distância exata usando o Teorema de Pitágoras (Math.hypot)
        int dx = alvo.getX() - getX();
        int dy = alvo.getY() - getY();
        return Math.hypot(dx, dy);
    }
}