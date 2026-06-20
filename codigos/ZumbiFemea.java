import greenfoot.GreenfootImage;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Representa um inimigo com comportamento de patrulha circular.
 */
public class ZumbiFemea extends Inimigo
{ 
    private static final int CENTRO_X = 415;
    private static final int CENTRO_Y = 350;
    private static final double RAIO_DA_ORBITA = 180.0;
    private static final double VELOCIDADE_ANGULAR = 1.2; // velocidade em graus/ciclo
    private double angulo; // única variavel que muda de estado no ciclo

    /**
     * Construtor da ZumbiFemea.
     */
    public ZumbiFemea()
    {
        super();
        this.angulo = 270.0; // a zumbi inicia no norte

        GreenfootImage[] idle = carregarAnimacao("z2Idle", 15, 60, 70);
        GreenfootImage[] walk = carregarAnimacao("z2Walk", 10, 60, 70);

        configurarAnimacoes(idle, walk);
    }

    /**
     * Implementa o movimento de patrulha circular.
     * CÁLCULO POLAR: Usa cosseno (X) e seno (Y) para calcular a nova posição.
     */
    @Override
    public void mover()
    {
        definirAcao("Correndo");

        angulo += VELOCIDADE_ANGULAR;
        if (angulo >= 360) {
            angulo -= 360; // mantém o ângulo entre 0 e 360.
        }

        double rad = Math.toRadians(angulo);
        int novoX = (int)(CENTRO_X + RAIO_DA_ORBITA * Math.cos(rad));
        int novoY = (int)(CENTRO_Y + RAIO_DA_ORBITA * Math.sin(rad));

        definirDirecao(novoX > getX()); // se a nova posição X for maior que a atual, o movimento é para a direita

        setLocation(novoX, novoY);
    }
}