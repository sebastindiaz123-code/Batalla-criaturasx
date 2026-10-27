
public class Mago extends Criatura {

    
    private final String hechizos;

    
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    
    @Override
    public void atacar(Criatura objetivo) {
        if (!puedeAtacar(objetivo)) {
            return;
        }
        int daño = getFuerza();
        System.out.println(getNombre() + " lanza el hechizo " + hechizos + " (" + daño + " de daño) a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    
    @Override
    public void defender(int daño) {
        int real = Math.max(1, daño - 2);
        System.out.println("  " + getNombre() + " levanta una barrera mágica y recibe " + real);
        recibirDaño(real);
    }

    /** @return hechizo del mago */
    public String getHechizos() { return hechizos; }
}
