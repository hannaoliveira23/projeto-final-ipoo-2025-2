import greenfoot.World; 
import greenfoot.Greenfoot; 
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela é uma superclasse que cuida da lógica genérica de criação de um mundo Tela.
 */
public class Tela extends World
{
    /**
     * Construtor de Tela.
     */
    public Tela(String nomeImagemDeFundo)
    {
        super(800, 560, 1, false);
        GreenfootImage fundo = new GreenfootImage(nomeImagemDeFundo);
        fundo.scale(getWidth(), getHeight());
        setBackground(fundo);
    }

    /**
     * Método act(). Deve ser sobrescrita pelas subclasses.
     */
    public void act() { }
}