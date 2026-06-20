import greenfoot.Greenfoot; 

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Primeira tela do jogo, exibe o título e as ações para direcionar o usuário para onde deseja.
 */
public class TelaInicial extends Tela
{
    /**
     * Construtor de TelaInicial.
     */
    public TelaInicial()
    {
        super("Titulo_Jogo.png");
    }

    /**
     * Sobrescrita do método act() da superclasse Tela.
     */
    @Override
    public void act()
    {
        if (Greenfoot.isKeyDown("1")) {
            Greenfoot.setWorld(new TelaInstrucoes());
        }
        if (Greenfoot.isKeyDown("2")) {
            Greenfoot.setWorld(new Fase1());
        }
        if (Greenfoot.isKeyDown("3")) {
            Greenfoot.stop();
        }
    }
}