import greenfoot.World;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa a segunda fase do jogo.
 */
public class Fase2 extends MundoJogo
{
    /**
     * Construtor da segunda fase.
     */
    public Fase2()
    {
        super();
    }

    /**
     * Sobrescrita de MundoJogo. Configura os pontos para spawn dos fragmentos.
     */
    @Override
    public void configurarSpawnPoints()
    {
        adicionarSpawnPoint(50, 50);
        adicionarSpawnPoint(750, 50);
        adicionarSpawnPoint(50, 550);
        adicionarSpawnPoint(850, 550);
    }

    /**
     * Sobrescrita de MundoJogo. Prepara a guardiã.
     */
    @Override
    public void criarGuardia()
    {
        addObject(new Guardia(), 419, 323);
    }

    /**
     * Sobrescrita de MundoJogo. Prepara os inimigos da fase.
     */
    @Override
    public void criarInimigos()
    {
        addObject(new ZumbiFemea(), 419, 158);
        addObject(new ZumbiMacho(), 50, 300);

        Aranha aranha = new Aranha(100, 560);
        addObject(aranha, 700, 450);
    }

    /**
     * Sobrescrita de MundoJogo.
     * @return Posições para o spawn da chave.
     */
    @Override
    protected int[] getPosicaoSpawnChave()
    {
        return new int[]{915, 225}; 
    }

    /**
     * Sobrescrita de MundoJogo. Prepara o cenário do jogo.
     */
    @Override
    public void prepararCenario()
    {
        addObject(new Vida(), 950, 375);

        Casa casa = new Casa();
        addObject(casa, 910, 80);
        Cerca cerca = new Cerca();
        addObject(cerca,15,475);
        Cerca cerca2 = new Cerca();
        addObject(cerca2,45,475);
        Cerca cerca3 = new Cerca();
        addObject(cerca3,75,475);
        Cerca cerca4 = new Cerca();
        addObject(cerca4,105,475);
        Cerca2 cerca22 = new Cerca2();
        addObject(cerca22,120,448);
        Cerca2 cerca23 = new Cerca2();
        addObject(cerca23,120,423);
        Cerca2 cerca24 = new Cerca2();
        addObject(cerca24,120,398);
        Cerca2 cerca25 = new Cerca2();
        addObject(cerca25,120,373);   
        Cerca2 cerca26 = new Cerca2();
        addObject(cerca26,260,582);
        Cerca2 cerca27 = new Cerca2();
        addObject(cerca27,260,550);
        Cerca cerca5 = new Cerca();
        addObject(cerca5,426,400);
        Cerca cerca6 = new Cerca();
        addObject(cerca6,456,400);
        Cerca cerca7 = new Cerca();
        addObject(cerca7,486,400);
        Cerca cerca8 = new Cerca();
        addObject(cerca8,366,400);
        Cerca cerca9 = new Cerca();
        addObject(cerca9,396,400);
        Cerca cerca10 = new Cerca();
        addObject(cerca10,13,213);
        Cerca cerca11 = new Cerca();
        addObject(cerca11,43,213);
        Cerca cerca12 = new Cerca();
        addObject(cerca12,73,213);
        Cerca cerca13 = new Cerca();
        addObject(cerca13,103,213);
        Cerca cerca14 = new Cerca();
        addObject(cerca14,133,213);
        Cerca cerca15 = new Cerca();
        addObject(cerca15,986,304);
        cerca15.setLocation(986,304);
        Cerca cerca16 = new Cerca();
        addObject(cerca16,951,307);
        cerca16.setLocation(956,304);
        Cerca cerca17 = new Cerca();
        addObject(cerca17,926,304);
        Cerca cerca18 = new Cerca();
        addObject(cerca18,896,304);
        Cerca cerca19 = new Cerca();
        addObject(cerca19,866,304);
        Cerca2 cerca213 = new Cerca2();
        addObject(cerca213,350,404);
        Cerca2 cerca214 = new Cerca2();
        addObject(cerca214,350,379);
        Cerca2 cerca215 = new Cerca2();
        addObject(cerca215,350,354);
        Cerca2 cerca216 = new Cerca2();
        addObject(cerca216,350,329);
        Cerca2 cerca217 = new Cerca2();
        addObject(cerca217,350,304);
        Cerca2 cerca218 = new Cerca2();
        addObject(cerca218,145,190);
        Cerca2 cerca220 = new Cerca2();
        addObject(cerca220,145,9);
        Cerca2 cerca221 = new Cerca2();
        addObject(cerca221,145,34);
        Cerca2 cerca222 = new Cerca2();
        addObject(cerca222,795,8);
        Cerca2 cerca223 = new Cerca2();
        addObject(cerca223,795,33);
        Cerca2 cerca224 = new Cerca2();
        addObject(cerca224,795,58);
        Cerca2 cerca225 = new Cerca2();
        addObject(cerca225,795,83);
        Cerca cerca20 = new Cerca();
        addObject(cerca20,795,159);
        Cerca2 cerca226 = new Cerca2();
        addObject(cerca226,795,108);
        Cerca2 cerca227 = new Cerca2();
        addObject(cerca227,795,133);
        Cerca2 cerca228 = new Cerca2();
        addObject(cerca228,795,158);
        Cerca2 cerca231 = new Cerca2();
        addObject(cerca231,656,179);
        Cerca2 cerca232 = new Cerca2();
        addObject(cerca232,656,204);
        Cerca2 cerca233 = new Cerca2();
        addObject(cerca233,656,229);
        Cerca2 cerca234 = new Cerca2();
        addObject(cerca234,656,254);
        Cerca2 cerca235 = new Cerca2();
        addObject(cerca235,656,279);
        Cerca2 cerca236 = new Cerca2();
        addObject(cerca236,666,304);
        Cerca cerca21 = new Cerca();
        addObject(cerca21,830,304);
        Cerca cerca30 = new Cerca();
        addObject(cerca30,800,304);
        Cerca cerca31 = new Cerca();
        addObject(cerca31,770,304);
        Cerca cerca32 = new Cerca();
        addObject(cerca32,740,304);
        Cerca cerca33 = new Cerca();
        addObject(cerca33,680,304);
        Cerca cerca34 = new Cerca();
        addObject(cerca34,710,304);
        cerca19.setLocation(850,304);
        Cerca2 cerca237 = new Cerca2();
        addObject(cerca237,878,304);
        Cerca2 cerca238 = new Cerca2();
        addObject(cerca238,666,304);
        Decora decora = new Decora();
        addObject(decora,35,423);
        Decora decora2 = new Decora();
        addObject(decora2,971,265);
        Tenda tenda = new Tenda();
        addObject(tenda,950,562);
        Cerca2 cerca239 = new Cerca2();
        addObject(cerca239,497,11);
        Cerca2 cerca240 = new Cerca2();
        addObject(cerca240,497,36);
        Cerca2 cerca241 = new Cerca2();
        addObject(cerca241,497,59);
        Cerca2 cerca242 = new Cerca2();
        addObject(cerca242,497,87);
        Cerca2 cerca243 = new Cerca2();
        addObject(cerca243,497,115);
        Cerca2 cerca244 = new Cerca2();
        addObject(cerca244,500,404);
        Cerca2 cerca245 = new Cerca2();
        addObject(cerca245,500,379);
        Cerca2 cerca246 = new Cerca2();
        addObject(cerca246,500,354);
        Cerca2 cerca247 = new Cerca2();
        addObject(cerca247,500,329);
        Cerca2 cerca248 = new Cerca2();
        addObject(cerca248,500,304);
        
        TeiaAranha teiaAranha = new TeiaAranha();
        addObject(teiaAranha,126,451);
        TeiaAranha teiaAranha2 = new TeiaAranha();
        addObject(teiaAranha2,21,179);
        TeiaAranha teiaAranha3 = new TeiaAranha();
        addObject(teiaAranha3,516,29);
        TeiaAranha teiaAranha4 = new TeiaAranha();
        addObject(teiaAranha4,281,573);
        TeiaAranha teiaAranha5 = new TeiaAranha();
        addObject(teiaAranha5,925,568);
        TeiaAranha teiaAranha6 = new TeiaAranha();
        addObject(teiaAranha6,670,333);
        TeiaAranha teiaAranha7 = new TeiaAranha();
        addObject(teiaAranha7,969,194);
        TeiaAranha teiaAranha8 = new TeiaAranha();
        addObject(teiaAranha8,165,33);
        TeiaAranha teiaAranha9 = new TeiaAranha();
        addObject(teiaAranha9,791,19);
    }

    /**
     * Sobrescrita de MundoJogo. 
     * @return Próxima fase.
     */
    @Override
    public World proximaFase()
    {
        return new Fase3();
    }
}