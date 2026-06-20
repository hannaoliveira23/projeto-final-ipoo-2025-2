import greenfoot.World;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa a primeira fase do jogo.
 */
public class Fase1 extends MundoJogo
{
    /**
     * Construtor da Fase1.
     */
    public Fase1()
    {    
        super();
        Placar.resetarJogo();
    }

    /**
     * Sobrescrita de MundoJogo. Configura os pontos para spawn dos fragmentos.
     */
    @Override
    public void configurarSpawnPoints()
    {
        adicionarSpawnPoint(100, 550);
        adicionarSpawnPoint(505, 300);
        adicionarSpawnPoint(900, 75);
        adicionarSpawnPoint(900, 525);
    }

    /**
     * Sobrescrita de MundoJogo. Prepara a guardiã.
     */
    @Override
    public void criarGuardia()
    {
        addObject(new Guardia(), 37, 215);
    }

    /**
     * Sobrescrita de MundoJogo. Prepara os inimigos da fase.
     */
    @Override
    public void criarInimigos()
    {
        addObject(new ZumbiMacho(9999), 40, 540);
        Aranha aranha = new Aranha(100, 500);
        addObject(aranha, 785, 300);
    }

    /**
     * Sobrescrita de MundoJogo.
     * @return Posições para o spawn da chave.
     */
    @Override
    protected int[] getPosicaoSpawnChave()
    {
        return new int[]{37, 215}; 
    }

    /**
     * Sobrescrita de MundoJogo. Prepara o cenário do jogo.
     */
    @Override
    public void prepararCenario()
    {
        addObject(new Estrela(), 870, 280);

        // canto superior direito (cercas verticais)
        Cerca2 cerca2 = new Cerca2();
        addObject(cerca2,778,4);
        Cerca2 cerca22 = new Cerca2();
        addObject(cerca22,778,25);
        Cerca2 cerca23 = new Cerca2();
        addObject(cerca23,778,46);
        Cerca2 cerca24 = new Cerca2();
        addObject(cerca24,778,67);
        Cerca2 cerca25 = new Cerca2();
        addObject(cerca25,778,88);
        Cerca2 cerca26 = new Cerca2();
        addObject(cerca26,778,109);
        Cerca2 cerca27 = new Cerca2();
        addObject(cerca27,778,130);
        Cerca2 cerca28 = new Cerca2();
        addObject(cerca28,778,151);

        // meio (cercas horizontais superiores)
        Cerca cerca3 = new Cerca();
        addObject(cerca3,425,220);
        Cerca cerca4 = new Cerca();
        addObject(cerca4,450,220);
        Cerca cerca5 = new Cerca();
        addObject(cerca5,475,220);
        Cerca cerca6 = new Cerca();
        addObject(cerca6,500,220);
        Cerca cerca7 = new Cerca();
        addObject(cerca7,525,220);
        Cerca cerca8 = new Cerca();
        addObject(cerca8,550,220);
        Cerca cerca9 = new Cerca();
        addObject(cerca9,575,220);
        Cerca cerca10 = new Cerca();
        addObject(cerca10,600,220);

        // meio (cercas verticais)
        Cerca2 cerca29 = new Cerca2();        
        addObject(cerca29,410,230);
        Cerca2 cerca210 = new Cerca2();
        addObject(cerca210,410,251);
        Cerca2 cerca211 = new Cerca2();
        addObject(cerca211,410,272);
        Cerca2 cerca212 = new Cerca2();
        addObject(cerca212,410,293);
        Cerca2 cerca213 = new Cerca2();
        addObject(cerca213,410,314);
        Cerca2 cerca214 = new Cerca2();
        addObject(cerca214,410,335);
        Cerca2 cerca215 = new Cerca2();
        addObject(cerca215,410,356);
        Cerca2 cerca216 = new Cerca2();
        addObject(cerca216,410,377);

        // meio (cercas horizontais inferiores)
        Cerca cerca12 = new Cerca();
        addObject(cerca12,425,377);
        Cerca cerca13 = new Cerca();
        addObject(cerca13,450,377);
        Cerca cerca14 = new Cerca();
        addObject(cerca14,475,377);
        Cerca cerca15 = new Cerca();
        addObject(cerca15,500,377);
        Cerca cerca16 = new Cerca();
        addObject(cerca16,525,377);
        Cerca cerca17 = new Cerca();
        addObject(cerca17,550,377);
        Cerca cerca18 = new Cerca();
        addObject(cerca18,575,377);
        Cerca cerca19 = new Cerca();
        addObject(cerca19,600,377);

        // canto inferior direito
        Cerca cerca20 = new Cerca();
        addObject(cerca20,984,423);
        Cerca cerca21 = new Cerca();
        addObject(cerca21,959,423);
        Cerca cerca30 = new Cerca();
        addObject(cerca30,934,423);
        Cerca cerca31 = new Cerca();
        addObject(cerca31,909,423);
        Cerca cerca32 = new Cerca();
        addObject(cerca32,884,423);
        Cerca cerca33 = new Cerca();
        addObject(cerca33,859,423);
        Cerca cerca34 = new Cerca();
        addObject(cerca34,834,423);
        Cerca cerca35 = new Cerca();
        addObject(cerca35,809,423);
        Cerca cerca36 = new Cerca();
        addObject(cerca36,784,423);
        Cerca cerca37 = new Cerca();
        addObject(cerca37,759,423);

        // canto superior esquerdo, perto da casa
        Cerca cerca38 = new Cerca();
        addObject(cerca38,122,158);
        Cerca cerca39 = new Cerca();
        addObject(cerca39,92,158);
        Cerca cerca40 = new Cerca();
        addObject(cerca40,62,158);
        Cerca cerca41 = new Cerca();
        addObject(cerca41,32,158);
        Cerca cerca42 = new Cerca();
        addObject(cerca42,2,158);

        Casa casa = new Casa();
        addObject(casa,230,78);
        Decora decora = new Decora();
        addObject(decora,205,436);
        
        TeiaAranha teiaAranha = new TeiaAranha();
        addObject(teiaAranha,430,366);
        TeiaAranha teiaAranha2 = new TeiaAranha();
        addObject(teiaAranha2,791,15);
        TeiaAranha teiaAranha3 = new TeiaAranha();
        addObject(teiaAranha3,966,442);
        TeiaAranha teiaAranha4 = new TeiaAranha();
        addObject(teiaAranha4,237,443);
        TeiaAranha teiaAranha5 = new TeiaAranha();
        addObject(teiaAranha5,328,22);
        TeiaAranha teiaAranha6 = new TeiaAranha();
        addObject(teiaAranha6,614,231);
    }

    /**
     * Sobrescrita de MundoJogo.
     * @return Próxima fase.
     */
    @Override
    public World proximaFase()
    {
        return new Fase2();
    }
}