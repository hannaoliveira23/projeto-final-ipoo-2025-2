import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa o chefão, que possui um comportamento similar ao da Aranha e ataca a Guardia de longe.
 */
public class JackLanterna extends Inimigo
{
    private static final int VELOCIDADE = 2; 
    private static final int VIDA_INICIAL_CHEFAO = 3;

    private int posYMin;
    private int posYMax;
    private boolean subindo = true;

    /**
     * Construtor do JackLanterna.
     */
    public JackLanterna(int posYMin, int posYMax)
    {
        super();
        this.posYMin = posYMin;
        this.posYMax = posYMax;

        GreenfootImage[] idle = carregarAnimacao("JIdle", 5, 60, 70);
        GreenfootImage[] run  = carregarAnimacao("JRun",  6, 60, 70);
        configurarAnimacoes(idle, run);

        definirAcao("Parada");
        definirVidaInicial(VIDA_INICIAL_CHEFAO); 
    }

    /**
     * Cuida da lógica de ação do JackLanterna.
     */
    @Override
    public void act()
    {
        super.act();
        atirarAleatoriamente();
    }

    /**
     * Cuida da movimentação do chefão.
     */
    @Override
    public void mover()
    {
        int antigoY = getY();

        if (subindo) {
            setLocation(getX(), antigoY - VELOCIDADE);
            if (getY() <= posYMin) subindo = false;
        } else {
            setLocation(getX(), antigoY + VELOCIDADE);
            if (getY() >= posYMax) subindo = true;
        }
    }

    /**
     * Checa, com uma chance aleatória, se o Jack deve atirar, e realiza a ação.
     */
    private void atirarAleatoriamente()
    {
        if (greenfoot.Greenfoot.getRandomNumber(100) < 1) { // 1% de chance por frame
            BolaDeFogo bola = new BolaDeFogo();
            getWorld().addObject(bola, getX() - 40, getY());
        }
    }

    /**
     * Sobrescreve atacarGuardia do Inimigo para NÃO dar dano por contato físico, e sim pelo tiro.
     */
    @Override
    public void atacarGuardia() { }
}