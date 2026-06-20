import greenfoot.World; 
import greenfoot.Greenfoot; 
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Menu principal do jogo, contendo a história e as instruções.
 */
public class TelaInstrucoes extends Tela
{
    /**
     * Construtor de TelaInstrucoes.
     */
    public TelaInstrucoes()
    {
        super("Instrucoes.png");
    }

    /**
     * Sobrescrita do método act() da superclasse Tela.
     */
    @Override
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Fase1());
        }
    }
}