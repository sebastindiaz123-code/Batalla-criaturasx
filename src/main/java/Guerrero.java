/** Guerrero: ataca con su arma (fuerza) y se defiende con el escudo (reduce 50% del daño). */
public class Guerrero extends Criatura {

    private final String arma;

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " golpea con " + arma + " (" + daño + " de daño) a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        // El escudo bloquea la mitad del golpe; el daño mínimo siempre es 1
        int real = Math.max(1, daño / 2);
        System.out.println("  " + getNombre() + " bloquea con el escudo y recibe " + real);
        recibirDaño(real);
    }

    public String getArma() { return arma; }
}
