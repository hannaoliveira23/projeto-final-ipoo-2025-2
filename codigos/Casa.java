import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa a casa, item do cenário.
 */
public class Casa extends Barreira
{
    /**
     * Construtor de Casa.
     */
    public Casa()
    {
        // carrega a imagem original
        GreenfootImage img = new GreenfootImage("4.png");

        // calcula novas dimensões
        int novaLargura = (int)(img.getWidth() * 1.3);
        int novaAltura  = (int)(img.getHeight() * 1.3);

        // redimensiona
        img.scale(novaLargura, novaAltura);

        // aplica a imagem no ator
        setImage(img);
    }
}