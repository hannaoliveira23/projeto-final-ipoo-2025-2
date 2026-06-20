import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa um item colecionável que dobra a pontuação do jogador ao ser coletado.
 */
public class Estrela extends ItemColecionavel
{
    /**
     * Construtor de objetos Estrela.
     */
    public Estrela()
    {
        GreenfootImage imagem = new GreenfootImage("estrela.png");
        imagem.scale(60, 60);
        setImage(imagem);
    }
    
    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o efeito específico da coleta da estrela.
     */
    @Override
    public void aplicarEfeito()
    {
        Placar.dobrarPontuacao();
    }
    
    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o som específico da coleta da estrela.
     */
    @Override
    public String obterNomeSomColeta()
    {
        return "coleta-estrela.wav";
    }
}