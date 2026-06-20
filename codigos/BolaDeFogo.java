import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa o tiro da bola de fogo, realizado pelo chefão na última fase do jogo.
 */
public class BolaDeFogo extends Projetil
{
    private static final int VELOCIDADE = 5;

    /**
     * Construtor de objetos BolaDeFogo.
     */
    public BolaDeFogo()
    {    
        GreenfootImage imagem = new GreenfootImage("bola-de-fogo.png");
        imagem.mirrorHorizontally();
        imagem.scale(40, 20);
        setImage(imagem);
    }

    /**
     * Sobrescreve o método de Projetil, implementando a movimentação.
     */
    @Override
    protected void mover()
    {
        setLocation(getX() - VELOCIDADE, getY());
    }

    /**
     * Sobrescreve o método de Projetil, implementando a verificação de colisão com a guardiã.
     */
    @Override
    protected void verificarColisao()
    {
        Guardia guardia = (Guardia) getOneIntersectingObject(Guardia.class);

        if (guardia != null) {
            greenfoot.Greenfoot.playSound("som-fogo.wav");
            guardia.sofrerDano(1);
            getWorld().removeObject(this);
        }
    }
}