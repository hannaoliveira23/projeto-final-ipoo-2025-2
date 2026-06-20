import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootSound;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa a terceira e última fase do jogo.
 */
public class Fase3 extends MundoJogo
{
    private JackLanterna jack;

    /**
     * Construtor da fase 3.
     */
    public Fase3()
    {
        super();
    }

    /**
     * Sobrescrita de MundoJogo. Prepara os inimigos da fase.
     */
    @Override
    public void criarInimigos()
    {
        jack = new JackLanterna(50, 550);
        addObject(jack, 950, 50);

        addObject(new ZumbiMacho(9999),47,42);
        addObject(new Aranha(150,450),575,200);
    }

    /**
     * Sobrescrita de MundoJogo. Prepara a guardiã.
     */
    @Override
    public void criarGuardia()
    {
        addObject(new Guardia(), 50, 300);
    }

    /**
     * Sobrescrita de MundoJogo. Prepara o cenário do jogo.
     */
    @Override
    public void prepararCenario()
    {
        Vida vida = new Vida();
        addObject(vida,792,240);
        
        Cerca2 cerca2 = new Cerca2();
        addObject(cerca2,266,70);
        Cerca2 cerca22 = new Cerca2();
        addObject(cerca22,266,100);
        Cerca2 cerca23 = new Cerca2();
        addObject(cerca23,266,130);
        Cerca2 cerca24 = new Cerca2();
        addObject(cerca24,266,160);
        Cerca2 cerca25 = new Cerca2();
        addObject(cerca25,266,190);
        Cerca2 cerca261 = new Cerca2();
        addObject(cerca261,266,210);

        Decora decora = new Decora();
        addObject(decora,444,508);
        Casa casa = new Casa();
        addObject(casa,100,509);

        Cerca cerca = new Cerca();
        addObject(cerca,278,210);
        Cerca cerca3 = new Cerca();
        addObject(cerca3,310,210);
        Cerca cerca4 = new Cerca();
        addObject(cerca4,342,210);
        Cerca cerca5 = new Cerca();
        addObject(cerca5,374,210);
        Cerca cerca6 = new Cerca();
        addObject(cerca6,406,210);
        Cerca cerca7 = new Cerca();
        addObject(cerca7,438,210);

        Cerca2 cerca26 = new Cerca2();
        addObject(cerca26,719,320);
        Cerca2 cerca27 = new Cerca2();
        addObject(cerca27,719,350);
        Cerca2 cerca28 = new Cerca2();
        addObject(cerca28,719,380);

        TeiaAranha teiaAranha = new TeiaAranha();
        addObject(teiaAranha,281,194);
        TeiaAranha teiaAranha2 = new TeiaAranha();
        addObject(teiaAranha2,724,91);
        TeiaAranha teiaAranha3 = new TeiaAranha();
        addObject(teiaAranha3,234,443);
        TeiaAranha teiaAranha4 = new TeiaAranha();
        addObject(teiaAranha4,691,350);
        TeiaAranha teiaAranha5 = new TeiaAranha();
        addObject(teiaAranha5,632,499);
        TeiaAranha teiaAranha6 = new TeiaAranha();
        addObject(teiaAranha6,86,153);
        TeiaAranha teiaAranha7 = new TeiaAranha();
        addObject(teiaAranha7,467,289);
    }

    /**
     * Ciclo da fase 3.
     */
    @Override
    public void act() {
        super.act();

        // VITÓRIA - a guardiã eliminou o jack lanterna;
        if (jack != null && jack.getWorld() == null) {
            registrarResultadoFase(" (Boss)"); 

            getMusicaFundo().stop();
            greenfoot.Greenfoot.setWorld(new TelaFinal(Placar.getPontuacaoTotal(), true));
            return;
        }

        // DERROTA - acabou a munição e o jack lanterna ainda está vivo.
        if (Placar.getFragmentosColetados() <= 0 && jack.getWorld() != null) {
            if (getObjects(TiroFragmento.class).isEmpty()) {
                registrarResultadoFase(" (Derrota)"); 

                getMusicaFundo().stop();
                greenfoot.Greenfoot.setWorld(new TelaFinal(Placar.getPontuacaoTotal(), false));
                return;
            }
        }
    }

    /**
     * Sobrescreve o método para adicionar informações.
     */
    @Override
    public void desenharHUD() {
        super.desenharHUD(); 

        getBackground().setColor(Color.BLACK);
        getBackground().fillRect(300, 0, 300, 60); 

        getBackground().setColor(Color.WHITE);
        getBackground().drawString("Munição: " + Placar.getFragmentosColetados() + "/8", 350, 40); 

        if (jack != null && jack.getWorld() != null) {
            getBackground().setColor(Color.BLACK);
            getBackground().fillRect(0, 60, getWidth(), 30); 

            getBackground().setColor(Color.WHITE);
            getBackground().setFont(new Font("Arial", true, false, 22));
            getBackground().drawString("VIDA CHEFÃO: " + jack.getVida(), 800, 75);
        }
    }

    /**
     * Sobrescreve o método de spawn da chave no mundo. Está vazio, pois, na fase 3, não há chave.
     */
    @Override
    protected void checarColetaCompleta() { }
}