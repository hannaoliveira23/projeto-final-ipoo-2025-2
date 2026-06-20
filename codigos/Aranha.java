import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa um inimigo com comportamento de deslocamento vertical em loop por um caminho predefinido.
 */
public class Aranha extends Inimigo
{
    private static final int VELOCIDADE = 2;

    private int posYMin;
    private int posYMax;
    private boolean subindo = true;

    /**
     * Construtor de objetos Aranha.
     */
    public Aranha(int posYMin, int posYMax)
    {
        super();
        this.posYMin = posYMin;
        this.posYMax = posYMax;
    }

    /**
     * Sobrescreve o método da classe Inimigo, implementando para a aranha seu próprio som de ataque.
     */
    @Override
    protected void tocarSomAtaque()
    {
         Greenfoot.playSound("som-aranha.wav");
    }

    /**
     * Sobrescreve o método da superclasse, implementando o ataque sem cooldown.
     */
    @Override
    public void atacarGuardia()
    {
        Guardia jogador = localizarGuardia();
        if (jogador == null) return;

        if (isTouching(Guardia.class)) {
            jogador.sofrerDano(getDanoBase()); 
            tocarSomAtaque();
        }
    }
    
    /**
     * Implementa o movimento da aranha: sobe até posYMin e desce até posYMax, sempre checando colisão com Barreira.
     */
    @Override
    protected void mover()
    {
        int antigoY = getY();
        int deltaY = subindo ? -VELOCIDADE : VELOCIDADE;
        
        setLocation(getX(), antigoY + deltaY);

        // checagem de colisão com Barreira
        if (getOneIntersectingObject(Barreira.class) != null) {
            setLocation(getX(), antigoY); // desfaz movimento
            subindo = !subindo; // inverte direção
            return;
        }

        // checagem de limites de patrulha
        if (subindo && getY() <= posYMin) {
            subindo = false;
        }
        else if (!subindo && getY() >= posYMax) {
            subindo = true;
        }
    }
}