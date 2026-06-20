import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa um inimigo com comportamento de perseguição à Guardia dentro de um raio de percepção definido pelo usuário.
 */
public class ZumbiMacho extends Inimigo
{
    private static final int VELOCIDADE = 2;
    private int raioPercepcao;

    /**
     * Construtor 1, usado na Fase 2.
     * Define o raio para perseguição como 300 - o zumbi só persegue se a Guardia estiver dentro desse raio.
     */
    public ZumbiMacho()
    {
        this(250); // chama o segundo construtor passando 300 como raio de percepção
    }
    
    /**
     * Construtor 2, usado na Fase 1.
     * Permite definir o raio de percepção ao criar o zumbi. Se passarmos um valor gigante, será uma perseguição "infinita".
     */
    public ZumbiMacho(int raioDesejado)
    {
        super();
        this.raioPercepcao = raioDesejado;
        
        GreenfootImage[] idle = carregarAnimacao("z1Idle", 15, 60, 70);
        GreenfootImage[] walk = carregarAnimacao("z1Walk", 10, 60, 70);
        configurarAnimacoes(idle, walk);
    }

    /**
     * Sobrescreve o mover() da classe Inimigo. Implementa a movimentação do ZumbiMacho.
     */
    @Override
    public void mover()
    {
        Guardia g = localizarGuardia();
        if (g == null) { definirAcao("Parada"); return; }

        // verifica a distância do inimigo até a guardiã
        double distancia = calcularDistanciaAte(g);

        // decide se deve perseguir
        if (distancia <= raioPercepcao) {
            moverEmDirecaoAoAlvo(g);
        } else {
            definirAcao("Parada");
        }
    }

    /**
     * Sistema de perseguição. Tenta mover em X e Y; se colidir, tenta eixo X, depois eixo Y.
     */
    private void moverEmDirecaoAoAlvo(Guardia alvo)
    {
        definirAcao("Correndo");

        int dx = alvo.getX() - getX();
        int dy = alvo.getY() - getY();

        // espelhamento do sprite
        definirDirecao(dx >= 0);

        double distancia = Math.hypot(dx, dy);
        if (distancia == 0) return; // evita divisão por zero

        double nx = dx / distancia;
        double ny = dy / distancia;

        // mover direto
        int novoX = getX() + (int)(nx * VELOCIDADE);
        int novoY = getY() + (int)(ny * VELOCIDADE);
        setLocation(novoX, novoY);

        if (!isTouching(Barreira.class)) return;
        setLocation(getX() - (int)(nx * VELOCIDADE), getY() - (int)(ny * VELOCIDADE));

        // mover só no eixo X
        int apenasX = getX() + (int)(nx * VELOCIDADE);
        setLocation(apenasX, getY());

        if (!isTouching(Barreira.class)) return;
        setLocation(getX() - (int)(nx * VELOCIDADE), getY());

        // mover só no eixo Y
        int apenasY = getY() + (int)(ny * VELOCIDADE);
        setLocation(getX(), apenasY);

        if (!isTouching(Barreira.class)) return;
        setLocation(getX(), getY() - (int)(ny * VELOCIDADE));
    }
}