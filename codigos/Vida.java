import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa um item colecionável que adiciona uma vida à Guardia.
 */
public class Vida extends ItemColecionavel
{
    /**
     * Construtor da classe FragmentoMagico.
     */
    public Vida()
    {
        GreenfootImage imagem = new GreenfootImage("Heart.png"); 
        imagem.scale(27, 27);
        setImage(imagem);
    }

    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o efeito específico da coleta da vida.
     */
    @Override
    public void aplicarEfeito()
    {
        Guardia g = (Guardia) getOneIntersectingObject(Guardia.class);
        if (g != null) {
            g.aumentarVidaGlobal();
        }
    }

    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o efeito específico da coleta da vida.
     */
    @Override
    public String obterNomeSomColeta()
    {
        return "coleta-vida.wav";
    }
}