import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * Ela é uma superclasse para todos os projéteis disparados no jogo (pelo jogador ou inimigo).
 * Centraliza o ciclo de vida: movimento, remoção na borda e colisão.
 */
public class Projetil extends Actor
{
    /**
     * Ação do projétil: movimentação, remoção na borda, colisão.
     */
    @Override
    public void act()
    {
        mover();
        if (checarColisaoBarreira()) {
            return;
        }
        if (checarRemocao()) {
             return; 
        }
        verificarColisao();
    }
    
    /**
     * Implementa a checagem de colisão com Barreira e remove o projétil.
     * @return true se colidiu com uma Barreira e foi removido, false caso contrário.
     */
    protected boolean checarColisaoBarreira()
    {
        Actor barreira = getOneIntersectingObject(Barreira.class);
        if (barreira != null) {
            World mundo = getWorld();
            if (mundo != null) {
                mundo.removeObject(this);
            }
            return true;
        }
        return false;
    }
    
    /**
     * Implementação da remoção na borda.
     * @return true se o objeto foi removido, false ao contrário.
     */
    protected boolean checarRemocao()
    {
        if (isAtEdge()) {
            emRemocaoNaBorda();
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
    
    /**
     * O que acontece se um projétil atinge a borda. Pode ser sobrescrito caso haja um comportamento específico.
     */
    protected void emRemocaoNaBorda() { }
    
    /**
     * Implementa a movimentação do projétil. Deve ser sobrescrito.
     */
    protected void mover() { }

    /**
     * Implementa a verificação de colisão. Deve ser sobrescrito.
     */
    protected void verificarColisao() { }
}