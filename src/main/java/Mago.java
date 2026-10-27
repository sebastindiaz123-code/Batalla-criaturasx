/** Mago: ataca con hechizos (fuerza) y se defiende con una barrera mágica (-2 de daño). */
public class Mago extends Criatura {

    private final String hechizos;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " lanza el hechizo " + hechizos + " (" + daño + " de daño) a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        // La barrera mágica reduce 2 puntos; el daño mínimo siempre es 1
        int real = Math.max(1, daño - 2);
        System.out.println("  " + getNombre() + " levanta una barrera mágica y recibe " + real);
        recibirDaño(real);
    }

    public String getHechizos() { return hechizos; }
}
