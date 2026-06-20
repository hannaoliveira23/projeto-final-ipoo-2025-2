import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Esta classe faz parte da aplicação "A Maldição da VilaVelha".
 * É a superclasse que lida com a lógica genérica de um item coletável pela Guardia.
 */
public class ItemColecionavel extends Actor
{
    /**
     * Define o efeito específico. As classes filhas devem sobrescrever.
     */
    public void aplicarEfeito() { }
    
    /**
     * Define o nome do arquivo de som. As classes filhas devem sobrescrever.
     */
    public String obterNomeSomColeta()
    {
        return "erro.wav"; // retorna um som padrão de erro para indicar que deve ser sobrescrito
    }

    /**
     * Ciclo de vida do item.
     */
    public void act()
    {
        verificarColeta();
    }
    
    /**
     * Checa se o item está tocando a Guardia e aplica o comportamento de coleta.
     */
    private void verificarColeta()
    {
        if (isTouching(Guardia.class))
        {
            aplicarEfeito();
            Greenfoot.playSound(obterNomeSomColeta());
            // remove-se do mundo.
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}