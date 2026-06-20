import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela é a superclasse base para todos os atores que possuem vida e podem interagir no mundo (ex: Guardia, Inimigos).
 */
public class Entidade extends Actor
{
    // atributos de estado (vida e direção)
    private int vida = 100; // valor padrão, que é modificado, depois, por cada entidade
    private boolean olhandoParaDireita = true;

    // atributos de animação
    private GreenfootImage[] imagensParadas;
    private GreenfootImage[] imagensCaminhando;
    private int indiceImagemAtual = 0;
    private static final int PASSOS_PARA_ATUALIZAR_IMAGEM = 4;
    private int passosDesdeUltimaAtualizacaoImagem = 0;
    private String acaoAtual = "Parada";

    /**
     * Construtor da classe Entidade. Não há nada a fazer.
     */
    public Entidade() { }

    /**
     * Método act(). Não há nada a fazer.
     */
    @Override
    public void act() { }

    /**
     * @return Valor atual da vida da Entidade.
     */
    protected int getVida()
    { 
        return vida; 
    }

    /**
     * Permite que subclasses definam o valor da vida.
     */
    protected void setVida(int novaVida)
    {
        this.vida = novaVida;
    }

    /**
     * Define o valor inicial da vida.
     * @param novaVida Novo valor de vida.
     */
    protected void definirVidaInicial(int novaVida)
    {
        vida = novaVida;
    }

    /**
     * Aplica dano à Entidade e verifica se ela deve ser removida do mundo.
     * @param dano A quantidade de vida a ser subtraída.
     */
    public void sofrerDano(int dano)
    {
        vida -= dano;
        if (vida <= 0) {
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Altera a direção para a qual a Entidade esta olhando. Usado para espelhar a imagem.
     * @param olhandoDireita true se estiver olhando para direita, false ao contrário.
     */
    public void definirDirecao(boolean olhandoDireita)
    {
        olhandoParaDireita = olhandoDireita;
    }

    /**
     * Define a ação atual ("Parada" ou "Correndo") para o sistema de animação.
     * @param novaAcao String referente à ação atual.
     */
    protected void definirAcao(String novaAcao)
    {
        if (!acaoAtual.equals(novaAcao)) {
            this.indiceImagemAtual = 0; // reseta animação ao mudar de ação.
        }
        acaoAtual = novaAcao;
    }

    /**
     * Método para subclasses registrarem seus vetores de animação.
     * @param paradas Vetor de imagens para quando a entidade estiver parada.
     * @param andando Vetor de imagens para quando a entidade estiver correndo/andando.
     */
    protected void configurarAnimacoes(GreenfootImage[] paradas, GreenfootImage[] andando)
    {
        this.imagensParadas = paradas;
        this.imagensCaminhando = andando;

        // configura a imagem inicial.
        if (paradas != null && paradas.length > 0) {
            setImage(paradas[0]);
        }
    }

    /**
     * Carrega as animações padrão.
     * @param prefixo    Prefixo do nome da imagem. Os nomes têm a estrutura padronizada, como ´prefixo (índice + 1).png´.
     * @param quantidade Quantidade de imagens do vetor.
     * @param largura    Largura da imagem.
     * @param altura     Altura da imagem.
     */
    protected GreenfootImage[] carregarAnimacao(String prefixo, int quantidade, int largura, int altura)
    {
        GreenfootImage[] vetor = new GreenfootImage[quantidade];

        for (int i = 0; i < quantidade; i++) {
            GreenfootImage img = new GreenfootImage(prefixo + " (" + (i + 1) + ").png");
            img.scale(largura, altura);
            vetor[i] = img;
        }
        return vetor;
    }

    /**
     * Executa a lógica de animação a cada ciclo de act().
     */
    protected void animar()
    {
        passosDesdeUltimaAtualizacaoImagem++;

        if (passosDesdeUltimaAtualizacaoImagem >= PASSOS_PARA_ATUALIZAR_IMAGEM) {
            passosDesdeUltimaAtualizacaoImagem = 0;

            GreenfootImage[] imagensAtuais =
                acaoAtual.equals("Correndo") ? imagensCaminhando : imagensParadas;

            if (imagensAtuais == null || imagensAtuais.length == 0) return;

            // avanca para o próximo índice (loop)
            indiceImagemAtual = (indiceImagemAtual + 1) % imagensAtuais.length;

            // cópia da imagem para poder espelhar sem alterar a original no vetor
            GreenfootImage imagemAtual = new GreenfootImage(imagensAtuais[indiceImagemAtual]);

            // espelha a imagem se a Entidade estiver olhando para a esquerda
            if (!olhandoParaDireita) {
                imagemAtual.mirrorHorizontally();
            }

            setImage(imagemAtual);
        }
    }
}