import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa o tiro do fragmento, realizado pela guardiã na última fase do jogo.
 */
public class TiroFragmento extends Projetil
{
    private static final int VELOCIDADE = 15;

    /**
     * Construtor do TiroFragmento.
     */
    public TiroFragmento()
    {
        // usa a mesma imagem do fragmento, mas menor
        GreenfootImage img = new GreenfootImage("FragmentoMagico.png");
        img.scale(15, 15); 
        setImage(img);
    }

    /**
     * Sobrescreve o método de Projetil. Implementa a movimentação do tiro.
     */
    @Override
    protected void mover()
    {
        setLocation(getX() + VELOCIDADE, getY());
    }
    
    /**
     * Sobrescreve o método de Projetil. Implementa o que acontece quando o tiro atinge a borda.
     */
    @Override
    protected void emRemocaoNaBorda()
    {
        Placar.adicionarPontos(-50); 
    }

    /**
     * Sobrescreve o método de Projetil. Implementa a verificação de colisão com o inimigo.
     */
    @Override
    protected void verificarColisao()
    {
        Inimigo inimigo = (Inimigo) getOneIntersectingObject(Inimigo.class);

        if (inimigo != null) {
            greenfoot.Greenfoot.playSound("dano-jack.wav");
            inimigo.sofrerDano(1); 
            Placar.adicionarPontos(50); 
            getWorld().removeObject(this);
        }
    }
}