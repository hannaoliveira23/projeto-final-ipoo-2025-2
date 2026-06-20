import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela representa um item colecionável necessário para o avanço da fase.
 */
public class FragmentoMagico extends ItemColecionavel
{
    /**
     * Construtor da classe FragmentoMagico.
     */
    public FragmentoMagico()
    {
        GreenfootImage imagem = new GreenfootImage("FragmentoMagico.png"); 
        imagem.scale(30, 30);
        setImage(imagem);
    }
    
    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o efeito específico da coleta do fragmento.
     */
    @Override
    public void aplicarEfeito()
    {
        Placar.coletarFragmento();
    }
    
    /**
     * Sobrescreve o método da classe ItemColecionavel. Define o efeito específico da coleta do fragmento.
     */
    @Override
    public String obterNomeSomColeta()
    {
        return "coleta-fragmento.wav";
    }
}