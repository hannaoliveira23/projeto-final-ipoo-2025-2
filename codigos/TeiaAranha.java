import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa um obstáculo que diminui a velocidade da guardiã.
 */
public class TeiaAranha extends Actor
{
    /**
     * Construtor de TeiaAranha.
     */
    public TeiaAranha()
    {
        GreenfootImage imagem = new GreenfootImage("teia.png");
        imagem.scale(70, 70);
        setImage(imagem);
    }
}