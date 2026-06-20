import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa um item colecionável que, ao ser coletado, faz o jogador passar de fase.
 */
public class Chave extends ItemColecionavel
{
    /**
     * Construtor de objetos Estrela.
     */
    public Chave()
    {
        GreenfootImage imagem = new GreenfootImage("Chave.png");
        imagem.scale(35, 35);
        setImage(imagem);
    }
    
    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o som específico da coleta da chave.
     */
    @Override
    public String obterNomeSomColeta()
    {
        return "coleta-chave.wav";
    }
}